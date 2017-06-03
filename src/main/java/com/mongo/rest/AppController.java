package com.mongo.rest;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.mongo.api.User;
import com.mongo.filter.JWTTokenNeeded;
import com.mongo.services.UserServices;
import com.mongo.utils.JWTUtils;
import com.mongo.utils.PasswordUtil;
import com.mongo.utils.UserValidator;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;
@Path("/users")
public class AppController {
	
	UserServices us = new UserServices();
	@Context
	UriInfo uriinfo;
	
	@JWTTokenNeeded
	@Path("/hi")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String Hello()
	{
		return "Hello";
	}
	
	@Path("/register")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response registerUser(User user)
	{
		if(!UserValidator.validateUserParams(user))
		{
			throw new InvalidUserException("User name / password is invalid");
		}
		else
		{
			us.register(user);
			Response.ok(200).entity(us).header("Location", uriinfo.getBaseUri() + "/" +user.getUsername()).build();
			
		}
		return null;
		
	}
	
	@Path("/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loginUser(User user)
	{
		if(!UserValidator.validateUserParams(user))
		{
			throw new InvalidUserException("User name / password is invalid");
		}
		else
		{
	
			User newuser = us.login(user);
			if(newuser != null){
				String token = JWTUtils.issueToken(user.getUsername(), uriinfo.getAbsolutePath().toString());
				return Response.ok(200).header(AUTHORIZATION, "Bearer" +token).build();
			}
			return Response.status(UNAUTHORIZED).build();	
		}
		
	}
	@JWTTokenNeeded
	@Path("/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response logout(User user)
	{
		if(!UserValidator.validateUserParams(user))
		{
			throw new InvalidUserException("User name / password is invalid");
		}
		else
		{
	
			User newuser = us.login(user);
			if(newuser != null){
				String token = JWTUtils.issueToken(user.getUsername(), uriinfo.getAbsolutePath().toString());
				return Response.ok(200).header(AUTHORIZATION, null).build();
			}
			return Response.status(UNAUTHORIZED).build();	
		}
		
	}


}
