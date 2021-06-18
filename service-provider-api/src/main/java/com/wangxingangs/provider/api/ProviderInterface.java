package com.wangxingangs.provider.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/user")
public interface ProviderInterface {

	@GetMapping("/sayHello/{id}")
	public String sayHello(@PathVariable("id") Long id,
                           @RequestParam("name") String name,
                           @RequestParam("age") Integer age);
	
	@PostMapping("/")
	public String createUser(@RequestBody User user);
	
	@PutMapping("/{id}")
	public String updateUser(@PathVariable("id") Long id, @RequestBody User user);
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") Long id);
	
	@GetMapping("/{id}")
	public User getById(@PathVariable("id") Long id);
}
