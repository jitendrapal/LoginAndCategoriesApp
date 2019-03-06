package com.user.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.login.dto.CategoriesResponseDTO;
import com.user.login.service.CustomerServiceImpl;

@RestController
public class CategoriesController {
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@RequestMapping(value = "/cotegories", method = RequestMethod.GET)
	public CategoriesResponseDTO UserCategories() {
		return customerServiceImpl.UserCategories();
	}

}
