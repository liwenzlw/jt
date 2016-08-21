package com.ethink.third.express.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.ethink.third.express.service.ExpressService;
import com.ethink.third.express.service.ExpressServiceImpl;
import com.ethink.third.express.util.APIConstant;

/**
 * 快递单号信息查询控制
 * 
 * @author liwen
 * @version 1.0
 */
@WebServlet(name = "expressQuery", urlPatterns = { "/express/expressQuery" })
public class ExpressServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/Json;charset=utf-8");
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.addHeader("Access-Control-Allow-Methods", "POST");
		resp.addHeader("Access-Control-Max-Age", "1000");
		String type = StringUtils.isEmpty(req.getParameter("type")) ? "" : req.getParameter("type");
		String number = req.getParameter("number");
		ExpressService expressService = new ExpressServiceImpl();
		String httpUrl = APIConstant.JISU_QYREY_EXPRESS_HTTPURL;
		String queryString = "type=" + type + "&number=" + number;
		String apikey = APIConstant.BAIDU_APIKEY;
		String retData = expressService.queryExpress(httpUrl, queryString, apikey);
		PrintWriter out = resp.getWriter();
		out.write(retData);
		out.flush();
		out.close();
	}
}
