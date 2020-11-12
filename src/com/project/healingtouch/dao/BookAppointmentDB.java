package com.project.healingtouch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.healingtouch.dto.BookAppointmentBean;
import com.project.healingtouch.dto.BookAppointmentSpinnerBean;
import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;

public class BookAppointmentDB {
	BookAppointmentBean appointmentBean;
	BookAppointmentSpinnerBean spinnerBean;
	public boolean result = false;
	SingleTon singleton = SingleTon.getSt();
	Connection con = singleton.getcon();
	
	/**
	 * Book Appointment
	 */

	public boolean patientBookAppointment(BookAppointmentBean appointmentBean) {
		this.appointmentBean = appointmentBean;
		String patient_name = appointmentBean.getPatientName();
		System.out.println("======="+patient_name);
		String patient_email = appointmentBean.getPatientEmail();
		System.out.println("======="+patient_email);
		String patient_contact = appointmentBean.getPatientContact();
		System.out.println("======="+patient_contact);
		String patient_gender = appointmentBean.getPatientGender();
		System.out.println("======="+patient_gender);
		String patient_city = appointmentBean.getPatientCity();
		System.out.println("======="+patient_city);
		String patient_doctor = appointmentBean.getPatientDoctor();
		System.out.println("======="+patient_doctor);
		String patient_hospital = appointmentBean.getPatientHospital();
		System.out.println("======="+patient_hospital);
		String patient_date = appointmentBean.getPatientAppointmentDate();
		System.out.println("======="+patient_date);
		String patient_time = appointmentBean.getPatientAppointmentTime();
		System.out.println("======="+patient_time);
		String speciality = appointmentBean.getSpeciality();
		System.out.println("========"+speciality);
		
		try {
			java.sql.PreparedStatement pStatement = con.prepareStatement(QueryCollection.PATIENT_BOOKAPPOINTMENT_QUERY);
			pStatement.setString(1, patient_name);
			pStatement.setString(2, patient_email);
			pStatement.setString(3, patient_contact);
			pStatement.setString(4, patient_gender);
			pStatement.setString(5, patient_city);
			pStatement.setString(6, patient_doctor);
			pStatement.setString(7, patient_hospital);
			pStatement.setString(8, patient_date);
			pStatement.setString(9, patient_time);
			pStatement.setString(10, "pending");
			pStatement.setString(11, speciality);
			
			System.out.println("Data is set into stmt");
			
			int i = pStatement.executeUpdate();
			if (i == 1) {
				System.out.println("book appointment successful");
				appointmentBean.setMessage("successfull");
				result = true;
			}
			else {
				appointmentBean.setMessage("book appointment failed");
				result = false;
			}
			System.out.println("======="+result);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql exception in BookAppointmentDB class");
		}
		
		return result;
	}

	public BookAppointmentSpinnerBean getDoctorDetailsFromDB(String patient_doctorname, String speciality) {
		// TODO Auto-generated method stub
		spinnerBean = new BookAppointmentSpinnerBean();
		System.out.println("=====patient_doctorname======"+patient_doctorname);
		System.out.println("=====speciality======"+speciality);
		try {
			PreparedStatement pstmt = con.prepareStatement(QueryCollection.GET_DOCTOR_DETAILS);
			pstmt.setString(1, patient_doctorname);
			pstmt.setString(2, speciality);
			System.out.println("Data is set into stmt");
			ResultSet rset = pstmt.executeQuery();
			if (rset != null) {
				while (rset.next()) {
					String hospitalname = rset.getString("d_hospitalname");
					String cityname = rset.getString("d_city");
					System.out.println("=======hospitalname========="+hospitalname);
					System.out.println("=====cityname=========="+cityname);
					spinnerBean.setHospital_name(hospitalname);
					spinnerBean.setHospital_city(cityname);
				}
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return spinnerBean;
	}

}
