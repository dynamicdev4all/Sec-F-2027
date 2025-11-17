package com.app.database;


import com.app.models.UserModel;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import shadow.com.nimbusds.oauth2.sdk.device.UserCode;
import shadow.org.bson.Document;

public class DatabaseConnection {
	 static String connectionString = "mongodb+srv://piebytwo014:piebytwo014@cluster0.wpqa5jt.mongodb.net/?appName=Cluster0";

     static ServerApi serverApi = ServerApi.builder()
              .version(ServerApiVersion.V1)
              .build();

     static MongoClientSettings settings = MongoClientSettings.builder()
              .applyConnectionString(new ConnectionString(connectionString))
              .serverApi(serverApi)
              .build();
	static MongoClient mongoClient = MongoClients.create(settings);
	static MongoDatabase database = mongoClient.getDatabase("sece");
	static MongoCollection<Document> c = database.getCollection("users");
	
//	public static void saveUserData(String firstName, String lastName, int phone, String userEmail, String userPassword) {
//		
//		  c.insertOne(new Document("firstName", firstName)
// 				 .append("lastName", lastName)
// 				 .append("mobile", phone)
// 				 .append("userEmail", userEmail)
// 				 .append("userPassword", userPassword));
//		
//	}
	
	public static boolean verifyUser(String email) {
		try {
			Document userSearch = new Document("userEmail", email);
			Document userFound = c.find(userSearch).first();
			if(userFound != null) {
				Document updatedUser = new Document("$set", new Document("isVerified", true));
				c.findOneAndUpdate(userFound, updatedUser);
			}
			return false;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
	public static boolean saveUserData(String firstName, String lastName, int phone, String userEmail, String userPassword) {
		try {
			  UserModel user = new UserModel(firstName, lastName, phone, userEmail, userPassword);		
			  c.insertOne(new Document("firstName", UserModel.getFirstName())
					 .append("lastName", UserModel.getLastName())
					 .append("mobile", UserModel.getPhone())
					 .append("userEmail", UserModel.getUserEmail())
					 .append("userPassword", UserModel.getUserPassword())
					 .append("isVerified", false));
			  return true;
		} catch (Exception e) {
			return false;
		}	
	}
	
	
}

