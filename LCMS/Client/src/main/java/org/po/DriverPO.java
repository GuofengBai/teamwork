package org.po;
import java.io.Serializable;

public class DriverPO implements Serializable {
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;
	private int driverNum;
	private String name;
	private myDate birthTime;
	private String ID;
	private boolean gender;
	private String phoneNum;
	private int licensePeriod;

	public DriverPO(int driverNum, String name, myDate birthTime, String ID,
			boolean gender, String phoneNum, int licensePeriod) {
		this.driverNum = driverNum;
		this.name = name;
		this.birthTime = birthTime;
		this.ID = ID;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.licensePeriod = licensePeriod;
	}

	public int getdriverNum() {
		return driverNum;
	}

	public myDate getbirthTime() {
		return birthTime;
	}

	public int getlicensePeriod() {
		return licensePeriod;
	}

	public String getname() {
		return name;
	}

	public String getID() {
		return ID;
	}

	public boolean getgender() {
		return gender;
	}

	public String getphoneNum() {
		return phoneNum;
	}

	public void setdriverNum(int driverNum) {
		this.driverNum = driverNum;
		// 本方法及以下方法在改变司机信息时使用
	}

	public void setdbirthTime(myDate birthTime) {
		this.birthTime = birthTime;
	}

	public void setlicensePeriod(int licensePeriod) {
		this.licensePeriod = licensePeriod;
	}

	public void setname(String name) {
		this.name = name;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public void setphoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setgender(boolean gender) {
		this.gender = gender;
	}
	public void del(){
		
	}
}
