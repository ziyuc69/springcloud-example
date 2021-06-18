package com.wangxingangs.consumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.glenn.demo.User;


@RestController
@RequestMapping("/ServiceConsumer/user")
public class ConsumerController {

// 第一种基于feign的声明式微服务调用
	
//	@Autowired
//	private ProviderClient providerClient;

//	@GetMapping("/sayHello/{id}")
//	public String sayHello(@PathVariable("id") Long id,
//			@RequestParam("name") String name,
//			@RequestParam("age") Integer age) {
//		return providerClient.sayHello(id, name, age);
//	}
	
// 第二种 请查看ServiceAClient接口
// 这里的话，User实体类就可以删掉了，不需要；直接使用jar里面的User实体类
	@Autowired
	private ProviderClient serviceA;
	
	@GetMapping("/sayHello/{id}")
	public String sayHello(@PathVariable("id") Long id, 
			@RequestParam("name") String name,
			@RequestParam("age") Integer age) {
		return serviceA.sayHello(id, name, age);
	}
	
	@PostMapping("/")
	public String createUser(@RequestBody User user) {
		return serviceA.createUser(user);
	}
	
	@PutMapping("/{id}")
	public String updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		return serviceA.updateUser(id, user);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		return serviceA.deleteUser(id);
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable("id") Long id) {
		return serviceA.getById(id);
	}
}
