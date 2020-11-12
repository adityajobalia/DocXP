package com.project.healingtouch.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.project.healingtouch.dto.SpinnerBean;

/**
 * Servlet implementation class SpinnerController
 */
public class SpinnerController extends HttpServlet {
	ArrayList<SpinnerBean> arrayList;
	SpinnerBean bean;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String auth = request.getParameter("auth");
		switch (auth) {
		case "city": {
			arrayList = new ArrayList<SpinnerBean>();
			JSONParser parser = new JSONParser();
			PrintWriter out = response.getWriter();
			try {
				org.json.simple.JSONObject object = (org.json.simple.JSONObject) parser
						.parse(new FileReader("G:/apache-tomcat-9.0.0.M26/webapps/DocXp/spinner/cities.json"));
				JSONArray array = (JSONArray) object.get("cities");
				for (Object o : array) {
					bean = new SpinnerBean();
					JSONObject jsonObject = (JSONObject) o;
					//String id = jsonObject.get("id").toString();
					String name = jsonObject.get("name").toString();
					//String state_id = jsonObject.get("state_id").toString();
					bean.setName(name);
					arrayList.add(bean);
				}
				org.json.JSONArray jsonArray = new org.json.JSONArray();
				org.json.JSONObject jsonObject = new org.json.JSONObject();
				for (int i = 0; i < array.size(); i++) {
					//System.out.println("city"+i+" === "+arrayList.get(i).getName());
					jsonObject.put("city"+i, arrayList.get(i).getName());
					jsonArray.put(jsonObject);
				}
				System.out.println(jsonObject.length());
				
				out.print(jsonArray);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
