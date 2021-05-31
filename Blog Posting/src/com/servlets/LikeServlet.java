package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.likedao;
import com.helper.ConnectionProvider;


@WebServlet("/LikeServlet")
public class LikeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        
        String operation=request.getParameter("operation");
        int uid = Integer.parseInt(request.getParameter("uid"));
        int pid = Integer.parseInt(request.getParameter("pid"));
        

        likedao Ldao = new likedao(ConnectionProvider.getConnection());
        
        
        if(operation.equals("like")) {
        	
        boolean f=	Ldao.inserlike(pid, uid);
        out.println(f);
        	
        }
        
        
        
	}

}
