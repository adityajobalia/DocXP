package com.project.healingtouch.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.project.healingtouch.dto.PatientEmergencyContactBean;
import com.project.healingtouch.services.PatientEmergencyContactServices;

public class PatientEmergencyContactFromController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean result;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/Json");
		System.out.println("======PatientEmergencyContactFromController======");
		
		PatientEmergencyContactBean bean= new PatientEmergencyContactBean();
		bean.setContact_name(req.getParameter("name"));
		bean.setContact_mobile(req.getParameter("mobile"));
		bean.setContact_email(req.getParameter("email"));
		bean.setLogin_email(req.getParameter("login_email"));
		
			
		System.out.println("========="+bean.getContact_name()+bean.getContact_mobile()+bean.getContact_email()+bean.getLogin_email());
		
		PatientEmergencyContactServices contactServices= new PatientEmergencyContactServices();
		result=contactServices.addEmergencyContactData(bean);
		if(result) {
			JSONArray array= new JSONArray();
			JSONObject object= new  JSONObject();
			
			try {
				object.put("message", "success");
				array.put(object);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.getWriter().println(array);
		}
		else {
			System.out.println("==============no data insertes===");
		}
		
	}

}
