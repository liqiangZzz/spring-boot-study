# Spring v4.0 模块

## 模块介绍

Spring v4.0 模块展示了 Spring 框架第四个版本的进一步完善。该版本在 v3.0 注解驱动的基础上，进一步完善了注解驱动开发，改进了条件化配置功能，增强了对 Java 8 的支持，提供了更加强大和灵活的配置方式。

## 功能特性

- 使用 Spring 5.2.16.RELEASE 版本（教学目的）
- 进一步完善注解驱动开发
- 改进条件化配置功能
- 增强对 Java 8 的支持
- 提供更加强大和灵活的配置方式

## 核心组件

### JavaConfig 配置类

```java
@Configuration
public class JavaConfig {
    @Bean
    @Conditional(MyCondition.class)
    public StudentService studentService() {
        return new StudentService();
    }
}
```

该配置类使用 [@Configuration](src/main/java/com/lq/condition/JavaConfig.java#L12) 注解标记，通过 [@Bean](src/main/java/com/lq/condition/JavaConfig.java#L15) 和 [@Conditional](src/main/java/com/lq/condition/JavaConfig.java#L16) 注解定义了条件化的 [StudentService](src/main/java/com/lq/condition/StudentService.java) Bean。

### MyCondition 条件类

```java
public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 条件判断逻辑
        return true;
    }
}
```

该类实现了 [Condition](src/main/java/com/lq/condition/MyCondition.java#L8) 接口，用于定义 Bean 创建的条件。

### StudentService 服务类

```java
public class StudentService {
}
```

这是一个基础的服务类，通过条件化配置被定义为 Bean。

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
java -cp target/classes:target/dependency/* com.lq.条件包.启动类
```

## 依赖关系

- `org.springframework:spring-context:5.2.16.RELEASE` - Spring 上下文核心库
- `org.springframework:spring-tx:5.2.16.RELEASE` - Spring 事务管理库

## 配置说明

### 条件化配置

Spring v4.0 引入了强大的条件化配置功能，通过 [@Conditional](src/main/java/com/lq/condition/JavaConfig.java#L16) 注解实现：

```java
@Bean
@Conditional(MyCondition.class)
public StudentService studentService() {
    return new StudentService();
}
```

### 条件判断逻辑

[MyCondition](src/main/java/com/lq/condition/MyCondition.java) 类实现了条件判断逻辑：

```java
public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 根据环境、配置等条件决定是否创建 Bean
        return true;
    }
}
```

## 学习要点

1. 理解条件化配置的使用场景和实现方式
2. 掌握 @Conditional 注解的使用
3. 了解 Condition 接口的实现方式
4. 认识配置条件化的灵活性和强大功能

## 与其它版本的差异

相比于其它版本 Spring：

1. 相比 v3.0，增加了条件化配置功能，使配置更加灵活
2. 相比 v5.0，缺少函数式编程和响应式编程支持
3. 提供了比早期版本更完善的注解驱动开发体验

## 注意事项

1. 本示例使用的是 Spring 5.2.16.RELEASE 版本，仅用于教学演示
2. 实际的 Spring 4.0 版本已经较为老旧
3. 条件化配置需要正确实现 Condition 接口