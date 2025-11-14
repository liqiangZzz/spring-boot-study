# Spring v1.0 模块

## 模块介绍

Spring v1.0 模块展示了 Spring 框架第一个版本的使用方式。该版本采用传统的 XML 配置方式，是 Spring 框架的最初形态，体现了最基础的 IoC（控制反转）和 DI（依赖注入）功能。

## 功能特性

- 使用 Spring 1.2.9 版本
- 基于 XML 配置的传统方式
- 使用 ClassPathXmlApplicationContext 初始化 Spring 容器
- 展示最基础的 IoC 和 DI 功能

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

该类是应用程序的入口，使用 [ClassPathXmlApplicationContext](src/main/java/com/lq/StartApp.java#L17) 加载 XML 配置文件并获取 Bean。

### UserService 服务类

```java
public class UserService {
}
```

这是一个基础的服务类，在 XML 配置文件中被定义为 Bean。

### applicationContext.xml 配置文件

```xml
<!-- XML 配置内容 -->
<beans>
    <bean id="userService" class="com.lq.service.UserService"/>
</beans>
```

该配置文件定义了 Bean 的创建和管理规则。

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

- `org.springframework:spring-context:1.2.9` - Spring 1.2.9 上下文核心库

## 配置说明

### XML 配置方式

Spring v1.0 使用 XML 文件进行配置，通过 `<bean>` 标签定义 Bean：

```xml
<beans>
    <bean id="userService" class="com.lq.service.UserService"/>
</beans>
```

### 容器初始化

使用 [ClassPathXmlApplicationContext](src/main/java/com/lq/StartApp.java#L17) 类加载类路径下的 XML 配置文件：

```java
ApplicationContext ac =
        new ClassPathXmlApplicationContext("applicationContext.xml");
```

## 学习要点

1. 理解 Spring 最初的 XML 配置方式
2. 掌握 ClassPathXmlApplicationContext 的使用
3. 了解基础的 IoC 和 DI 概念
4. 认识 Spring 框架的核心思想

## 与新版本的差异

相比于新版本 Spring：

1. 完全依赖 XML 配置，没有注解支持
2. API 使用相对繁琐
3. 功能相对简单，缺少现代 Spring 的许多特性
4. 配置文件较大，维护成本高

## 注意事项

1. 确保 applicationContext.xml 配置文件位于类路径下
2. Bean 的定义必须符合 XML 格式要求
3. 注意 Spring 1.2.9 版本与现代 Java 版本的兼容性问题