package com.app.database;


import javax.print.Doc;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import shadow.org.bson.Document;

public class DatabaseConnection {
	
	 static String connectionString = "mongodb+srv://piebytwo014:piebytwo014@cluster0.nktwqqb.mongodb.net/?appName=Cluster0";

     static ServerApi serverApi = ServerApi.builder()
             .version(ServerApiVersion.V1)
             .build();

     static MongoClientSettings settings = MongoClientSettings.builder()
             .applyConnectionString(new ConnectionString(connectionString))
             .serverApi(serverApi)
             .build();
     static MongoClient mongoClient = MongoClients.create(settings);
	 static MongoDatabase database = mongoClient.getDatabase("secf");
	 static MongoCollection<Document> c = database.getCollection("users");
	
	 
	 public static void verifyUser() {
		 // first step is to search for user
		 //then update the arg from false to true
		 //then reinsert the updated data in the db
	 }
	
	public static boolean insertUserData(String firstName, String lastName, int phone, String userEmail, String userPassword) {
		
		try {
			c.insertOne(new Document("firstName",firstName)
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
}

