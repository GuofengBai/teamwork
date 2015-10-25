package org.po;
import java.io.Serializable;
public class HallLoadingBills extends BillsPO{
	private int Date;
	private String HallNum;
	private String TravelNum;
	private String TrafficNum;
	private String EndPlace;
	private String name;
	private long[] GoodsNum;
	public void setDate(int t){
		this.Date=t;
	}
	public int getDate(){
		return Date;
	}
	public void setHallNum(String s){
		this.HallNum=s;
	}
	public String getHallNum(){
		return HallNum;
	}
	public void setTravelNum(String s){
		this.TravelNum=s;
	}
	public String getTravelNum(){
		return TravelNum;
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
	public void setGoodsNum(long[] l){
		this.GoodsNum=l;
	}
	public long[] getGoodsNum(){
		return GoodsNum;
	}

}
