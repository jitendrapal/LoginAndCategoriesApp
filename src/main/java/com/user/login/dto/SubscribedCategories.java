package com.user.login.dto;

import java.util.Date;

import lombok.Data;

@Data
public class SubscribedCategories {

	private String name;
	private int remainingContent;
	private String price;
	private Date startDate;
}
