package com.project.healingtouch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.healingtouch.dto.DoctorListofAppointmenBean;
import com.project.healingtouch.dto.DoctorMyScheduleBean;
import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;

public class DoctorMyScheduleDB {

	SingleTon singleTon=SingleTon.getSt();
	Connection connection=singleTon.getcon();
	String doc_name,doc_hospitalname;
	DoctorMyScheduleBean doctorMyScheduleBean;
	ArrayList<DoctorMyScheduleBean> list= new ArrayList<>();
	public ArrayList<DoctorMyScheduleBean> getConformAppointmentList(DoctorMyScheduleBean bean) {
		this.doctorMyScheduleBean=bean;
		try {
			PreparedStatement pstmt= connection.prepareStatement(QueryCollection.LIST_OF_APPOINTMENT_DOCTOR_DATA);
			pstmt.setString(1, doctorMyScheduleBean.getDoc_email());
			ResultSet resultSet=pstmt.executeQuery();
			System.out.println("====LIST_OF_APPOINTMENT_DOCTOR_DATA==rs="+resultSet);
			while (resultSet.next()) {
				doc_name=resultSet.getString("d_name");
				System.out.println("====name=="+doc_name);	
				doc_hospitalname=resultSet.getString("d_hospitalname");
				System.out.println("====hospital name==="+doc_hospitalname);
				
			}
			
			PreparedStatement getData_stmt= connection.prepareStatement(QueryCollection.DOC_LIST_OF_APPOINTMENT_DATA);
			getData_stmt.setString(1, doc_name);
			getData_stmt.setString(2, doc_hospitalname);
			getData_stmt.setString(3, doctorMyScheduleBean.getStatus());
			System.out.println("===DoctorMyScheduleBean="+doctorMyScheduleBean.getStatus());
			ResultSet set=getData_stmt.executeQuery();
			System.out.println("===DOC_LIST_OF_APPOINTMENT_DATA==rs"+set);
			while (set.next()) {
				
				doctorMyScheduleBean.setName(set.getString("patient_name"));
				System.out.println("====patient_name--=="+doctorMyScheduleBean.getName());
				doctorMyScheduleBean.setEmail(set.getString("patient_email"));
				System.out.println("===pateint email--==="+doctorMyScheduleBean.getEmail());
				doctorMyScheduleBean.setDoc_name(set.getString("patient_doctor"));
				doctorMyScheduleBean.setHospitalname(set.getString("patient_hospital"));
				doctorMyScheduleBean.setGender(set.getString("patient_gender"));
				doctorMyScheduleBean.setContect(set.getString("patient_contact"));
				doctorMyScheduleBean.setCity(set.getString("patient_city"));
				doctorMyScheduleBean.setDate(set.getString("patient_date"));
				doctorMyScheduleBean.setTime(set.getString("patient_time"));
				doctorMyScheduleBean.setStatus(set.getString("patient_status"));
				System.out.println("===pateint --==="+doctorMyScheduleBean.getTime());
				
				list.add(new DoctorMyScheduleBean(doctorMyScheduleBean.getName(),doctorMyScheduleBean.getEmail(),
						doctorMyScheduleBean.getGender(),doctorMyScheduleBean.getContect(),doctorMyScheduleBean.getDate(),doctorMyScheduleBean.getTime(),
						doctorMyScheduleBean.getStatus()));
				
				System.out.println("===add data in list -----==="+list);
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return list;
		
	
		}
}
