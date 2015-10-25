package org.po;
import java.io.Serializable;

public class CarPO implements Serializable {
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;
	private int carNum;// 车辆代号，3位城市+3位营业厅+3位
	private int engineNum;// 发动机编号，随意
	private int chassisNum;// 底盘号，随意
	private int buyTime;// 购买时间

	private int serveTime;// 服役时间
	private String number;// 车牌号

	public CarPO(int carNum, int engineNum, int chassisNum, int buyTime,
			int serveTime, String number) {
		this.carNum = carNum;
		this.engineNum = engineNum;
		this.chassisNum = chassisNum;
		this.buyTime = buyTime;
		this.serveTime = serveTime;
		this.number = number;
	}

	public int getcarNum() {
		return carNum;
	}

	public int getengineNum() {
		return engineNum;
	}

	public int getchassisNum() {
		return chassisNum;
	}

	public int getbuyTime() {
		return buyTime;
	}

	public int getserveTime() {
		return serveTime;
	}

	public String getnumber() {
		return number;
	}

	public void setcarNum(int carNum) {
		this.carNum = carNum;
		// 本方法及以下方法在改变车辆信息时使用
	}

	public void setengineNum(int engineNum) {
		this.engineNum = engineNum;
	}

	public void setchassisNum(int chassisNum) {
		this.chassisNum = chassisNum;
	}

	public void setbuyTime(int buyTime) {
		this.buyTime = buyTime;
	}

	public void setserveTime(int serveTime) {
		this.serveTime = serveTime;
	}

	public void setnumber(String number) {
		this.number = number;
	}
	public void del(){
		
	}
}