package com.project.healingtouch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.healingtouch.dto.DocRegisterBean;
import com.project.healingtouch.dto.LogBean;
import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;

public class NotificationDB {
	SingleTon singleton = SingleTon.getSt();
	Connection con = singleton.getcon();
	boolean flag = false;

	public boolean getPatientData(String email, String token) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = con.prepareStatement(QueryCollection.UPDATE_PATIENT_TOKEN);
			pstmt.setString(1, token);
			pstmt.setString(2, email);
			int result = pstmt.executeUpdate();
			System.out.println(result);
			if(result == 1) {
				System.out.println("Data updated...");
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in updating patient token");
		}
		return flag;
	}

	public boolean getDoctorData(String email, String token) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = con.prepareStatement(QueryCollection.UPDATE_DOCTOR_TOKEN);
			pstmt.setString(1, token);
			pstmt.setString(2, email);
			int result = pstmt.executeUpdate();
			if(result == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public DocRegisterBean sendNotificationToDoctor(DocRegisterBean docBean) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt =  con.prepareStatement(QueryCollection.GET_DOCTOR_TOKEN);
			pstmt.setString(1, docBean.getDocName());
			ResultSet rSet = pstmt.executeQuery();
			while(rSet.next()) {
				docBean.setToken(rSet.getString("d_token"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return docBean;
	}

	public LogBean sendNotificationToPatient(LogBean patBean) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt =  con.prepareStatement(QueryCollection.GET_PATIENT_TOKEN);
			pstmt.setString(1, patBean.getLogEmail());
			ResultSet rSet = pstmt.executeQuery();
			while(rSet.next()) {
				patBean.setToken(rSet.getString("token"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patBean;
	}

}
