package com.knowledge.accumulation.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 读取配置文件中的配置信息到内存中
 */
@Configuration
@ConfigurationProperties(prefix = "")
public class CachePropertiesConfig {

    private static final Logger logger = LoggerFactory.getLogger(CachePropertiesConfig.class);

    private Environment env;

   @Value("apiSecret")
    public static String apiSecret; //aibee分配apiSecret
    @Value("apiKey")
    public static String apiKey; //aibee分配apikey
}
