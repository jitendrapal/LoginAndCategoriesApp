package com.user.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.login.dto.UserLoginDTO;
import com.user.login.dto.UserResponseDTO;
import com.user.login.service.CustomerServiceImpl;

@RestController
@RequestMapping(value = "/user")
public class LoginController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public UserResponseDTO UserValidate(@RequestBody UserLoginDTO userLoginDTO) {
		return customerServiceImpl.UserValidate(userLoginDTO);
	}

}
