package org.po;
import java.io.Serializable;
public class PayingBills extends BillsPO{
	private int Date;
	private long Cash;
	private String name;
	private String PayNum;
	private String[] Item;
	public void setDate(int t){
		this.Date=t;
	}
	public int getDate(){
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
		this.PayNum=s;
	}
	public String getPayNum(){
		return PayNum;
	}
	public void setItem(String[] s){
		this.Item=s;
	}
	public String[] getItem(){
		return Item;
	}

}
