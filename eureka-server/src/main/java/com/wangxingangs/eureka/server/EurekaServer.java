package com.wangxingangs.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心的启动类
 * @author wangxingangs
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer {
    public static void main( String[] args ) {
        SpringApplication.run(EurekaServer.class, args);
    }
}
