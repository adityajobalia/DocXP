package com.project.healingtouch.services;

import java.util.ArrayList;

import com.project.healingtouch.dao.PatientMyAppointmentDB;
import com.project.healingtouch.dto.PatientMyAppointmentBean;

public class PatientMyAppointmentServices {
	PatientMyAppointmentDB db= new PatientMyAppointmentDB();
	ArrayList<PatientMyAppointmentBean> arrayList;
	
	public ArrayList<PatientMyAppointmentBean> getPatientAppointmentData(PatientMyAppointmentBean bean) {
		arrayList=db.getPatientAppointment(bean);
		return arrayList;
		
	}

}
