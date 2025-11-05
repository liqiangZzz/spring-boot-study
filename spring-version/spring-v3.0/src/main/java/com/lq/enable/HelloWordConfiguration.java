package com.lq.enable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName HelloWordConfiguration
 * @Description
 * @Author liqiang
 * @Date 2025/11/5 17:15
 */
@Configuration
public class HelloWordConfiguration {

    @Bean
    public String helloWorld() {
        return "Hello World";
    }

}
