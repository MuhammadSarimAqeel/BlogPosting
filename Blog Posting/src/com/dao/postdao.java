package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import jdk.jfr.Category;
 

import com.entities.category;
import com.entities.post;
import com.entities.users;
public class postdao {

	Connection con;

	public postdao(Connection con) {
		
		this.con = con;
	}
	public ArrayList <category> getAllCategories(){

		ArrayList <category> list = new ArrayList<>();
		try {
		String query= "select * from categories";
		Statement st=con.createStatement();
		ResultSet set=st.executeQuery(query);
		
		while(set.next()) {
			
			int cid=set.getInt("cid");
			String name=set.getString("name");
			String desc=set.getString("description");
			
		category c= new category (cid, name, desc);
			list.add(c);
		}
		
		
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		return list;
	}
	
	
	public boolean savepost(post post) {
		boolean f =false;
		try {
			String query = "insert into posts(pTitle, pContent, pCode, pPics, Cid, userid, pType) values (?,?,?,?,?,?,?)";
			PreparedStatement pstmt =con.prepareStatement(query);
			pstmt.setString(1, post.getpTitle());
			pstmt.setString(2, post.getpContent());
			pstmt.setString(3, post.getpCode());
			pstmt.setString(4, post.getpPic());
			pstmt.setInt(5, post.getCid());
			pstmt.setInt(6, post.getUserid());
			pstmt.setString(7, post.getpType());
			
			pstmt.executeUpdate();
			f=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	
	
	public List<post> getAllPosts(){
		
		List<post> list1 = new ArrayList<>();
		
		try {
		PreparedStatement p = con.prepareStatement("select * from posts");	
		ResultSet set = p.executeQuery();
		
		while(set.next()) {
		 int pid = set.getInt("pid");
		String pTitle =set.getString("pTitle");
		String pContent = set.getString("pContent");
		String pCode = set.getString("pCode");
		String pPics = set.getString("pPics");
		Timestamp date = set.getTimestamp("pDate");
		int Cid= set.getInt("Cid");
		int userid= set.getInt("userid");
		String pType = set.getString("pType");
		
		
		post post = new post(pid, pTitle, pContent, pCode, pPics, date, Cid, userid, pType);
		
		list1.add(post);
		}
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return list1;
		
	}
	
	
	
	
	public List<post> getPostByCId(int Cid){
		

		List<post> list1 = new ArrayList<>();
		

		try {
		PreparedStatement p = con.prepareStatement("select * from posts where Cid=?");	
		p.setInt(1, Cid);
		ResultSet set = p.executeQuery();
		
		while(set.next()) {
		 int pid = set.getInt("pid");
		String pTitle =set.getString("pTitle");
		String pContent = set.getString("pContent");
		String pCode = set.getString("pCode");
		String pPics = set.getString("pPics");
		Timestamp date = set.getTimestamp("pDate");
		String pType = set.getString("pType");
	
		int userid= set.getInt("userid");
		
		post post = new post(pid, pTitle, pContent, pCode, pPics, date, Cid, userid, pType);
		
		list1.add(post);
		}
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return list1;
		
		
		
		
	}
	
	public post getPostByPostId(int postId) {
		post post=null;
		
		try {
		String query="select * from posts where pid=?";
		PreparedStatement ppost= con.prepareStatement(query);
		ppost.setInt(1, postId);
		ResultSet set = ppost.executeQuery();
		if(set.next()) {
			int pid = set.getInt("pid");
			String pTitle =set.getString("pTitle");
			String pContent = set.getString("pContent");
			String pCode = set.getString("pCode");
			String pPics = set.getString("pPics");
			Timestamp date = set.getTimestamp("pDate");
		    int cid = set.getInt("Cid");
			int userid= set.getInt("userid");
			String pType = set.getString("pType");
			
			
			 post = new post(pid, pTitle, pContent, pCode, pPics, date, cid, userid,pType);
			
			
			
		}
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return post;
	}
	
	
	
	public boolean addcategory(category category) {
		boolean f= false;
		try {
			String query= "insert into categories(name,description) values(?,?)";
			PreparedStatement pstmt= this.con.prepareStatement(query);
			pstmt.setString(1, category.getName());
		
			pstmt.setString(2, category.getDescription());
		
			pstmt.executeUpdate();
			f=true;
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return f;
		
		
		
	}
	
	
public boolean UpdatePost (post post) {
		
		boolean f =false;
	try	{
		String query2="update posts set pTitle=?, pContent=? ,pCode=?, pType=? where pid=?";
		PreparedStatement p=con.prepareStatement(query2);
		p.setString(1, post.getpTitle());
		p.setString(2,post.getpContent());
		p.setString(3, post.getpCode());
		p.setString(4, post.getpType());
		p.setInt(5, post.getPid());
		
		
	System.out.println(post);
	
		
		
		p.executeUpdate();
		f=true;
	
	}catch(Exception e){
		e.printStackTrace();
	}
	return f;
	
	}


public List<post> getPostsByUserID(int userid){
	
	List<post> list1 = new ArrayList<>();
	
	try {
	PreparedStatement p = con.prepareStatement("select * from posts where userid=?");
	p.setInt(1, userid);
	ResultSet set = p.executeQuery();
	
	while(set.next()) {
	 int pid = set.getInt("pid");
	String pTitle =set.getString("pTitle");
	String pContent = set.getString("pContent");
	String pCode = set.getString("pCode");
	String pPics = set.getString("pPics");
	Timestamp date = set.getTimestamp("pDate");
	int Cid= set.getInt("Cid");
	String pType = set.getString("pType");
	

	
	post post = new post(pid, pTitle, pContent, pCode, pPics, date, Cid, userid, pType);
	
	list1.add(post);
	}
	
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
	
	
	return list1;
	
}

public boolean DeletePostById(int pid) {
	boolean f = false;
	
	try {
		PreparedStatement p = con.prepareStatement("delete  from posts where pid=?");
		p.setInt(1, pid);
		p.executeUpdate();
		
		f= true;
		
		
	}catch(Exception e) {

	e.printStackTrace();
	
	}
	
	
return f;	
}


public List<post> getPostByCIdAndUserId(int Cid , int userId){
	

	List<post> list1 = new ArrayList<>();
	

	try {
	PreparedStatement p = con.prepareStatement("select * from posts where Cid=? and userid=?");	
	p.setInt(1, Cid);
	p.setInt(2, userId);
	ResultSet set = p.executeQuery();
	
	while(set.next()) {
	 int pid = set.getInt("pid");
	String pTitle =set.getString("pTitle");
	String pContent = set.getString("pContent");
	String pCode = set.getString("pCode");
	String pPics = set.getString("pPics");
	Timestamp date = set.getTimestamp("pDate");
	String pType = set.getString("pType");
	

	
	
	post post = new post(pid, pTitle, pContent, pCode, pPics, date, Cid, userId, pType);
	
	list1.add(post);
	}
	
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
	
	
	
	return list1;
	
	
	
	
}


}





