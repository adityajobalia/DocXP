package com.project.healingtouch.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.project.healingtouch.dto.ProfileBean;
import com.project.healingtouch.services.NavigationDrawerDataServices;

public class PatientNavigationDrawerDataController extends HttpServlet{
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
		resp.setContentType("application/Json");
		System.out.println("==========PatientNavigationDrawerDataController=============");
		String email=req.getParameter("patient_email");
		System.out.println("======##email======="+email);
		NavigationDrawerDataServices services= new NavigationDrawerDataServices();
		ProfileBean bean=services.getPatientDrawerData(email);
		
		JSONArray array= new JSONArray();
		JSONObject object= new  JSONObject();
		try {
			object.put("patient_nm", bean.getName());
			object.put("patient_profile", bean.getProfileimage());
			array.put(object);
			resp.getWriter().print(array);
			System.out.println("====array==========="+array.toString());
			
		} catch (JSONException e) {
			System.out.println("=======JSONException======");
		}
		
	}
}
