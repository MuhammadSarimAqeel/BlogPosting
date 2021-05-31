package com.dao;
import java .sql.*;

import com.entities.contacts;
import com.entities.users;
import com.helper.ConnectionProvider;

public class usersdao {

	private Connection con;

	public usersdao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean saveuser(users users) {
		boolean f= false;
		try {
			String query= "insert into users(name,email,password,mobile,gender,profile,about) values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt= this.con.prepareStatement(query);
			pstmt.setString(1, users.getName());
		
			pstmt.setString(2, users.getEmail());
			pstmt.setString(3, users.getPass());
			pstmt.setString(4, users.getMobile());
			pstmt.setString(5, users.getGender());
			pstmt.setString(6, users.getProfile());
			pstmt.setString(7, users.getAbout());
		
			
			pstmt.executeUpdate();
			f=true;
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return f;
		
		
		
	}
	
	public users getUserByEmailAndPassword(String email, String password) {
		users user=null;
		try {
		String query= "select * from users where email=? and password=?";	
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
		
			
			ResultSet set=pstmt.executeQuery();
			if(set.next()){
				user = new users();
				String name=set.getString("name");
				user.setName(name);
				user.setRole(set.getString("role"));
				user.setId(set.getInt("id"));
				user.setEmail(set.getString("email"));
				user.setPass(set.getString("password"));
				user.setMobile(set.getString("mobile"));
				user.setGender(set.getString("gender"));
				user.setAbout(set.getString("about"));
				user.setProfile(set.getString("profile"));
				
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return user;
	}

	public boolean UpdateUser (users user) {
		
		boolean f =false;
	try	{
		String query2="update users set name=?, email=? ,password=?, mobile=?, gender=?, about=? ,profile=? where id=?";
		PreparedStatement p=con.prepareStatement(query2);
		p.setString(1, user.getName());
		p.setString(2,user.getEmail());
		p.setString(3, user.getPass());
		p.setString(4, user.getMobile());
		p.setString(5, user.getGender());
		p.setString(6, user.getAbout());
		p.setString(7, user.getProfile());
		p.setInt(8, user.getId());
		
		
		p.executeUpdate();
		f=true;
	
	}catch(Exception e){
		e.printStackTrace();
	}
	return f;
	
	}
	
	public users getUserByUserId(int userId) {
		users user=null;
		try {
		
		String q ="select * from users where id=?";
		PreparedStatement ps =con.prepareStatement(q);
		ps.setInt(1, userId);
		ResultSet s = ps.executeQuery();
		if (s.next()) {
			
			user = new users();
			String name=s.getString("name");
			user.setName(name);
			user.setId(s.getInt("id"));
			user.setRole(s.getString("role"));
			user.setEmail(s.getString("email"));
			user.setPass(s.getString("password"));
			user.setMobile(s.getString("mobile"));
			user.setGender(s.getString("gender"));
			user.setAbout(s.getString("about"));
			user.setProfile(s.getString("profile"));

			
			
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	return user;	
	}
	
	public boolean SaveContactUser(contacts contact) {
		boolean f= false;
		try {
			String query= "insert into contacts(name,email,mobile,messege) values(?,?,?,?)";
			PreparedStatement pstmt= this.con.prepareStatement(query);
			
		
			pstmt.setString(1, contact.getConname());	
			pstmt.setString(2, contact.getConemail());
			pstmt.setString(3, contact.getConmobile());
			
			pstmt.setString(4, contact.getConmessege());
			
			pstmt.executeUpdate();
			f=true;

		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return f;
		
		
		
	}
	
	
	public users getUserByEmail(String email) {
		users user=null;
		try {
		String query= "select * from users where email=?";	
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			
		
			
			ResultSet set=pstmt.executeQuery();
			if(set.next()){
				user = new users();
				String name=set.getString("name");
				user.setName(name);
				user.setRole(set.getString("role"));
				user.setId(set.getInt("id"));
				user.setEmail(set.getString("email"));
				user.setPass(set.getString("password"));
				user.setMobile(set.getString("mobile"));
				user.setGender(set.getString("gender"));
				user.setAbout(set.getString("about"));
				user.setProfile(set.getString("profile"));
				
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return user;
	}
	
}
