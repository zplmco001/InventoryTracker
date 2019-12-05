package edu.aydin.InventroyTracker.Controller;

import Database.MailSender;
import Database.MongoAdapter;
import com.mongodb.client.MongoCursor;
import com.sun.mail.smtp.SMTPTransport;
import org.bson.Document;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class SendMailController extends HttpServlet {

    private ArrayList<String> adminMailList = new ArrayList<>();
    MongoAdapter mongoAdapter = new MongoAdapter();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        MongoCursor<Document> cursor = mongoAdapter.getUserCollection().find().iterator();

        while (cursor.hasNext()){
            Document document = cursor.next();

            String isAdmin = document.get("isAdmin").toString();
            System.out.println("is admin ne geldi : "+isAdmin);
            String email = document.get("email").toString();
            if(isAdmin.equals("true")){
                System.out.println("buraya girdi");
                adminMailList.add(email);
            }
        }
        req.setAttribute("adminMailList",adminMailList);
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
