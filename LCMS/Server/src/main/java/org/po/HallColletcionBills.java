package org.po;
import java.io.Serializable;
public class HallColletcionBills extends BillsPO{
	private int Date;
	private int Cash;
	private String name;
	private long[] GoodsNum;
	public void setDate(int t){
		this.Date=t;
	}
	public int getDate(){
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
