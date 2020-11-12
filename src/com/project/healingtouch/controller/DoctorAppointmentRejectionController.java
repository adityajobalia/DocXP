package com.project.healingtouch.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.project.healingtouch.dto.DoctorListofAppointmenBean;
import com.project.healingtouch.services.DoctorAppointmentRejectionServices;

public class DoctorAppointmentRejectionController extends HttpServlet {
	DoctorListofAppointmenBean bean= new DoctorListofAppointmenBean();
	boolean result;
	
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
		
		resp.setContentType("application/json");
		System.out.println("====doc list of apointment reject ====");
		
		String pateint_name=req.getParameter("pateint_name");
		String pateint_email=req.getParameter("pateint_email");
		String pateint_date=req.getParameter("pateint_date");
		String pateint_time=req.getParameter("pateint_time");
		
		System.out.println("=====pateint_name reject ==="+pateint_name);
		
		bean.setName(pateint_name);
		bean.setDate(pateint_date);
		bean.setEmail(pateint_email);
		bean.setTime(pateint_time);
		
		DoctorAppointmentRejectionServices services= new DoctorAppointmentRejectionServices();
		result=services.removeData(bean);
		JSONArray jArray= new JSONArray();
		JSONObject  jsonObject=new  JSONObject();
		PrintWriter   printWriter= resp.getWriter();
		if (result) {
			
			try {
				
				System.out.println("########");
				
				jsonObject.put("status","reject" );
			
				//System.out.println("====message=="+bean.getStatus());
				jArray.put(jsonObject);
				System.out.println("===jarray=="+jArray.toString());
				printWriter.print(jArray);
				//printWriter.print(jsonObject.toString());
				//System.out.println("===obj=="+jsonObject);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		else {
			System.out.println("======no data found====");
			
		}
		
	}

}
