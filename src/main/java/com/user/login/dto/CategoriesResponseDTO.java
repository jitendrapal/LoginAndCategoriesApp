package com.user.login.dto;

import java.util.List;

import lombok.Data;

@Data
public class CategoriesResponseDTO {
 
	private List<AvailableCategories> availableCategories;

	private List<SubscribedCategories> subscribedCategories;

}
