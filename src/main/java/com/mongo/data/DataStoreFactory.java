package com.mongo.data;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongo.config.BlogConfig;
import com.mongo.rest.DataStoreException;
import com.mongodb.MongoClient;

public class DataStoreFactory {
	private MongoClient mongoClient;
	private Morphia morphia;
	private Datastore datastore;

	public DataStoreFactory() {
		this.mongoClient = new MongoClient(BlogConfig.getMongoDBIP());
		 this.morphia = new Morphia();
	}
	
	public Datastore getDataStore(String databaseName)
	{	 try {
		 return this.datastore = morphia.createDatastore(mongoClient, databaseName);
		}
		catch(Exception e)
		{
			throw new DataStoreException("Something went wron in data store");
		}
	}

}
