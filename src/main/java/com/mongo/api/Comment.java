package com.mongo.api;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class Comment {

	@Id
	private String commentid;
	private String Comment;
	private String username;
	private Date date;
	
	
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

}
