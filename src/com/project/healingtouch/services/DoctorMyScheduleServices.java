package com.project.healingtouch.services;

import java.util.ArrayList;

import com.project.healingtouch.dao.DoctorMyScheduleDB;
import com.project.healingtouch.dto.DoctorMyScheduleBean;

public class DoctorMyScheduleServices {

	DoctorMyScheduleDB db;  
	ArrayList<DoctorMyScheduleBean> list;
	public ArrayList<DoctorMyScheduleBean> getConformAppointmentData(DoctorMyScheduleBean bean) {
		db= new DoctorMyScheduleDB();
		list=db.getConformAppointmentList(bean);
		return list;
		
	}

}
