package service;

/**
 * 查询快递数据服务
 * 
 * @author liwen
 * @version 1.0
 */
public interface ExpressService {

	/**
	 * 查询快递（极速数据API）
	 * 
	 * @param httpUrl
	 * @param queryString
	 * @param apikey
	 * @return
	 */
	public String queryExpress(String httpUrl, String queryString, String apikey);

	/**
	 * 查询快递公司 （极速数据API）
	 * 
	 * @param httpUrl
	 * @param queryString
	 * @param apikey
	 * @return
	 */
	String queryExpressCompany(String httpUrl, String queryString, String apikey);
}
