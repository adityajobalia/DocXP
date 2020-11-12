package com.project.healingtouch.services;

import java.util.ArrayList;

import com.project.healingtouch.dao.PatientFinHospitalDB;
import com.project.healingtouch.dto.PatientFinHospitalBean;

public class PatientFinHospitalServices {

	private PatientFinHospitalDB db;
	private ArrayList<PatientFinHospitalBean> list;
	
	public ArrayList<PatientFinHospitalBean> getPatientFinHospitalData() {
		
		db= new PatientFinHospitalDB();
		list=db.getPatientFinHospitalBListData();
		return list;
	}

	public ArrayList<PatientFinHospitalBean> getPatientFindHospitalByCityData(String city) {
		db= new PatientFinHospitalDB();
		list=db.getPatientFindHospitalByCityListData(city);
		return list;
	}

}
