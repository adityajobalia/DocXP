package com.project.healingtouch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.healingtouch.dto.ProfileBean;
import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;

public class NavigationDrawerDataDB {

	SingleTon singleTon=SingleTon.getSt();
	Connection connection= singleTon.getcon();
	String doc_nm,doc_image;
	ProfileBean bean= new ProfileBean();

	public ProfileBean getDoctorDrawerData(String email) {
		try {
			PreparedStatement statement=connection.prepareStatement(QueryCollection.DOCTOR_DRAWER_DATA);
			statement.setString(1, email);
			ResultSet set=statement.executeQuery();
			while (set.next()) {
				doc_nm=set.getString("d_name");
				doc_image=set.getString("d_profileimage");
				bean.setName(doc_nm);
				bean.setProfileimage(doc_image);
				System.out.println("======bean.getName()========"+bean.getName());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
		
	
}

	public ProfileBean getPatientDrawerData(String email) {
		try {
			PreparedStatement statement=connection.prepareStatement(QueryCollection.PATIENT_DRAWER_DATA);
			System.out.println("=================#############3");
			statement.setString(1, email);
			ResultSet set=statement.executeQuery();
			while (set.next()) {
				
				doc_nm=set.getString("rname");
				doc_image=set.getString("rprofileimage");
				bean.setName(doc_nm);
				bean.setProfileimage(doc_image);
				System.out.println("======bean.getName()========"+bean.getName());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}
}
