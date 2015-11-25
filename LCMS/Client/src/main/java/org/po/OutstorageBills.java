package org.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.vo.CommodityVO;


public class OutstorageBills extends BillsPO{
	private myDate date;
	private String centerNum;
	private String entruckNum;
	private ArrayList<CommodityVO> list;
	public OutstorageBills(myDate date, String centerNum, String entruckNum, ArrayList<CommodityVO> list){
		this.date=date;
		this.centerNum=centerNum;
		this.entruckNum=entruckNum;
		this.list=list;
	}
	public myDate getdate(){
		return date;
	}
	
	public String getcenterNum(){
		return centerNum;
	}
	
	public String getentruckNum(){
		return entruckNum;
	}
	public ArrayList<CommodityVO> getlist(){
		return list;
	}

}
