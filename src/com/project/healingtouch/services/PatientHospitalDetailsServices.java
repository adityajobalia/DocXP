package com.project.healingtouch.services;

import java.util.ArrayList;

import com.project.healingtouch.dao.PatientHospitalDetailsDB;
import com.project.healingtouch.dto.PatientHospitalDetailsBean;

public class PatientHospitalDetailsServices {
PatientHospitalDetailsDB db;
ArrayList<PatientHospitalDetailsBean> arrayList;
PatientHospitalDetailsBean bean;
	public PatientHospitalDetailsBean getHospitalDetails(PatientHospitalDetailsBean bean) {
		db= new PatientHospitalDetailsDB();
		bean=db.getHospitalData(bean);
		return bean;
			
	}
	public ArrayList<PatientHospitalDetailsBean> getDoctorDetails(PatientHospitalDetailsBean bean2) {
		db= new PatientHospitalDetailsDB();
		arrayList=db.getDoctorData(bean2);
		return arrayList;
	}
	public PatientHospitalDetailsBean getHospitalLatLong(PatientHospitalDetailsBean bean2) {
		db= new PatientHospitalDetailsDB();
		bean=db.getHospitalLatLongData(bean2);
		return bean;
	}

}
