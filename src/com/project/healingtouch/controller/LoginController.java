package com.project.healingtouch.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.project.healingtouch.dto.LogBean;
import com.project.healingtouch.services.LoginServices;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginController extends HttpServlet {
	boolean result;
	LogBean bean;

	private static final long serialVersionUID = 8727606094313699834L;

	/**
	 * @author aditya
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Fetching data from JSP files
		 */
		String login_Email = request.getParameter("login_edittext_email");
		String login_Password = request.getParameter("login_edittext_password");
		/**
		 * Data validation
		 */
		bean = new LogBean();
		if (!login_Email.isEmpty()) {
			bean.setLogEmail(login_Email);
		}
		if (!login_Password.isEmpty()) {
			bean.setLogPass(login_Password);
		}

		/**
		 * LoginDB is instantiated to perform database operations
		 */
		LoginServices services = new LoginServices();
		result = services.verifyUserWhileLogin(bean);
		JSONArray array = new JSONArray();
		JSONObject object = new JSONObject();
		if (result) {
			try {
				object.put("auth", bean.getMessage());
				array.put(object);
				response.getWriter().print(array);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("No such Data Found");
			try {
				object.put("auth", "No such Data Found... Try Registering first");
				array.put(object);
				response.getWriter().print(array);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

}
