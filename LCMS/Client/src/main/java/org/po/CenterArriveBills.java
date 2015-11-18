package org.po;

import java.io.Serializable;


public class CenterArriveBills extends BillsPO{
	private String CenterNum;
	private String State;
	public void setBillNum(String s){
		this.idNum=s;
	}
	public String getBillNum(){
		return idNum;
	}
	public void setCenterNum(String s){
		this.CenterNum=s;
	}
	public String getCenterNum(){
		return CenterNum;
	}
	public void setDate(myDate d){
		this.Date=d;
	}
	public myDate getDate(){
		return Date;
	}
	public void setState(String s){
		this.State=s;
	}
	public String getState(){
		return State;
	}	
}
