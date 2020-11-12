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
import com.project.healingtouch.services.ProfileServices;

/**
 * Servlet implementation class DoctorProfileController
 */
public class DoctorProfileController extends HttpServlet {
	boolean flag;
	ProfileBean profileBean;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doc profile servlet =======");
		String email = request.getParameter("email");
		System.out.println("=========email"+email);
		String password = request.getParameter("password");
		System.out.println("==========pass"+password);

		profileBean = new ProfileBean();
		profileBean.setEmail(email);
		profileBean.setPassword(password);
		
		ProfileServices services = new ProfileServices();
		flag = services.verifyDoctorProfileData(profileBean);
		System.out.println("result:---- "+flag);
		JSONArray array = new JSONArray();
		JSONObject object = new JSONObject();
		if (flag) {
			try {
				object.put("name", profileBean.getName());
				object.put("mobile", profileBean.getMobile());
				object.put("speciality", profileBean.getSpeciality());
				object.put("profileimage", profileBean.getProfileimage());
				object.put("auth", profileBean.getAuth());
				array.put(object);
				response.getWriter().print(array);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			System.out.println("NO Data found"+flag);
		}
	}

}
