package com.project.healingtouch.services;

import com.project.healingtouch.dao.NavigationDrawerDataDB;
import com.project.healingtouch.dto.ProfileBean;

public class NavigationDrawerDataServices {

	public ProfileBean getDoctorDrawerData(String email) {
		NavigationDrawerDataDB db= new NavigationDrawerDataDB();
		ProfileBean bean=db.getDoctorDrawerData(email);
		return bean;
	}

	public ProfileBean getPatientDrawerData(String email) {
		NavigationDrawerDataDB db= new NavigationDrawerDataDB();
		ProfileBean bean=db.getPatientDrawerData(email);
		return bean;
	}

}
