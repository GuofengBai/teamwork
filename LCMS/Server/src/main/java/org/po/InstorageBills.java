package org.po;
import java.io.Serializable;
public class InstorageBills extends BillsPO{
	private long GoodsNum;
	private int Date;
	private String Place;
	private String LocationNum;
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
	public void setPlace(String s){
		this.Place=s;
	}
	public String getPlace(){
		return Place;
	}
	public void setLocationNum(String s){
		this.LocationNum=s;
	}
	public String getLocationNum(){
		return LocationNum;
	}
}