package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.usersdao;
import com.entities.contacts;
import com.helper.ConnectionProvider;


@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         
         System.out.println(request.getAttribute("name"));
         String conname=request.getParameter("name");
         System.out.println(conname);
 
			String conemail=request.getParameter("email");
		      System.out.println(conemail);
			String conmobile=request.getParameter("mobile");
		      System.out.println(conmobile);
			String conmessege=request.getParameter("messege");
		      System.out.println(conmessege);
     
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
