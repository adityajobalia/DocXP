package com.project.healingtouch.dto;

import java.io.Serializable;

public class HospitalBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String h_name,h_locality,h_address,h_contact,h_website,h_image1,h_image2,h_image3,latitude,longitude;
	
	public String getH_locality() {
		return h_locality;
	}

	public void setH_locality(String h_locality) {
		this.h_locality = h_locality;
	}

	public String getH_name() {
		return h_name;
	}
	
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}
	public String getH_address() {
		return h_address;
	}
	public String getH_image1() {
		return h_image1;
	}
	public void setH_image1(String h_image1) {
		this.h_image1 = h_image1;
	}
	public String getH_image2() {
		return h_image2;
	}
	public void setH_image2(String h_image2) {
		this.h_image2 = h_image2;
	}
	public String getH_image3() {
		return h_image3;
	}
	public void setH_image3(String h_image3) {
		this.h_image3 = h_image3;
	}
	public void setH_address(String h_address) {
		this.h_address = h_address;
	}
	public String getH_contact() {
		return h_contact;
	}
	public void setH_contact(String h_contact) {
		this.h_contact = h_contact;
	}
	public String getH_website() {
		return h_website;
	}
	public void setH_website(String h_website) {
		this.h_website = h_website;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
