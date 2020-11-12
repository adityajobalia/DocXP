package com.project.healingtouch.services;

import com.project.healingtouch.dao.BookAppointmentDB;
import com.project.healingtouch.dto.BookAppointmentBean;
import com.project.healingtouch.dto.BookAppointmentSpinnerBean;

public class BookAppointmentServices {
	public boolean result;
	BookAppointmentSpinnerBean spinnerBean;
	BookAppointmentDB bookAppointmentDB = new BookAppointmentDB();;

	public boolean appointmentServices(BookAppointmentBean appointmentBean) {
		// TODO Auto-generated method stub
		result = bookAppointmentDB.patientBookAppointment(appointmentBean);
		return result;
		
	}

	public BookAppointmentSpinnerBean getDoctorDetailsServices(String patient_doctorname, String speciality) {
		// TODO Auto-generated method stub
		spinnerBean = bookAppointmentDB.getDoctorDetailsFromDB(patient_doctorname,speciality);
		return spinnerBean;
		
	}

}
