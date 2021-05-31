package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.usersdao;
import com.entities.contacts;
import com.entities.users;
import com.helper.ConnectionProvider;


@MultipartConfig
@WebServlet("/NewServlet")
public class NewServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
         PrintWriter out = response.getWriter();
	 
	        
	         String conname=request.getParameter("name");
	       
	 
				String conemail=request.getParameter("email");
			
				String conmobile=request.getParameter("mobile");
			
				String conmessege=request.getParameter("messege");
			 
	     
				contacts contact = new contacts(conname, conemail, conmobile, conmessege);
				
				usersdao dao =new usersdao(ConnectionProvider.getConnection());
		
				if(dao.SaveContactUser(contact)) {
					
					out.println("done");
					
				}
	            else {
					
					out.println("Something Went Wrong On Server");
				}
       
		
		
	}

}
