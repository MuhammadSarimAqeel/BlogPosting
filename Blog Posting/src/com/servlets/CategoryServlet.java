
package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.postdao;
import com.dao.usersdao;
import com.entities.category;
import com.entities.contacts;
import com.entities.users;
import com.helper.ConnectionProvider;


@MultipartConfig
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         String category= request.getParameter("category");
         String description =request.getParameter("description");
       
        category c = new category(category, description);
        
        
        postdao dao = new postdao(ConnectionProvider.getConnection());
        if(dao.addcategory(c)) {
        	out.println("done");
        	
        	
        	
        }
        else {
        	out.println("Something Went Wrong On Server");
        	
        }
			
     
		
		
	}

}





















