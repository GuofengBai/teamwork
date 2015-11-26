package org.po;

public class AlertPO {
	private String centerNum;
	private int fullNumber=100000;
	private int nowNumber;
	private double alertline;
	public AlertPO(String centerNum,int nowNumber,double alertline){
		this.centerNum=centerNum;
		this.nowNumber=nowNumber;
		this.alertline=alertline;
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
	public double getalertline(){
		return alertline;
	}
}
