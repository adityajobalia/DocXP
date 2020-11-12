package com.project.healingtouch.dto;

import java.io.Serializable;

public class BookAppointmentSpinnerBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String doctor_name;
	private String hospital_name;
	private String hospital_city;
	private String speciality;
	
	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public BookAppointmentSpinnerBean() {
		
	}
	
	public BookAppointmentSpinnerBean(String doctor_name, String hospital_name, String hospital_city, String speciality) {
		super();
		this.doctor_name = doctor_name;
		this.hospital_name = hospital_name;
		this.hospital_city = hospital_city;
		this.speciality = speciality;
	}
	public BookAppointmentSpinnerBean(String hospital_city2) {
		// TODO Auto-generated constructor stub
		this.hospital_city = hospital_city2;
	}

	public BookAppointmentSpinnerBean(BookAppointmentSpinnerBean dataBean) {
		// TODO Auto-generated constructor stub
		this.hospital_city = dataBean.getHospital_city();
		this.doctor_name = dataBean.getDoctor_name();
		this.hospital_name = dataBean.getHospital_name();
		this.speciality = dataBean.getSpeciality();
	}

	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getHospital_name() {
		return hospital_name;
	}
	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}
	public String getHospital_city() {
		return hospital_city;
	}
	public void setHospital_city(String hospital_city) {
		this.hospital_city = hospital_city;
	}
	
	

}
