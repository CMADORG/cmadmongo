package com.mongo.utils;

import com.mongo.api.User;

public class UserValidator {

	public static boolean validateUserParams(User user)
	{
		return user !=null && user.getUsername() != null /*&& user.getUsername().matches("[A-Za-z0-9]") */&& user.getPassword() != null;
	}
}
