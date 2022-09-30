package com.howtodoinjava.rest.model;

public class APIModel {
	private Integer id;
    private String UserName;
    private String UserPassword;
 
	public APIModel() {
		//super();
	}


	public APIModel(Integer id, String userName, String userPassword) {
		super();
		this.id = id;
		UserName = userName;
		UserPassword = userPassword;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUserName() {
		return UserName;
	}


	public void setUserName(String userName) {
		UserName = userName;
	}


	public String getUserPassword() {
		return UserPassword;
	}


	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}


	@Override
	public String toString() {
		return "APIModel [id=" + id + ", UserName=" + UserName + ", UserPassword=" + UserPassword + "]";
	}
	
	

    
}
