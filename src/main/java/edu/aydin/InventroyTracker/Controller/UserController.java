package edu.aydin.InventroyTracker.Controller;

import Database.MongoAdapter;
import Model.Product;
import com.google.gson.Gson;
import org.bson.Document;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class UserController extends HttpServlet {

    MongoAdapter mongoAdapter = new MongoAdapter();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("addUser.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean isAdmin = Boolean.parseBoolean(req.getParameter("item"));
        ArrayList<Product> list = new ArrayList();
        Gson gson = new Gson();
        String jsonArray = gson.toJson(list);
        try{
            mongoAdapter.getUserCollection().insertOne(
                    new Document("name",firstName)
                    .append("surname",lastName)
                    .append("phone",phone)
                    .append("email",email)
                    .append("password",password)
                    .append("productList", jsonArray)
            );
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println(firstName + lastName +phone + email+password+isAdmin);
    }
}
