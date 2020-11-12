package com.project.healingtouch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.healingtouch.dto.DoctorListofAppointmenBean;
import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;

public class DoctorAppointmentRejectionDB {

	public boolean removedata(DoctorListofAppointmenBean bean) {
		SingleTon ton= SingleTon.getSt();
		Connection connection=ton.getcon();
		boolean result = false;
		try {
			PreparedStatement preparedStatement= connection.prepareStatement(QueryCollection.REMOVE_DATA_FROM_LIST);
			preparedStatement.setString(1, bean.getName());
			preparedStatement.setString(2, bean.getEmail());
			preparedStatement.setString(3, bean.getDate());
			preparedStatement.setString(4, bean.getTime());
			
			int i=preparedStatement.executeUpdate();
			System.out.println("====delete==="+i);
			if(i==1) {
				result=true;
				
			}
			else {
				System.out.println("=======");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	

}
