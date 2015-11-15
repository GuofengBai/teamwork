package org.po;
import java.io.Serializable;

public class CenterPO implements Serializable {
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;
	private String city;// 城市编号，3位
	private String CenterNum;// 中转中心编号，城市编号+1位+3位
	private String name;// 中转中心名称，例如“鼓楼”

	public CenterPO(String city, String CenterNum, String name) {
		this.city = city;
		this.CenterNum = CenterNum;
		this.name = name;
	}

	public String getCity() {
		/*
		 * if(city==025) return "南京"; else if (city==010) return "北京"; else
		 * if(city==021) return "上海"; else if(city==020) return "广州"; else return
		 * "新城市";
		 */
		return city;
	}

	public String getCenterNum() {
		return CenterNum;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}
	public void del(){
		
	}
}
