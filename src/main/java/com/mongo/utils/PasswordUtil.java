package com.mongo.utils;

import java.security.MessageDigest;
import java.util.Base64;

import com.mongo.rest.InvalidParameterException;


public class PasswordUtil {

	public PasswordUtil() {
	}
		
	public static String encryptPassword(String password)
	{
			try {
				MessageDigest md =  MessageDigest.getInstance("SHA-256");
				md.update(password.getBytes("UTF-8"));
				byte[] digest = md.digest();
				return new String(Base64.getEncoder().encode(digest));
				
			}
			catch(Exception e)
			{
				throw new RuntimeException("Password Encryption failed");
			}
	}

}
