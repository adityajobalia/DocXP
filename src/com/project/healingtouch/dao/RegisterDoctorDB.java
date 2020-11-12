package com.project.healingtouch.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import java.sql.PreparedStatement;
import com.project.healingtouch.dto.DocRegisterBean;
import com.project.healingtouch.dto.LogBean;
import com.project.healingtouch.dto.RegBean;
import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;

public class RegisterDoctorDB {
	DocRegisterBean docRegisterBean;
	public boolean result = false;
	SingleTon singleton = SingleTon.getSt();
	Connection con = singleton.getcon();


	public boolean registerDoctor(DocRegisterBean docRegisterBean, HttpServletResponse resp) {
		this.docRegisterBean=docRegisterBean;
		String docName=docRegisterBean.getDocName();
		String docEmail=docRegisterBean.getDocEmail();
		String docPass=docRegisterBean.getDocPass();
		String docMobile=docRegisterBean.getDocMobile();
		String docSpeciality=docRegisterBean.getDocSpeciality();
		String docCity=docRegisterBean.getDoccity();
		String docHospitlname=docRegisterBean.getDochospitalname();
		String docAddress=docRegisterBean.getDocaddress();
		String docImage=docRegisterBean.getDocImage();
		
		try {
			PreparedStatement preparedStatement=con.prepareStatement(QueryCollection.DOCTOR_REGISTER_QUERY);
			System.out.println("DOCTOR_REGISTER_QUERY set data ..............");
			preparedStatement.setString(1, docName);
			preparedStatement.setString(2, docEmail);
			preparedStatement.setString(3, docPass);
			preparedStatement.setString(4, docMobile);
			preparedStatement.setString(5, docSpeciality);
			preparedStatement.setString(6, docHospitlname);
			preparedStatement.setString(7, docCity);
			preparedStatement.setString(8, docAddress);
			preparedStatement.setString(9, docImage);
			
			System.out.println("Data is set into stmt");
			
			/**
			 * Verification of User Email while registration
			 * 
			 */
		PreparedStatement pstmt_readData = con.prepareStatement(QueryCollection.DOCTOR_REGISTER_VERIFY_QUERY);
			pstmt_readData.setString(1, docEmail);
			ResultSet resultSet = pstmt_readData.executeQuery();
			System.out.println("reg_verify_query executed");

			if (resultSet.first()) {
				System.out.println("Account already exists in doc");
				docRegisterBean.setMessage("exists");
				PrintWriter pw;
				try {
					pw = resp.getWriter();
					String s="<html><body><h1><i>"+"Doctor Account already exists "+
							"</i></h3></body></html>";
						pw.write(s)	;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("========IOException======");
				}
				
				
				
			} else {
				System.out.println("inside else condition");
				int query_result = preparedStatement.executeUpdate();
				if (query_result == 1) {
					result = true;
			
					System.out.println("Data Insertion successful in doc  register table");
					PrintWriter pw;
					try {
						pw = resp.getWriter();
						String s="<html><body><h3><i>"+"Data Insertion successful in doctor  register table"+
								"</i></h3></body></html>";
							pw.write(s)	;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("========IOException======");
					}
					
					/**
					 * Registration of User into Login table
					 * 
					 *//*
					LogBean mLogBean = new LogBean();
					mLogBean.setLogEmail(docEmail);
					mLogBean.setLogPass(docPass);
					LoginDB db = new LoginDB();
					result = db.loginUser(mLogBean);
					if (result) {
						result = true;
						docRegisterBean.setMessage("success");
						System.out
								.println("Data insertion Successfull in Login table");
					} else {
						result = false;
						System.out
								.println("Insertion in login table failed!! Check loginDB class");
					}*/
				} else {
					System.out.println("Failed inserting data");
				}

			}
		} catch (SQLException e) {
			System.out.println("SQL exception in Doc RegisterDB class");
		}

		return result;
	}

}
