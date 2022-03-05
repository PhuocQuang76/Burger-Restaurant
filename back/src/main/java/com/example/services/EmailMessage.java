package com.example.services;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.example.modules.Purchase;

public class EmailMessage {

    private static String from;
    private static String pass;
    private static Session session;

    static {
        pass = System.getenv("PROJECT_02_EMAIL_P");
        from = System.getenv("PROJECT_02_EMAIL");
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.outlook.com");
        props.put("mail.smtp.port", "587");
        session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, pass);
            }
        });
    }

    public EmailMessage() {
    }

    public static void sendmail(Purchase p) throws AddressException, MessagingException, IOException {
        String emailto = p.getBuyer().getEmail();
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(from, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailto));
        msg.setSubject("Thanks for your purchase at Rick And Morty KrustyKrab");
        msg.setContent("You made a purchase at Rick And Morty KrustyKrab", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        String message = "Purchase status: " + p.getStatusid() +
                "\nName: " + p.getBuyer().getFname() + " " + p.getBuyer().getLname() +
                "\nProduct: " + p.getProduct().getName() +
                "\nPrice: " + p.getProduct().getPrice() +
                "\nStatus: " + p.getStatusid() +
                "\nPurchase Date: " + p.getPurchase();
        messageBodyPart.setContent(message, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        // MimeBodyPart attachPart = new MimeBodyPart();

        // attachPart.attachFile("/var/tmp/image19.png");
        // multipart.addBodyPart(attachPart);
        msg.setContent(multipart);
        Transport.send(msg);
    }
}
