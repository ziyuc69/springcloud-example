package com.wangxingangs.provider;

import com.wangxingangs.provider.api.ProviderInterface;
import com.wangxingangs.provider.api.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxingangs
 */
@RestController
public class ProviderController implements ProviderInterface {

	@Override
	public String sayHello(@PathVariable("id") Long id, 
			@RequestParam("name") String name,
			@RequestParam("age") Integer age) {
		System.out.println("打招呼, id=" + id + ", name=" + name + ",age=" + age);
		return "{'msg': 'hello, " + name + "'}";
	}

	@Override
	public String createUser(@RequestBody User user) {
		System.out.println("创建用户, " + user);
		return "{'msg': 'success'}";
	}

	@Override
	public String updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		System.out.println("更新用户, " + user);
		return "{'msg': 'success'}";
	}

	@Override
	public String deleteUser(@PathVariable("id") Long id) {
		System.out.println("删除用户, id=" + id);
		return "{'msg': 'success'}";
	}

	@Override
	public User getById(@PathVariable("id") Long id) {
		System.out.println("查询用户, id=" + id);
		return new User(1L, "张三", 20);
	}
}
