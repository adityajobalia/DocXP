package com.project.healingtouch.services;

import java.util.ArrayList;

import com.project.healingtouch.dao.PatientDoctorSpecialityDB;
import com.project.healingtouch.dto.PatientDoctorSpecialityBean;

public class PatientDoctorSpecialityServices {
	ArrayList<PatientDoctorSpecialityBean> list;
	PatientDoctorSpecialityDB db;
	public ArrayList<PatientDoctorSpecialityBean> getPatientDoctorSpecialityData(PatientDoctorSpecialityBean bean) {
		db= new PatientDoctorSpecialityDB();
		list=db.getgPatientDoctorSpecialityList(bean);
		return list;
	}

}
