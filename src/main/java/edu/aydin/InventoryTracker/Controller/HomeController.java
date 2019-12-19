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

public class HomeController extends HttpServlet {

    MongoConnection mongoConnection = new MongoConnection();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int productSize = mongoConnection.getProductList().size();
        int userSize = mongoConnection.getUserList().size();
        req.setAttribute("productCount",productSize);
        req.setAttribute("userCount",userSize);
        int count = mongoConnection.getVisit();
        req.setAttribute("visit",count);
        RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
        rd.forward(req,resp);
    }
}
