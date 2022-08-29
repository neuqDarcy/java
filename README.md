# Activity-platform 
```
└── activity
    ├── annotation-----自定义注解
    ├── aop-----自定义切面
    ├── common----常用类
    ├── config----自定义配置类
    ├── controller-------路由层，负责分发请求
    ├── domain-------领域层，负责业务建模与处理各种逻辑，里面类被称为Entity
    ├── infrastructure-----基础层，负责与db交互
    │   ├── mapper-----根据DO生成的mapper，负责crud
    │   └── repository----封装了mapper
    │       └── impl
    ├── model
    │   ├── DO------与DB一一对应
    │   └── dto-----输入/输出对应的模型
    │       ├── reqeust-----请求参数
    │       └── response-----响应参数
    ├── service------处理业务流程相关的逻辑
    │   └── impl
    ├── transfer------模型转换器
    │   ├── assembler------DTO与Entity的转换器
    │   │   ├── request
    │   │   └── response
    │   └── converter------DO与Entity的转换器
    └── uitls-----工具类

```
基本开发流程：
1. 根据数据库表生成 mapper 和 DO，生成器为：DaoAutoGenerator
2. 根据业务定义 domain 层的 entity， 加入字段的校验逻辑
3. 根据与前端约定的交互方式，定义 DTO，包括 response DTO 与 request DTO， 编写对应的 Assembler