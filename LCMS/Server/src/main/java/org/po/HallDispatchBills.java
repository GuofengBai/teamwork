package org.po;
import java.io.Serializable;
public class HallDispatchBills extends BillsPO{
	private int Date;
	private long GoodsNum;
	private String name;
	public void setDate(int t){
		this.Date=t;
	}
	public int getDate(){
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
