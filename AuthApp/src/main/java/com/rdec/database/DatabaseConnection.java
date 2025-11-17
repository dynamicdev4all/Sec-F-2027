package com.rdec.database;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.rdec.config.SecretReader;

import shadow.org.bson.Document;

public class DatabaseConnection {
	
	  static String connectionString = SecretReader.readSecrets("MONGO_DB_URI", "en", "US");
	  static ServerApi serverApi = ServerApi.builder()
	                .version(ServerApiVersion.V1)
	                .build();
	  static MongoClientSettings settings = MongoClientSettings.builder()
		                .applyConnectionString(new ConnectionString(connectionString))
		                .serverApi(serverApi)
		                .build();
	  static MongoClient mongoClient = MongoClients.create(settings);
	  static MongoDatabase database = mongoClient.getDatabase("secd");
	  static MongoCollection<Document> c = database.getCollection("users");
	
			  
			  
	public static boolean insertUserData(String firstName, String lastName, int phone, String userEmail, String userPassword) {
		try {
			  c.insertOne(new Document("firstName", firstName)
		  				.append("lastName", lastName)
		  				.append("mobileNum", phone)
		  				.append("userEmail", userEmail)
		  				.append("userPassword", userPassword)
		  				.append("isVerified", false));
			  return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public static boolean verifyUser(String email) {
		try {
			Document user = c.find(new Document("userEmail", email)).first(); // this code is used to find the user by their email add
			if(user != null) {
				Document updatedUser = new Document("$set", new Document("isVerified", true)); // then here we are updating the "isVerified" field from false to true
				c.findOneAndUpdate(user, updatedUser); // now here we are again updating the entire document in the db
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public static Document loginUser(String email) {
		Document user = c.find(new Document("userEmail", email)).first();
		if(user != null) {
			return user;
		}
		return null;
	}
}
