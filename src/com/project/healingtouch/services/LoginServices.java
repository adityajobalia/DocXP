package com.project.healingtouch.services;

import com.project.healingtouch.dao.LoginDB;
import com.project.healingtouch.dto.LogBean;

public class LoginServices {
	boolean result;
	LoginDB db;
	
	/**
	 * business logic implementation
	 * @param bean
	 * @return
	 */
	
	public boolean verifyUserWhileLogin(LogBean bean){
		db = new LoginDB();
		result = db.validateUser(bean);
		return result;
	}

}
