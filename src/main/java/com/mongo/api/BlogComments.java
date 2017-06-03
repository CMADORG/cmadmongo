package com.mongo.api;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

public class BlogComments {

	@Id
	private String blogID;
	@Embedded
	List<Comment>[] comment;
	
	//private String 
	
	public BlogComments() {
		// TODO Auto-generated constructor stub
	}

}
