package edu.aydin.InventoryTracker.Controller;

import edu.aydin.InventoryTracker.Database.MongoConnection;
import edu.aydin.InventoryTracker.Model.ShowProduct;
import org.bson.Document;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class ProductController extends HttpServlet {

    MongoConnection mc = new MongoConnection();
    ArrayList<ShowProduct> items;
    Set<String> prodKeySet;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Document> products = mc.getProductList();
        req.setAttribute("products",products);
        items = new ArrayList<>();

        for (Document doc: products){
            items.add(new ShowProduct(new HashMap<>(doc)));
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
        String editedId = req.getParameter("editedId");
        String indexMap = req.getParameter("editedMap");



        System.out.println("gelen id "+deleteId);

        if(deleteId!=null){
            System.out.println("buraya girdi ");
            mc.deleteProduct(deleteId);
        }else if(editedId!=null){

            ShowProduct incomingMap = items.get(Integer.parseInt(indexMap));


            prodKeySet = items.get(Integer.parseInt(indexMap)).pMap.keySet();
            Iterator<String> itr = prodKeySet.iterator();

            String prodName = req.getParameter("productName");
            String prodQuantity = req.getParameter("productQuantity");

            incomingMap.name = prodName;
            incomingMap.quantity = prodQuantity;

            for(int i=0; i<items.get(Integer.parseInt(indexMap)).pMap.size(); i++){

                String attKey = itr.next();
                String att = req.getParameter("prop"+i);
                if(att!=null && !attKey.equals("_id")){
                    incomingMap.pMap.put(attKey,att);
                }
            }


            mc.updateProduct(incomingMap);
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
