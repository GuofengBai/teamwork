package org.po;

import java.io.Serializable;

public class TransFeePO implements Serializable{

	private double car;
	private double train;
	private double plane;
	
	public TransFeePO() {
		super();
		car=20;
		train=400;
		plane=1000;
	}
	public void setFee(TRANSPORTATION type,double fee){
		if(type==TRANSPORTATION.CAR){
			car=fee;
		}else if(type==TRANSPORTATION.TRAIN){
			train=fee;
		}else{
			plane=fee;
		}
	}
	public double getFee(TRANSPORTATION type){
		if(type==TRANSPORTATION.CAR){
			return car;
		}else if(type==TRANSPORTATION.TRAIN){
			return train;
		}else{
			return plane;
		}
	}
}
