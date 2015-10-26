package org.po;

import java.io.Serializable;


public class SendingBills extends BillsPO{
	private myDate Date;
	private BOXSTYPE boxstype;
	private SENDSTYPE sendstype;
	private String startplace;
	private String endplace;
	private String location;
	private long GoodsNum;
	private String name;
	public EXPRESSSTATE expressState;
	public double price;
	
	public SendingBills(){
		super();
	}
	
	public SendingBills(myDate Date, BOXSTYPE boxstype,
			SENDSTYPE sendstype, String startplace, String endplace,
			String location, long GoodsNum, String name,double price){
		this.Date=Date;
		this.boxstype=boxstype;
		this.sendstype=sendstype;
		this.startplace=startplace;
		this.endplace=endplace;
		this.location=location;
		this.GoodsNum=GoodsNum;
		this.name=name;
		this.expressState=EXPRESSSTATE.LOCALHALL;
		this.price=price;
		this.type=BILLSTYPE.SB;
	}
	
	public void setDate(myDate t){
		this.Date=t;
	}
	public myDate getDate(){
		return Date;
	}
	public void setsendstype(SENDSTYPE t){
		this.sendstype=t;
	}
	public SENDSTYPE getsendstype(){
		return sendstype;
	}
	public void setboxstype(BOXSTYPE t){
		this.boxstype=t;
	}
	public BOXSTYPE getboxstype(){
		return boxstype;
	}
	public void setGoodsNum(long l){
		this.GoodsNum=l;
	}
	public long getGoodsNum(){
		return GoodsNum;
	}
	public void setname(String s){
		this.name=s;
	}
	public String getname(){
		return name;
	}
	public void setstartplace(String s){
		this.startplace=s;
	}
	public String getstartplace(){
		return startplace;
	}
	public void setendplace(String s){
		this.endplace=s;
	}
	public String getendplace(){
		return endplace;
	}
	public void setlocation(String s){
		this.location=s;
	}
	public String getlocation(){
		return location;
	}
	public void setExpressState(EXPRESSSTATE state){
		expressState=state;
	}
	public EXPRESSSTATE getExpressState(){
		return expressState;
		
	}
}
