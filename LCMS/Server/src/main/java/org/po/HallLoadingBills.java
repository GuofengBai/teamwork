package org.po;

import java.io.Serializable;


public class HallLoadingBills extends BillsPO{
	private String HallNum;
	private String TrafficNum;
	private String EndPlace;
	private String name;
	private String[] GoodsNum;
	
	public HallLoadingBills(myDate t,String id,String hn,String tn,String ep,String name,String[] gs){
		this.Date=t;
		this.idNum=id;
		this.HallNum=hn;
		this.TrafficNum=tn;
		this.EndPlace=ep;
		this.name=name;
		this.GoodsNum=gs;
	}
	
	public void setDate(myDate t){
		this.Date=t;
	}
	public myDate getDate(){
		return Date;
	}
	public void setHallNum(String s){
		this.HallNum=s;
	}
	public String getHallNum(){
		return HallNum;
	}
	public void setTravelNum(String s){
		this.idNum=s;
	}
	public String getTravelNum(){
		return this.idNum;
	}
	public void setTrafficNum(String s){
		this.TrafficNum=s;
	}
	public String getTrafficNum(){
		return TrafficNum;
	}
	public void setEndPlace(String s){
		this.EndPlace=s;
	}
	public String getEndPlace(){
		return EndPlace;
	}
	public void setname(String s){
		this.name=s;
	}
	public String getname(){
		return name;
	}
	public void setGoodsNum(String[] l){
		this.GoodsNum=l;
	}
	public String[] getGoodsNum(){
		return GoodsNum;
	}

}
