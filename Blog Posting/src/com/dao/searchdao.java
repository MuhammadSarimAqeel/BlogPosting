package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.entities.post;
import com.entities.users;

public class searchdao {
	private Connection con;

	public searchdao(Connection con) {
		super();
		this.con = con;
	}
	public List<post> getPostByName( String Title) {
		List<post> list = new ArrayList<>();

		try {
		String query= "select * from posts where upper(pTitle) like ? ";	
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,"%"+Title.toUpperCase()+"%");
		
		
			
			ResultSet set=pstmt.executeQuery();
			
			while(set.next()){
		
				String title=set.getString("pTitle");				
				int pid =set.getInt("pid");
				String content=set.getString("pContent");
			    String code=set.getString("pCode");
			    String pic = set.getString("pPics");
			    int cid =set.getInt("Cid");
			    Timestamp date=set.getTimestamp("pDate");
			    int userid=set.getInt("userid");
			    String pType = set.getString("pType");
			    
			    post post = new post(pid, title, content, code, pic, date, cid, userid,pType);
			   
			    list.add(post);
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}
	
}
