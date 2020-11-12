package com.project.healingtouch.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import com.project.healingtouch.dto.HospitalBean;
import com.project.healingtouch.utility.QueryCollection;
import com.project.healingtouch.utility.SingleTon;

public class HospitalDB {

	public void getHopital(HospitalBean bean, HttpServletResponse resp) {
		SingleTon singleTon=SingleTon.getSt();
		Connection connection=singleTon.getcon();
		
		try {
			PreparedStatement pstmt=connection.prepareStatement(QueryCollection.HOSPITAL_QUERY);
			pstmt.setString(1, bean.getH_name());
			pstmt.setString(2, bean.getH_locality());
			pstmt.setString(3, bean.getH_address());
			pstmt.setString(4, bean.getLatitude());
			pstmt.setString(5, bean.getLongitude());
			pstmt.setString(6, bean.getH_contact());
			pstmt.setString(7, bean.getH_website());
			pstmt.setString(8, bean.getH_image1());
			
			
			
			PreparedStatement getData_pstmt=connection.prepareStatement(QueryCollection.HOSPITAL_VERIFY_QUERY);
			getData_pstmt.setString(1,bean.getH_website());
			ResultSet resultSet=getData_pstmt.executeQuery();
			if (resultSet.first()) {
				System.out.println("Already Hospital is reisterd");
				PrintWriter pw;
				try {
					pw = resp.getWriter();
					String s="<html><body><h3><i>"+"Already Hospital is reisterd"+
							"</i></h3></body></html>";
						pw.write(s)	;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("========IOException======");
				}
			}
			else {
			int i=pstmt.executeUpdate();
			System.out.println("====Hospital Data is inserted successfully=="+i);
			PrintWriter pw;
			try {
				pw = resp.getWriter();
				String s="<html><body><h3><i>"+"Hospital Data is inserted successfully"+
						"</i></h3></body></html>";
					pw.write(s)	;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("========IOException======");
			}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
