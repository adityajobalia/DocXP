package com.project.healingtouch.services;

import javax.servlet.http.HttpServletResponse;

import com.project.healingtouch.dao.LoginDB;
import com.project.healingtouch.dao.RegisterDoctorDB;
import com.project.healingtouch.dto.DocRegisterBean;
import com.project.healingtouch.dto.LogBean;

public class DocRegisterServices {
	public boolean result;
	LoginDB login_db;
	LogBean logUserBean;
	RegisterDoctorDB doctorDB;
	public boolean verifyDoctorRegistration(DocRegisterBean docRegisterBean, HttpServletResponse resp) {
		doctorDB= new RegisterDoctorDB();
		result=doctorDB.registerDoctor(docRegisterBean,resp);
		return result;
	}

}
