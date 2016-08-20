package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.APIConstant;
import service.ExpressService;
import serviceImpl.ExpressServiceImpl;

/**
 * 快递公司的信息查询控制
 * 
 * @author liwen
 * @version 1.0
 */
@WebServlet(name = "expressCompanyQuery", urlPatterns = { "/expressCompanyQuery" })
public class ExpressCompanyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.addHeader("Access-Control-Allow-Methods", "POST");
		resp.addHeader("Access-Control-Max-Age", "1000");
		ExpressService expressService = new ExpressServiceImpl();
		String httpUrl = APIConstant.JISU_QYREY_COMPANY_HTTPURL;
		String apikey = APIConstant.BAIDU_APIKEY;
		String retData = expressService.queryExpressCompany(httpUrl, null, apikey);
		PrintWriter out = resp.getWriter();
		out.write(retData);
		out.flush();
		out.close();
	}
}
