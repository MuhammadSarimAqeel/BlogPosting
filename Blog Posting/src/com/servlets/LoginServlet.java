package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.searchdao;
import com.dao.usersdao;
import com.entities.messege;
import com.entities.post;
import com.entities.users;
import com.helper.ConnectionProvider;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         
         String useremail= request.getParameter("email");
         String userpassword = request.getParameter("password");
         
         
     
        
         
         
         if(useremail.equals("sarimaqeel037@gmail.com")&& userpassword.equals("SarimSarim123")) {
         usersdao dao = new usersdao(ConnectionProvider.getConnection());
         users u = dao.getUserByEmailAndPassword(useremail, userpassword);
         
        if(u==null) {

        	messege msg = new messege("Invalid Email or Password", "error", "alert-danger");
        	HttpSession s= request.getSession();
        	s.setAttribute("msg", msg);
        	
        	
        	response.sendRedirect("login.jsp");
        } 
        else {
        	HttpSession s= request.getSession();
        	s.setAttribute("currentuser", u);
        	response.sendRedirect("adminuser.jsp");
        	
        }
        
         }else {
        	 usersdao dao = new usersdao(ConnectionProvider.getConnection());
             users u = dao.getUserByEmailAndPassword(useremail, userpassword);
             
            if(u==null) {

            	messege msg = new messege("Invalid Email or Password", "error", "alert-danger");
            	HttpSession s= request.getSession();
            	s.setAttribute("msg", msg);
            	
            	
            	response.sendRedirect("login.jsp");
            	
            } 
           
            else {
            	HttpSession s= request.getSession();
            	s.setAttribute("currentuser", u);
            	response.sendRedirect("profile.jsp");
            	
            }
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
         }
         
	}

}
