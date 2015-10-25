package org.po;

import java.io.Serializable;


public class OutstorageBills extends BillsPO{
	private long GoodsNum;
	private myDate Date;
	private String FreightNum;
	public void setGoodsNum(long l){
		this.GoodsNum=l;
	}
	public long getGoodsNum(){
		return GoodsNum;
	}
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

}
