package com.ethink.third.traffic.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ethink.third.traffic.bean.CarPlateType;
import com.ethink.third.traffic.bean.IllegalMessage;
import com.ethink.third.traffic.bean.ProvinceTrafficBureau;
import com.ethink.third.traffic.bean.TrafficErrorMessage;
import com.ethink.third.traffic.util.QueryApiUtil;

public class TrafficIllegalServiceImpl implements TrafficIllegalService {

	@Override
	public String queryCarPlateType(String httpUrl, String apikey) {
		String data = null;
		// 调用api接口获取数据
		data = QueryApiUtil.queryAPIGet(httpUrl,null, apikey);

		// ---------------------测试数据(覆盖真实数据data) start----------------------
		if (StringUtils.isEmpty(data)||JSON.parseObject(data).getInteger("errNum")>300000)  {
			InputStreamReader ir = null;
			try {
				ir = new InputStreamReader(
						getClass().getClassLoader().getResourceAsStream("com/ethink/third/traffic/carPlateType.json"),
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
			List<CarPlateType> list = JSON.parseArray(json.getString("result"), CarPlateType.class);
			return JSON.toJSONString(list);
		} else {
			String errorMsg = json.getString("errMsg");
			errorMsg = StringUtils.isEmpty(errorMsg) ? json.getString("msg") : errorMsg;
			TrafficErrorMessage msg = new TrafficErrorMessage();
			msg.setErrorMsg(errorMsg);
			return JSON.toJSONString(msg);
		}
	}

	@Override
	public String queryBureau(String httpUrl, String apikey) {
		String data = null;
		// 调用api接口获取数据
		data = QueryApiUtil.queryAPIGet(httpUrl,null, apikey);

		// ---------------------测试数据(覆盖真实数据data) start----------------------
		if (StringUtils.isEmpty(data)||JSON.parseObject(data).getInteger("errNum")>300000)  {
			InputStreamReader ir = null;
			try {
				ir = new InputStreamReader(
						getClass().getClassLoader().getResourceAsStream("com/ethink/third/traffic/trafficBureau.json"),
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
			List<ProvinceTrafficBureau> list = JSON.parseArray(json.getJSONObject("result").getString("data"), ProvinceTrafficBureau.class);
			return JSON.toJSONString(list);
		} else {
			String errorMsg = json.getString("errMsg");
			errorMsg = StringUtils.isEmpty(errorMsg) ? json.getString("msg") : errorMsg;
			TrafficErrorMessage msg = new TrafficErrorMessage();
			msg.setErrorMsg(errorMsg);
			return JSON.toJSONString(msg);
		}
	}

	@Override
	public String queryIllegalMessageg(String httpUrl, String queryString, String apikey) {
		String data = null;
		// 调用api接口获取数据
		data = QueryApiUtil.queryAPIGet(httpUrl,queryString, apikey);

		// ---------------------测试数据(覆盖真实数据data) start----------------------
		if (StringUtils.isEmpty(data)||JSON.parseObject(data).getInteger("errNum")>300000) {
			InputStreamReader ir = null;
			try {
				ir = new InputStreamReader(
						getClass().getClassLoader().getResourceAsStream("com/ethink/third/traffic/trafficIllegal.json"),
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
			IllegalMessage illeganMessage = JSON.parseObject(json.getString("result"), IllegalMessage.class);
			return JSON.toJSONString(illeganMessage);
		} else {
			String errorMsg = json.getString("errMsg");
			errorMsg = StringUtils.isEmpty(errorMsg) ? json.getString("msg") : errorMsg;
			TrafficErrorMessage msg = new TrafficErrorMessage();
			msg.setErrorMsg(errorMsg);
			return JSON.toJSONString(msg);
		}
	}

}
