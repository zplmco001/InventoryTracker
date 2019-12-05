package edu.aydin.InventroyTracker.Controller;

import Database.MongoAdapter;
import Model.Product;
import Model.User;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DisplayUsersController extends HttpServlet {

    MongoAdapter mongoAdapter = new MongoAdapter();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<User> userList = new ArrayList();
        MongoCursor<Document> cursor = mongoAdapter.getUserCollection().find().iterator();
        while(cursor.hasNext()){
            System.out.println("çalıştı");
            try{

                Document document = cursor.next();
                String id = document.get("_id").toString();
                String firstName = document.get("name").toString();
                String lastName = document.get("surname").toString();
                String phoneNumber = document.get("name").toString();
                String email = document.get("name").toString();
                List<Document> products = (List<Document>) document.get("productList");

                User user = new User(id,firstName,lastName,phoneNumber,email);
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
