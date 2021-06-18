package com.wangxingangs.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;

import com.glenn.demo.ServiceAInterface;

/**
 * 这个FeignClient里面的名字，就是你要调用的那个服务的名字
 * 什么叫声明式的方式，就是不用写代码，直接接口+注解就搞定了，直接就可以访问别的服务
 * 
 * 你用了feign之后，其实spring cloud直接将feign和ribbon整合再一起了
 * feign+ribbon+eureka都是整合在一起的
 * 
 * feign发起请求的时候，都是会交给ribbon的LoadBalancer去进行负载均衡的
 * 
 * 
 * 疑问来了，我希望的是，ServiceB要调用ServiceA
 * 我希望的是，我连这个下面这一堆接口都不用自己定义，ServiceA直接提供给我们这一堆东西，我们拿来直接用
 * 这里其实有重复行的劳动在里面的，其实每个接口的一堆定义和注解，都是ServiceA搞定就可以了
 * 不需要ServiceB重复的定义一遍
 */
//@SuppressWarnings("unused")
//@FeignClient("ServiceA")
//public interface ServiceAClient {
//
//	@GetMapping("/user/sayHello/{id}")
//	public String sayHello(@PathVariable("id") Long id, 
//			@RequestParam("name") String name,
//			@RequestParam("age") Integer age);
//	
//	@PostMapping("/user/")
//	public String createUser(@RequestBody User user);
//	
//	@PutMapping("/user/{id}")
//	public String updateUser(@PathVariable("id") Long id, @RequestBody User user);
//	
//	@DeleteMapping("/user/{id}")
//	public String deleteUser(@PathVariable("id") Long id);
//	
//	@GetMapping("/user/{id}")
//	public User getById(@PathVariable("id") Long id);
//}


//第四种基于feign的声明式微服务调用（引入jar包；继承service-provider提供的接口即可）
// 这里是说，我要访问ServiceA，但是人家service-provider里面定义了那些接口，那些参数，都不用你管了
// 这里不用SerivceB把接口的定义重新写一遍了，直接用人家jar包里面提供的就好了
@FeignClient("service-provider")
public interface ProviderClient extends ServiceAInterface {

}
