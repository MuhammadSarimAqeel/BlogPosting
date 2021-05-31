package com.servlets;





import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;
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
import com.dao.sendemail;
import com.dao.usersdao;
import com.entities.contacts;
import com.entities.users;
import com.entities.verification;
import com.helper.ConnectionProvider;


@MultipartConfig
@WebServlet("/VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         
         
         

         HttpSession session = request.getSession();
         verification ver = (verification)session.getAttribute("auth");
         String code = request.getParameter("code");
         System.out.println(code);
         if(code.trim().equals(ver.getCode())) {
         	
         	
         String name=	(String) session.getAttribute("name");
           String email =	(String) session.getAttribute("email");
           String password =  	(String) session.getAttribute("password");
           String mobile=	(String) session.getAttribute("mobile");
           String gender=   	(String) session.getAttribute("gender");
           String about=	(String) session.getAttribute("about");
           	
         	
         	users newuser= new users(name,email,password,mobile, gender,about);
  			
         	 
  			usersdao dao =new usersdao(ConnectionProvider.getConnection());
  			if(dao.saveuser(newuser)) {
  				
  				out.println("done");
  				messege msg = new messege("Registered Successfully", "success", "alert-success");
  	        	HttpSession s= request.getSession();
  	        	s.setAttribute("msg", msg);
  				
  				
  			}
  			else {
  				
  				out.println("This email was already registered. Try another one");
  			}
 	
 		
         	
         }
         else {
         	out.println("Invalid Code Please try again.");
         }
         
         
         
        
         
         
       
		
	}
	
}	


		











































/*
import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;
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
import com.dao.sendemail;
import com.dao.usersdao;
import com.entities.contacts;
import com.entities.users;
import com.entities.verification;
import com.helper.ConnectionProvider;

@WebServlet("/VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        
        HttpSession session = request.getSession();
        verification ver = (verification)session.getAttribute("auth");
        String code = request.getParameter("code");
        System.out.println(code);
        if(code.equals(ver.getCode())) {
        	
        	
        String name=	(String) session.getAttribute("name");
          String email =	(String) session.getAttribute("email");
          String password =  	(String) session.getAttribute("password");
          String mobile=	(String) session.getAttribute("mobile");
          String gender=   	(String) session.getAttribute("gender");
          String about=	(String) session.getAttribute("about");
          	
        	
        	users newuser= new users(name,email,password,mobile, gender,about);
 			
        	 
 			usersdao dao =new usersdao(ConnectionProvider.getConnection());
 			if(dao.saveuser(newuser)) {
 				
 				out.println("done");
 			
 				
 				
 			}
 			else {
 				
 				out.println("Something Went Wrong On Server");
 			}
	
		
        	
        }
        else {
        	out.println("An error Occured");
        }
        
	}

}
*/
