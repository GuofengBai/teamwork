package org.po;

public class AlertPO {
	private String centerNum;
	private int fullNumber=100000;
	private int nowNumber;
	public AlertPO(String centerNum,int nowNumber){
		this.centerNum=centerNum;
		this.nowNumber=nowNumber;
	}
	public int getfullNumber(){
		return fullNumber;
	}
	public int getnowNumber(){
		return nowNumber;
	}
	public String getcenterNum(){
		return centerNum;
	}
	
}
