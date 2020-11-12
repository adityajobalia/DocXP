package com.project.healingtouch.services;

import com.project.healingtouch.dao.ChangePasswordDB;
import com.project.healingtouch.dto.ChangePasswordBean;

public class ChangePasswordServices {
	public boolean flag;
	ChangePasswordDB db;

	public boolean verifyPatientPassword(ChangePasswordBean bean) {
		db = new ChangePasswordDB();
		flag = db.updatePatientData(bean);
		return flag;
	}

	public boolean verifyDoctorPassword(ChangePasswordBean bean) {
		flag = db.updateDoctorData(bean);
		return flag;
	}

}
