package com.mongo.utils;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;

import com.mongo.config.BlogConfig;

public class KeyGen {
	
	public static Key getSecretKey()
	{
		String secret = BlogConfig.getJWTsecretKey();
		return new SecretKeySpec(secret.getBytes(), 0 , secret.length(),"DES");
	}

}
