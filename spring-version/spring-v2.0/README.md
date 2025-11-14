# Spring v2.0 模块

## 模块介绍

Spring v2.0 模块展示了 Spring 框架第二个版本的使用方式。该版本在保持 XML 配置传统的基础上，引入了新的注解支持和增强功能，进一步完善了 IoC 和 AOP 特性。

## 功能特性

- 使用 Spring 5.2.16.RELEASE 版本（教学目的，实际 Spring 2.0 版本较老）
- 继续使用 XML 配置，但增加了更多特性
- 引入了新的注解支持
- 增强了 AOP 功能

## 核心组件

### StartApp 启动类

```java
public class StartApp {
    public static void main(String[] args) {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        ac.getBean("userService");
    }
}
```

该类是应用程序的入口，使用 [ClassPathXmlApplicationContext](../../spring-v1.0/src/main/java/com/lq/StartApp.java#L17) 加载 XML 配置文件并获取 Bean。

### UserService 服务类

```java
public class UserService {
}
```

这是一个基础的服务类，在 XML 配置文件中被定义为 Bean。

## 使用方法

### 1. 编译项目

```bash
mvn clean compile
```

### 2. 运行示例

```bash
mvn exec:java
```

或者

```bash
mvn clean package
java -cp target/classes:target/dependency/* com.lq.StartApp
```

## 依赖关系

- `org.springframework:spring-context:5.2.16.RELEASE` - Spring 上下文核心库
- `org.springframework:spring-tx:5.2.16.RELEASE` - Spring 事务管理库

## 配置说明

### XML 配置增强

Spring v2.0 在 XML 配置方面进行了增强，支持更多的配置选项和命名空间。

### 注解支持

相比 v1.0，v2.0 开始引入了一些基础的注解支持，为后续版本的注解驱动开发奠定了基础。

## 学习要点

1. 理解 Spring 2.0 相比 1.0 的改进
2. 掌握 XML 配置的增强功能
3. 了解早期注解支持的使用
4. 认识 AOP 功能的增强

## 与其它版本的差异

相比于其它版本 Spring：

1. 相比 v1.0，增加了注解支持和 AOP 增强
2. 相比 v3.0 及以后版本，仍主要依赖 XML 配置
3. API 和功能比现代 Spring 版本简单

## 注意事项

1. 本示例使用的是 Spring 5.2.16.RELEASE 版本，仅用于教学演示
2. 实际的 Spring 2.0 版本已经非常老旧，不建议在生产环境中使用
3. 配置方式仍以 XML 为主，注解支持有限