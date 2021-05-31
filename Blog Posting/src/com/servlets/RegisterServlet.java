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
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         
			
         
		String check=request.getParameter("check");
		if(check==null) {
		out.println("You must agree terms and conditions");
		
		}
		else {
			
			
			String name=request.getParameter("user_name");
			System.out.println("Name is "+name);
			String email=request.getParameter("user_email");
			String password=request.getParameter("user_password");
			String mobile=request.getParameter("user_mobile");
			String gender=request.getParameter("user_gender");
			String about=request.getParameter("about");
			
			users newuser= new users(name,email,password,mobile, gender,about);
			
		
			
			usersdao dao =new usersdao(ConnectionProvider.getConnection());
			if(dao.saveuser(newuser)) {
				
				out.println("done");
			}
			else {
				
				out.println("Something Went Wrong On Server");
			}
			
		}
		
		
	}

}
