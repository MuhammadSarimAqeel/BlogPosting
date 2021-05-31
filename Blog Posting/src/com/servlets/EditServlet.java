package com.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.usersdao;
import com.entities.messege;
import com.entities.users;
import com.helper.ConnectionProvider;
import com.helper.Helper;

@WebServlet("/EditServlet")
@MultipartConfig
public class EditServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        
        String userEmail=request.getParameter("user_email");
        String userName =request.getParameter("user_name");
        String userPassword= request.getParameter("user_password");
        String userMobile=request.getParameter("user_mobile");
        String userAbout=request.getParameter("user_about");
        Part part =request.getPart("image");
        String imageName=part.getSubmittedFileName();
        System.out.println(imageName);
        
        HttpSession s=request.getSession();
       users user=(users) s.getAttribute("currentuser");
        user.setEmail(userEmail);
        user.setName(userName);
        user.setPass(userPassword);
        user.setMobile(userMobile);
        user.setAbout(userAbout);
        String oldfile = user.getProfile();
        user.setProfile(imageName);
        
        usersdao dao2 = new usersdao(ConnectionProvider.getConnection());
       boolean ans= dao2.UpdateUser(user);
       if(ans) {
    	
    	  String path = request. getRealPath("/") + "pics"+ File.separator + user.getProfile();
    	  System.out.println(path);
    	  String oldfilepath = request. getRealPath("/")+ "pics"+ File.separator + oldfile;
    	  
    	  if(!oldfile.equals("default.jpg")) {
                Helper.deletefile(oldfilepath) ;
    	  }
    		if (Helper.saveFile(part.getInputStream(), path)) {
    			 out.println("done");
    		}
    		
    	
    	

       }
       else {
    	   out.println("error ");

       }

	}


	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        
        String userEmail=request.getParameter("user_email");
        String userName =request.getParameter("user_name");
        String userPassword= request.getParameter("user_password");
        String userMobile=request.getParameter("user_mobile");
        String userAbout=request.getParameter("user_about");
        Part part =request.getPart("image");
        String imageName=part.getSubmittedFileName();
        
        
        HttpSession s=request.getSession();
       users user=(users) s.getAttribute("currentuser");
        user.setEmail(userEmail);
        user.setName(userName);
        user.setPass(userPassword);
        user.setMobile(userMobile);
        user.setAbout(userAbout);
        user.setProfile(imageName);
        
        usersdao dao2 = new usersdao(ConnectionProvider.getConnection());
       boolean ans= dao2.UpdateUser(user);
       if(ans) {
    	 
    	  String path = request.getRealPath("/")+ "pics"+ File.separator + user.getProfile();
    	  
    	Helper.deletefile(path);
    	
    		if (Helper.saveFile(part.getInputStream(), path)) {
    			 out.println("done");
    		}
    		
    	
    	  

       }
       else {
    	   out.println("error ");

       }

	}

}

