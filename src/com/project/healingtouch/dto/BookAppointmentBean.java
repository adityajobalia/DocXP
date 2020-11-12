package com.project.healingtouch.dto;

import java.io.Serializable;

public class BookAppointmentBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String patientName;
	private String patientEmail;
	private String patientContact;
	private String patientGender;
	private String patientCity;
	private String patientDoctor;
	private String patientHospital;
	private String speciality;
	private String patientAppointmentDate;
	private String patientAppointmentTime;
	private String message;
	private String status;
	
	
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	public String getPatientContact() {
		return patientContact;
	}
	public void setPatientContact(String patientContact) {
		this.patientContact = patientContact;
	}
	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	public String getPatientCity() {
		return patientCity;
	}
	public void setPatientCity(String patientCity) {
		this.patientCity = patientCity;
	}
	public String getPatientDoctor() {
		return patientDoctor;
	}
	public void setPatientDoctor(String patientDoctor) {
		this.patientDoctor = patientDoctor;
	}
	public String getPatientHospital() {
		return patientHospital;
	}
	public void setPatientHospital(String patientHospital) {
		this.patientHospital = patientHospital;
	}
	public String getPatientAppointmentDate() {
		return patientAppointmentDate;
	}
	public void setPatientAppointmentDate(String patientAppointmentDate) {
		this.patientAppointmentDate = patientAppointmentDate;
	}
	public String getPatientAppointmentTime() {
		return patientAppointmentTime;
	}
	public void setPatientAppointmentTime(String patientAppointmentTime) {
		this.patientAppointmentTime = patientAppointmentTime;
	}
	
}
