package Database;

import com.mongodb.MongoClient;

import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class MongoAdapter {
    MongoClient mongoClient ;

    public MongoCollection getUserCollection(){
        mongoClient = new MongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("inventory");
        System.out.println("Connected to user database successfully");
        return mongoDatabase.getCollection("Users");
    }

    public MongoCollection getProductCollection(){
        mongoClient = new MongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("inventory");
        System.out.println("Connected to product database");
        return mongoDatabase.getCollection("Products");
    }

    public void closeMongoClient(){
        mongoClient.close();
    }

}
