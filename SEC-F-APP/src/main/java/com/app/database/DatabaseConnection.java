package com.app.database;


import javax.print.Doc;

import com.app.config.AppSecretData;
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
	
	private static String DB_USERNAME = AppSecretData.loadAppSecrets("MONGO_DB_USERNAME", "en", "US");
	private static String DB_PASSWORD = AppSecretData.loadAppSecrets("MONGO_DB_PASSWORD", "en", "US");
	
	 static String connectionString = "mongodb+srv://"+DB_USERNAME+":"+DB_PASSWORD+"@cluster0.nktwqqb.mongodb.net/?appName=Cluster0";

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
	
	 
	 public static Document loginUser(String email) {
		 Document userSearch = new Document("userEmail", email);
		 Document user = c.find(userSearch).first();
		 if(user != null) {
			 return user;
		 }
		 return null;
	 }
	 
	 public static void verifyUser(String email) {
		 Document userSearch = new Document("userEmail", email);
		 Document user = c.find(userSearch).first();
		 if(user != null) {
			 Document updatedUser = new Document("$set", new Document("isVerified", true));
			 c.findOneAndUpdate(userSearch,updatedUser);
		 }else {
			 System.out.println("No USer Found");
		 }
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

