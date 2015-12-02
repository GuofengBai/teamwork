package org.po;
import java.io.Serializable;

public class HallPO implements Serializable {
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;

	private String HallNum;// 营业厅编号，三位城市+1位+三位编号
	private String cityName;// 城市名称
	private String name;//营业厅名称
	private String concreteLocation;//营业厅详细地址，用文字描述

	public HallPO(String HallNum, String cityName, String name,String loc) {
		this.HallNum = HallNum;
		this.cityName = cityName;
		this.name=name;
		this.concreteLocation=loc;
	}

	public String getHallNum() {
		return HallNum;
	}

	public String getcityName() {
		return cityName;
	}
	public String getname(){
		return name;
	}

	public void setHallNum(String HallNum) {
		this.HallNum = HallNum;
		// 不知道哪用
	}
	public void setname(String name){
		this.name=name;
	}
	public String getLocation(){
		return this.concreteLocation;
	}
	public void setLocation(String loc){
		this.concreteLocation=loc;
	}

}