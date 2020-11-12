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
	
	public ArrayList<String> spinnerDoctorServices() {
		spinnerlist = appointmentSpinnerDB.getSpinnerDoctorData();
		return spinnerlist;
	}
	
	public ArrayList<String> spinnerHospitalServices() {
		spinnerlist = appointmentSpinnerDB.getSpinnerHospitalData();
		return spinnerlist;
	}

}
