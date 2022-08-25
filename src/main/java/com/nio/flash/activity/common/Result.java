package com.nio.flash.activity.common;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.UUID;
import java.util.function.Function;
import java.util.function.UnaryOperator;


/**
 * 符合接口响应规范的响应实体类（只支持 Jackson）
 */
@With
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
//@Builder(builderMethodName = "internalBuilder", toBuilder = true)
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result<T> {

    @JsonProperty("request_id")
    private String requestId;

    @JsonProperty("server_time")
    private long serverTime;

    @JsonProperty("result_code")
    private String resultCode;

    @JsonProperty("display_msg")
    private String displayMessage;

    @JsonProperty("debug_msg")
    @JsonAlias("message")
    private String debugMessage;

    private T data;

    private static final String GEN_ = "gen-";

    /**
     * @return 用于调试的 message
     * @deprecated 请改用 getDebugMessage / getDisplayMessage
     */
    @Deprecated
    public String getMessage() {
        return debugMessage;
    }

    public boolean succeed() {
        return "success".equals(resultCode);
    }

    public boolean hasData() {
        return data != null;
    }

    public boolean succeedWithData() {
        return succeed() && hasData();
    }

    /**
     * 如果成功返回 data（可空），否则返回默认值
     *
     * @return data 或默认值
     */
    public T nullableDataOr(T defaultData) {
        return succeed() ? data : defaultData;
    }

    /**
     * 如果成功且数据不为空返回 data，否则返回默认值
     *
     * @return data 或默认值
     */
    public T nonNullDataOr(T defaultData) {
        return succeedWithData() ? data : defaultData;
    }


    /**
     * 如果成功返回自身，否则返回数据为 defaultData 的成功结果
     * 如果非自身，则 server_time 相同，request-id 加“gen-”前缀（如果已有该前缀则不加）
     *
     * @param defaultData 默认数据
     * @return 成功的结果
     */
    public Result<T> nullableOr(T defaultData) {
        return succeed() ? this : generatedWith(defaultData);
    }

    /**
     * 如果成功且数据非空返回自身，否则返回数据为 defaultData 的成功结果
     * 如果非自身，则 server_time 相同，request-id 加“gen-”前缀（如果已有该前缀则不加）
     *
     * @param defaultData 默认数据
     * @return 成功且数据非空的结果
     */
    public Result<T> nonNullOr(T defaultData) {
        return succeedWithData() ? this : generatedWith(defaultData);
    }

    private <U> Result<U> generatedWith(U newData) {
        return Result.<U>builder()
                .requestId(toGeneratedRequestId())
                .serverTime(serverTime)
                .resultCode("success")
                .data(newData)
                .build();
    }

    private String toGeneratedRequestId() {
        return requestId == null ? null : requestId.startsWith(GEN_) ? requestId : GEN_ + requestId;
    }

    /**
     * 如果成功返回自身，否则返回 operator 返回的结果
     *
     * @param operator 将原始结果转换为默认结果的函数
     * @return 成功的结果
     */
    public Result<T> nullableOrElse(@NonNull UnaryOperator<Result<T>> operator) {
        return succeed() ? this : operator.apply(this);
    }

    /**
     * 如果成功且数据非空返回自身，否则返回 operator 返回的结果
     *
     * @param operator 将原始结果转换为默认结果的函数
     * @return 成功且数据非空的结果
     */
    public Result<T> nonNullOrElse(@NonNull UnaryOperator<Result<T>> operator) {
        return succeedWithData() ? this : operator.apply(this);
    }

    /**
     * 如果成功返回自身，否则返回 fallback
     *
     * @param fallback 备用值
     * @return 成功的结果
     */
    public Result<T> nullableFallback(Result<T> fallback) {
        return succeed() ? this : fallback;
    }

    /**
     * 如果成功且数据非空返回自身，否则返回 fallback
     *
     * @param fallback 备用值
     * @return 成功且数据非空的结果
     */
    public Result<T> nonNullFallback(Result<T> fallback) {
        return succeedWithData() ? this : fallback;
    }

    /**
     * 如果成功，对数据应用 function，转换为新的结果
     *
     * @param function 转换函数
     * @param <R>      转换函数的返回值类型亦即新结果的返回值类型
     * @return 转换后的结果
     */
    public <R> Result<R> mapNullable(@NonNull Function<T, R> function) {
        return mapConditional(function, succeed());
    }

    /**
     * 如果成功且数据非空，对数据应用 function，转换为新的结果
     *
     * @param function 转换函数
     * @param <R>      转换函数的返回值类型亦即新结果的返回值类型
     * @return 转换后的结果
     */
    public <R> Result<R> mapNonNull(@NonNull Function<T, R> function) {
        return mapConditional(function, succeedWithData());
    }

    private <R> Result<R> mapConditional(@NonNull Function<T, R> function, boolean succeed) {
        return succeed ? withTypedData(function.apply(data)) : withoutData();
    }

    private <R> Result<R> withoutData() {
        //noinspection unchecked
        return !hasData() ? (Result<R>) this : withTypedData(null);
    }

    private <R> Result<R> withTypedData(R newData) {
        //noinspection unchecked
        return ((ResultBuilder<R>) toBuilder())
                .requestId(toGeneratedRequestId())
                .data(newData)
                .build();
    }

    /**
     * 将嵌套结果打平
     *
     * @param nestedResult 嵌套结果
     * @param <U>          目标结果类型
     * @return 打平后的结果
     */
    public static <U> Result<U> flatten(@NonNull Result<Result<U>> nestedResult) {
        return nestedResult.succeedWithData() ? nestedResult.getData() : nestedResult.withoutData();
    }

    /**
     * 如果成功，对数据应用 function，转换为新的结果，
     * 最终返回 Result 类型与 function 返回的 Result 类型相同
     *
     * @param function 转换函数，其返回类型与新的结果相同
     * @param <R>      转换函数的返回值类型亦即新结果的返回值类型
     * @return 转换后的结果
     */
    public <R> Result<R> flatMapNullable(@NonNull Function<T, Result<R>> function) {
        return flatten(mapNullable(function));
    }

    /**
     * 如果成功且数据非空，对数据应用 function，转换为新的结果，
     * 最终返回 Result 类型与 function 返回的 Result 类型相同
     *
     * @param function 转换函数，其返回类型与新的结果相同
     * @param <R>      转换函数的返回值类型亦即新结果的返回值类型
     * @return 转换后的结果
     */
    public <R> Result<R> flatMapNonNull(@NonNull Function<T, Result<R>> function) {
        return flatten(mapNonNull(function));
    }


    /**
     * 如果成功则对 data 通过 successMapper 进行映射，否则取备用值对应的结果。
     *
     * @param successMapper 成功且时的映射函数
     * @param fallback      备用值
     * @param <R>           返回结果的数据类型
     * @return 映射或通过备用值得到的结果
     */
    public <R> Result<R> mapNullableOr(@NonNull Function<T, R> successMapper, R fallback) {
        return generatedWith(succeed() ? successMapper.apply(data) : fallback);
    }

    /**
     * 如果成功且非数据空则对 data 通过 successNonNullMapper 进行映射，否则取备用值对应的结果。
     *
     * @param successNonNullMapper 成功且数据非空时的映射函数
     * @param fallback             备用值
     * @param <R>                  返回结果的数据类型
     * @return 映射或通过备用值得到的结果
     */
    public <R> Result<R> mapNonNullOr(@NonNull Function<T, R> successNonNullMapper, R fallback) {
        return generatedWith(succeedWithData() ? successNonNullMapper.apply(data) : fallback);
    }

    public static <T> ResultBuilder<T> builder() {
        return new Result.ResultBuilder<T>();
    }

    public static <T> ResultBuilder<T> defaultTime() {
        return Result.<T>builder().serverTime(System.currentTimeMillis() / 1000L);
    }

    public static <T> ResultBuilder<T> ok(String requestId) {
        return Result.<T>defaultTime().requestId(requestId).resultCode("success");
    }
    public static <T> ResultBuilder<T> ok() {
        return Result.<T>defaultTime().requestId(UUID.randomUUID().toString()).resultCode("success");
    }

    public static <T> Result<T> of(String requestId, T data) {
        return Result.<T>ok(requestId).data(data).build();
    }

    public static <T> Result<T> success(T data, String requestId) {
        return Result.<T>ok(requestId).data(data).build();
    }
}
