package com.project.healingtouch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.healingtouch.dto.PatientEmergencyContactBean;
import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;

public class PatientEmergencyContactDB {
	SingleTon singleTon=SingleTon.getSt();
	Connection con=singleTon.getcon();
	PatientEmergencyContactBean contactBean;
	boolean result=false;

	public boolean addContactData(PatientEmergencyContactBean bean) {
		this.contactBean=bean;
		try {
			PreparedStatement addData= con.prepareStatement(QueryCollection.ADD_EMERGENCY_CONTACT_DATA);
			addData.setString(1, contactBean.getContact_name());
			addData.setString(2, contactBean.getContact_email());
			addData.setString(3,contactBean.getContact_mobile());
			addData.setString(4, contactBean.getLogin_email());
			
			PreparedStatement verifyData= con.prepareStatement(QueryCollection.GET_EMERGENCY_CONTACT_DATA);
			verifyData.setString(1, bean.getLogin_email());
			ResultSet resultSet=verifyData.executeQuery();
			
			if(!resultSet.first()) {
				
			int i=addData.executeUpdate();
			System.out.println("==========insert=="+i);
				if(i==1) {
					result=true;
				}
				else {
					result=false;
				}
			}
			else { 
				PreparedStatement updatedata=con.prepareStatement(QueryCollection.UPDATE_EMERGENCY_CONTACT_DATA);
				updatedata.setString(1, contactBean.getContact_name());
				updatedata.setString(2, contactBean.getContact_email());
				updatedata.setString(3,contactBean.getContact_mobile());
				updatedata.setString(4, contactBean.getLogin_email());
				int i=updatedata.executeUpdate();
				System.out.println("==========update=="+i);
				if(i==1) {
					result=true;
				}
				else {
					result=false;
				}
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return result;	
		
	}

	public PatientEmergencyContactBean getPatientEmergencyData(PatientEmergencyContactBean contactBean2) {
		PatientEmergencyContactBean bean= new PatientEmergencyContactBean();
		try {
			PreparedStatement getData= con.prepareStatement(QueryCollection.GET_EMERGENCY_CONTACT_DATA);
			getData.setString(1, contactBean2.getLogin_email());
			ResultSet resultSet=getData.executeQuery();
			System.out.println("======resultSet======"+resultSet);
			while (resultSet.next()) {
				
				bean.setContact_name(resultSet.getString("c_name"));
				bean.setContact_email(resultSet.getString("c_email"));
				bean.setContact_mobile(resultSet.getString("c_mobile"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
		
	}

	/*public boolean rejectDataFromDB(PatientEmergencyContactBean contactBean2) {
		try {
			PreparedStatement reject=con.prepareStatement(QueryCollection.REJECT_EMERGENCY_CONTACT_DATA);
			reject.setString(1, contactBean2.getLogin_email());
			reject.setString(2, contactBean2.getContact_name());
			
			int i=reject.executeUpdate();
			if(i==1) {
				result=true;
			}
			else {
				result=false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
*/
}
