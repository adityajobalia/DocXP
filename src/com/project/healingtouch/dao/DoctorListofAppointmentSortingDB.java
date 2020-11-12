package com.project.healingtouch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.healingtouch.dto.DoctorListofAppointmenBean;
import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;

public class DoctorListofAppointmentSortingDB {
	public DoctorListofAppointmenBean appointmenBean;
	boolean result;
	String doc_name,doc_hospitalname,date;
	SingleTon singleTon=SingleTon.getSt();
	Connection con=singleTon.getcon();
	ArrayList<DoctorListofAppointmenBean> list= new ArrayList<>();
	
	public ArrayList<DoctorListofAppointmenBean> getDocListofAppointmentSortedData(DoctorListofAppointmenBean bean) {
this.appointmenBean=bean;
		
		try {
			PreparedStatement pstmt= con.prepareStatement(QueryCollection.LIST_OF_APPOINTMENT_DOCTOR_DATA);
			pstmt.setString(1, appointmenBean.getDoc_email());
			ResultSet resultSet=pstmt.executeQuery();
			System.out.println("====LIST_OF_APPOINTMENT_DOCTOR_DATA==rs="+resultSet);
			while (resultSet.next()) {
				doc_name=resultSet.getString("d_name");
				System.out.println("====name=="+doc_name);	
				doc_hospitalname=resultSet.getString("d_hospitalname");
				System.out.println("====hospital name==="+doc_hospitalname);
				
			}
			
			PreparedStatement getData_stmt= con.prepareStatement(QueryCollection.DOC_LIST_OF_APPOINTMENT_SORTED_DATA);
			getData_stmt.setString(1, doc_name);
			getData_stmt.setString(2, doc_hospitalname);
			
			date=appointmenBean.getDoc_date();
			getData_stmt.setString(3, date);
			getData_stmt.setString(4, "pending");
			System.out.println("==date=="+appointmenBean.getDoc_date());
			ResultSet set=getData_stmt.executeQuery();
			System.out.println("===DOC_LIST_OF_APPOINTMENT_DATA==rs"+set);
			while (set.next()) {
				System.out.println("---in while loop---");
				appointmenBean.setName(set.getString("patient_name"));
				System.out.println("====patient_name--=="+appointmenBean.getName());
				appointmenBean.setEmail(set.getString("patient_email"));
				System.out.println("===pateint email--==="+appointmenBean.getEmail());
				appointmenBean.setDoc_name(set.getString("patient_doctor"));
				appointmenBean.setHospitalname(set.getString("patient_hospital"));
				appointmenBean.setGender(set.getString("patient_gender"));
				appointmenBean.setContect(set.getString("patient_contact"));
				appointmenBean.setCity(set.getString("patient_city"));
				appointmenBean.setDate(set.getString("patient_date"));
				appointmenBean.setTime(set.getString("patient_time"));
				appointmenBean.setStatus(set.getString("patient_status"));
				System.out.println("===pateint --==="+appointmenBean.getTime());
				
					System.out.println("===date.equals(set.getString(\"patient_date\"))=="+date.equals(set.getString("patient_date")));
					
					list.add(new DoctorListofAppointmenBean(appointmenBean.getName(),appointmenBean.getEmail(),
							appointmenBean.getGender(),appointmenBean.getContect(),appointmenBean.getDate(),appointmenBean.getTime(),
							appointmenBean.getStatus()));
					
				}
				
				System.out.println("===add data in list -----==="+list);
				
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return list;
	}
		

}
