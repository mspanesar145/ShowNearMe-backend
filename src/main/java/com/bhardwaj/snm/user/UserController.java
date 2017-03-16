package com.bhardwaj.snm.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhardwaj.snm.user.service.UserService;

@RestController
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/user/registration", method = RequestMethod.POST)
	/*public User registerUser(@RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("token") String token,
			@RequestParam("device") String device) {
		userService.createUser(name, phone, token, device);
		return null;
	}*/
	public User registerUser(@RequestBody User user) {
		return userService.createUser(user);
	}
}
