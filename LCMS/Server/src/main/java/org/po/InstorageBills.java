package org.po;

import java.io.Serializable;


public class InstorageBills extends BillsPO{
	private String GoodsNum;
	private myDate Date;
	private String Place;
	private String LocationNum;
	public void setGoodsNum(String l){
		this.GoodsNum=l;
	}
	public String getGoodsNum(){
		return GoodsNum;
	}
	public void setDate(myDate t){
		this.Date=t;
	}
	public myDate getDate(){
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
