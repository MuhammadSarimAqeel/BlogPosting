package com.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.postdao;
import com.entities.post;
import com.entities.users;
import com.helper.ConnectionProvider;
import com.helper.Helper;


@WebServlet("/AddPostServlet")
@MultipartConfig
public class AddPostServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        int CID = Integer.parseInt(request.getParameter("cid"));
        System.out.println(CID);
        String pType = request.getParameter("posttype");
        System.out.println(pType);
        String pTitle=request.getParameter("posttitle");
        String pContent =request.getParameter("postcontent");
        String pCode = request.getParameter("postcode");
        Part part = request.getPart("postpic");
        String picName= part.getSubmittedFileName();
        
       
        
//        getting user
        HttpSession session = request.getSession();
        users user = (users)session.getAttribute("currentuser");
        user.getId();
        
        

        post post=new post(pTitle, pContent, pCode, picName, null, CID, user.getId(), pType);
        
       
    	
        postdao pdao = new postdao(ConnectionProvider.getConnection());
        if(pdao.savepost(post)) {
        	
        	String path = request.getServletContext().getRealPath("/")+ "blog_pics"+ File.separator + part.getSubmittedFileName();
        	Helper.saveFile(part.getInputStream(), path);
        	out.println("done");
        	
        }
        else {
        	out.println("error");
        }
	}





}

