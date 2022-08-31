package com.nio.flash.activity.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {

    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";

    @JsonProperty("request_id")
    private String requestId;

    @JsonProperty("result_code")
    protected String resultCode;

    @JsonProperty("server_time")
    protected long serverTime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String message;

    @JsonProperty("display_msg")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String displayMessage;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("debug_msg")
    protected String debugMessage;

    private T data;

    public static <T> Response<T> success(String code, String message, T data) {
        return Response.<T>builder()
                .requestId(UUID.randomUUID().toString().replace("-", ""))
                .resultCode(code)
                .message(message)
                .serverTime(System.currentTimeMillis() / 1000L)
                .data(data)
                .build();
    }

    public static <T> Response<T> success() {
        return Response.<T>builder()
                .resultCode(SUCCESS)
                .requestId(UUID.randomUUID().toString().replace("-", ""))
                .serverTime(System.currentTimeMillis() / 1000L)
                .build();
    }
    public static <T> Response<T> success(String message) {
        return Response.<T>builder()
                .resultCode(SUCCESS)
                .requestId(UUID.randomUUID().toString().replace("-", ""))
                .message(message)
                .serverTime(System.currentTimeMillis() / 1000L)
                .build();
    }

    public static <T> Response<T> success(T data) {
        return Response.<T>builder()
                .requestId(UUID.randomUUID().toString().replace("-", ""))
                .data(data)
                .serverTime(System.currentTimeMillis() / 1000L)
                .build();
    }

    public static <T> Response<T> success(String requestId, T data) {
        return Response.<T>builder()
                .requestId(requestId)
                .serverTime(System.currentTimeMillis() / 1000L)
                .data(data)
                .build();
    }

    public static <T> Response<T> failure(T data) {
        return Response.<T>builder()
                .requestId(UUID.randomUUID().toString().replace("-", ""))
                .serverTime(System.currentTimeMillis() / 1000L)
                .data(data)
                .build();
    }

    public static <T> Response<T> failure() {
        return Response.<T>builder()
                .resultCode(FAILURE)
                .requestId(UUID.randomUUID().toString().replace("-", ""))
                .serverTime(System.currentTimeMillis() / 1000L)
                .build();
    }

    public static <T> Response<T> failure(String code, String message) {
        return Response.<T>builder()
                .resultCode(code)
                .requestId(UUID.randomUUID().toString().replace("-", ""))
                .message(message)
                .serverTime(System.currentTimeMillis() / 1000L)
                .build();
    }

    public static <T> Response<T> failure(String message) {

        return Response.<T>builder()
                .requestId(UUID.randomUUID().toString().replace("-", ""))
                .message(message)
                .serverTime(System.currentTimeMillis() / 1000L)
                .build();
    }



    public static <T> Response<T> build(String code, String  message, T data) {
        return Response.<T>builder()
                .resultCode(code)
                .requestId(UUID.randomUUID().toString().replace("-", ""))
                .message(message)
                .data(data)
                .serverTime(System.currentTimeMillis() / 1000L)
                .build();
    }
}