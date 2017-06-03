package com.mongo.filter;

import java.io.IOException;
import java.security.Key;

import javax.annotation.Priority;
import javax.crypto.KeyGenerator;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.mongo.utils.KeyGen;

import io.jsonwebtoken.Jwts;

@Provider
@JWTTokenNeeded
@Priority(Priorities.AUTHENTICATION)
public class JWTTokenNeededFilter implements ContainerRequestFilter {

	//private KeyGenerator keyGenerator = KeyGen;
	public void filter(ContainerRequestContext request) throws IOException {
		
		System.out.println("coming to filter");
		String authHeader = request.getHeaderString(HttpHeaders.AUTHORIZATION);
		System.out.println("Header =  " +authHeader);
		if(authHeader == null && !authHeader.startsWith("Bearer"))
		{
			System.out.println("Not starting with Bearer");
			throw new NotAuthorizedException("User is not authorized");
		}
		
		System.out.println("JWTTokenNeededFilter.filter() Header = " +authHeader);
		String token = authHeader.substring("Bearer".length()).trim();
		System.out.println("JWTTokenNeededFilter.filter() token = " +token);
		Key key = KeyGen.getSecretKey();
		try {
		Jwts.parser().setSigningKey(key).parseClaimsJws(token);
		}
		catch(Exception e)
		{
			System.out.println("invalid exception");
			request.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}	
	}
}
