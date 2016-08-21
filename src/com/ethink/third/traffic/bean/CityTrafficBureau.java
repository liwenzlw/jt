package com.ethink.third.traffic.bean;

/**
 * 交管局(市级)
 * 
 * @author liwen
 * @version 1.0
 */
public class CityTrafficBureau {

	// 省 如：安庆
	private String city;
	// 车牌前缀 如：皖
	private String lsprefix;
	// 车牌首字母 如：H
	private String lsnum;
	// 管局名称 如：anqing
	private String carorg;
	// 车架号需要输入的长度（当数值为“100”时表示查询时需要全部输入，当数值为“0”时表示查询时此项不需要输入）如：6
	private String frameno;
	// 发动机号需要输入的长度（当数值为“100”时表示查询时需要全部输入，当数值为“0”时表示查询时此项不需要输入）如：0
	private String engineno;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLsprefix() {
		return lsprefix;
	}

	public void setLsprefix(String lsprefix) {
		this.lsprefix = lsprefix;
	}

	public String getLsnum() {
		return lsnum;
	}

	public void setLsnum(String lsnum) {
		this.lsnum = lsnum;
	}

	public String getCarorg() {
		return carorg;
	}

	public void setCarorg(String carorg) {
		this.carorg = carorg;
	}

	public String getFrameno() {
		return frameno;
	}

	public void setFrameno(String frameno) {
		this.frameno = frameno;
	}

	public String getEngineno() {
		return engineno;
	}

	public void setEngineno(String engineno) {
		this.engineno = engineno;
	}
}
