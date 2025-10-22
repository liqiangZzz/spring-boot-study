package com.lq.import2;

import com.lq.config.MyBatisConfig;
import com.lq.import2.service.PersonService;
import com.lq.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @ClassName JavaConfig
 * @Description
 * @Author liqiang
 * @Date 2025/10/22 13:36
 */
@Configuration
//注解将指定的配置类引入到当前的配置中，实现配置的模块化管理
//@Import(MyBatisConfig.class)
//注解可以导入一个或多个组件类，这些类会被注册为Spring容器中的Bean
@Import(value = {PersonService.class, UserService.class})
public class JavaConfig {


    public static void main(String[] args) {
        ApplicationContext ac =
                new AnnotationConfigApplicationContext(JavaConfig.class);

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

    }
}
