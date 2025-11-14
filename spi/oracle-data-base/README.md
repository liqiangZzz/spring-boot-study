# Oracle Data Base 模块

## 模块介绍

Oracle Data Base 是 SPI 演示项目中针对 Oracle 数据库的具体实现模块。该模块实现了 [BaseData](../../my-data-base/src/main/java/com/lq/database/BaseData.java) 接口，提供了连接 Oracle 数据库的功能。

## 功能特性

- 实现 Oracle 数据库连接功能
- 提供 Oracle 特定的连接URL
- 符合 SPI 机制的服务提供者规范

## 核心实现

### OracleBaseData 类

```java
public class OracleBaseData implements BaseData {
    @Override
    public String baseURL() {
        System.out.println("oracle ....");
        return null;
    }
}
```

该类实现了 [BaseData](../../my-data-base/src/main/java/com/lq/database/BaseData.java) 接口，并在 [baseURL()](src/main/java/com/oracle/database/OracleBaseData.java#L13) 方法中输出 "oracle ...." 信息。

## 使用方法

### 1. 添加依赖

在需要使用 Oracle 数据库连接的模块中添加 Maven 依赖：

```xml
<dependency>
    <groupId>com.lq</groupId>
    <artifactId>oracle-data-base</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

### 2. SPI 服务注册

在 `src/main/resources/META-INF/services/` 目录下创建文件 `com.lq.database.BaseData`，内容为：

```
com.oracle.database.OracleBaseData
```

### 3. 服务加载

通过 ServiceLoader 加载服务：

```java
ServiceLoader<BaseData> loader = ServiceLoader.load(BaseData.class);
for (BaseData data : loader) {
    if (data instanceof OracleBaseData) {
        data.baseURL(); // 输出: oracle ....
    }
}
```

## 依赖关系

- [my-data-base](../../my-data-base) - 基础接口模块

## 在 SPI 机制中的作用

1. 作为 Oracle 数据库的服务提供者实现
2. 通过标准的 SPI 服务注册机制被 ServiceLoader 发现和加载
3. 提供运行时动态加载 Oracle 数据库连接能力

## 扩展说明

如需扩展 Oracle 连接功能，可以：

1. 修改 [baseURL()](src/main/java/com/oracle/database/OracleBaseData.java#L13) 方法返回真实的 Oracle 连接URL
2. 添加更多的 Oracle 配置参数
3. 实现连接池等功能

## 注意事项

1. 确保服务注册文件路径和名称正确
2. 实现类必须具有公共的无参构造函数
3. 当前实现仅输出日志信息，实际使用时需要完善连接逻辑