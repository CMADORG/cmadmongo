package com.mongo.api;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;


@Entity
public class User {
	
	@Id
	private String username;
	private String passHash;
	private String password;
	/*private String emailID;
	private String photoUrl;
	private String descriptionTxt;
	private String interests;
	private String dateofBirth;*/
	//@Embedded
	//@Embedded
	//List<Blog>[] myblogs;
	
	public User(String uname, String password) {
		this.username = uname;
		this.password = password;
		// TODO Auto-generated constructor stub
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassHash() {
		return passHash;
	}
	public void setPassHash(String passHash) {
		this.passHash = passHash;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
