package com.project.healingtouch.services;

import java.util.ArrayList;

import com.project.healingtouch.dao.BookAppointmentSpinnerDB;
import com.project.healingtouch.dto.BookAppointmentSpinnerBean;

public class BookAppointmentSpinnerServices {
	BookAppointmentSpinnerBean dataBean;
	ArrayList<String> spinnerlist;
	public boolean result;
	BookAppointmentSpinnerDB appointmentSpinnerDB = new BookAppointmentSpinnerDB();
	
	public ArrayList<String> spinnerCityServices() {
		spinnerlist = appointmentSpinnerDB.getSpinnerCityData();
		return spinnerlist;
	}
	
	public ArrayList<String> spinnerSpecialityServices(String cityname) {
		spinnerlist = appointmentSpinnerDB.getSpinnerSpecialityData(cityname);
		return spinnerlist;
	}
	
	public ArrayList<String> spinnerHospitalServices(String speciality, String city) {
		spinnerlist = appointmentSpinnerDB.getSpinnerHospitalData(speciality,city);
		return spinnerlist;
	}
	
	public ArrayList<String> spinnerDoctorServices(String hospital, String speciality) {
		spinnerlist = appointmentSpinnerDB.getSpinnerDoctorData(hospital,speciality);
		return spinnerlist;
	}

}
