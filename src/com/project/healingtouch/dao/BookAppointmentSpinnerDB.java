package com.project.healingtouch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.project.healingtouch.dto.BookAppointmentSpinnerBean;
import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;

public class BookAppointmentSpinnerDB {
	BookAppointmentSpinnerBean dataBean = new BookAppointmentSpinnerBean();
	SingleTon singleton = SingleTon.getSt();
	Connection con = singleton.getcon();
	ArrayList<String> citylist= new ArrayList<String>();
	ArrayList<String> hospitallist= new ArrayList<String>();
	ArrayList<String> doctorlist= new ArrayList<String>();
	ArrayList<String> specialitylist= new ArrayList<String>();
	HashSet<String> hospitalset = new HashSet<String>();
	HashSet<String> specialityset = new HashSet<String>();
	HashSet<String> cityset = new HashSet<String>();
	HashSet<String> doctorset = new HashSet<String>();
	//ArrayList<BookAppointmentSpinnerBean> list = new ArrayList<>();
	public boolean result = false;
	
	
	public ArrayList<String> getSpinnerCityData() {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pStatement = con.prepareStatement(QueryCollection.SPINNER_CITY_DATA);
			ResultSet rs = pStatement.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					String city = rs.getString("d_city");
					dataBean.setHospital_city(city);
					System.out.println("====city==== "+city);
					BookAppointmentSpinnerBean spinnerBean = new BookAppointmentSpinnerBean(dataBean);
					citylist.add(spinnerBean.getHospital_city());
					cityset.addAll(citylist);
					citylist.clear();
					citylist.addAll(cityset);
				}
				//result = true;
			}
			else {
				//result =  false;
			}
		}
		catch(SQLException e) {
			System.out.println("sql exception");
		}
		return citylist;
	}

	public ArrayList<String> getSpinnerDoctorData(String hospital, String speciality) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pStatement = con.prepareStatement(QueryCollection.SPINNER_DOCTOR_DATA);
			pStatement.setString(1, hospital);
			pStatement.setString(2, speciality);
			ResultSet rs = pStatement.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					String docname = rs.getString("d_name");
					dataBean.setDoctor_name(docname);
					System.out.println("====doc name==== "+docname);
					BookAppointmentSpinnerBean spinnerBean = new BookAppointmentSpinnerBean(dataBean);
					doctorlist.add(spinnerBean.getDoctor_name());
					doctorset.addAll(doctorlist);
					doctorlist.clear();
					doctorlist.addAll(doctorset);
				}
				System.out.println("db doctor list====="+doctorlist);
				//result = true;
			}
			else {
				//result =  false;
			}
		}
		catch(SQLException e) {
			System.out.println("sql exception");
		}
		return doctorlist;
			
	}
		

	public ArrayList<String> getSpinnerHospitalData(String speciality, String city) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pStatement = con.prepareStatement(QueryCollection.SPINNER_HOSPITAL_DATA);
			pStatement.setString(1, speciality);
			pStatement.setString(2, city);
			ResultSet rs = pStatement.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					String hopitalname = rs.getString("d_hospitalname");
					dataBean.setHospital_name(hopitalname);
					System.out.println("====hopital name==== "+hopitalname);
					BookAppointmentSpinnerBean spinnerBean = new BookAppointmentSpinnerBean(dataBean);
					hospitallist.add(spinnerBean.getHospital_name());
					hospitalset.addAll(hospitallist);
					hospitallist.clear();
					hospitallist.addAll(hospitalset);
				}
				//result = true;
			}
			else {
				//result =  false;
			}
		}
		catch(SQLException e) {
			System.out.println("sql exception");
		}
		return hospitallist;
		
	}

	public ArrayList<String> getSpinnerSpecialityData(String cityname) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pStatement = con.prepareStatement(QueryCollection.SPINNER_SPECIALITY_DATA);
			pStatement.setString(1, cityname);
			ResultSet rs = pStatement.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					String speciality = rs.getString("d_speciality");
					dataBean.setSpeciality(speciality);
					System.out.println("====speciality name==== "+speciality);
					BookAppointmentSpinnerBean spinnerBean = new BookAppointmentSpinnerBean(dataBean);
					specialitylist.add(spinnerBean.getSpeciality());
					specialityset.addAll(specialitylist);
					specialitylist.clear();
					specialitylist.addAll(specialityset);
				}
				System.out.println("db speciality list====="+specialitylist);
			}
			else {
				//result =  false;
			}
		}
		catch(SQLException e) {
			System.out.println("sql exception");
		}
		return specialitylist;
	}
	
}
