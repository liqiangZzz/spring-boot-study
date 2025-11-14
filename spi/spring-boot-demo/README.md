# Spring Boot Demo 模块

## 模块介绍

Spring Boot Demo 是 SPI 演示项目的示例应用模块。该模块演示了如何在应用程序中使用 Java SPI 机制动态加载和使用不同的数据库实现。

## 功能特性

- 演示 ServiceLoader 的使用方法
- 展示运行时动态加载服务提供者
- 集成多种数据库实现进行演示

## 核心实现

### JavaMain 类

```java
public class JavaMain {
    public static void main(String[] args) {
        ServiceLoader<BaseData> providers = ServiceLoader.load(BaseData.class);
        Iterator<BaseData> iterator = providers.iterator();
        while (iterator.hasNext()) {
            BaseData baseData = iterator.next();
            baseData.baseURL();
        }
    }
}
```

该类是示例程序的入口，使用 [ServiceLoader](src/main/java/com/lq/JavaMain.java#L17) 加载所有 [BaseData](src/main/java/com/lq/JavaMain.java#L17) 接口的实现，并调用其 [baseURL()](src/main/java/com/lq/JavaMain.java#L22) 方法。

## 使用方法

### 1. 运行示例

```bash
mvn clean compile exec:java
```

或者

```bash
mvn clean package
java -jar target/spring-boot-demo-1.0-SNAPSHOT.jar
```

### 2. 观察输出

程序将输出所有已注册的数据库实现信息：
- mysql ....
- oracle ....

## 依赖关系

- [mysql-data-base](../mysql-data-base) - MySQL 数据库实现
- [oracle-data-base](../oracle-data-base) - Oracle 数据库实现

## SPI 机制演示

该模块通过以下步骤演示 SPI 机制：

1. 通过 [ServiceLoader.load(BaseData.class)](src/main/java/com/lq/JavaMain.java#L17) 方法加载服务
2. 遍历所有已注册的服务提供者
3. 调用每个提供者的 [baseURL()](src/main/java/com/lq/JavaMain.java#L22) 方法

## 扩展说明

如需添加新的数据库支持：

1. 创建新的数据库实现模块
2. 实现 [BaseData](src/main/java/com/lq/JavaMain.java#L17) 接口
3. 在新模块中注册服务提供者
4. 将新模块添加为本模块的依赖

## 注意事项

1. 确保所有依赖的数据库实现模块已正确编译和安装
2. 服务提供者必须在 `META-INF/services/` 目录下正确注册
3. 程序运行时会自动发现并加载所有已注册的服务提供者