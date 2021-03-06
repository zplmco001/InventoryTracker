package edu.aydin.InventoryTracker.Controller;

import edu.aydin.InventoryTracker.Database.MongoAdapter;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import edu.aydin.InventoryTracker.Database.MongoConnection;
import org.bson.Document;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class IndexController extends HttpServlet {

    MongoAdapter mongoAdapter = new MongoAdapter();
    MongoConnection mongoConnection = new MongoConnection();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String error = (String) req.getAttribute("error");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path="";
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+" "+password);

        if(checkUser(username,password)){
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            session.setMaxInactiveInterval(30*60);
            if(checkIsAdmin(username)){
                req.setAttribute("isAdmin",true);
                session.setAttribute("isAdmin",true);
            }else{
                session.setAttribute("isAdmin",false);
            }
            System.out.println("index:"+session.getAttribute("username"));
            mongoConnection.setVisit();
            resp.sendRedirect("home");
        }else{
            path ="index.jsp";
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
            requestDispatcher.forward(req,resp);
        }


    }

    private boolean checkIsAdmin(String username){

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("username",username);
        FindIterable<Document> result = mongoAdapter.getUserCollection().find(whereQuery);
        MongoCursor<Document> cursor = result.iterator();
        boolean isAdmin = false;
        while (cursor.hasNext()){
            Document document = cursor.next();
            isAdmin = Boolean.parseBoolean(document.get("isAdmin").toString());
        }
        return isAdmin;

    }


    private boolean checkUser(String username, String password){
        //FindIterable<Document> result = mongoAdapter.getUserCollection().find();
        MongoCursor<Document> cursor = mongoAdapter.getUserCollection().find().iterator();

        while(cursor.hasNext()){
            Document document = cursor.next();
            System.out.println(document.get("_id"));
            System.out.println(document.get("username"));
            System.out.println(document.get("password"));

            String dbusername = document.get("username").toString();
            String dbpassword = document.get("password").toString();

            if(dbusername.equals(username) && dbpassword.equals(password))
                return true;
        }
        return false;
    }
}
