package com.ncme.svc.area;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 基于Eureka 注册中心，需要先启动注册中心
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SvcAreaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SvcAreaApplication.class, args);
    }

}
