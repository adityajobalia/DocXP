package com.project.healingtouch.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.project.healingtouch.dto.NearByHospitalBean;
import com.project.healingtouch.services.NearByHospitalServices;

public class NearByHospitalController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("=========NearByHospitalController======");
		resp.setContentType("application/json");
		String locality=req.getParameter("locality");
		System.out.println("======locality========="+locality);
		NearByHospitalBean bean= new NearByHospitalBean();
		bean.setLocality(locality);
		NearByHospitalServices services= new NearByHospitalServices();
		ArrayList<NearByHospitalBean> latlonglist=services.getNearByHospitalData(bean);
		
		if(latlonglist !=null) {
			JSONArray array= new JSONArray();
			for (int i=0;i<latlonglist.size();i++) {
				System.out.println("==lengh====="+latlonglist.size());
				try {
					JSONObject object = new JSONObject();
					object.put("latitude",latlonglist.get(i).getLatitude());
					object.put("longitude",latlonglist.get(i).getLongitude());
					object.put("address", latlonglist.get(i).getAddress());
					object.put("hospitalname", latlonglist.get(i).getH_name());
					array.put(object);
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			resp.getWriter().print(array);
			System.out.println("array.toString()=="+array.toString());
		
		}else {
			System.out.println("======= data is not added========");
		}
		
	}
}
