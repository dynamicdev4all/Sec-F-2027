package com.app.helper;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

	public class SendOTP {
	    

	        // provide recipient's email ID
	        String to = "admin@rdec.in";
	        // provide sender's email ID
	        String from = "piebytwo014@gmail.com";

	        // provide Mailtrap's username
	        final String username = "api";
	        final String password = "9c8aee72e7e4ebdd64b57bf2df163e1e";

	        // provide Mailtrap's host address
	        String host = "live.smtp.mailtrap.io";

	        // configure Mailtrap's SMTP details
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.port", "587");

	        // create the Session object
	        Session session = Session.getInstance(props,
	            new Authenticator() {
	                @Override
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });

	        try {
	            // create a MimeMessage object
	            Message message = new MimeMessage(session);
	            // set From email field
	            message.setFrom(new InternetAddress(from));
	            // set To email field
	            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            // set email subject field
	            message.setSubject("Hello from the Mailtrap team");
	            // set the content of the email message
	            message.setText("Enjoy sending emails from Jakarta Mail!");

	            // send the email message
	            Transport.send(message);

	            System.out.println("Email Message Sent Successfully!");

	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
	    }
	
}
