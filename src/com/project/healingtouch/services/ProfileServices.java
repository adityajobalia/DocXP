package com.project.healingtouch.services;

import com.project.healingtouch.dao.ProfileDB;
import com.project.healingtouch.dto.ProfileBean;

public class ProfileServices {
	boolean result;
	ProfileDB db = new ProfileDB();

	public boolean verifyProfileData(ProfileBean bean) {
		result = db.getPatientProfileData(bean);
		return result;
	}

	public boolean changePatientData(ProfileBean bean) {
		result = db.updatePatientData(bean);
		return result;
	}
	public boolean verifyDoctorProfileData(ProfileBean profileBean) {
		result = db.getDoctorData(profileBean);
		return result;
	}

	public boolean changeDoctorData(ProfileBean bean) {
		result = db.updateDoctorData(bean);
		return result;
	}
}
