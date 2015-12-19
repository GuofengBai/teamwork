package org.po;
import java.io.Serializable;

public class CarPO implements Serializable {
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;
	private String carNum;//车辆编号
	private String engineNum;// 发动机编号，随意
	private String chassisNum;// 底盘号，随意
	private myDate buyTime;// 购买时间
	private String hallNum;
	private myDate serveTime;// 服役截止时间
	private String number;// 车牌号

	public CarPO(String carNum, String engineNum, String chassisNum, myDate buyTime,
			myDate serveTime, String number,String hallNum) {
		this.carNum = carNum;
		this.engineNum = engineNum;
		this.chassisNum = chassisNum;
		this.buyTime = buyTime;
		this.serveTime = serveTime;
		this.number = number;
		this.hallNum=hallNum;
	}

	public String getcarNum() {
		return carNum;
	}

	public String getengineNum() {
		return engineNum;
	}

	public String getchassisNum() {
		return chassisNum;
	}

	public myDate getbuyTime() {
		return buyTime;
	}
	
	public String getHallNum(){
		return hallNum;
	}

	public myDate getserveTime() {
		return serveTime;
	}

	public String getnumber() {
		return number;
	}

	public void setcarNum(String carNum) {
		this.carNum = carNum;
		// 本方法及以下方法在改变车辆信息时使用
	}

	public void setengineNum(String engineNum) {
		this.engineNum = engineNum;
	}

	public void setchassisNum(String chassisNum) {
		this.chassisNum = chassisNum;
	}

	public void setbuyTime(myDate buyTime) {
		this.buyTime = buyTime;
	}

	public void setserveTime(myDate serveTime) {
		this.serveTime = serveTime;
	}

	public void setnumber(String number) {
		this.number = number;
	}
	public void del(){
		
	}
}
