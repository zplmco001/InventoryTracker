package Database;

import Model.User;
import com.mongodb.MongoClient;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;


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


    public void closeMongoClient(){
        mongoClient.close();
    }

}
