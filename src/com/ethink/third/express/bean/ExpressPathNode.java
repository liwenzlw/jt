package com.ethink.third.express.bean;

/**
 * 快递运送过程的节点信息抽象
 * 
 * @author liwen
 * @version 1.0
 */
public class ExpressPathNode {

	// 时间: "2016-04-13 13:30:30"
	private String time;
	// 当前时间快递的状态 : "正在派送途中(派件人:徐程得,电话:15990107893)"
	private String status;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
