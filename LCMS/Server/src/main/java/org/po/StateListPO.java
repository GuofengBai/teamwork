package org.po;

import java.io.Serializable;

public class StateListPO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String GoodsNum;
	private String goodState;
	public StateListPO(String GoodsNum,String goodState){
		this.GoodsNum=GoodsNum;
		this.goodState=goodState;
	}
	public String getNum(){
		return GoodsNum;
	}
	
	public String getState(){
		return goodState;
	}

}
