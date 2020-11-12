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

import com.project.healingtouch.dto.PatientDoctorSpecialityBean;
import com.project.healingtouch.services.PatientDoctorSpecialityServices;

public class PatientDoctorSpecialityController  extends HttpServlet{
	PatientDoctorSpecialityBean bean= new PatientDoctorSpecialityBean();
	ArrayList<PatientDoctorSpecialityBean> list;
	JSONArray array;
	JSONObject object;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/Json");
		System.out.println("==PatientDoctorSpecialityController==");
		String title=req.getParameter("title");
		bean.setTitle(title);
		
		PatientDoctorSpecialityServices services= new PatientDoctorSpecialityServices();
		list=services.getPatientDoctorSpecialityData(bean);
		if(list != null) {
			array= new JSONArray();
			for (int i=0;i<list.size();i++) {
				System.out.println("======in loop===");
				object= new JSONObject();
				try {
					object.put("doctor_profileimage", list.get(i).getProfileimage());
					System.out.println("==== list.get(i).getProfileimage()=="+ list.get(i).getProfileimage());
					object.put("doctor_name", list.get(i).getDoctorname());
					System.out.println("===list.get(i).getDoctorname()==="+list.get(i).getDoctorname());
					object.put("doctor_speciality", list.get(i).getDoctorspeciality());
					System.out.println("== list.get(i).getDoctorspeciality()==="+ list.get(i).getDoctorspeciality());
					object.put("doctor_hospitalname", list.get(i).getDoctorhospitalname());
					System.out.println("====list.get(i).getDoctorhospitalname()=="+list.get(i).getDoctorhospitalname());
					object.put("doctor_city", list.get(i).getDoctorcity());
					System.out.println("===list.get(i).getDoctorcity()=="+list.get(i).getDoctorcity());
					object.put("doctor_contact", list.get(i).getDoctorcontact());
					System.out.println("====list.get(i).getDoctorcontact()==="+list.get(i).getDoctorcontact());
					object.put("doctor_email", list.get(i).getDoctoremail());
					System.out.println("==list.get(i).getDoctoremail()==="+list.get(i).getDoctoremail());
					array.put(object);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			resp.getWriter().print(array.toString());
			resp.getWriter().write(array.toString());
		}
		
		
	}
}
