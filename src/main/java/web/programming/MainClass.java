package web.programming;

import Database.MongoAdapter;
import Model.Product;
import com.mongodb.MongoClient;
import org.bson.Document;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MainClass extends HttpServlet {


    MongoAdapter mongoAdapter;

    @Override
    public void init(){

        mongoAdapter = new MongoAdapter();

        try{
            mongoAdapter.getProductCollection().insertOne(new Document().append("name","fatih").append("surname","sezgin"));

        }catch (Exception e){
            System.out.println(e );
        }


    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("id");
        int id = Integer.parseInt(productId);
        RequestDispatcher rd =
                request.getRequestDispatcher("show_product.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
        rd.forward(req,resp);
    }
}
