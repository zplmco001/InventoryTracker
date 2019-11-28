package edu.aydin.InventroyTracker.Controller;

import Database.MongoAdapter;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
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

        String path= "";
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+" "+password);
        if(checkUser(username,password)){
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            if(checkIsAdmin(username)){
                req.setAttribute("isAdmin",true);
            }
            path = "home.jsp";
        }else{
            path ="index.jsp";
        }

        /*try{
            mongoAdapter.getUserCollection().insertOne(new Document().append("username",username).append("password",password));

        }catch (Exception e){
            System.out.println(e );
        }*/
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req,resp);
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

        /*MongoCursor<Document> cursor = mongoAdapter.getUserCollection().find().iterator();

        while(cursor.hasNext()){
            Document document = cursor.next();
            boolean isAdmin = Boolean.parseBoolean(document.get("isAdmin").toString());
        }*/
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
