package org.po;
import java.io.Serializable;

public class CenterPO implements Serializable {
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;
	private String location;// 城市详细地址
	private String CenterNum;// 中转中心编号，城市编号+1位+3位
	private String name;// 中转中心名称，例如“鼓楼”

	public CenterPO(String name, String CenetrNum, String location) {
		this.location = location;
		this.CenterNum = CenterNum;
		this.name = name;
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
	public  void setLocation(String loc){
		this.location=loc;
	}
	public String getLocation(){
		return this.location;
	}

}
