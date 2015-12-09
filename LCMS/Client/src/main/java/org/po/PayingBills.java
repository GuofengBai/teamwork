package org.po;

import java.io.Serializable;


public class PayingBills extends BillsPO{
	
	private String name;
	private long money;
	private String accountName;
	private String item;
	private String remark;
	
	public PayingBills(myDate date,String name,String accountName,String item,long money,String remark,String idNum){
		this.Date=date;
		this.name=name;
		this.accountName=accountName;
		this.item=item;
		this.money=money;
		this.remark=remark;
		this.idNum=idNum;
		this.type=BILLSTYPE.PB;
	}
	
	public void setIdNum(String s){
		this.idNum=s;
	}
	
	public String getIdNum(){
		return this.idNum;
	}
	
	public void setDate(myDate t){
		this.Date=t;
	}
	public myDate getDate(){
		return Date;
	}
	public void setCash(long l){
		this.money=l;
	}
	public long getMoney(){
		return money;
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
	public void setAccountname(String s){
		this.accountName=s;
	}
	public String getAccountName(){
		return accountName;
	}
	public void setItem(String s){
		this.item=s;
	}
	public String getItem(){
		return item;
	}
	public void setRemark(String s){
		this.remark=s;
	}
	public String getRemark(){
		return remark;
	}

}
