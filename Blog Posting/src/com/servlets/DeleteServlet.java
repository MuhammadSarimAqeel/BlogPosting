package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.postdao;
import com.helper.ConnectionProvider;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
         PrintWriter out = response.getWriter();
       
       
         int postId= Integer.parseInt(request.getParameter("pid"));
         postdao dao = new postdao(ConnectionProvider.getConnection());


        if (dao.DeletePostById(postId)) {
        	
        	out.println("done");
        	
        }else {
        	
        	out.println("An error occured");
        }
	}

}
