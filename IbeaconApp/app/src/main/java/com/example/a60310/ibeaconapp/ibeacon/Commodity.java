package com.example.a60310.ibeaconapp.ibeacon;

import java.io.Serializable;

/**
 * 商品实体类
 * 
 * @author cheny
 *
 */
public class Commodity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String commodityId;// 商品编号
	private int iconId;// 商品图片资源id
	private double price; // 价格
	private String desc;// 商品描述
	private String distance;// 与用户距离

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public Commodity(String commodityId, int iconId, double price, String desc, String distance) {
		super();
		this.commodityId = commodityId;
		this.iconId = iconId;
		this.price = price;
		this.desc = desc;
		this.distance = distance;
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public double getPrice() {
		return price;
	}

	public int getIconId() {
		return iconId;
	}

	public void setIconId(int iconId) {
		this.iconId = iconId;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Commodity() {
		super();
	}

}
