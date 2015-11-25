package org.vo;

import java.util.Vector;

import org.po.myDate;

public class CommodityVO extends Vector<String> {

	public CommodityVO(String GoodsNum, myDate inDate, String place,
			String LocationNum, String area,String city) {
		this.add(GoodsNum);
		this.add(String.valueOf(inDate.year) +"/"+ String.valueOf(inDate.month)
				+ "/"+String.valueOf(inDate.day));
		this.add(place);
		this.add(area);
		this.add(LocationNum.substring(0, 1));
		this.add(LocationNum.substring(1, 2));
		this.add(LocationNum.substring(2, 3));
		this.add(LocationNum.substring(3, 4));
		this.add(city);
	}

	public String getGoodsNum() {
		return this.get(0);
	}
	public String getyear(){
		String year;
		String[] temp;
		temp=this.get(1).split("/");
		year=temp[0];
		return year;
	}
	public String getmonth(){
		String month;
		String[] temp;
		temp=this.get(1).split("/");
		month=temp[1];
		return month;
	}
	public String getday(){
		String day;
		String[] temp;
		temp=this.get(1).split("/");
		day=temp[2];
		return day;
	}

	public String getDate() {
		return this.get(1);
	}

	public String getplace() {
		return this.get(2);

	}

	public String getLocation() {
		return this.get(4)+this.get(5)+this.get(6)+this.get(7);
	}

	public String getarea() {
		return this.get(3);
	}
	public String getcity(){
		return this.get(8);
	}
}
