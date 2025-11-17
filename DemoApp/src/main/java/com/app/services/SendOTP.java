package com.app.services;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class SendOTP {
	public static boolean sendRegisterOTP( String to, String userName, int OTP) {
		String from = "piebytwo014@gmail.com";
		String fromPassword = "dvntxafkgfasyfkn";
		Properties emailProperties = new Properties();
		emailProperties.put("mail.smtp.host", "smtp.gmail.com");
		emailProperties.put("mail.smtp.port", "587");
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
		
		
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, fromPassword);
			}
		};
		
		
		Session emailAuthSession = Session.getInstance(emailProperties, auth);
		
		Message emailMsg = new MimeMessage(emailAuthSession);
		
		try {
			emailMsg.setFrom(new InternetAddress(from));
			emailMsg.setRecipients(Message.RecipientType.TO , InternetAddress.parse(to));
			emailMsg.setSubject("Welcome onboard!");
			emailMsg.setText("Hey, " + userName +".\n\n"
					        +"Welcome to SEC-E APP. \n\n"
					        +"Please use OTP :" + OTP+ " to verify your account.\n\n"
					        +"Best Regards, \n"
					        +"Team Sec-E");
			Transport.send(emailMsg);
			System.out.println("Email Sent Success");
			return true;
		} catch (MessagingException e) {
			System.out.println("Email Sent Failure!");
			e.printStackTrace();
			return false;
		}
 	}
	
}
