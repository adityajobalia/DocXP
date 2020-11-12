package com.project.healingtouch.services;

import java.util.ArrayList;

import com.project.healingtouch.dao.DoctorAppointmentConfirmDB;
import com.project.healingtouch.dto.DoctorListofAppointmenBean;

public class DoctorAppointmentConfirmServices {
DoctorAppointmentConfirmDB db;
DoctorListofAppointmenBean bean;
boolean result;
ArrayList<DoctorListofAppointmenBean> list;
	public boolean conformAppointmentData(DoctorListofAppointmenBean bean) {
		db= new DoctorAppointmentConfirmDB();
		result=db.conformAppontmentData(bean);
		return result;
	}

}
