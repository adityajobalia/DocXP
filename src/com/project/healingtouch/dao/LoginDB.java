package com.project.healingtouch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.healingtouch.dto.LogBean;
import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;

public class LoginDB {
	public LogBean bean;
	public boolean result = false;
	SingleTon singleton = SingleTon.getSt();
	Connection con = singleton.getcon();

	/**
	 * 
	 * @param bean
	 * @return User Validation while login
	 */
	public boolean validateUser(LogBean bean) {
		this.bean = bean;
		String logEmail = bean.getLogEmail();
		String logPass = bean.getLogPass();

		try {
			/**
			 * @Patient Login
			 */
			PreparedStatement pstmt = con
					.prepareStatement(QueryCollection.LOGIN_VERIFY_QUERY);
			pstmt.setString(1, logEmail);
			pstmt.setString(2, logPass);
			ResultSet login_rset = pstmt.executeQuery();

			/**
			 * @Doctor Login
			 */
			PreparedStatement docPstmt = con
					.prepareStatement(QueryCollection.DOCTOR_LOGIN_QUERY);
			docPstmt.setString(1, logEmail);
			docPstmt.setString(2, logPass);
			ResultSet docLogin_rset = docPstmt.executeQuery();
			while (login_rset.next() || docLogin_rset.next()) {
				if (login_rset.first()) {
					String remail = login_rset.getString("remail");
					if (remail.equals(logEmail)) {
						result = true;
						System.out.println("===bean.setMessage(\"patient\");");
						bean.setMessage("patient");
						System.out.println("Welcome " + logEmail);
					}
				} else if (docLogin_rset.first()) {
					String docemail = docLogin_rset.getString("d_email");
					if (docemail.equals(logEmail)) {
						result = true;
						System.out.println("-====bean.setMessage(\"doctor\");");
						bean.setMessage("doctor");
						System.out.println("Welcome Doctor:" + logEmail);
					}
				} else {
					System.out.println("No such Data found");
					
					
				}
			}
		} catch (SQLException e) {
			System.out.println("SQL exception in LoginDB class   " + e);
		}

		return result;
	}
	/**
	 * 
	 * @param bean
	 * @return Registration of User in login table
	 */
	public boolean loginUser(LogBean bean) {

		String logEmail = bean.getLogEmail();
		String logPass = bean.getLogPass();

		try {
			PreparedStatement pstmt = con
					.prepareStatement(QueryCollection.LOGIN_QUERY);
			pstmt.setString(1, logEmail);
			pstmt.setString(2, logPass);
			int query_result = pstmt.executeUpdate();
			if (query_result == 1) {
				System.out
						.println("=============Data Insertion successful in Login Table");
				result = true;
			} else {
				System.out.println("Failed Fetching data");
			}
		} catch (SQLException e) {
			System.out.println("SQL exception in LoginDB class");
		}
		return result;
	}

}
