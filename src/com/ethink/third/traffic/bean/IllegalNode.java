package com.ethink.third.traffic.bean;

/**
 * 某次违章的详细信息
 * 
 * @author liwen
 * @version
 */
public class IllegalNode {
	// 时间 如：2015-06-08 18:22:00.0
	private String time;
	// 地点 如：鼓浪路近291弄路段
	private String address;
	// 违章内容 如：违反规定停放、临时停车且驾驶人不在现场或驾驶人虽在现场拒绝立即驶离，妨碍其他车辆、行人通行的
	private String content;
	// 罚款金额 如：800
	private String price;
	// 扣分 如：6
	private String score;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

}
