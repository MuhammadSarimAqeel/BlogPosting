package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.searchdao;
import com.entities.post;
import com.helper.ConnectionProvider;


@WebServlet("/AdminPostSearchingServlet")
public class AdminPostSearchingServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String name= request.getParameter("search");
     
        searchdao dao = new searchdao(ConnectionProvider.getConnection());
        List<post> list= dao.getPostByName(name);
        System.out.println(list);
        request.setAttribute("name", list);
        if(list==null) {
        	
        	out.println("<h1> This post doesn`t exist</h1>");
	
        
        }
        else {
        	String url = "/adminpostsearching.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);

        	
        }
        
	}

}
