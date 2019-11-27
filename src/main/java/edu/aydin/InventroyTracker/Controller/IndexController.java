package edu.aydin.InventroyTracker.Controller;

import Database.MongoAdapter;
import org.bson.Document;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class IndexController extends HttpServlet {

    MongoAdapter mongoAdapter = new MongoAdapter();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+" "+password);
        if(checkUser(username,password)){
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
            session.setAttribute("password",password);
        }
        try{
            mongoAdapter.getUserCollection().insertOne(new Document().append("username",username).append("password",password));

        }catch (Exception e){
            System.out.println(e );
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp");
        requestDispatcher.forward(req,resp);
    }


    private boolean checkUser(String username, String password){
        return true;
    }
}
