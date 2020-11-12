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
 * Servlet implementation class ProfileController
 */
public class PatientProfileController extends HttpServlet {
	ProfileBean bean;
	boolean result;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ProfileController is invoked");
		String email = request.getParameter("email");
		System.out.println("=========email"+email);
		String password = request.getParameter("password");
		System.out.println("==========pass"+password);

		bean = new ProfileBean();
		bean.setEmail(email);
		bean.setPassword(password);
		
		ProfileServices services = new ProfileServices();
		result = services.verifyProfileData(bean);
		System.out.println("result:---- "+result);
		JSONArray array = new JSONArray();
		
		if (result) {
			try {
				JSONObject object = new JSONObject();
				object.put("name", bean.getName());
				object.put("mobile", bean.getMobile());
				object.put("auth", bean.getAuth());
				object.put("profileimage", bean.getProfileimage());
				array.put(object);
				response.getWriter().print(array);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			System.out.println("NO Data found"+result);
		}
	}

}
