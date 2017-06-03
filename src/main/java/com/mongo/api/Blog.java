package com.mongo.api;

import java.util.Date;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class Blog {

	@Id
	private String Blogid;
	private String title;
	private String category;
	private String[] tags;
	private String blog;
	private Date date;
	@Reference 
	private BlogComments comments; 
//	@Embedded 
//	private Comment[] comments;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String[] getTags() {
		return tags;
	}



	public void setTags(String[] tags) {
		this.tags = tags;
	}



	public String getBlog() {
		return blog;
	}



	public void setBlog(String blog) {
		this.blog = blog;
	}

	public Blog() {
		// TODO Auto-generated constructor stub
	}


	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}

}
