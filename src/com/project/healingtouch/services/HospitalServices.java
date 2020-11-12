package com.project.healingtouch.services;

import javax.servlet.http.HttpServletResponse;

import com.project.healingtouch.dao.HospitalDB;
import com.project.healingtouch.dto.HospitalBean;

public class HospitalServices {

	public void getHospitalData(HospitalBean bean, HttpServletResponse resp) {
		HospitalDB  db= new  HospitalDB();
		db.getHopital(bean,resp);
		
	}

}
