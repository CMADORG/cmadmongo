package com.mongo.config;

public class BlogConfig {
	
	public static String getMongoDBIP()
	{
		return "127.0.0.1:27017";	
	}
	public static String getDBName()
	{
		return "Users";
	}
	public static String getJWTsecretKey() {
		// TODO Auto-generated method stub
		return "our-blog";
	}
}
