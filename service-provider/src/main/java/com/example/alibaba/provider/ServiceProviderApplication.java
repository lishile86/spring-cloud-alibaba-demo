package com.example.alibaba.provider;

import javafx.concurrent.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lishile
 * @version 1.0
 * @since 2019/12/1
 */
@RefreshScope
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceProviderApplication {
    @Value("${config.test}")
    private String testConfigValue;

    @GetMapping("/config")
    public String getConfigValue() {
        return testConfigValue;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderApplication.class, args);
    }

}
