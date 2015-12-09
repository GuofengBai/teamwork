package org.po;

import java.io.Serializable;

public class ExpressFeePO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double slow;
	private double normal;
	private double fast;
	
	public ExpressFeePO() {
		super();
		slow=18;
		normal=23;
		fast=25;
	}
	public void setFee(SENDSTYPE type,double fee){
		if(type==SENDSTYPE.SLOW){
			slow=fee;
		}else if(type==SENDSTYPE.NORMAL){
			normal=fee;
		}else{
			fast=fee;
		}
	}
	public double getFee(SENDSTYPE type){
		if(type==SENDSTYPE.SLOW){
			return slow;
		}else if(type==SENDSTYPE.NORMAL){
			return normal;
		}else{
			return fast;
		}
	}

}
