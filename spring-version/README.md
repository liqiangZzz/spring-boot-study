# Spring Version 模块

## 模块介绍

Spring Version 是一个用于学习和演示 Spring 框架各个版本演进过程的多模块项目。该项目包含了从 Spring v1.0 到 v5.0 的不同版本示例，展示了 Spring 框架在不同版本中的特性和使用方式的变化。

## 功能特性

- 演示 Spring v1.0 到 v5.0 的演进过程
- 展示不同版本中配置方式的变化
- 提供各版本核心特性的实践示例
- 对比不同版本间的差异和改进

## 模块结构

```
spring-version/
├── spring-v1.0/    # Spring 1.x 版本示例
├── spring-v2.0/    # Spring 2.x 版本示例
├── spring-v3.0/    # Spring 3.x 版本示例
├── spring-v4.0/    # Spring 4.x 版本示例
├── spring-v5.0/    # Spring 5.x 版本示例
```

## 各版本特点

### Spring v1.0

- 基于 XML 配置的传统方式
- 使用 ClassPathXmlApplicationContext 初始化 Spring 容器
- 最基础的 IoC 和 DI 功能

### Spring v2.0

- 继续使用 XML 配置，但增加了更多特性
- 引入了新的注解支持
- 增强了 AOP 功能

### Spring v3.0

- 大量使用注解替代 XML 配置
- 引入 @Configuration、@Bean 等 Java 配置注解
- 支持基于 Java 类的配置方式

### Spring v4.0

- 进一步完善注解驱动开发
- 改进条件化配置功能
- 增强对 Java 8 的支持

### Spring v5.0

- 全面支持函数式编程
- 引入 Spring WebFlux 响应式编程模型
- 增强测试功能

## 使用方法

### 1. 编译所有版本模块

```bash
mvn clean install
```

### 2. 运行特定版本示例

进入相应的版本目录，执行：

```bash
mvn exec:java
```

或者

```bash
mvn clean package
java -cp target/classes:target/dependency/* com.lq.对应版本的主类
```

## 依赖关系

各版本模块依赖不同版本的 Spring 库：

- spring-v1.0: spring-context 1.2.9
- spring-v2.0: spring-context 5.2.16.RELEASE, spring-tx 5.2.16.RELEASE
- spring-v3.0: spring-context 5.2.16.RELEASE, spring-tx 5.2.16.RELEASE
- spring-v4.0: spring-context 5.2.16.RELEASE, spring-tx 5.2.16.RELEASE
- spring-v5.0: spring-context 5.2.16.RELEASE, spring-tx 5.2.16.RELEASE, spring-context-indexer 5.2.16.RELEASE

## 学习建议

1. 按照版本顺序学习，理解 Spring 框架的演进过程
2. 对比不同版本间的配置方式差异
3. 关注注解驱动开发的演进历程
4. 理解 Spring 容器初始化和 Bean 管理机制的变化

## 注意事项

1. 不同版本间的依赖可能存在冲突，建议单独运行各版本示例
2. 某些版本示例可能需要特定的运行环境
3. 学习时重点关注配置方式和核心概念的变化