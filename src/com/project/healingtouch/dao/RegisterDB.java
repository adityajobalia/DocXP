package com.project.healingtouch.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;
import com.project.healingtouch.dto.LogBean;
import com.project.healingtouch.dto.RegBean;

/**
 * 
 * @author Class for registering User in Database
 */
public class RegisterDB {
	RegBean bean;
	public boolean result = false;
	SingleTon singleton = SingleTon.getSt();
	Connection con = singleton.getcon();

	/**
	 * Register new User
	 */
	
	public boolean registerUser(RegBean bean) {
		this.bean = bean;
		String regName = bean.getUserName();
		String regEmail = bean.getUserEmail();
		String regPass = bean.getUserPass();
		String regMobile = bean.getUserMobile();
		String regImage=bean.getUserImage();
		
		try {
			
			PreparedStatement pstmt = con
					.prepareStatement(QueryCollection.REGISTER_QUERY);
			pstmt.setString(1, regName);
			pstmt.setString(2, regEmail);
			pstmt.setString(3, regPass);
			pstmt.setString(4, regMobile);
			pstmt.setString(5, regImage);
			
			
			System.out.println("Data is set into stmt");
			
			/**
			 * Verification of User Email while registration
			 * 
			 */
			PreparedStatement pstmt_readData = con
					.prepareStatement(QueryCollection.REGISTER_VERIFY_QUERY);
			pstmt_readData.setString(1, regEmail);
			ResultSet resultSet = pstmt_readData.executeQuery();
			System.out.println("reg_verify_query executed");

			if (resultSet.first()) {
				System.out.println("Account already exists");
				bean.setMessage("exists");
			} else {
				System.out.println("inside else condition");
				int query_result = pstmt.executeUpdate();
				if (query_result == 1) {
					result = true;
					System.out
							.println("Data Insertion successful in register table");
					
					/**
					 * Registration of User into Login table
					 * 
					 */
					LogBean mLogBean = new LogBean();
					mLogBean.setLogEmail(regEmail);
					mLogBean.setLogPass(regPass);
					LoginDB db = new LoginDB();
					result = db.loginUser(mLogBean);
					if (result) {
						result = true;
						bean.setMessage("success");
						System.out
								.println("Data insertion Successfull in Login table");
					} else {
						result = false;
						System.out
								.println("Insertion in login table failed!! Check loginDB class");
					}
				} else {
					System.out.println("Failed inserting data");
				}

			}
		} catch (SQLException e) {
			System.out.println("SQL exception in RegisterDB class");
		}

		return result;

	}
}
