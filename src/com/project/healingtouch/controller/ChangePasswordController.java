package com.project.healingtouch.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.project.healingtouch.dto.ChangePasswordBean;
import com.project.healingtouch.services.ChangePasswordServices;

/**
 * Servlet implementation class ChangePasswordController
 */
public class ChangePasswordController extends HttpServlet {
	public boolean flag;
	ChangePasswordBean bean;
	ChangePasswordServices services;
	JSONArray array;
	JSONObject object;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		switch (user) {
		case "patient": {
			bean = new ChangePasswordBean();
			bean.setEmail(email);
			bean.setPassword(password);
			services = new ChangePasswordServices();
			flag = services.verifyPatientPassword(bean);
			if (flag) {
				passData(response);
			}
			else {
				System.out.println("Failure patient");
			}
			break;
		}
		case "doctor": {
			bean = new ChangePasswordBean();
			bean.setEmail(email);
			bean.setPassword(password);
			services = new ChangePasswordServices();
			flag = services.verifyDoctorPassword(bean);
			if (flag) {
				passData(response);
			}
			else {
				System.out.println("Failure doctor");
			}
			break;
		}
		default:
			break;
		}
	}
	public void passData(HttpServletResponse response){
		array = new JSONArray();
		object = new JSONObject();
		try {
			object.put("message", bean.getMessage());
			array.put(object);
			response.getWriter().print(array);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
