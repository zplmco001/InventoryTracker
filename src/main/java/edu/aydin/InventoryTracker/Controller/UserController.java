package edu.aydin.InventoryTracker.Controller;

import edu.aydin.InventoryTracker.Database.MongoConnection;
import org.bson.Document;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserController extends HttpServlet {

    MongoConnection mongoConnection = new MongoConnection();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Document> productList = mongoConnection.getProductList();
        req.setAttribute("productList", productList);
        RequestDispatcher rd = req.getRequestDispatcher("addUser.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String username= req.getParameter("username");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean isAdmin = Boolean.parseBoolean(req.getParameter("item"));
        //ArrayList<Product> list = new ArrayList();
        Map<String,String> list = new HashMap<>();
        list.put("computer","5000");
        list.put("phone","4500");

        mongoConnection.addUser(firstName,lastName,username,phone,email,password,isAdmin,list);
        System.out.println(firstName + lastName +username+phone + email+password+isAdmin);

        RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
        rd.forward(req, resp);
    }
}
