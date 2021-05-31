package com.entities;
import java.sql.*;
public class users {
  
	private int id;
	private String name;
	private String email;
	private String pass;
	private String mobile;
	private String gender;
	private String about;
	private String profile;
	private String role;
	
	
	
	
	public users(int id, String name, String email, String pass, String mobile, String gender, String about) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.mobile = mobile;
		this.gender = gender;
		this.about = about;
	}




	public users() {
		super();
	}




	public users(String name, String email, String pass, String mobile, String gender, String about) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.mobile = mobile;
		this.gender = gender;
		this.about = about;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPass() {
		return pass;
	}




	public void setPass(String pass) {
		this.pass = pass;
	}




	public String getMobile() {
		return mobile;
	}




	public void setMobile(String mobile) {
		this.mobile = mobile;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getAbout() {
		return about;
	}




	public void setAbout(String about) {
		this.about = about;
	}




	public String getProfile() {
		return profile;
	}




	public void setProfile(String profile) {
		this.profile = profile;
	}




	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	
	
}
