package edu.aydin.InventroyTracker.Controller;

import Database.MongoAdapter;
import Model.User;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


public class DisplayUsersController extends HttpServlet {

    MongoAdapter mongoAdapter = new MongoAdapter();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<User> userList = new ArrayList<>();
        MongoCursor<Document> cursor = mongoAdapter.getUserCollection().find().iterator();
        while(cursor.hasNext()){
            System.out.println("çalıştı");
            try{
                Document document = cursor.next();
                String id = document.get("_id").toString();
                String firstName = document.get("name").toString();
                String lastName = document.get("surname").toString();
                String phoneNumber = document.get("phone").toString();
                String email = document.get("email").toString();
                //Set<Map.Entry<String, Object>> products = document.
                Document products = (Document) document.get("productList");

                //Set<String> productsSet = products.keySet();


                System.out.println(id+" "+firstName+" "+lastName+" "+phoneNumber+" "+email+" "+products);


                HashMap<String,Object> userProduct = new HashMap<>();
                for(Map.Entry<String,Object> entry : products.entrySet()){
                    String name = entry.getKey();
                    int quantity = Integer.parseInt(entry.getValue().toString());
                    userProduct.put(name,quantity);
                    System.out.println(name + " " + quantity);
                }

                User user = new User(id,firstName,lastName,phoneNumber,email);
                user.setUserProduct(userProduct);

                for(Map.Entry<String, Object> entry : user.getUserProduct().entrySet()){
                    System.out.println("userProduct");
                    String name = entry.getKey();
                    int quantity = Integer.parseInt(entry.getValue().toString());System.out.println(name + " " + quantity);
                }

                userList.add(user);
                /*user.add(id);
                user.add(firstName);
                user.add(lastName);
                user.add(phoneNumber);
                user.add(email);
                user.add(products);*/

            }catch (Exception e){
                System.out.println(e);
            }
        }
        req.setAttribute("userList",userList);

        RequestDispatcher rd = req.getRequestDispatcher("displayUsers.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*String name = req.getParameter("name");
        String quantity= req.getParameter("quantity");

        mongoAdapter.getProductCollection().insertOne(new Document()
                .append("name",name).append("quantity",quantity));

        RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
        rd.forward(req, resp);*/
    }
}
