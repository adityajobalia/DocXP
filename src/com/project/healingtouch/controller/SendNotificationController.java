package com.project.healingtouch.controller;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.project.healingtouch.dto.DocRegisterBean;
import com.project.healingtouch.dto.LogBean;
import com.project.healingtouch.services.NotificationServices;

/**
 * Servlet implementation class SendNotificationController
 */
public class SendNotificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String APIKEY = "AIzaSyDaY1sjIAQ_Uptst8DG_rh4DVi7pOFGCDQ";
	public final static String SERVERKEY = "AAAAFEQWkpY:APA91bE242ubD_pftHBtDJJhq2X72rzuz47vEPRX75XbdAPATyyGoSxcqnHiHJ0QvOpAscRWG-RAQauQe0bxWYXVC5lIw0WdlVfqGdUFf80UcByG_8_HBt57egxmuSPeUztz0L8GaFFV";
	public final static String FCMURL = "https://fcm.googleapis.com/fcm/send";
	HttpURLConnection connection ;
	PrintWriter writer;
	NotificationServices notificationServices;
	DocRegisterBean docBean;
	LogBean patBean;  
	String token = "",title = "",body="";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		writer = response.getWriter();
		// TODO Auto-generated method stub
		URL url = new URL(FCMURL);
		connection = (HttpURLConnection) url.openConnection();
		connection.setUseCaches(false);
		connection.setDoInput(true);
		connection.setDoOutput(true);

		connection.setRequestMethod("POST");
		connection.setRequestProperty("Authorization", "key=" + SERVERKEY);
		connection.setRequestProperty("Content-Type", "application/json");

		String auth = request.getParameter("auth");

		switch (auth) {
			case "patient": {
				docBean = new DocRegisterBean();
				String doctorName = request.getParameter("doctorName");
				docBean.setDocName(doctorName);
				notificationServices = new NotificationServices();
				docBean = notificationServices.sendNotificationToDoctorServices(docBean);
				if (!docBean.getToken().isEmpty()) {
					token = docBean.getToken();
					title = "DocXp";
					body = "You have new appointment request.";
					System.out.println("===doc token=="+token);
					sendNotification(token,title,body,"doctor");
				}
				else {
					System.out.println("Didnt find any token");
				}
			
				break;
			}
			case "doctor":{
				patBean = new LogBean();
				String email = request.getParameter("patientEmail");
				String status  = request.getParameter("status");
				patBean.setLogEmail(email);
				notificationServices = new NotificationServices();
				patBean = notificationServices.sendNotificationToPatientService(patBean);
				if (!patBean.getToken().isEmpty()) {
					token = patBean.getToken();
					title = "DocXp";
					if (status.equals("confirm")) {
						body = "You appointment is confirmed.";
						sendNotification(token,title,body,"patient");
					}
					else if(status.equals("reject")) {
						body = "You appointment is rejected, try again later.";
						sendNotification(token,title,body,"patient");
					}
				}
				else {
					System.out.println("Didnt find any token");
				}
				break;
			}
		}
	}
	public void sendNotification(String token,String title,String body,String auth) {
		JSONObject data = new JSONObject();
		try {
			data.put("to", token.trim());
			data.put("to", "/topics/"+auth);
			JSONObject info = new JSONObject();
			info.put("title", title);
			info.put("body", body);
			data.put("data", info);

			OutputStreamWriter outputStreamWriter;
			try {
				outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
				outputStreamWriter.write(data.toString());
				outputStreamWriter.flush();
				outputStreamWriter.close();

				int res_Code = connection.getResponseCode();
				System.out.println("Response code : " + res_Code);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		writer.print(data);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
