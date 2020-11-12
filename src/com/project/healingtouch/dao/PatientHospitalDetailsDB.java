package com.project.healingtouch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.healingtouch.dto.PatientHospitalDetailsBean;
import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;

public class PatientHospitalDetailsDB {
	SingleTon singleTon=SingleTon.getSt();
	Connection connection=singleTon.getcon();
	PatientHospitalDetailsBean bean;
	String hospiatal_name;
	ArrayList<PatientHospitalDetailsBean> arrayList= new ArrayList<>();
	public PatientHospitalDetailsBean getHospitalData(PatientHospitalDetailsBean bean) {
		this.bean=bean;
		System.out.println("=======###getHospitalData=======");
		try {
			PreparedStatement statement=connection.prepareStatement(QueryCollection.HOSPITAL_DETAILS);
			hospiatal_name=bean.getHospital_name();
			statement.setString(1, hospiatal_name);
			statement.setString(2, bean.getHospital_locality());
			System.out.println("==hospiatal_name==="+hospiatal_name);
			System.out.println("==hospiatal_locality==="+bean.getHospital_locality());
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				bean.setHospital_name(rs.getString("h_name"));
				bean.setHospital_address(rs.getString("h_address"));
				bean.setHospital_contact(rs.getString("h_contact"));
				bean.setHospital_website(rs.getString("h_website"));
				bean.setHospital_image(rs.getString("h_profile"));
				
				System.out.println("====rs.getString(\"h_name\")====="+rs.getString("h_name"));
				System.out.println("=====rs.getString(\"h_address\")====="+rs.getString("h_address"));
				System.out.println("===rs.getString(\"h_contact\")===="+rs.getString("h_contact"));
				System.out.println("=====rs.getString(\"h_website\")===="+rs.getString("h_website"));
				System.out.println("=====rs.getString(\"h_image\")===="+rs.getString("h_profile"));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}

	public ArrayList<PatientHospitalDetailsBean> getDoctorData(PatientHospitalDetailsBean bean2) {
		this.bean=bean2;
		System.out.println("======getDoctorData=======");
		String h_nm=bean2.getHospital_name();
		System.out.println("=====hospiatal_name========"+h_nm);
		PreparedStatement getDoctor_pstmt;
		try {
			getDoctor_pstmt = connection.prepareStatement(QueryCollection.HOSPITAL_DETAILS_DOCTOR_LIST);
			getDoctor_pstmt.setString(1,h_nm);
			getDoctor_pstmt.setString(2, bean2.getHospital_locality());
			System.out.println("==hospiatal_name==="+h_nm);
			System.out.println("==hospiatal_city==="+ bean2.getHospital_locality());
			ResultSet  getData_rs=getDoctor_pstmt.executeQuery();
			while (getData_rs.next()) {
				
				
				bean.setDoctor_name(getData_rs.getString("d_name"));
				bean.setDoctor_speciality(getData_rs.getString("d_speciality"));
				bean.setDoctor_image(getData_rs.getString("d_profileimage"));
				
				System.out.println("=========getData_rs.getString(\"d_name\")======="+getData_rs.getString("d_name"));
				System.out.println("======getData_rs.getString(\"g_speciality\")======="+getData_rs.getString("d_speciality"));
				System.out.println("=====getData_rs.getString(\"d_profileimage\")====="+getData_rs.getString("d_profileimage"));
			
				arrayList.add( new PatientHospitalDetailsBean(bean.getDoctor_name(),bean.getDoctor_speciality(),bean.getDoctor_image()));
				System.out.println("===arrayList==="+arrayList);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return arrayList;
		


	}

	public PatientHospitalDetailsBean getHospitalLatLongData(PatientHospitalDetailsBean bean2) {
		this.bean=bean2;
		System.out.println("=======getHospitalData=======");
		try {
			PreparedStatement statement=connection.prepareStatement(QueryCollection.HOSPITAL_DATA_LATLONG);
			hospiatal_name=bean.getHospital_name();
			statement.setString(1, hospiatal_name);
			statement.setString(2, bean2.getHospital_locality());
			System.out.println("==hospiatal_name##==="+hospiatal_name);
			System.out.println("==hospiatal_locality##==="+bean2.getHospital_locality());
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				bean.setH_lat(rs.getString("h_latitude"));
				bean.setH_long(rs.getString("h_longitude"));


				System.out.println("====rs.getString(\"h_latitude\")##===="+rs.getString("h_latitude"));
				System.out.println("=====rs.getString(\"h_longitude\")##====="+rs.getString("h_longitude"));
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
		
	}
}
