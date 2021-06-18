package com.wangxingangs.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxingangs
 */
@RestController
public class HelloController {

	@GetMapping("/sayHello/{name}")
	public String sayHello(@PathVariable("name") String name) {
		System.out.println("打招呼, name=" + name);
		return "{'msg': 'hello, " + name + "'}";
	}
}
