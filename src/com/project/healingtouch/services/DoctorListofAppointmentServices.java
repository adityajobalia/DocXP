package com.project.healingtouch.services;

import java.util.ArrayList;

import com.project.healingtouch.dao.DoctorListofAppointmentDB;
import com.project.healingtouch.dto.DoctorListofAppointmenBean;

public class DoctorListofAppointmentServices {
	ArrayList<DoctorListofAppointmenBean> lst;
	DoctorListofAppointmenBean result;
	DoctorListofAppointmentDB appointmentDB= new DoctorListofAppointmentDB();
	public ArrayList<DoctorListofAppointmenBean> verifyDoctorListofAppointmentData(DoctorListofAppointmenBean bean) {
		lst=appointmentDB.getDocListofAppointmentData(bean);
		return lst;
	}
	
	

}
