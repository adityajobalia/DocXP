package com.project.healingtouch.services;

import com.project.healingtouch.dao.DoctorAppointmentRejectionDB;
import com.project.healingtouch.dto.DoctorListofAppointmenBean;

public class DoctorAppointmentRejectionServices {
	DoctorAppointmentRejectionDB db= new DoctorAppointmentRejectionDB();
	DoctorListofAppointmenBean appointmenBean;
	boolean result;
	
	public boolean removeData(DoctorListofAppointmenBean bean) {
		
		result=db.removedata(bean);
		return result;
		
	}
	

}
