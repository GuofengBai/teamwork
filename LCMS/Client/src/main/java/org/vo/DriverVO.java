package org.vo;

import java.util.Vector;

import org.po.DriverPO;
import org.po.GENDER;
import org.po.myDate;

public class DriverVO extends Vector<String>{
	
	public DriverVO(String driverNum, String name, myDate birthTime,
			GENDER gender, String phoneNum,String ID){
		this.add(driverNum);
		this.add(name);
		this.add(birthTime.toString());
		if(gender==GENDER.MALE){
			this.add("男");
		}else{
			this.add("女");
		}
		this.add(phoneNum);
		this.add(ID);
	}
	
	public DriverVO(DriverPO po){
		this.add(po.getdriverNum());
		this.add(po.getname());
		this.add(po.getbirthTime().toString());
		if(po.getgender()==GENDER.MALE){
			this.add("男");
		}else{
			this.add("女");
		}
		this.add(po.getphoneNum());
		this.add(po.getID());
		
	}

}
