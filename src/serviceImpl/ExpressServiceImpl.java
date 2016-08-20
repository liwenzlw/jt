package serviceImpl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import bean.ExpressCompany;
import bean.ExpressErrorMessage;
import bean.ExpressMessage;
import bean.ExpressPathNode;
import service.ExpressService;
import util.QueryApiUtil;

public class ExpressServiceImpl implements ExpressService {

	private static Logger logger = LoggerFactory.getLogger(ExpressServiceImpl.class);

	@Override
	public String queryExpress(String httpUrl, String queryString, String apikey) {

		// 调用api接口
		String data = QueryApiUtil.queryAPI(httpUrl, "GET", queryString, null, apikey);

		// ---------------------测试数据(覆盖真实数据data) start----------------------

		String number = queryString.substring(queryString.lastIndexOf("=") + 1);
		if (StringUtils.isEmpty(number) || "0".equals(number)) {
			JSONObject errorJson = new JSONObject();
			errorJson.put("errMsg", "快递单号不存在");
			data = errorJson.toJSONString();
		} else {
			InputStreamReader ir = new InputStreamReader(
					getClass().getClassLoader().getResourceAsStream("express.json"));
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
			ExpressErrorMessage msg = new ExpressErrorMessage();
			msg.setErrorMsg(errorMsg);
			return JSON.toJSONString(msg);
		}
	}

	public static void main(String[] args) {
		String s = "{\"status\": \"205\", \"msg\": \"没有信息\", \"result\": \"\"}";
		JSONObject json = JSON.parseObject(s);
		System.out.println(json);
		System.out.println(json.getInteger("status"));
	}

	@Override
	public String queryExpressCompany(String httpUrl, String queryString, String apikey) {

		// 调用api接口
		String data = QueryApiUtil.queryAPI(httpUrl, "GET", queryString, null, apikey);

		// ---------------------测试数据 (覆盖真实数据data)start ----------------------
		
		
		
		InputStreamReader ir = new InputStreamReader(
				getClass().getClassLoader().getResourceAsStream("expressCompany.json"));
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
