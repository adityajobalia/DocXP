package com.project.healingtouch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.healingtouch.dto.DoctorListofAppointmenBean;
import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;

public class DoctorAppointmentConfirmDB {
	SingleTon singleTon=SingleTon.getSt();
	Connection connection=singleTon.getcon();
	DoctorListofAppointmenBean bean;
	boolean result;
	String doc_name,doc_hospitalname;
	ArrayList<DoctorListofAppointmenBean> list= new ArrayList<>();
	public boolean conformAppontmentData(DoctorListofAppointmenBean bean) {
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(QueryCollection.CONFIRM_UPDATE_APPOINTMENT);
			preparedStatement.setString(1, bean.getStatus());
			preparedStatement.setString(2, bean.getName());
			preparedStatement.setString(3, bean.getEmail());
			preparedStatement.setString(4, bean.getDate());
			preparedStatement.setString(5, bean.getTime());
			System.out.println("=====set data==");
			int i=preparedStatement.executeUpdate();
			System.out.println("===update=="+i);
			if(i==1) {
				result=true;
			}
			else {
				System.out.println("=====no data update==");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
