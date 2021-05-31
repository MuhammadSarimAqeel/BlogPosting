package com.dao;

import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.entities.messege;
import com.entities.users;
import com.entities.verification;

public class sendemail {
  
	public String getRandom() {
		
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		
		return String.format("%06d", number);
		
	}
	
	
	public boolean sendEmail(verification verification) {
		boolean test = false;
		
		
		String toEmail = verification.getEmail();
		
		String fromEmail = "sarimaqeel037@gmail.com";
		String password = "sarimsarim";
		
		
		try {
			
			Properties pr = new Properties();
			
			  pr.put("mail.smtp.host", "smtp.gmail.com");    
	          pr.put("mail.smtp.socketFactory.port", "465");    
	          pr.put("mail.smtp.socketFactory.class",    
	                    "javax.net.ssl.SSLSocketFactory");    
	          pr.put("mail.smtp.auth", "true");    
	          pr.put("mail.smtp.port", "465"); 
			
			
			
			Session session = Session.getDefaultInstance(pr, new Authenticator() {
				
				@Override
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					
					return new javax.mail.PasswordAuthentication(fromEmail, password) ;
				}
				
			});
			Message msg = new MimeMessage(session);
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail) );
			msg.setFrom(new InternetAddress(fromEmail));
			
			
			msg.setSubject("User Email Verification Code");
			msg.setText("You Have been Registered Succeccfully. Verify Your Account Using this Code  " + verification.getCode());
			
			Transport.send(msg);
			
			
			test = true;
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		return test;
	}
	
	
	
	
}
