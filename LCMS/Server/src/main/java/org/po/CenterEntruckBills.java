package org.po;

import java.io.Serializable;


public class CenterEntruckBills extends BillsPO{
	private myDate Date;
	private String TrafficNum;
	private String HallNum;
	private String Name;
	private String[] GoodsNum;
	public void setTravelNum(String s){
		this.idNum=s;
	}
	public String getTravelNum(){
		return this.idNum;
	}
	public void setDate(myDate t){
		this.Date=t;
	}
	public myDate getDate(){
		return Date;
	}
	public void setTrafficNum(String s){
		this.TrafficNum=s;
	}
	public String getTrafficNum(){
		return TrafficNum;
	}
	public void setHallNum(String s){
		this.HallNum=s;
	}
	public String getHallNum(){
		return HallNum;
	}
	public void setName(String s){
		this.Name=s;
	}
	public String getName(){
		return Name;
	}
	public void setGoodsNum(String[] l){
		this.GoodsNum=l;
	}
	public String[] getGoodsNum(){
		return GoodsNum;
	}
}
