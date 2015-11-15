package org.po;

import java.io.Serializable;


public class HallColletionBills extends BillsPO{
	private myDate Date;
	private int Cash;
	private String name;
	private long[] GoodsNum;
	public void setDate(myDate t){
		this.Date=t;
	}
	public myDate getDate(){
		return Date;
	}
	public void setCash(int t){
		this.Cash=t;
	}
	public int getCash(){
		return Cash;
	}
	public void setname(String s){
		this.name=s;
	}
	public String getname(){
		return name;
	}
	public void setGoodsNum(long[] l){
		this.GoodsNum=l;
	}
	public long[] getGoodsNum(){
		return GoodsNum;
	}

}
