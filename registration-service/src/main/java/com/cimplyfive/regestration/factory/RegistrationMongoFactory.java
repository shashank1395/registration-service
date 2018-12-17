package com.cimplyfive.regestration.factory;

import java.util.Objects;

import org.apache.log4j.Logger;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class RegistrationMongoFactory {

	private static Logger log = Logger.getLogger(RegistrationMongoFactory.class);
	
	private static Mongo registrationMongo;
	
	private RegistrationMongoFactory() {}
	
	/**
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static Mongo getRegistrationMongo() {
		int port_no = 27017;
		String hostname = "localhost"; 
		if(!Objects.nonNull(registrationMongo)) {
			try {
				registrationMongo = new Mongo(hostname, port_no);
			}catch (MongoException exception) {
              log.error(exception);
			}
		}
		return registrationMongo;
	}
	
	@SuppressWarnings("deprecation")
	public static DB getDB(String databaseName) {
		return getRegistrationMongo().getDB(databaseName);
	}

	public static DBCollection getCollection(String databseName, String collectionName) {
		return getDB(databseName).getCollection(collectionName);

	}
}
