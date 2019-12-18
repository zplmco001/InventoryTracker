package edu.aydin.InventoryTracker.Database;

import edu.aydin.InventoryTracker.Model.Product;
import edu.aydin.InventoryTracker.Model.User;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MongoConnection {
    MongoAdapter adapter;

    public MongoConnection() {
        this.adapter = new MongoAdapter();
    }

    public boolean addroduct(String name, String quantity){
        boolean success = false;
        try{
            this.adapter.getProductCollection().insertOne(new Document().append("name",name).append("quantity",quantity));
            success = true;
        }catch (Exception e){
            System.out.println(e);
            success = false;
        }
        return success;
    }

    public boolean addUser(String firstname, String lastname, String username, String phone, String email, String password, boolean isAdmin, Map<String,String> productList){
        try {
            this.adapter.getUserCollection().insertOne(
                    new Document("name",firstname)
                            .append("surname",lastname)
                            .append("username",username)
                            .append("phone",phone)
                            .append("email",email)
                            .append("password",password)
                            .append("isAdmin",isAdmin)
                            .append("productList",productList)
            );

            return true;

        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public ArrayList<User> getUserList(){
        ArrayList<User> userList = new ArrayList<>();
        MongoCursor<Document> cursor = adapter.getUserCollection().find().iterator();
        while(cursor.hasNext()){
            Document document = cursor.next();
            String id = document.get("_id").toString();
            String firstName = document.get("name").toString();
            String lastName = document.get("surname").toString();
            String phoneNumber = document.get("phone").toString();
            String email = document.get("email").toString();
            Document products = (Document) document.get("productList");

            HashMap<String,Object> userProduct = new HashMap<>();
            for(Map.Entry<String,Object> entry : products.entrySet()){
                String name = entry.getKey();
                int quantity = Integer.parseInt(entry.getValue().toString());
                userProduct.put(name,quantity);
                System.out.println(name + " " + quantity);
            }

            User user = new User(id,firstName,lastName,phoneNumber,email);
            user.setUserProduct(userProduct);
            userList.add(user);
        }
        return userList;
    }

    public ArrayList<Product> getProductList(){
        ArrayList<Product> products = new ArrayList<>();
        MongoCursor<Document> cursor = adapter.getProductCollection().find().iterator();
        while (cursor.hasNext()){
            Document document = cursor.next();
            String productId = document.get("_id").toString();
            String productName = document.get("name").toString();
            String productQuantity = document.get("quantity").toString();
            Product product = new Product(productId,productName,productQuantity);
            products.add(product);
        }

        return products;
    }



}
