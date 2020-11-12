package com.project.healingtouch.dto;

import java.io.Serializable;

public class NearByHospitalBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String locality,address,h_name;
	private double latitude,longitude;
	public  NearByHospitalBean (double latitude,double longitude,String address,String h_name) {
		this.latitude=latitude;
		this.longitude=longitude;
		this.address=address;
		this.h_name=h_name;
		
	}
	
	
	public String getH_name() {
		return h_name;
	}


	public void setH_name(String h_name) {
		this.h_name = h_name;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public  NearByHospitalBean () {
		
	}
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}
	

}
