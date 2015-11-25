package org.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.vo.CommodityVO;


public class InstorageBills extends BillsPO{
	private myDate date;
	private String centerNum;
	private ArrayList<CommodityVO> list;
	public InstorageBills(myDate date,String centerNum,ArrayList<CommodityVO> list){
		this.date=date;
		this.centerNum=centerNum;
		this.list=list;
	}
	public myDate getdate(){
		return date;
	}
	public String getcenterNum(){
		return centerNum;
	}
	public ArrayList<CommodityVO> getlist(){
		return list;
	}
	
	
}
