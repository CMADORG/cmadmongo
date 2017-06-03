package com.mongo.api;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("UserBlogs")
public class UserBlogs {

	@Id
	private String username;
	@Embedded
	List<Blog>[] myblogs;
	
	public UserBlogs() {
		// TODO Auto-generated constructor stub
	}

}
