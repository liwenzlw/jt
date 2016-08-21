package com.ethink.third.express.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ethink.third.express.bean.ExpressCompany;
import com.ethink.third.express.bean.ExpressErrorMessage;
import com.ethink.third.express.bean.ExpressMessage;
import com.ethink.third.express.bean.ExpressPathNode;
import com.ethink.third.express.util.QueryApiUtil;

public class ExpressServiceImpl implements ExpressService {

	private static Logger logger = LoggerFactory.getLogger(ExpressServiceImpl.class);

	@Override
	public String queryExpress(String httpUrl, String queryString, String apikey) {

		String data = null;
		// 调用api接口获取数据
		data = QueryApiUtil.queryAPIGet(httpUrl, queryString, apikey);

		// ---------------------测试数据(覆盖真实数据data) start----------------------
		if (StringUtils.isEmpty(data) || JSON.parseObject(data).getInteger("errNum") > 300000) {
			String number = queryString.substring(queryString.lastIndexOf("=") + 1);
			if (StringUtils.isEmpty(number) || "0".equals(number)) {
				JSONObject errorJson = new JSONObject();
				errorJson.put("errMsg", "快递单号不存在");
				data = errorJson.toJSONString();
			} else {
				InputStreamReader ir = null;
				try {
					ir = new InputStreamReader(
							getClass().getClassLoader().getResourceAsStream("com/ethink/third/express/express.json"),
							"utf-8");
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BufferedReader br = new BufferedReader(ir);
				StringBuilder sb = new StringBuilder();
				while (true) {
					String temp = null;
					try {
						temp = br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (temp == null) {
						break;
					}
					sb.append(temp);
				}
				data = sb.toString();
			}
		}
		// ---------------------测试数据 end----------------------

		// 解析数据
		JSONObject json = JSON.parseObject(data);
		if (StringUtils.isNotEmpty(json.getString("status")) && json.getInteger("status") == 0) {
			json = json.getJSONObject("result");
			ExpressMessage expressMessage = new ExpressMessage();
			expressMessage.setType(json.getString("type"));
			expressMessage.setDeliverystatus(json.getString("deliverystatus"));
			expressMessage.setExpressNumber(json.getString("expressNumber"));
			List pathNodeList = JSON.parseArray(json.getString("list"), ExpressPathNode.class);
			expressMessage.setPathNodeList(pathNodeList);

			return JSON.toJSONString(expressMessage);

		} else {
			String errorMsg = json.getString("errMsg");
			errorMsg = StringUtils.isEmpty(errorMsg) ? json.getString("msg") : errorMsg;
			ExpressErrorMessage msg = new ExpressErrorMessage();
			msg.setErrorMsg(errorMsg);
			return JSON.toJSONString(msg);
		}
	}

	@Override
	public String queryExpressCompany(String httpUrl, String queryString, String apikey) {

		String data = null;
		// 调用api接口获取数据
		data = QueryApiUtil.queryAPIGet(httpUrl, queryString, apikey);

		// ---------------------测试数据 (覆盖真实数据data)start ----------------------
		if (StringUtils.isEmpty(data) || JSON.parseObject(data).getInteger("errNum") > 300000) {
			InputStreamReader ir = null;
			try {
				ir = new InputStreamReader(
						getClass().getClassLoader().getResourceAsStream("com/ethink/third/express/expressCompany.json"),
						"utf-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			BufferedReader br = new BufferedReader(ir);
			StringBuilder sb = new StringBuilder();
			while (true) {
				String temp = null;
				try {
					temp = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (temp == null) {
					break;
				}
				sb.append(temp);
			}
			data = sb.toString();
		}
		// ---------------------测试数据 end----------------------

		// 解析数据
		JSONObject json = JSON.parseObject(data);
		if (StringUtils.isNotEmpty(json.getString("status")) && json.getInteger("status") == 0) {
			String result = json.getString("result");
			List expressCompanyList = JSON.parseArray(result, ExpressCompany.class);
			return JSON.toJSONString(expressCompanyList);
		} else {
			String errorMsg = json.getString("errMsg");
			ExpressErrorMessage msg = new ExpressErrorMessage();
			msg.setErrorMsg(errorMsg);
			return JSON.toJSONString(msg);
		}
	}

}
