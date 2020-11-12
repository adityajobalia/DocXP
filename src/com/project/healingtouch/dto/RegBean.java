package com.project.healingtouch.dto;

import java.io.Serializable;

public class RegBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7927390422470026627L;
	private String userName;
	private String userPass;
	private String userEmail;
	private String userMobile;
	private String message;
	private String userImage;
	
	
	/*
	 * Generating getters and setters for Registered Users
	 * */
	
	
	
	
	
	public String getUserName() {
		return userName;
	}
	
	

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	
	

}
