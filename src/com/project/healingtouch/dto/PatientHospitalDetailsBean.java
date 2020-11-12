package com.project.healingtouch.dto;

import java.io.Serializable;

public class PatientHospitalDetailsBean implements Serializable{
	 private String doctor_name,doctor_image,doctor_speciality;
	 private String hospital_name,hospital_locality,hospital_image,hospital_address,hospital_contact,hospital_website,h_lat,h_long;

	 public  PatientHospitalDetailsBean () {
		 
	 }

	public PatientHospitalDetailsBean(String doctor_name2, String doctor_speciality2, String doctor_image2) {
		this.doctor_name=doctor_name2;
		this.doctor_speciality=doctor_speciality2;
		this.doctor_image=doctor_image2;
	}

	public String getHospital_locality() {
		return hospital_locality;
	}

	public void setHospital_locality(String hospital_locality) {
		this.hospital_locality = hospital_locality;
	}

	public String getH_lat() {
		return h_lat;
	}

	public void setH_lat(String h_lat) {
		this.h_lat = h_lat;
	}

	public String getH_long() {
		return h_long;
	}

	public void setH_long(String h_long) {
		this.h_long = h_long;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getDoctor_image() {
		return doctor_image;
	}

	public void setDoctor_image(String doctor_image) {
		this.doctor_image = doctor_image;
	}

	public String getDoctor_speciality() {
		return doctor_speciality;
	}

	public void setDoctor_speciality(String doctor_speciality) {
		this.doctor_speciality = doctor_speciality;
	}

	public String getHospital_name() {
		return hospital_name;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	public String getHospital_image() {
		return hospital_image;
	}

	public void setHospital_image(String hospital_image) {
		this.hospital_image = hospital_image;
	}

	public String getHospital_address() {
		return hospital_address;
	}

	public void setHospital_address(String hospital_address) {
		this.hospital_address = hospital_address;
	}

	public String getHospital_contact() {
		return hospital_contact;
	}

	public void setHospital_contact(String hospital_contact) {
		this.hospital_contact = hospital_contact;
	}

	public String getHospital_website() {
		return hospital_website;
	}

	public void setHospital_website(String hospital_website) {
		this.hospital_website = hospital_website;
	}
	 
}
