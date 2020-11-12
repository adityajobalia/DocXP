package com.project.healingtouch.services;

import java.util.ArrayList;

import com.project.healingtouch.dao.DoctorListofAppointmentSortingDB;
import com.project.healingtouch.dto.DoctorListofAppointmenBean;

public class DoctorListofAppointmentSortingServices {
	ArrayList<DoctorListofAppointmenBean> lst;
	DoctorListofAppointmenBean result;
	DoctorListofAppointmentSortingDB db= new DoctorListofAppointmentSortingDB();

	public ArrayList<DoctorListofAppointmenBean> verifyDoctorListofAppointmentSortingData(DoctorListofAppointmenBean bean) {
		lst=db.getDocListofAppointmentSortedData(bean);
		return lst;
	}
	
}
