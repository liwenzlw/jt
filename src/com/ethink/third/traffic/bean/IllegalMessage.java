package com.ethink.third.traffic.bean;

import java.util.List;

/**
 * 车辆违章的详细信息
 * 
 * @author liwen
 * @version
 */
public class IllegalMessage {
	// 车牌前缀 如：皖
	private String lsprefix;
	// 车牌剩余部分 如：B91801
	private String lsnum;
	// 管局名称 如：anhui
	private String carorg;
	// 车牌ID 如：1483850
	private String usercarid;
	// 每次违章详情
	List<IllegalNode> list;

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

	public String getUsercarid() {
		return usercarid;
	}

	public void setUsercarid(String usercarid) {
		this.usercarid = usercarid;
	}

	public List<IllegalNode> getList() {
		return list;
	}

	public void setList(List<IllegalNode> list) {
		this.list = list;
	}

}
