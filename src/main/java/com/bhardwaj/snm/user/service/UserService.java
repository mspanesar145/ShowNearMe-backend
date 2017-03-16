package com.bhardwaj.snm.user.service;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.bhardwaj.snm.user.User;
import com.bhardwaj.snm.user.repository.UserRepository;

@Component
public class UserService {
	
	private UserRepository userRepository;
	private User user;
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User createUser(User user) {
		this.user = userRepository.findOneByPhone(user.getPhone());
		if (null == this.user) {
			this.user = new User();
			if ("" != user.getPhone() && null != user.getPhone()) {
				this.user.setPhone(user.getPhone());
	        }
			this.user.setCreationTimestamp(new Date());
			this.user.setName(user.getName());
			this.user.setToken(user.getToken());
			this.user.setDevice(user.getDevice());
			return userRepository.save(this.user);
		} else {
			return userRepository.updateUser(user.getUserId(), user.getDevice(), user.getToken());
		}
	}
}
