package com.project.healingtouch.dto;

import java.io.Serializable;

public class PatientFinHospitalBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String h_name,h_contact,h_address,h_website;
	public  PatientFinHospitalBean() {
		
	}
	public PatientFinHospitalBean(String h_name2, String h_contact2) {
		this.h_name=h_name2;
		this.h_contact=h_contact2;
	}
	public String getH_name() {
		return h_name;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}
	public String getH_contact() {
		return h_contact;
	}
	public void setH_contact(String h_contact) {
		this.h_contact = h_contact;
	}
	public String getH_address() {
		return h_address;
	}
	public void setH_address(String h_address) {
		this.h_address = h_address;
	}
	public String getH_website() {
		return h_website;
	}
	public void setH_website(String h_website) {
		this.h_website = h_website;
	}
	

}
