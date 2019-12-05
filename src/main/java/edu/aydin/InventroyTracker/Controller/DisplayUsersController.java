package edu.aydin.InventroyTracker.Controller;

import Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class DisplayUsersController extends HttpServlet {

    private ArrayList<User> users = new ArrayList<>();

    @Override
    public void init() throws ServletException {

        users.add(new User("1","deneme","yaman","943932","wemjldfad"));
        users.add(new User("1","deneme","yaman","943932","wemjldfad"));
        users.add(new User("1","deneme","yaman","943932","wemjldfad"));
        users.add(new User("1","deneme","yaman","943932","wemjldfad"));
        users.add(new User("1","deneme","yaman","943932","wemjldfad"));
        users.add(new User("1","deneme","yaman","943932","wemjldfad"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setAttribute("userList",users);
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

        req.setAttribute("userList",users);
        RequestDispatcher rd = req.getRequestDispatcher("displayUsers.jsp");
        rd.forward(req, resp);
    }
}
