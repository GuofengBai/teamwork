package org.po;
import java.io.Serializable;

public class DriverPO implements Serializable {
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;
	private String driverNum;
	private String name;
	private myDate birthTime;
	private GENDER gender;
	private String phoneNum;
	private String ID;
	private String hallNum;
	

	public DriverPO(String driverNum, String name, myDate birthTime,
			GENDER gender, String phoneNum,String ID,String hallNum) {
		this.driverNum = driverNum;
		this.name = name;
		this.birthTime = birthTime;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.ID=ID;
		this.hallNum=hallNum;
	}

	public String getdriverNum() {
		return driverNum;
	}

	public myDate getbirthTime() {
		return birthTime;
	}

	public String getname() {
		return name;
	}

	public GENDER getgender() {
		return gender;
	}

	public String getphoneNum() {
		return phoneNum;
	}
	
	public String getID(){
		return ID;
	}
	
	public String getHallNum(){
		return hallNum;
	}

}
