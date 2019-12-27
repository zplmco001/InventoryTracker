package edu.aydin.InventoryTracker.Controller;

import edu.aydin.InventoryTracker.Database.MongoAdapter;
import edu.aydin.InventoryTracker.Database.MongoConnection;
import edu.aydin.InventoryTracker.Model.User;
import org.bson.Document;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


public class DisplayUsersController extends HttpServlet {

    MongoConnection mc = new MongoConnection();
    ArrayList<User> userList;
    Set<String> prodKeySet;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        userList = mc.getUserList();

        req.setAttribute("userList",userList);
        ArrayList<Document> productList = mc.getProductList();
        req.setAttribute("productList", productList);





        RequestDispatcher rd = req.getRequestDispatcher("displayUsers.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        RequestDispatcher rd = req.getRequestDispatcher("displayUsers.jsp");
        String id = req.getParameter("id");
        String firstname = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String phone = req.getParameter("phone");
        String mail = req.getParameter("email");
        String deletedId = req.getParameter("deletedId");


        if(deletedId!=null){
            mc.deleteUser(deletedId);
        }else{

            String editId = req.getParameter("editId");

            User editedUser = userList.get(Integer.parseInt(editId));
            prodKeySet = editedUser.getUserProduct().keySet();

            Iterator<String> itr = prodKeySet.iterator();


            for(int i=0; i<editedUser.getUserProduct().size(); i++){

                String prodKey = itr.next();
                String prodValue = req.getParameter("prodVal"+i);


                editedUser.getUserProduct().put(prodKey,prodValue);
            }


            System.out.println("edit user product  "+userList.get(Integer.parseInt(editId)).getUserProduct().get("computer"));

            editedUser.setId(id);
            editedUser.setFirstname(firstname);
            editedUser.setLastname(lastname);
            editedUser.setPhoneNumber(phone);
            editedUser.setEmail(mail);


            mc.updateUser(editedUser);


        }

        rd.forward(req, resp);


        /*String name = req.getParameter("name");
        String quantity= req.getParameter("quantity");

        mongoAdapter.getProductCollection().insertOne(new Document()
                .append("name",name).append("quantity",quantity));

        RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
        rd.forward(req, resp);*/
    }


}
