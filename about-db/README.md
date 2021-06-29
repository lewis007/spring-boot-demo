# MySQL 相关

> 前提：新建 Database，命名为 `spring-boot-demo`

## `demo-mysql`

来源于 Spring Guides 官方的 [gs-accessing-data-mysql][1]，比较基础，基于 JPA 的方式对 MySQL 数据库执行基本操作。

## `demo-mybatis`

在 `demo-mysql` 的基础上，引入 MyBatis 框架。

## `demo-druid`

在 `demo-mybatis` 的基础上，更进一步，引入 druid 数据库连接池配置

## `demo-pagehelper`

在 `demo-druid` 的基础上，增加分页查询的能力。

## `demo-mybatis-generator`

当我们完成表结构设计后，需要按照 `model | dao | service | controller` 的顺序完成后台代码的开发，那么与表结构相关的，能不能自动生成部分代码呢。

答案是可以的，利用 `mybatis-generator` 可以通过表自动生成 `model | dao (mapper) | XML (mapper)` 。

按照本 demo 完成基础配置后，执行命令 `mvn mybatis-generator:generate`，即可。

[1]: https://github.com/spring-guides/gs-accessing-data-mysql
