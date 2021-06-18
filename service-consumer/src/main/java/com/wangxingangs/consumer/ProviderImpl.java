package com.wangxingangs.consumer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 基于ribbon做了一些简单的封装，对服务A进行调用(还是比较麻烦的，所以要使用feign声明式的服务调用；正常来说，微服务中，B服务调用A服务，B服务是不需要针对A服务的调用而写一堆多余的代码的)
 * @author glenn wang
 * 2020年3月14日上午10:43:37
 */
@Service
@Configuration
public class ProviderImpl implements IProvider {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Override
	public String sayHello(String name) {   
		RestTemplate restTemplate = getRestTemplate();
		return restTemplate.getForObject("http://ServiceA/sayHello/" + name, String.class);
	}
}
