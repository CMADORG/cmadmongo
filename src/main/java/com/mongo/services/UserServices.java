package com.mongo.services;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongo.api.User;
import com.mongo.config.BlogConfig;
import com.mongo.data.DataStoreFactory;
import com.mongo.data.MongoUserDAO;
import com.mongo.rest.InvalidParameterException;
import com.mongo.utils.UserValidator;
import com.mongodb.MongoClient;

public class UserServices {

	MongoUserDAO userdao = null;
	public UserServices() {
		userdao = new MongoUserDAO(User.class, (new DataStoreFactory()).getDataStore(BlogConfig.getDBName()));
	}
	public void register(User u)
	{
		userdao.register(u);
	}
	/*@Docs
	 * 
	 * This function authenticate user and generates a token
	 * */
	public User login(User u)
	{
		User newuser = userdao.readUserByNameandPassword(u);
		if(newuser != null)
		{
			return newuser;
		}
		else
		{
			throw new InvalidParameterException("User name of password is wrong");
		}
	}
	

}
