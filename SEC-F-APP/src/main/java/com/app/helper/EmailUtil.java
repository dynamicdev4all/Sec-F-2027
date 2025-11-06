package com.app.helper;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;



public class EmailUtil {
	
	public static boolean sendRegisterOTP(String to, String userName, int OTP) {
		String senderEmail = "piebytwo014@gmail.com";
		String senderPassword = "kabovwslpslihxfi";
		
		Properties emailProperties = new Properties();
		
		emailProperties.put("mail.smtp.host", "smtp.gmail.com");
		emailProperties.put("mail.smtp.port", "587");
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
		
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, senderPassword);
			}
		};
		
		Session emailSession = Session.getInstance(emailProperties, auth);
		
		Message emailMsg = new MimeMessage(emailSession);
		
		try {
			emailMsg.setFrom(new InternetAddress(senderEmail));
			emailMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			emailMsg.setSubject("Thank You for the Registration. 🙏");
			emailMsg.setText("Hello, "+userName+". \n\n"
							+"Your account has been create successfully. \n\n"
							+"Please use One Time Password (OTP) : "+OTP+". \n\n"
							+"If you did not request this OTP, kindly ignore this mail. \n\n"
							+"Note: Please do not share this OTP with anyone. \n\n"
							+"Best Regards, \n"
							+"Team Sec-F.");
			Transport.send(emailMsg);
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
}
