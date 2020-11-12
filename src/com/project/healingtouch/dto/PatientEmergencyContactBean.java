package com.project.healingtouch.dto;

import java.io.Serializable;

public class PatientEmergencyContactBean implements Serializable {
	 private String contact_name,contact_mobile,contact_email,login_email;

	public String getContact_name() {
		return contact_name;
	}

	public String getLogin_email() {
		return login_email;
	}

	public void setLogin_email(String login_email) {
		this.login_email = login_email;
	}

	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}

	public String getContact_mobile() {
		return contact_mobile;
	}

	public void setContact_mobile(String contact_mobile) {
		this.contact_mobile = contact_mobile;
	}

	public String getContact_email() {
		return contact_email;
	}

	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}
	 

}
