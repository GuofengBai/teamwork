package org.po;

import java.io.Serializable;


public class PayingBills extends BillsPO{
	private long Cash;
	private String name;
	private String[] Item;
	public void setDate(myDate t){
		this.Date=t;
	}
	public myDate getDate(){
		return Date;
	}
	public void setCash(long l){
		this.Cash=l;
	}
	public long getCash(){
		return Cash;
	}
	public void setname(String s){
		this.name=s;
	}
	public String getname(){
		return name;
	}
	public void setPayNum(String s){
		this.idNum=s;
	}
	public String getPayNum(){
		return this.idNum;
	}
	public void setItem(String[] s){
		this.Item=s;
	}
	public String[] getItem(){
		return Item;
	}

}
