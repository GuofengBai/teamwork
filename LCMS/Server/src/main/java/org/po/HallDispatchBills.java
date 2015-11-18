package org.po;

import java.io.Serializable;


public class HallDispatchBills extends BillsPO{
	
	private String name;
	
	public HallDispatchBills(myDate t,String id,String name){
		this.Date=t;
		this.idNum=id;
		this.name=name;
	}
	
	public void setDate(myDate t){
		this.Date=t;
	}
	public myDate getDate(){
		return Date;
	}
	public void setGoodsNum(String l){
		this.idNum=l;
	}
	public String getGoodsNum(){
		return this.idNum;
	}
	public void setname(String s){
		this.name=s;
	}
	public String getname(){
		return name;
	}

}
