package edu.aydin.InventroyTracker.Controller;

import Database.MongoAdapter;
import Database.MongoConnection;
import Model.User;
import com.mongodb.client.MongoCollection;
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

        MongoConnection mc = new MongoConnection();
        ArrayList<User> userList;
        userList = mc.getUserList();

        req.setAttribute("userList",userList);

        RequestDispatcher rd = req.getRequestDispatcher("displayUsers.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = (String) req.getParameter("item.id");
        System.out.println(id);
        /*String name = req.getParameter("name");
        String quantity= req.getParameter("quantity");

        mongoAdapter.getProductCollection().insertOne(new Document()
                .append("name",name).append("quantity",quantity));

        RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
        rd.forward(req, resp);*/
    }
}
