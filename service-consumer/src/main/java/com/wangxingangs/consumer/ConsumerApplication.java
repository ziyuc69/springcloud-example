package com.wangxingangs.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 消费服务启动类
 * @author wangxingangs
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}
