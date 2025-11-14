# SPI 机制演示模块

## 模块介绍

SPI (Service Provider Interface) 模块是用于演示 Java SPI 机制的一个实践项目。该项目展示了如何通过 Java 的 SPI 机制实现服务的动态扩展和插件化架构，允许第三方为应用程序提供不同的实现。

## 功能特性

- 演示 Java SPI 机制的基本使用方法
- 展示如何定义服务接口和服务实现
- 提供多种数据库连接实现的示例
- 实现运行时动态加载服务提供者

## 模块结构

```
spi/
├── my-data-base/           # 公共接口定义模块
├── mysql-data-base/        # MySQL 数据库实现模块
├── oracle-data-base/       # Oracle 数据库实现模块
└── spring-boot-demo/       # 示例应用模块
```

## 使用方法

### 1. 接口定义

在 [my-data-base](./my-data-base) 模块中定义服务接口：

```java
public interface BaseData {
    public String baseURL();
}
```

### 2. 服务实现

在各个实现模块中提供具体实现：

- [mysql-data-base](./mysql-data-base) - MySQL 数据库连接实现
- [oracle-data-base](./oracle-data-base) - Oracle 数据库连接实现

### 3. 服务注册

在实现模块的 `resources/META-INF/services/` 目录下创建以接口全限定名为文件名的文件，内容为实现类的全限定名。

### 4. 服务加载

使用 `ServiceLoader` 加载服务实现：

```java
ServiceLoader<BaseData> providers = ServiceLoader.load(BaseData.class);
Iterator<BaseData> iterator = providers.iterator();
while (iterator.hasNext()) {
    BaseData baseData = iterator.next();
    baseData.baseURL();
}
```

## 核心组件

### BaseData 接口

定义了数据访问的基础接口，所有数据库实现都需要实现此接口。

### MySQLBaseData 实现

MySQL 数据库的具体实现类。

### OracleBaseData 实现

Oracle 数据库的具体实现类。

### JavaMain 示例程序

演示如何使用 SPI 机制加载和使用不同的数据库实现。

## 依赖关系

- [my-data-base](./my-data-base) - 基础接口模块
- [mysql-data-base](./mysql-data-base) - MySQL 实现模块
- [oracle-data-base](./oracle-data-base) - Oracle 实现模块
- [spring-boot-demo](./spring-boot-demo) - 示例应用模块

## 运行示例

1. 编译所有模块：
   ```bash
   mvn clean install
   ```

2. 运行示例程序：
   ```bash
   cd spring-boot-demo
   mvn exec:java
   ```

## 扩展性说明

可以通过以下步骤添加新的数据库支持：

1. 创建新的数据库实现模块
2. 实现 BaseData 接口
3. 在 `META-INF/services/` 目录下注册实现类
4. 将新模块添加到 [spring-boot-demo](./spring-boot-demo) 的依赖中

## 注意事项

1. 确保在 `META-INF/services/` 目录下的服务注册文件命名正确
2. 实现类必须具有无参构造函数
3. 服务加载是延迟加载的，在调用 iterator() 方法时才真正加载服务实现