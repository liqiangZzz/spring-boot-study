package com.lq.config;

import com.lq.service.ProductService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 条件化自动配置类
 * 
 * 该配置类实现了Spring Boot中基于条件的自动配置机制，
 * 通过{@link ConditionalOnClass}和{@link ConditionalOnBean}注解
 * 实现运行时条件判断和Bean的按需注册。
 * 
 * 作为提供方，该配置类为满足特定前置条件的外部应用提供增强的服务组件。
 * 
 * 与spring-autoconfigure-metadata.properties的关系：
 * 1. 该类中的注解提供了运行时条件判断逻辑
 * 2. 元数据文件提供了编译期条件声明，用于优化自动配置候选者的筛选过程
 * 3. 两者结合使用可实现更高效的自动配置机制
 * 
 * Bean命名策略：
 * - primaryProductService: 调用方定义的基础服务Bean
 * - conditionalProductService: 本配置类创建的条件化增强服务Bean
 * 通过不同的Bean名称避免类型冲突问题
 * 
 * 注意：如果提供方和调用方使用相同的Bean名称，后注册的Bean会覆盖先注册的Bean，
 * 这可能导致意外的行为。建议使用不同的Bean名称以确保可预测性。
 * 
 * @author liqiang
 * @since 1.0.0
 */
@Configuration
@ConditionalOnClass(name = "com.lq.autoconfigure.CoreAutoConfiguration")
public class ConditionalConfig {

    /**
     * 条件化 ProductService Bean注册
     * 
     * 该Bean仅在满足以下运行时条件时才会被注册到Spring应用上下文中：
     * 1. classpath中存在com.lq.autoconfigure.CoreAutoConfiguration类
     * 2. Spring容器中已存在名为"primaryProductService"的Bean实例
     * 
     * 注意：该Bean与primaryProductService Bean是不同的实例，用于提供增强功能
     * Bean名称为"conditionalProductService"，避免与调用方定义的"primaryProductService"冲突
     * 
     * 如果使用相同名称（如"productService"），后注册的Bean会覆盖先注册的Bean，
     * 具体哪个生效取决于注册顺序，这可能导致不可预测的行为。
     * 
     * @return ProductService实例
     */
    @Bean
    @ConditionalOnBean(name = "primaryProductService")
    public ProductService conditionalProductService() {
        System.out.println("提供方创建的conditionalProductService Bean");
        return new ProductService(); // 提供增强功能的ProductService实例
    }
}