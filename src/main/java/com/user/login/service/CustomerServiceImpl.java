package com.user.login.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.login.common.Constant;
import com.user.login.dto.AvailableCategories;
import com.user.login.dto.CategoriesResponseDTO;
import com.user.login.dto.SubscribedCategories;
import com.user.login.dto.UserLoginDTO;
import com.user.login.dto.UserResponseDTO;
import com.user.login.encryption.EncryptionUtil;
import com.user.login.entity.Login;
import com.user.login.repository.LoginUser;

@Component
public class CustomerServiceImpl {

	@Autowired
	private LoginUser logiUser;
	private UserResponseDTO userResponseDTO = new UserResponseDTO();
	private CategoriesResponseDTO categoriesResponseDTO=new CategoriesResponseDTO();

	public UserResponseDTO UserValidate(UserLoginDTO userLoginDTO) {
		Optional<Login> Userlogin = logiUser.findByEmail(userLoginDTO.getEmail());
		if (Userlogin.isPresent()) {
			if (userLoginDTO.getEmail().equals(Userlogin.get().getEmail())
					&& userLoginDTO.getPassword().equals(EncryptionUtil.decrypt(Userlogin.get().getPassword()))) {
				
				List<AvailableCategories> availableCategoriesList=new ArrayList<>();
				AvailableCategories availableCategories=new AvailableCategories();
				availableCategories.setName("Dutch Films");
				availableCategories.setAvailableContent(10);
				availableCategories.setPrice("4.0");
				availableCategoriesList.add(availableCategories);
				categoriesResponseDTO.setAvailableCategories(availableCategoriesList);
				List<SubscribedCategories> subscribedCategoriesList=new  ArrayList<>();
				SubscribedCategories subscribedCategories=new SubscribedCategories();
				subscribedCategories.setName("International films");
				subscribedCategories.setPrice("8.0");
				subscribedCategories.setRemainingContent(5);
				subscribedCategories.setStartDate(new Date());
				subscribedCategoriesList.add(subscribedCategories);
				categoriesResponseDTO.setSubscribedCategories(subscribedCategoriesList);
				userResponseDTO.setStatus(Constant.LOGIN_SUCCESS);
				userResponseDTO.setMessage(Constant.CONGRATS_USER);

			} else {
				userResponseDTO.setStatus(Constant.LOGIN_FAILD);
				userResponseDTO.setMessage(Constant.INCORRECT_USER_PWD);
			}

		}
		return userResponseDTO;

	}

	public CategoriesResponseDTO UserCategories() {
		

		List<AvailableCategories> availableCategoriesList=new ArrayList<>();
		AvailableCategories availableCategories=new AvailableCategories();
		availableCategories.setName("Dutch Films");
		availableCategories.setAvailableContent(10);
		availableCategories.setPrice("4.0");
		AvailableCategories availableCategories1=new AvailableCategories();
		availableCategories.setName("Dutch Films");
		availableCategories.setAvailableContent(20);
		availableCategories.setPrice("6.0");
		availableCategoriesList.add(availableCategories);
		availableCategoriesList.add(availableCategories1);
		categoriesResponseDTO.setAvailableCategories(availableCategoriesList);
		List<SubscribedCategories> subscribedCategoriesList=new  ArrayList<>();
		SubscribedCategories subscribedCategories=new SubscribedCategories();
		subscribedCategories.setName("International films");
		subscribedCategories.setPrice("8.0");
		subscribedCategories.setRemainingContent(5);
		subscribedCategories.setStartDate(new Date());
		subscribedCategoriesList.add(subscribedCategories);
		categoriesResponseDTO.setSubscribedCategories(subscribedCategoriesList);
		return categoriesResponseDTO;
	}


}
