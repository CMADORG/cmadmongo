package com.mongo.data;



import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.mongo.api.Blog;
import com.mongo.api.User;
import com.mongo.rest.DuplicateUserException;
import com.mongo.rest.InvalidParameterException;
import com.mongo.utils.PasswordUtil;
import com.mongodb.MongoClient;
import com.mongodb.operation.UserExistsOperation;

public class MongoUserDAO extends BasicDAO<User, Double> implements UserDAO  {
	
	Datastore datastore = null;
	
	public MongoUserDAO(Class<User> entityClass, Datastore ds) {
		super(entityClass,ds);
		
	}

	@Override
	public void register(User user) throws InvalidParameterException, DuplicateUserException {
		
		if(user == null || user.getUsername() == null || user.getPassword() == null 
				|| user.getUsername().isEmpty() == true)
		{
			throw new InvalidParameterException("User name or passoword is not valid");
		}
		else
		{
			Query<User> q = createQuery().filter("username", user.getUsername());
			if(q.count() != 0)
			{
				throw new DuplicateUserException("Duplicate user exception");
			}
			else
			{
				String passHash = PasswordUtil.encryptPassword(user.getPassword());
				user.setPassHash(passHash);
				/*We dont need to save the password*/
				user.setPassword(null);
				this.save(user);
			}
		}
	}

	@Override
	public User readUserByNameandPassword(User user) throws InvalidParameterException, DuplicateUserException {
		if(user == null || user.getUsername() == null || user.getPassword() == null)
		{
			throw new InvalidParameterException("User name or passoword is not valid");
		}
		else
		{
			String passHash = PasswordUtil.encryptPassword(user.getPassword());
			Query<User> q = createQuery().filter("username", user.getUsername()).filter("passHash", passHash);
			if(q.count() == 0)
			{
				throw new InvalidParameterException("User name or password is invalid");
			}
			else
			{
				User result = q.get();	
				return result;
			}
	}

	}

	@Override
	public void logout() throws InvalidParameterException, DuplicateUserException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addBlog(Blog blog) {
		
		Query<User> q = createQuery().field("username").contains("sankar"); //.("username", "sankar");
		//UpdateOperations<User> 
		List<Blog> nwlist = new ArrayList<Blog>();
		nwlist.add(blog);
		UpdateOperations<User> ops = createUpdateOperations().addToSet("myblogs",nwlist);
		update(q, ops);
		
		
	}
	


}
