package edu.aydin.InventoryTracker.Database;

import com.mongodb.MongoClient;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class MongoAdapter {
    MongoClient mongoClient ;

    public MongoAdapter(){
        mongoClient = new MongoClient();
    }

    public MongoCollection getUserCollection(){

        MongoDatabase mongoDatabase = mongoClient.getDatabase("inventory");
        System.out.println("Connected to user database successfully");
        return mongoDatabase.getCollection("Users");
    }

    public MongoCollection getProductCollection(){
        MongoDatabase mongoDatabase = mongoClient.getDatabase("inventory");
        System.out.println("Connected to product database");
        return mongoDatabase.getCollection("Products");
    }

    public MongoCollection getDailyVisits(){
        MongoDatabase mongoDatabase = mongoClient.getDatabase("inventory");
        return mongoDatabase.getCollection("DailyVisit");
    }


    public void closeMongoClient(){
        mongoClient.close();
    }

}
