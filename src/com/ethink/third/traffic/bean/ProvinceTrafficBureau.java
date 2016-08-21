package com.ethink.third.traffic.bean;

import java.util.List;

/**
 * 交管局(省级)
 * 
 * @author liwen
 * @version 1.0
 */
public class ProvinceTrafficBureau {

	// 省 如：北京
	private String province;
	// 车牌前缀 如：京
	private String lsprefix;
	// 车牌首字母 （省级一般为空""）
	private String lsnum;
	// 管局名称 如：beijing7
	private String carorg;
	// 车架号需要输入的长度（当数值为“100”时表示查询时需要全部输入，当数值为“0”时表示查询时此项不需要输入）如：0
	private String frameno;
	// 发动机号需要输入的长度（当数值为“100”时表示查询时需要全部输入，当数值为“0”时表示查询时此项不需要输入）如：100
	private String engineno;
	// 市级交管局
	private List<CityTrafficBureau> list;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
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

	public List<CityTrafficBureau> getList() {
		return list;
	}

	public void setList(List<CityTrafficBureau> cityTrafficBureauList) {
		this.list = cityTrafficBureauList;
	}

}
