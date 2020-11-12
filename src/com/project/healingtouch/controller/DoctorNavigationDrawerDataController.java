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

public class DoctorNavigationDrawerDataController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/Json");
		
		String email=req.getParameter("doc_email");
		System.out.println("======email======="+email);
		NavigationDrawerDataServices services= new NavigationDrawerDataServices();
		ProfileBean bean=services.getDoctorDrawerData(email);
		
		JSONArray array= new JSONArray();
		JSONObject object= new  JSONObject();
		try {
			object.put("doc_nm", bean.getName());
			object.put("doc_profile", bean.getProfileimage());
			array.put(object);
			resp.getWriter().print(array);
			
		} catch (JSONException e) {
			System.out.println("=======JSONException======");
		}
		
	}
}
