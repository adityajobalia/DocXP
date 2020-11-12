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

import com.project.healingtouch.dto.PatientFinHospitalBean;
import com.project.healingtouch.services.PatientFinHospitalServices;

public class PatientFinHospitalController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<PatientFinHospitalBean> list;
	JSONArray array;
	JSONObject object;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		System.out.println("====PatientFinHospitalController====");
		
		System.out.println("===go to services PatientFinHospital==");
		
		PatientFinHospitalServices services= new PatientFinHospitalServices();
		list=services.getPatientFinHospitalData();
		
		if(list !=null) {
			array=new JSONArray();
			for(int i=0;i<list.size();i++) {
				System.out.println("=====in loop==="+list.size());
				
				
				try {
					object= new JSONObject();
					object.put("hospital_name", list.get(i).getH_name());
					System.out.println("h_name==="+list.get(i).getH_name());
					object.put("hospital_locality", list.get(i).getH_contact());
					System.out.println("h_contact=="+list.get(i).getH_contact());
					array.put(object);
					System.out.println("===array####"+array.toString());
				} catch (JSONException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			resp.getWriter().print(array.toString());
			resp.getWriter().write(array.toString());
		}else {
			System.out.println("no data ===");
		}
		
		
		
	}
}
