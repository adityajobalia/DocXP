package com.project.healingtouch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.healingtouch.dto.PatientFinHospitalBean;
import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;

public class PatientFinHospitalDB {
	SingleTon singleTon=SingleTon.getSt();
	Connection connection= singleTon.getcon();
	
ArrayList<PatientFinHospitalBean> list= new ArrayList<>();
	public ArrayList<PatientFinHospitalBean> getPatientFinHospitalBListData() {
		try {
			PreparedStatement getData_pstmt= connection.prepareStatement(QueryCollection.HOSPITAL_LIST_DATA);
			ResultSet rs=getData_pstmt.executeQuery();
			System.out.println("==result set=="+rs);
			while (rs.next()) {
				PatientFinHospitalBean bean= new PatientFinHospitalBean();
				bean.setH_name(rs.getString("h_name"));
				System.out.println("==rs.getString(\"h_name\")==="+rs.getString("h_name"));
				bean.setH_contact(rs.getString("h_locality"));
				System.out.println("====rs.getString(\"h_contact\")=="+rs.getString("h_locality"));
			
				list.add(new PatientFinHospitalBean(bean.getH_name(),bean.getH_contact()));
				System.out.println("===addd list=="+list);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public ArrayList<PatientFinHospitalBean> getPatientFindHospitalByCityListData(String city) {
		try {
			System.out.println("####====city======="+city);
			PreparedStatement getData_pstmt= connection.prepareStatement(QueryCollection.HOSPITAL_LIST_DATA_BY_CITY);
			getData_pstmt.setString(1, city);
			ResultSet rs=getData_pstmt.executeQuery();
			System.out.println("==result set=="+rs);
			while (rs.next()) {
				PatientFinHospitalBean bean= new PatientFinHospitalBean();
				bean.setH_name(rs.getString("h_name"));
				System.out.println("==rs.getString(\"h_name\")==="+rs.getString("h_name"));
				bean.setH_contact(rs.getString("h_locality"));
				System.out.println("====rs.getString(\"h_contact\")=="+rs.getString("h_locality"));
			
				list.add(new PatientFinHospitalBean(bean.getH_name(),bean.getH_contact()));
				System.out.println("===addd list=="+list);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
