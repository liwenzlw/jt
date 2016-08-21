package com.ethink.third.traffic.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ethink.third.traffic.service.TrafficIllegalService;
import com.ethink.third.traffic.service.TrafficIllegalServiceImpl;
import com.ethink.third.traffic.util.APIConstant;

@WebServlet(name = "carPlate", urlPatterns = "/traffic/carPlateType")
public class CarPlateController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/Json;charset=utf-8");
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.addHeader("Access-Control-Allow-Methods", "POST");
		resp.addHeader("Access-Control-Max-Age", "1000");
		// cookie有效时间为5天
		resp.setDateHeader("experice", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 5);
		TrafficIllegalService trafficService = new TrafficIllegalServiceImpl();
		String httpUrl = APIConstant.JISU_CAR_PLATE_TYPE_HTTPURL;
		String apikey = APIConstant.BAIDU_APIKEY;
		String retData = trafficService.queryCarPlateType(httpUrl, apikey);
		PrintWriter out = resp.getWriter();
		out.write(retData);
		out.flush();
		out.close();
	}
}
