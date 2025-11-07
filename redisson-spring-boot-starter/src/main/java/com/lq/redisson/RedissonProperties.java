package com.lq.redisson;

import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * @ClassName RedissonAutoConfiguration
 * @Description  redisson 配置
 * @Author liqiang
 * @Date 2025/11/7 16:49
 */
@ConfigurationProperties(prefix = "lq.redisson")
public class RedissonProperties {

    private String host = "localhost";
    private Integer port = 6379;
    private int timeout = 1000;
    private boolean ssl = false;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }
}
