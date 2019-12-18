package edu.aydin.InventoryTracker.Database;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.util.Properties;

public class MailSender {
    private String smtpAuthUser;
    private String smtpAuthPassword;
    private String mailBody;
    private String mailSubject;
    private String mailSender;
    private String mailRecipient;


    public MailSender(String smtpAuthUser, String smtpAuthPassword, String mailBody, String mailSubject, String mailSender, String mailRecipient) {
        this.smtpAuthUser = smtpAuthUser;
        this.smtpAuthPassword = smtpAuthPassword;
        this.mailBody = mailBody;
        this.mailSubject = mailSubject;
        this.mailSender = mailSender;
        this.mailRecipient = mailRecipient;
    }


    public void sendMail() throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");

        Authenticator authenticator = new SMTPAuthentication();
        Session session = Session.getDefaultInstance(properties, authenticator);

        InternetAddress mailFrom = new InternetAddress(mailSender);
        InternetAddress mailTo = new InternetAddress(mailRecipient);



        Message message = new MimeMessage(session);
        message.setFrom(mailFrom);
        message.setRecipient(Message.RecipientType.TO,mailTo);
        message.setSubject(mailSubject);

        Multipart multipart = new MimeMultipart();

        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setText(mailBody);
        multipart.addBodyPart(bodyPart);
        message.setContent(multipart);
        Transport.send(message);
    }

    private class SMTPAuthentication extends Authenticator {

        public PasswordAuthentication getPasswordAuthentication(){
            String username = smtpAuthUser;
            String password = smtpAuthPassword;
            return new javax.mail.PasswordAuthentication(username,password);
        }
    }
}


