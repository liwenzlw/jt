package com.ethink.third.traffic.bean;

/**
 * 车牌类型
 * 
 * @author liwen
 * @version 1.0
 */
public class CarPlateType {

	// 车牌类型代号 如：08
	private String code;
	// 车牌类型名称 如：轻便摩托车号牌
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
