package com.project.healingtouch.services;

import com.project.healingtouch.dao.PatientEmergencyContactDB;
import com.project.healingtouch.dto.PatientEmergencyContactBean;

public class PatientEmergencyContactServices  {
	PatientEmergencyContactDB db;
	boolean result;
	public boolean addEmergencyContactData(PatientEmergencyContactBean bean) {
		
		db= new PatientEmergencyContactDB();
		result=db.addContactData(bean);
		return result;
	}
	public PatientEmergencyContactBean getEmergencyData(PatientEmergencyContactBean contactBean) {
		db= new PatientEmergencyContactDB();
		PatientEmergencyContactBean bean=db.getPatientEmergencyData(contactBean);
		return bean;
	}
	/*public boolean rejectData(PatientEmergencyContactBean contactBean) {
		db= new PatientEmergencyContactDB();
		result=db.rejectDataFromDB(contactBean);
		return result;
	}*/

}
