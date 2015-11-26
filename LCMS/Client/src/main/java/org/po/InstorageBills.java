package org.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.vo.CommodityVO;


public class InstorageBills extends BillsPO{
	private String centerNum;
	private ArrayList<CommodityVO> list;
	public InstorageBills(myDate date,String idNum,String centerNum,ArrayList<CommodityVO> list){
		this.Date=date;
		this.idNum=idNum;
		this.centerNum=centerNum;
		this.list=list;
	}
	
	public String getidNum(){
		return idNum;
	}
	public myDate getdate(){
		return Date;
	}
	public String getcenterNum(){
		return centerNum;
	}
	public ArrayList<CommodityVO> getlist(){
		return list;
	}
	
	
}
