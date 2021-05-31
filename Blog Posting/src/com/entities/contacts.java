package com.entities;

public class contacts {
	private int conid;
	private String conname;
	private String conemail;
	private String conmobile;
	private String conmessege;
	
	
	
	
	public contacts(int conid, String conname, String conemail, String conmobile, String conmessege) {
		super();
		this.conid = conid;
		this.conname = conname;
		this.conemail = conemail;
		this.conmobile = conmobile;
		this.conmessege = conmessege;
	}



	public contacts(String conname, String conemail, String conmobile, String conmessege) {
		super();
		this.conname = conname;
		this.conemail = conemail;
		this.conmobile = conmobile;
		this.conmessege = conmessege;
	}



	public contacts() {
		super();
	}



	public int getConid() {
		return conid;
	}



	public void setConid(int conid) {
		this.conid = conid;
	}



	public String getConname() {
		return conname;
	}



	public void setConname(String conname) {
		this.conname = conname;
	}



	public String getConemail() {
		return conemail;
	}



	public void setConemail(String conemail) {
		this.conemail = conemail;
	}



	public String getConmobile() {
		return conmobile;
	}



	public void setConmobile(String conmobile) {
		this.conmobile = conmobile;
	}



	public String getConmessege() {
		return conmessege;
	}



	public void setConmessege(String conmessege) {
		this.conmessege = conmessege;
	}



	

}
