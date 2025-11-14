# Spring v3.0 模块

## 模块介绍

Spring v3.0 模块展示了 Spring 框架第三个版本的重要变革。该版本大量使用注解替代 XML 配置，引入了 @Configuration、@Bean 等 Java 配置注解，支持基于 Java 类的配置方式，标志着 Spring 框架进入注解驱动开发的新时代。

## 功能特性

- 使用 Spring 5.2.16.RELEASE 版本（教学目的）
- 大量使用注解替代 XML 配置
- 引入 @Configuration、@Bean 等 Java 配置注解
- 支持基于 Java 类的配置方式
- 提供更简洁的开发体验

## 核心组件

### JavaConfig 配置类

```java
@Configuration
public class JavaConfig {
    @Bean
    public UserService userService() {
        return new UserService();
    }
}
```

该配置类使用 [@Configuration](src/main/java/com/lq/config/JavaConfig.java#L14) 注解标记，通过 [@Bean](src/main/java/com/lq/config/JavaConfig.java#L17) 注解定义了 [UserService](src/main/java/com/lq/service/UserService.java) Bean。

### UserService 服务类

```java
public class UserService {
}
```

这是一个基础的服务类，通过 Java 配置类被定义为 Bean。

### StartApp 启动类

```java
public class StartApp {
    public static void main(String[] args) {
        ApplicationContext ac =
                new AnnotationConfigApplicationContext(JavaConfig.class);
        UserService userService = ac.getBean(UserService.class);
        System.out.println(userService);
    }
}
```

该类是应用程序的入口，使用 [AnnotationConfigApplicationContext](src/main/java/com/lq/StartApp.java#L17) 加载 Java 配置类并获取 Bean。

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

### Java 配置方式

Spring v3.0 引入了基于 Java 类的配置方式，通过 [@Configuration](src/main/java/com/lq/config/JavaConfig.java#L14) 和 [@Bean](src/main/java/com/lq/config/JavaConfig.java#L17) 注解实现：

```java
@Configuration
public class JavaConfig {
    @Bean
    public UserService userService() {
        return new UserService();
    }
}
```

### 容器初始化

使用 [AnnotationConfigApplicationContext](src/main/java/com/lq/StartApp.java#L17) 类加载 Java 配置类：

```java
ApplicationContext ac =
        new AnnotationConfigApplicationContext(JavaConfig.class);
```

## 学习要点

1. 理解 Java 配置方式相比 XML 配置的优势
2. 掌握 @Configuration 和 @Bean 注解的使用
3. 了解 AnnotationConfigApplicationContext 的使用
4. 认识注解驱动开发的思想

## 与其它版本的差异

相比于其它版本 Spring：

1. 相比 v1.0/v2.0，完全采用注解配置，摒弃了繁琐的 XML 配置
2. 相比 v4.0/v5.0，注解支持相对基础，功能还在完善中
3. 提供了更简洁、更易维护的配置方式

## 注意事项

1. 本示例使用的是 Spring 5.2.16.RELEASE 版本，仅用于教学演示
2. 实际的 Spring 3.0 版本已经较为老旧
3. Java 配置方式需要正确使用相关注解