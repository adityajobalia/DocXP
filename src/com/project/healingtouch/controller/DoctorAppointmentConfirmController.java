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
import com.project.healingtouch.services.DoctorAppointmentConfirmServices;
import com.project.healingtouch.services.DoctorAppointmentRejectionServices;

public class DoctorAppointmentConfirmController extends HttpServlet {

	DoctorListofAppointmenBean bean= new DoctorListofAppointmenBean();
	boolean result;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		System.out.println("====doc list of apointment confirm ====");
		
		
		String pateint_name=req.getParameter("pateint_name");
		String pateint_email=req.getParameter("pateint_email");
		String pateint_date=req.getParameter("pateint_date");
		String pateint_time=req.getParameter("pateint_time");
		String status=req.getParameter("status");
		
		System.out.println("=====pateint_name  ==="+pateint_name);
		System.out.println("===status==="+status);
		
		bean.setName(pateint_name);
		bean.setEmail(pateint_email);
		bean.setDate(pateint_date);
		bean.setEmail(pateint_email);
		bean.setTime(pateint_time);
		bean.setStatus(status);
		
		
		DoctorAppointmentConfirmServices services= new DoctorAppointmentConfirmServices();
		result=services.conformAppointmentData(bean);
		PrintWriter writer = resp.getWriter();
		JSONArray array = new JSONArray();
		JSONObject object = new JSONObject();
		if(result) {
			try {
				object.put("status", "conform");
				array.put(object);
				writer.print(array);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Error in updating mobile...");
		}
	}
}
