package org.po;

import java.io.Serializable;


public class HallArrivingBills extends BillsPO{
	private myDate Date;
	private String FreightNum;
	private String StartPlace;
	private String State;
	public void setDate(myDate t){
		this.Date=t;
	}
	public myDate getDate(){
		return Date;
	}
	public void setFreightNum(String s){
		this.FreightNum=s;
	}
	public String getFreightNum(){
		return FreightNum;
	}
	public void setStartPlace(String s){
		this.StartPlace=s;
	}
	public String getStartPlace(){
		return StartPlace;
	}
	public void setState(String s){
		this.State=s;
	}
	public String getState(){
		return State;
	}

}
