package org.po;
import java.io.Serializable;
public class OutstorageBills extends BillsPO{
	private long GoodsNum;
	private int Date;
	private String FreightNum;
	public void setGoodsNum(long l){
		this.GoodsNum=l;
	}
	public long getGoodsNum(){
		return GoodsNum;
	}
	public void setDate(int t){
		this.Date=t;
	}
	public int getDate(){
		return Date;
	}
	public void setFreightNum(String s){
		this.FreightNum=s;
	}
	public String getFreightNum(){
		return FreightNum;
	}

}
