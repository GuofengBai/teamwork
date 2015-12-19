package org.vo;

import java.util.Vector;

import org.po.CarPO;
import org.po.myDate;

public class CarVO extends Vector<String>{
	
	public CarVO(String carNum, String engineNum, String chassisNum, myDate buyTime,
			myDate serveTime, String number){
		this.add(carNum);
		this.add(engineNum);
		this.add(chassisNum);
		this.add(buyTime.toString());
		this.add(serveTime.toString());
		this.add(number);
	}
	
	public CarVO(CarPO po){
		this.add(po.getcarNum());
		this.add(po.getengineNum());
		this.add(po.getchassisNum());
		this.add(po.getbuyTime().toString());
		this.add(po.getserveTime().toString());
		this.add(po.getnumber());
	}

}
