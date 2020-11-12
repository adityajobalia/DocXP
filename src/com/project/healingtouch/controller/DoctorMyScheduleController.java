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

import com.project.healingtouch.dto.DoctorMyScheduleBean;
import com.project.healingtouch.services.DoctorMyScheduleServices;

public class DoctorMyScheduleController extends HttpServlet {
	DoctorMyScheduleBean bean= new DoctorMyScheduleBean();
	ArrayList<DoctorMyScheduleBean> list;
	JSONArray array;
	JSONObject object;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		System.out.println("====doc my schedule apointment====");
		String email=req.getParameter("email");
		String status=req.getParameter("status");
		System.out.println("==email=="+email);
		System.out.println("==status=="+status);
		bean.setStatus(status);
		bean.setDoc_email(email);
		
		DoctorMyScheduleServices services= new DoctorMyScheduleServices();
		list=services.getConformAppointmentData(bean);
		
		System.out.println("=====lst==="+list);


		if(list != null) {
			System.out.println("=====");
			array= new JSONArray();


			for(int i=0;i<list.size();i++) {

				try {
					object= new JSONObject();
					
					String patient_name=list.get(i).getName();
					object.put("patient_name", patient_name);
					System.out.println("==name=="+patient_name);

					String patient_email=list.get(i).getEmail();
					object.put("patient_email",patient_email);
					System.out.println("=== bean.getEmail()=="+ patient_email);

					String patient_gender=list.get(i).getGender();
					object.put("patient_gender",patient_gender);
					System.out.println("=== bean.getGender()=="+ patient_gender);

					String pateint_contact=list.get(i).getContect();
					object.put("pateint_contact",pateint_contact);
					System.out.println("=== pateint_contact=="+ pateint_contact);

					String pateint_date=list.get(i).getDate();
					object.put("pateint_date",pateint_date);
					System.out.println("=== pateint_date=="+ pateint_date);

					String patient_time=list.get(i).getTime();
					object.put("patient_time",patient_time);
					System.out.println("=== patient_time=="+ patient_time);
					
					String patient_status=list.get(i).getStatus();
					object.put("patient_status",patient_status);
					System.out.println("=== patient_status=="+ patient_status);
					array.put(object);
					System.out.println("=====array==="+array.toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//resp.getWriter().print(object.toString());

			}
			

			resp.getWriter().print(array.toString());
			resp.getWriter().write(array.toString());
			
			

		}
		else {
			System.out.println("No data found==");
			
		}			
		
	}
	

}
