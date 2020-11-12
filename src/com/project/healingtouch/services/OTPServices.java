package com.project.healingtouch.services;

import com.project.healingtouch.dao.OTPDB;
import com.project.healingtouch.dto.ChangePasswordBean;

public class OTPServices {

	public boolean flag;
	public boolean verifyEmail(ChangePasswordBean bean) {
		OTPDB otpdb = new OTPDB();
		flag = otpdb.getEmailData(bean);
		return flag;
	}

}
