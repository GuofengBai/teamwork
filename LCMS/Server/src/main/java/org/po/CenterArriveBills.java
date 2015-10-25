package org.po;
import java.io.Serializable;
public class CenterArriveBills extends BillsPO{
	private String BillNum;
	private String CenterNum;
	private int Date;
	private String State;
	public void setBillNum(String s){
		this.BillNum=s;
	}
	public String getBillNum(){
		return BillNum;
	}
	public void setCenterNum(String s){
		this.CenterNum=s;
	}
	public String getCenterNum(){
		return CenterNum;
	}
	public void setDate(int d){
		this.Date=d;
	}
	public int getDate(){
		return Date;
	}
	public void setState(String s){
		this.State=s;
	}
	public String getState(){
		return State;
	}	
}
