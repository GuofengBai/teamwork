package org.po;

public class AlertPO {
	private int fullNumber=10000;
	private double alertline;//0-1小数
	public AlertPO(double alertline){
		this.alertline=alertline;
	}
	public int getfullNumber(){
		return fullNumber;
	}
	public double getalertline(){
		return alertline;
	}
}