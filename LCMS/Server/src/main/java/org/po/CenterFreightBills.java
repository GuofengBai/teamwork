package org.po;

import java.io.Serializable;


public class CenterFreightBills extends BillsPO{
	private String BillNum;
	private myDate Date;
	private String ContainerNum;
	private String Means;
	private String Name;
	private String StartPlace;
	private String EndPlace;
	private long[] GoodsNum;	
	public void setBillNum(String s){
		this.BillNum=s;
	}
	public String getBillNum(){
		return BillNum;
	}
	public void setDate(myDate t){
		this.Date=t;
	}
	public myDate getDate(){
		return Date;
	}
	public void setContainerNum(String s){
		this.ContainerNum=s;
	}
	public String getContainerNum(){
		return ContainerNum;
	}
	public void setMeans(String s){
		this.Means=s;
	}
	public String getMeans(){
		return Means;
	}
	public void setName(String s){
		this.Name=s;
	}
	public String getName(){
		return Name;
	}
	public void setStartPlace(String s){
		this.StartPlace=s;
	}
	public String getStartPlace(){
		return StartPlace;
	}
	public void setEndPlace(String s){
		this.EndPlace=s;
	}
	public String getEndPlace(){
		return EndPlace;
	}
	public void setGoodsNum(long[] l){
		this.GoodsNum=l;
	}
	public long[] getGoodsNum(){
		return GoodsNum;
	}
}
