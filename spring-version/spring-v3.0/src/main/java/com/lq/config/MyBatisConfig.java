package com.lq.config;

import com.lq.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyBatisConfig
 * @Description
 * @Author liqiang
 * @Date 2025/10/22 13:29
 */
@Configuration
public class MyBatisConfig {

    @Bean
    public StudentService studentService(){
        return new StudentService();
    }
}
