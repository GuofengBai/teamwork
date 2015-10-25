package org.po;
import java.io.Serializable;

public class CenterPO implements Serializable {
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;
	private int city;// 城市编号，3位
	private int CenterNum;// 中转中心编号，城市编号+1位+3位
	private String name;// 中转中心名称，例如“鼓楼”

	public CenterPO(int city, int CenterNum, String name) {
		this.city = city;
		this.CenterNum = CenterNum;
		this.name = name;
	}

	public int getCity() {
		/*
		 * sif(city==25) return "南京"; else if (city==10) return "北京"; else
		 * if(city==21) return "上海"; else if(city==20) return "广州"; else return
		 * "新城市";
		 */
		return city;
	}

	public int getCenterNum() {
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
