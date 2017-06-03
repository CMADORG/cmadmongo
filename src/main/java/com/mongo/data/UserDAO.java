package com.mongo.data;

import com.mongo.api.Blog;
import com.mongo.api.User;
import com.mongo.rest.DuplicateUserException;
import com.mongo.rest.InvalidParameterException;

public interface UserDAO {
	
	/*What are the method to be supported*/
	public void register(User user) throws InvalidParameterException, DuplicateUserException;
	//public void login(User user) throws InvalidParameterException, DuplicateUserException;
	public void logout() throws InvalidParameterException, DuplicateUserException;
	public void addBlog(Blog blog);
	public User readUserByNameandPassword(User user) throws InvalidParameterException, DuplicateUserException;

}
