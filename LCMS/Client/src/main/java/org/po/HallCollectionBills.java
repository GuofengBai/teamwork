package org.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.vo.StateListVO;


public class HallCollectionBills extends BillsPO{
	private String name;
	private String total;
	private ArrayList<StateListVO> list;
	public HallCollectionBills(myDate date,String idNum, String name, String total, ArrayList<StateListVO> list){
		this.Date=date;
		this.idNum=idNum;
		this.name=name;
		this.total=total;
		this.list=list;
	}
	
	public String getidNum(){
		return idNum;
	}
	
	public myDate getdate(){
		return Date;
	}
	
	public String gettotal(){
		return total;
	}
	public String getname(){
		return name;
	}
	public ArrayList<StateListVO> getlist(){
		return list;
	}

}
