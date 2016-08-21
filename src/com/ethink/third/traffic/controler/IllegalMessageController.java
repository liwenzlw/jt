package com.ethink.third.traffic.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.ethink.third.traffic.service.TrafficIllegalService;
import com.ethink.third.traffic.service.TrafficIllegalServiceImpl;
import com.ethink.third.traffic.util.APIConstant;

@WebServlet(name = "illegalMessage", urlPatterns = "/traffic/illegalMessage")
public class IllegalMessageController extends HttpServlet {
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
		
		
		String httpUrl = APIConstant.JISU_ILLEGAL_HTTPURL;
		String apikey = APIConstant.BAIDU_APIKEY;
		
//		String carorg = req.getParameter("carorg");
//		String lsprefix = req.getParameter("lsprefix");
//		String lsnum = req.getParameter("lsnum");
//		String lstype = req.getParameter("lstype");
//		String frameno = req.getParameter("frameno");
//		String engineno = req.getParameter("engineno");
		Enumeration<String> paramNames = req.getParameterNames();
		String name = null;
		String queryString = "";
		String temp = null;
		while(paramNames.hasMoreElements()) {
			name = paramNames.nextElement();
			temp = req.getParameter(name);
			if(StringUtils.isNotEmpty(temp)) {
				queryString +="&" + name + "=" + temp;
			}
		}
		
		if(StringUtils.isNotEmpty(queryString)) {
			queryString = queryString.substring(1);
		}
		System.out.println(queryString);
		TrafficIllegalService trafficService = new TrafficIllegalServiceImpl();
		String retData = trafficService.queryIllegalMessageg(httpUrl, queryString, apikey);
		PrintWriter out = resp.getWriter();
		out.write(retData);
		out.flush();
		out.close();
	}
}
