package com.ethink.third.traffic.service;

/**
 * 交通违章信心服务
 * 
 * @author liwen
 * @version 1.0
 */
public interface TrafficIllegalService {

	/**
	 * 查询车牌类型
	 * 
	 * @param httpUrl
	 * @param apikey
	 * @return
	 */
	public String queryCarPlateType(String httpUrl, String apikey);

	/**
	 * 查询交管局
	 * 
	 * @param httpUrl
	 * @param apikey
	 * @return
	 */
	public String queryBureau(String httpUrl, String apikey);

	/**
	 * 查询违章信息
	 * 
	 * @param httpUrl
	 * @param queryString
	 * @param apikey
	 * @return
	 */
	public String queryIllegalMessageg(String httpUrl, String queryString, String apikey);
}
