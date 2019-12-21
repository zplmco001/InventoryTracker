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
import java.util.List;
import java.util.Map;

public class ProductController extends HttpServlet {

    MongoConnection mc = new MongoConnection();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Document> products = mc.getProductList();
        req.setAttribute("products",products);
        ArrayList<Map<String,Object>> items = new ArrayList<>();
        ArrayList<Object> values = new ArrayList<>();
        for (Document doc: products){
            items.add(new HashMap<>(doc));
        }
        req.setAttribute("items",items);

        RequestDispatcher rd = req.getRequestDispatcher("addProduct.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
        String name = req.getParameter("name");
        String quantity= req.getParameter("quantity");

        String deleteId = req.getParameter("deletedId");
        System.out.println("gelen id "+deleteId);

        if(deleteId!=null){
            System.out.println("buraya girdi ");
            mc.deleteProduct(deleteId);
        }else{
            //List<String> parameterNames = new ArrayList<>(req.getParameterMap().keySet());
            Map<String,String> proVals = new HashMap<>();
            ArrayList<Map.Entry<String,String[]>> parameterValues = new ArrayList<>(req.getParameterMap().entrySet());
            for (int i=0;i<parameterValues.size();i++){
                String key;
                String value;
                if (i<2){
                    key = parameterValues.get(i).getKey();
                    value = parameterValues.get(i).getValue()[0];

                }
                else{
                    key = parameterValues.get(i).getValue()[0];
                    value = parameterValues.get(i+1).getValue()[0];
                    i++;
                }
                proVals.put(key,value);
                System.out.println(key+":"+value);
            }

            mc.addProduct(proVals);

        /*for(Map.Entry<String, String[]> entry : req.getParameterMap().entrySet()){
            String parname = entry.getKey();
            String parvalue = entry.getValue()[0];
            System.out.println(parname + parvalue);
        }*/
        /*while (req.getParameterNames().hasMoreElements()){
            System.out.println(req.getParameterNames().nextElement());
        }*/
            //mc.addroduct(name,quantity);
        }




        rd.forward(req, resp);
    }
}
