package com.project.healingtouch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.healingtouch.dto.PatientDoctorSpecialityBean;
import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;

public class PatientDoctorSpecialityDB {
	SingleTon singleTon= SingleTon.getSt();
	Connection connection= singleTon.getcon();
	ArrayList<PatientDoctorSpecialityBean> list= new ArrayList<>();
	public ArrayList<PatientDoctorSpecialityBean> getgPatientDoctorSpecialityList(PatientDoctorSpecialityBean bean) {
		try {
			PreparedStatement preparedStatement= connection.prepareStatement(QueryCollection.DOCTOR_SPECIALITY_lIST);
			preparedStatement.setString(1,bean.getTitle());
			System.out.println("====bean.getTitle()=="+bean.getTitle());
			ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				
				bean.setDoctorname(resultSet.getString("d_name"));
				System.out.println("===resultSet.getString(\"d_name\")=="+resultSet.getString("d_name"));
				bean.setDoctorspeciality(resultSet.getString("d_speciality"));
				bean.setDoctorcity(resultSet.getString("d_city"));
				bean.setDoctorhospitalname(resultSet.getString("d_hospitalname"));
				bean.setDoctorcontact(resultSet.getString("d_mobile"));
				bean.setDoctoremail(resultSet.getString("d_email"));
				bean.setProfileimage(resultSet.getString("d_profileimage"));
				
				list.add(new PatientDoctorSpecialityBean(bean.getDoctorname(),
						bean.getDoctorspeciality(),bean.getDoctorhospitalname(),
						bean.getDoctorcity(),bean.getDoctorcontact(),bean.getDoctoremail(),bean.getProfileimage()));
				System.out.println("=====list=="+list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	

}
