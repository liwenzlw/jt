package com.ethink.third.express.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.iterators.EntrySetMapIterator;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 向API接口查询数据-工具类
 * 
 * @author liwen
 * @version 1.0
 */
public class QueryApiUtil {
	private static Logger logger = LoggerFactory.getLogger(QueryApiUtil.class);

	/**
	 * 根据查询字符串向httpUrl发送请求(GET)
	 * 
	 * @param httpUrl
	 *            API请求地址
	 * @param queryString
	 *            查询字符串
	 * @param apikey
	 * @return
	 */
	public static String queryAPIGet(String httpUrl, String queryString, String apikey) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		if (StringUtils.isNotEmpty(queryString)) {
			httpUrl = httpUrl + "?" + queryString;
		}

		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(APIConstant.GET);
			// 填入apikey到HTTP header
			if (null != apikey) {
				connection.setRequestProperty("apikey", apikey);
			}
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("调用 API查询接口异常");
			throw new RuntimeException("调用 API查询接口异常");
		}
		return result;
	}

	/**
	 * 向httpUrl发送POST请求
	 * 
	 * @param httpUrl
	 *            API接口请求地址
	 * @param postData
	 *            post请求的数据
	 * @param apikey
	 * @return
	 */
	public static String queryAPIPost(String httpUrl, Map<String, String> postData, String apikey) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();

		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(APIConstant.POST);
			// 设置Post数据到请求体中
			if (MapUtils.isNotEmpty(postData)) {
				Set<String> keySet = postData.keySet();
				for (String key : keySet) {
					connection.setRequestProperty(key, postData.get(key));
				}
			}
			// 填入apikey到HTTP header
			if (null != apikey) {
				connection.setRequestProperty("apikey", apikey);
			}
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("调用 API查询接口异常");
			throw new RuntimeException("调用 API查询接口异常");
		}
		return result;
	}
}
