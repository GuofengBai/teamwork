package org.po;

import java.io.Serializable;


public class HallDispatchBills extends BillsPO{
	
	private String name;
	private String goodNum;
	
	public HallDispatchBills(myDate t,String id,String goodNum,String name){
		this.Date=t;
		this.goodNum=goodNum;
		this.idNum=id;
		this.name=name;
		this.type=BILLSTYPE.HDB;
		this.Examined=false;
	}
	
	public void setDate(myDate t){
		this.Date=t;
	}
	public myDate getDate(){
		return Date;
	}
	
	public String getgoodNum(){
		return goodNum;
	}
	
	public void setidNum(String l){
		this.idNum=l;
	}
	public String getidNum(){
		return this.idNum;
	}
	public void setname(String s){
		this.name=s;
	}
	public String getname(){
		return name;
	}

}
