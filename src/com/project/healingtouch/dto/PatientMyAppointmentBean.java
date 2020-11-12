package com.project.healingtouch.dto;

import java.io.Serializable;

public class PatientMyAppointmentBean implements Serializable{
	String name,age,gender,email,contect,date,time,patient_email,doc_name,doc_date,hospitalname,city;

	public  PatientMyAppointmentBean() {
		
	}
	public  PatientMyAppointmentBean(String name2, String email2, String gender2, String contect2, String date2,String time2) {
		this.name=name2;
		this.email=email2;
		this.gender=gender2;
		this.contect=contect2;
		this.date=date2;
		this.time=time2;
	
		
	}

	public PatientMyAppointmentBean(String name2,String email2,String doc_name2, String hospitalname2, String city2, String date2, String time2) {
		this.name=name2;
		this.email=email2;
		this.doc_name=doc_name2;
		this.hospitalname=hospitalname2;
		this.city=city2;
		this.date=date2;
		this.time=time2;
	}
	public String getPatient_email() {
		return patient_email;
	}
	public void setPatient_email(String patient_email) {
		this.patient_email = patient_email;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContect() {
		return contect;
	}

	public void setContect(String contect) {
		this.contect = contect;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}


	public String getDoc_name() {
		return doc_name;
	}

	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}

	public String getDoc_date() {
		return doc_date;
	}

	public void setDoc_date(String doc_date) {
		this.doc_date = doc_date;
	}

	public String getHospitalname() {
		return hospitalname;
	}

	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	

}
