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

public class PatientEmergencyContactController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PatientEmergencyContactBean contactBean;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/Json");
		System.out.println("=====PatientEmergencyContactController=======");
		contactBean = new PatientEmergencyContactBean();
		contactBean.setLogin_email(req.getParameter("login_email"));
		System.out.println("=======req.getParameter(\"login_email\")====="+req.getParameter("login_email"));
		PatientEmergencyContactServices services= new PatientEmergencyContactServices();
		PatientEmergencyContactBean bean=services.getEmergencyData(contactBean);
		if(bean != null) {
			JSONArray array= new JSONArray();
			JSONObject jsonObject= new JSONObject();
			try {
				jsonObject.put("name", bean.getContact_name());
				jsonObject.put("email", bean.getContact_email());
				jsonObject.put("mobile", bean.getContact_mobile());
				System.out.println("==========="+bean.getContact_name()+"===="+bean.getContact_email()+"===="+bean.getContact_mobile());
				array.put(jsonObject);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.getWriter().print(array);
			
		}
		else {
			System.out.println("============");
		}
	} 

}
