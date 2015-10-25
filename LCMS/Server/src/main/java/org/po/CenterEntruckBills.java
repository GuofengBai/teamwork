package org.po;
import java.io.Serializable;
public class CenterEntruckBills extends BillsPO{
	private String TravelNum;
	private int Date;
	private String TrafficNum;
	private String HallNum;
	private String Name;
	private long[] GoodsNum;
	public void setTravelNum(String s){
		this.TravelNum=s;
	}
	public String getTravelNum(){
		return TravelNum;
	}
	public void setDate(int t){
		this.Date=t;
	}
	public int getDate(){
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
	public void setGoodsNum(long[] l){
		this.GoodsNum=l;
	}
	public long[] getGoodsNum(){
		return GoodsNum;
	}
}
