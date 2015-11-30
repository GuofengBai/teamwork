package org.po;

public class StateListPO {
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
