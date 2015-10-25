package org.po;

import java.io.Serializable;

public class Payment implements Serializable{
	
	public String type;          // 结算方式
	public double parameter;     //参数
	
	public Payment(){
		super();
		type="按月";
		parameter=2000;
	}
	
	public Payment(String type,double parameter){
		super();
		this.type=type;
		this.parameter=parameter;
	}

}
