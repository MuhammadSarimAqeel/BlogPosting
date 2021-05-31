package com.dao;
import java.sql.*;
public class likedao {
	 Connection con ;
	 
	 
	 
	 
public likedao(Connection con) {
		super();
		this.con = con;
	}




public boolean inserlike(int pid, int uid) {
	boolean f= false;
	try {
		String query="insert into likes(pid,uid) values(?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, pid);
		pstmt.setInt(2, uid);
		pstmt.executeUpdate();
		f=true;
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	return f;
}

 public int countLikeonPost(int pid) {
	 int count=0;
	 
	 try {
		 String q = "select count(*) from likes where pid=?";
		 PreparedStatement p = con.prepareStatement(q);
		 p.setInt(1, pid);
		 ResultSet set=p.executeQuery();
		 while(set.next()) {
			 count=set.getInt("count(*)");
			 
			 
		 }
		 
		 
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 
	 
	 
	 
	return count; 
 }
 
 public boolean isLikedByUser(int pid, int uid) {
	 
	 boolean f= false;
	 try {
		 String q ="select * from likes where pid=? and uid=?";
		 PreparedStatement p=con.prepareStatement(q);
		 p.setInt(1, pid);
		 p.setInt(2, uid);
		 
		 ResultSet set=p.executeQuery();
		 while(set.next()) {
			 f=true;
		 }
		 
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 
	 
	 
	 
	return f; 
 }
 public boolean deleteLike(int pid, int uid) {
	 boolean f= false;
	 try {
		 String q ="delete from likes where pid=? and uid=?";
		 PreparedStatement p=con.prepareStatement(q);
		 p.setInt(1, pid);
		 p.setInt(2, uid);
		 
		 ResultSet set=p.executeQuery();
		 if(set.next()) {
			 f=true;
		 }
		 
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	
	 
	 return f;
 } 
}
