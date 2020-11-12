package com.project.healingtouch.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.project.healingtouch.services.NotificationServices;

/**
 * Servlet implementation class NotificationController
 */
public class NotificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NotificationServices notificationServices;
	boolean flag;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		JSONObject jsonObject = new JSONObject();

		String email = request.getParameter("email");
		String auth = request.getParameter("auth");
		String token = request.getParameter("token");

		System.out.println("email::" + email + " auth:" + auth + " token:" + token);
		notificationServices = new NotificationServices();
		switch (auth) {

		case "patient": {
			flag = notificationServices.getPatientServices(email, token);
			if (flag) {
				response.getWriter().print(jsonObject);
			} else {
				System.out.println("Error in updating token in patient database");
			}
			break;
		}

		case "doctor": {
			flag = notificationServices.getDoctorServices(email, token);
			if (flag) {
				response.getWriter().print(jsonObject);
			} else {
				System.out.println("Error in updating token in doctor database");
			}

			break;
		}
		}
	}

}
