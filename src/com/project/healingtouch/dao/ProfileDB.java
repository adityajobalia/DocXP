package com.project.healingtouch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.healingtouch.dto.ProfileBean;
import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;

public class ProfileDB {
	public ProfileBean bean;
	boolean result;
	SingleTon singleton = SingleTon.getSt();
	Connection con = singleton.getcon();

	public boolean getPatientProfileData(ProfileBean bean) {
		this.bean = bean;
		try {
			PreparedStatement patient_pstmt = con
					.prepareStatement(QueryCollection.PATIENT_PROFILE_QUERY);
			patient_pstmt.setString(1, bean.getEmail());
			System.out.println("====="+bean.getEmail());
			patient_pstmt.setString(2, bean.getPassword());
			System.out.println("===="+bean.getPassword());
			System.out.println("===============");
			ResultSet patient_rset = patient_pstmt.executeQuery();
			System.out.println("====="+patient_rset);
			
				while  (patient_rset.next()) {
					System.out.println("===========true");
					 result = true;
					bean.setAuth("patient");
					bean.setName(patient_rset.getString("rname"));
					bean.setMobile(patient_rset.getString("rmobile"));
					bean.setProfileimage(patient_rset.getString("rprofileimage"));
					
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean updatePatientData(ProfileBean bean2) {
		//this.bean = bean2;
		switch (bean2.getField()) {
		case "name": {
			result = updatePatientDataRegDB(bean2);
			break;
		}
		case "password": {
			result = updatePatientDataLogDB(bean2);
			break;
		}
		case "email": {
			result = updatePatientDataLogDB(bean2);
			break;
		}
		case "mobile": {
			result = updatePatientDataRegDB(bean2);
			break;
		}
		case "profileimage": {
			System.out.println("====profileimage====");
			result = updatePatientDataRegDB(bean2);
			break;
		}
		default:
			break;
		}
		return result;
	}
	
	public boolean updatePatientDataRegDB(ProfileBean regProfileBean){
		//this.bean = regProfileBean;
		try {
			System.out.println("=============");
			PreparedStatement regDb_pstmt = con.prepareStatement(QueryCollection.PATIENT_DATA_UPDATE_REGISTRATION);
			regDb_pstmt.setString(1, regProfileBean.getName());
			regDb_pstmt.setString(2,regProfileBean.getEmail());
			regDb_pstmt.setString(3,regProfileBean.getPassword());
			regDb_pstmt.setString(4,regProfileBean.getMobile());
			regDb_pstmt.setString(5, regProfileBean.getProfileimage());
			regDb_pstmt.setString(6,regProfileBean.getOldEmail());
			System.out.println(regProfileBean.getName()+" "+regProfileBean.getEmail()+" "+regProfileBean.getPassword()+" "+regProfileBean.getMobile()+" "+regProfileBean.getOldEmail()+" "+regProfileBean.getProfileimage());
			int i= regDb_pstmt.executeUpdate();
			System.out.println("==============update"+i);
			if (i == 1) {
				result = true;
			}
			else {
				System.out.println("Failed to update data .............in registration table");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean updatePatientDataLogDB(ProfileBean logProfileBean){
		//this.bean = logProfileBean;
		try {
			PreparedStatement logDb_pstmt = con.prepareStatement(QueryCollection.PATIENT_DATA_UPDATE_LOGIN);
			logDb_pstmt.setString(1, logProfileBean.getEmail());
			logDb_pstmt.setString(2, logProfileBean.getPassword());
			logDb_pstmt.setString(3, logProfileBean.getOldEmail());
			
			
			int logDb_result = logDb_pstmt.executeUpdate();
			if (logDb_result == 1 ) {
				result = updatePatientDataRegDB(logProfileBean);
				if (result) {
					result = true;
				}
				else {
					System.out.println("Failed to update data in register table");
				}
			}
			else{
				System.out.println("Failed to update data in Login table");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public boolean getDoctorData(ProfileBean profileBean) {
		this.bean = profileBean;
		try {
			PreparedStatement patient_pstmt = con
					.prepareStatement(QueryCollection.DOCTOR_LOGIN_QUERY);
			patient_pstmt.setString(1, bean.getEmail());
			patient_pstmt.setString(2, bean.getPassword());
			ResultSet patient_rset = patient_pstmt.executeQuery();
			while (patient_rset.next()) {
				result = true;
				bean.setAuth("doctor");
				System.out.println("==========="+bean.getAuth());
				bean.setName(patient_rset.getString("d_name"));
				System.out.println("==========="+bean.getName());
				bean.setMobile(patient_rset.getString("d_mobile"));
				System.out.println("==========="+bean.getMobile());
				bean.setSpeciality(patient_rset.getString("d_speciality"));
				System.out.println("==========="+bean.getSpeciality());
				bean.setProfileimage(patient_rset.getString("d_profileimage"));
				System.out.println("==========="+bean.getProfileimage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean updateDoctorData(ProfileBean profileBean) {
		switch (profileBean.getField()) {
		
		case "password": {
			result = updateDoctorDataLogDB(profileBean);
			break;
		}
		case "email": {
			result = updateDoctorDataLogDB(profileBean);
			break;
		}
		case "mobile": {
			result = updateDoctorDataDocDB(profileBean);
			break;
		}
		case "profileimage": {
			System.out.println("====profileimage====");
			result = updateDoctorDataDocDB(profileBean);
			break;
		}
		default:
			break;
		}
		return result;
		
	}

	private boolean updateDoctorDataLogDB(ProfileBean profileBean) {
		try {
			PreparedStatement logDb_pstmt = con.prepareStatement(QueryCollection.PATIENT_DATA_UPDATE_LOGIN);
			logDb_pstmt.setString(1, profileBean.getEmail());
			logDb_pstmt.setString(2, profileBean.getPassword());
			logDb_pstmt.setString(3, profileBean.getOldEmail());
			
			
			int logDb_result = logDb_pstmt.executeUpdate();
			if (logDb_result == 1 ) {
				result = updateDoctorDataDocDB(profileBean);
				if (result) {
					result = true;
				}
				else {
					System.out.println("Failed to update data in register table");
				}
			}
			else{
				System.out.println("Failed to update data in Login table");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private boolean updateDoctorDataDocDB(ProfileBean profileBean) {
		try {
			PreparedStatement docDb_pstmt = con.prepareStatement(QueryCollection.DOCTOR_DATA_UPDATE_QUERY);
			docDb_pstmt.setString(1, profileBean.getName());
			docDb_pstmt.setString(2,profileBean.getEmail());
			docDb_pstmt.setString(3,profileBean.getPassword());
			docDb_pstmt.setString(4,profileBean.getMobile());
			//docDb_pstmt.setString(5, profileBean.getSpeciality());
			docDb_pstmt.setString(5, profileBean.getProfileimage());
			docDb_pstmt.setString(6,profileBean.getOldEmail());
			System.out.println(profileBean.getName()+" "+profileBean.getEmail()+" "+profileBean.getPassword()+" "+profileBean.getMobile()+" "+profileBean.getProfileimage()+" "+profileBean.getSpeciality()+""+profileBean.getOldEmail());
			int regDb_result = docDb_pstmt.executeUpdate();
			if (regDb_result == 1) {
				result = true;
			}
			else {
				System.out.println("Failed to update data in registration table");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
