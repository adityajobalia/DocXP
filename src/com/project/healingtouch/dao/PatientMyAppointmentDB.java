package com.project.healingtouch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.healingtouch.dto.PatientMyAppointmentBean;
import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;


public class PatientMyAppointmentDB {
	PatientMyAppointmentBean  bean;
	boolean result;
	SingleTon singleTon=SingleTon.getSt();
	Connection con=singleTon.getcon();
	ArrayList<PatientMyAppointmentBean> arrayList= new ArrayList<>();
	public ArrayList<PatientMyAppointmentBean> getPatientAppointment(PatientMyAppointmentBean bean) {
		this.bean=bean;
		
		try {
			PreparedStatement statement= con.prepareStatement(QueryCollection.LIST_OF_APPOINTMENT_PATIENT_DATA);
			statement.setString(1,bean.getPatient_email());
			statement.setString(2, "confirm");
			ResultSet set=statement.executeQuery();
			while (set.next()) {
				bean.setName(set.getString(2));
				System.out.println("==setName=="+set.getString(2));
				bean.setEmail(set.getString(3));
				System.out.println("==setEmail=="+set.getString(3));
				bean.setCity(set.getString(6));
				System.out.println("===setCity=="+set.getString(6));
				bean.setDoc_name(set.getString(7));
				System.out.println("===set doc namwe=="+set.getString(7));
				bean.setHospitalname(set.getString(8));
				System.out.println("===set hospital=="+set.getString(8));
				bean.setDate(set.getString(9));
				System.out.println("===setDate=="+set.getString(9));
				bean.setTime(set.getString(10));	
				System.out.println("===setTime=="+set.getString(10));
				
				arrayList.add(new PatientMyAppointmentBean(bean.getName(),bean.getEmail(),bean.getDoc_name(),bean.getHospitalname(),bean.getCity(),
						bean.getDate(),bean.getTime()));
			}
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return arrayList;
		
	}

}
