package com.project.healingtouch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.healingtouch.dto.ChangePasswordBean;
import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;

public class OTPDB {
	public boolean flag = false;
	SingleTon singleTon = SingleTon.getSt();
	Connection con = singleTon.getcon();

	public boolean getEmailData(ChangePasswordBean bean) {
		/**
		 * Patient Data
		 */
		try {
			String email = bean.getEmail();
			PreparedStatement patient_pstmt = con.prepareStatement(QueryCollection.REGISTER_VERIFY_QUERY);
			patient_pstmt.setString(1, email);
			ResultSet patient_rset = patient_pstmt.executeQuery();
			
			PreparedStatement doctor_pstmt = con.prepareStatement(QueryCollection.DOCTOR_VERIFY_QUERY);
			doctor_pstmt.setString(1, email);
			ResultSet doctor_rset = doctor_pstmt.executeQuery();
			while (patient_rset.next() || doctor_rset.next()){
				if (patient_rset.first()) {
					bean.setAuth("patient");
					flag = true;
				}
				else if (doctor_rset.first()) {
					bean.setAuth("doctor");
					flag = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

}

