package com.project.healingtouch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.healingtouch.dto.ChangePasswordBean;
import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;

public class ChangePasswordDB {
	public boolean flag = false;
	SingleTon singleTon = SingleTon.getSt();
	Connection con = singleTon.getcon();

	public boolean updatePatientData(ChangePasswordBean bean) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement patient_reg_pstmt = con.prepareStatement(QueryCollection.PATIENT_PASSWORD_UPDATE_REGISTRATION);
			patient_reg_pstmt.setString(1, bean.getPassword());
			patient_reg_pstmt.setString(2, bean.getEmail());
			int patient_reg_result = patient_reg_pstmt.executeUpdate();
			if (patient_reg_result == 1) {
				PreparedStatement patient_log_pstmt = con.prepareStatement(QueryCollection.PATIENT_PASSWORD_UPDATE_LOGIN);
				patient_log_pstmt.setString(1, bean.getPassword());
				patient_log_pstmt.setString(2, bean.getEmail());
				int patient_log_result = patient_log_pstmt.executeUpdate();
				if (patient_log_result == 1) {
					bean.setMessage("success");
					flag = true;
				}
				else {
					System.out.println("Error updating data in LoginTable");
				}
			}
			else {
				System.out.println("Error updating data in RegistrationTable");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	public boolean updateDoctorData(ChangePasswordBean bean) {
	try {
		PreparedStatement doctor_pstmt = con.prepareStatement(QueryCollection.DOCTOR_PASSWORD_UPDATE);
		doctor_pstmt.setString(1, bean.getPassword());
		doctor_pstmt.setString(2, bean.getEmail());
		int doctor_result = doctor_pstmt.executeUpdate();
		if (doctor_result == 1) {
			bean.setMessage("success");
			flag = true;
		}
		else {
			System.out.println("Password update failure in DoctorTable");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return flag;
	}

}
