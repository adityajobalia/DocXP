package com.project.healingtouch.services;

import com.project.healingtouch.dao.LoginDB;
import com.project.healingtouch.dao.RegisterDB;
import com.project.healingtouch.dto.LogBean;
import com.project.healingtouch.dto.RegBean;

public class RegisterServices {
	public boolean result;
	RegisterDB register_db;
	LoginDB login_db;
	LogBean logUserBean;
	
	/**
	 * 
	 * @param bean
	 * @return
	 * Business logic application
	 */

	public boolean verifyUserWhileRegister(RegBean bean) {
		register_db = new RegisterDB();
		result = register_db.registerUser(bean);
		return result;
	}

}
