package com.project.healingtouch.dto;

import java.io.Serializable;

public class LogBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String logEmail;
	private String logPass;
	private String message;
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	private String token;

	public String getLogEmail() {
		return logEmail;
	}

	public void setLogEmail(String logEmail) {
		this.logEmail = logEmail;
	}

	public String getLogPass() {
		return logPass;
	}

	public void setLogPass(String logPass) {
		this.logPass = logPass;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
