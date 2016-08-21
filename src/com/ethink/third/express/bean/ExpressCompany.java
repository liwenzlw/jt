package com.ethink.third.express.bean;

/**
 * 快递公司的抽象
 * 
 * @author liwen
 * @version 1.0
 */
public class ExpressCompany {

	// 快递公司的名称 如："name":"圆通"
	private String name;
	// 快递公司的标识 如： "type":"YTO"
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
