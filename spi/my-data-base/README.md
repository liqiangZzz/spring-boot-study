# My Data Base 模块

## 模块介绍

My Data Base 是 SPI 演示项目中的基础接口定义模块。该模块定义了一个通用的数据访问接口 [BaseData](src/main/java/com/lq/database/BaseData.java)，为各种数据库实现提供了统一的抽象。

## 功能特性

- 定义通用数据访问接口
- 提供标准化的方法签名
- 支持不同数据库实现的统一调用

## 核心接口

### BaseData 接口

```java
public interface BaseData {
    public String baseURL();
}
```

该接口定义了所有数据库实现都必须提供的 [baseURL()](src/main/java/com/lq/database/BaseData.java#L11) 方法，用于返回数据库连接的基础URL。

## 使用方法

### 1. 添加依赖

在需要使用该接口的模块中添加 Maven 依赖：

```xml
<dependency>
    <groupId>com.lq</groupId>
    <artifactId>my-data-base</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

### 2. 实现接口

创建类实现 [BaseData](src/main/java/com/lq/database/BaseData.java) 接口：

```java
public class YourDatabaseImpl implements BaseData {
    @Override
    public String baseURL() {
        // 返回具体的数据库连接URL
        return "your-database-url";
    }
}
```

## 依赖关系

该模块不依赖其他模块，是一个独立的接口定义模块。

## 在 SPI 机制中的作用

1. 作为服务提供者接口（Service Provider Interface）
2. 定义了所有数据库实现必须遵循的契约
3. 为 ServiceLoader 提供加载服务的标准接口

## 注意事项

1. 接口设计应保持简洁和通用性
2. 方法签名一旦确定不应随意更改，以保证向后兼容性
3. 实现类应该提供有意义的 baseURL 返回值