package com.project.healingtouch.services;

import com.project.healingtouch.dao.NotificationDB;
import com.project.healingtouch.dto.DocRegisterBean;
import com.project.healingtouch.dto.LogBean;

public class NotificationServices {
	boolean flag;
	NotificationDB db = new NotificationDB();

	public boolean getPatientServices(String email, String token) {
		// TODO Auto-generated method stub
		flag = db.getPatientData(email,token);
		return flag;
	}

	public boolean getDoctorServices(String email, String token) {
		// TODO Auto-generated method stub
		flag = db.getDoctorData(email,token);
		return flag;
	}

	public DocRegisterBean sendNotificationToDoctorServices(DocRegisterBean docBean) {
		// TODO Auto-generated method stub
		docBean= db.sendNotificationToDoctor(docBean);
		return docBean;
	}

	public LogBean sendNotificationToPatientService(LogBean patBean) {
		// TODO Auto-generated method stub
		patBean = db.sendNotificationToPatient(patBean);
		return patBean;
	}

}
