package edu.aydin.InventoryTracker.Controller;

import edu.aydin.InventoryTracker.Database.MailSender;
import edu.aydin.InventoryTracker.Database.MongoAdapter;
import com.mongodb.client.MongoCursor;
import edu.aydin.InventoryTracker.Database.MongoConnection;
import org.bson.Document;


import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class SendMailController extends HttpServlet {

    private ArrayList<String> adminMailList = new ArrayList<>();
    private ArrayList<String> allMailList = new ArrayList<>();
    MongoAdapter mongoAdapter = new MongoAdapter();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MongoConnection mc = new MongoConnection();
        adminMailList.clear();
        allMailList.clear();
        String username = (String) req.getSession().getAttribute("username");
        String userMail = mc.getEmailbyUsername(username);

        MongoCursor<Document> cursor = mongoAdapter.getUserCollection().find().iterator();
        while (cursor.hasNext()){
            Document document = cursor.next();
            String isAdmin = document.get("isAdmin").toString();
            System.out.println("is admin ne geldi : "+isAdmin);
            String email = document.get("email").toString();
            if(isAdmin.equals("true")){
                adminMailList.add(email);
            }
            allMailList.add(email);

        }
        req.setAttribute("adminMailList",adminMailList);
        req.setAttribute("userMail",userMail);
        req.setAttribute("allMailList",allMailList);
        RequestDispatcher rd = req.getRequestDispatcher("sendMail.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String from = req.getParameter("userMail");
        String to = req.getParameter("adminMail");
        String message = req.getParameter("mail");
        String subject = req.getParameter("mailSubject");

        MailSender mailSender = new MailSender(from,"seyitali34."
                ,message,subject,from,to);

        try {
            mailSender.sendMail();
            System.out.println("gönderim başarılı");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        /*String name = req.getParameter("name");
        String quantity= req.getParameter("quantity");

        mongoAdapter.getProductCollection().insertOne(new Document()
                .append("name",name).append("quantity",quantity));
*/
        RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
        rd.forward(req, resp);
    }
}
