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
@WebServlet("/VerifyServlet")
public class VerifyServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         
         String gender=request.getParameter("user_gender");
         String check=request.getParameter("check");
 		if(check==null) {
 		out.println("check");
 		
 		}
 		
 		else if(gender==null) {
 			out.println("gender");
 			
 		}	
 		else {
 		
 		

			 String name=request.getParameter("user_name");
 			System.out.println("Name is "+name);
 		    		
 			String password=request.getParameter("user_password");
 			String mobile=request.getParameter("user_mobile");
 			String email=request.getParameter("user_email");
 			String about=request.getParameter("about");
 		
 			 
 		
 			
 			
 			HttpSession session = request.getSession();
 		
			
 			session.setAttribute("name",name);
 			session.setAttribute("email",email);
 			session.setAttribute("password",password);
 			session.setAttribute("mobile",mobile);
 			session.setAttribute("gender",gender);
 			session.setAttribute("about",about);
			
			
		
 			
 			 
 			 System.out.println(email);
 			sendemail snd = new sendemail();
 			String code = snd.getRandom();
 			System.out.println(code);
 			verification ver = new verification(email, code);
 			boolean ans= snd.sendEmail(ver);
 			
 			if(ans) {
 				System.out.println(ans);
 				out.println("done");
 				HttpSession session2 = request.getSession();
 				session2.setAttribute("auth", ver);
 				response.sendRedirect("Verificationjsp.jsp");
 				
 			}
 			
			
			
		}
	}
}	


		
