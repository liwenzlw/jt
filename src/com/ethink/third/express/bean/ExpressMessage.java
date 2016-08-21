package com.ethink.third.express.bean;

import java.util.List;

/**
 * 快递查询信息抽象
 * 
 * @author liwen
 * @version 1.0
 */
public class ExpressMessage {

	// 快递编号
	private String expressNumber;
	// 快递类型
	private String type;
	// 物流状态 1在途中 2派件中 3已签收 4派送失败(拒签等)
	private String deliverystatus;
	// 在运输过程中，获取的泊位的集合
	private List<ExpressPathNode> pathNodeList;

	public String getExpressNumber() {
		return expressNumber;
	}

	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDeliverystatus() {
		return deliverystatus;
	}

	public void setDeliverystatus(String deliverystatus) {
		switch (deliverystatus) {
		case "1":
			this.deliverystatus = "在途中";
			break;
		case "2":
			this.deliverystatus = "派件中";
			break;
		case "3":
			this.deliverystatus = "已签收";
			break;
		case "4":
			this.deliverystatus = "派送失败(拒签等)";
			break;
		}
	}

	public List<ExpressPathNode> getPathNodeList() {
		return pathNodeList;
	}

	public void setPathNodeList(List<ExpressPathNode> pathNodeList) {
		this.pathNodeList = pathNodeList;
	}
}
