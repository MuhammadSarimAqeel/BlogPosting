package com.entities;

public class verification {
  String email;
  String code;
public verification(String email, String code) {
	super();
	this.email = email;
	this.code = code;
}
public verification(String email) {
	super();
	this.email = email;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
  
}
