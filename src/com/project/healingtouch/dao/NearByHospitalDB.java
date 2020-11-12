package com.project.healingtouch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.healingtouch.dto.NearByHospitalBean;
import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;

public class NearByHospitalDB {

	SingleTon singleTon=SingleTon.getSt();
	Connection connection=singleTon.getcon();
	ArrayList<NearByHospitalBean> list= new ArrayList<>();
	public ArrayList<NearByHospitalBean> getNearByHopitalLatlongList(NearByHospitalBean bean){
		
		try {
			PreparedStatement pstmt= connection.prepareStatement(QueryCollection.HOSPITAL_LATLONG);
			pstmt.setString(1, bean.getLocality());
			ResultSet set=pstmt.executeQuery();
			while (set.next()) {
				double laitude=set.getDouble("h_latitude");
				double longitude=set.getDouble("h_longitude");
				String address=set.getString("h_address");
				String hospital_nm=set.getString("h_name");
				
				list.add(new NearByHospitalBean(laitude,longitude,address,hospital_nm));
				System.out.println("=====latlong======"+laitude+"=="+longitude);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	

}
