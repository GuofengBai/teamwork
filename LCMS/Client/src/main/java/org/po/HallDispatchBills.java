package org.po;

import java.io.Serializable;


public class HallDispatchBills extends BillsPO{
	private myDate Date;
	private long GoodsNum;
	private String name;
	public void setDate(myDate t){
		this.Date=t;
	}
	public myDate getDate(){
		return Date;
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

}
