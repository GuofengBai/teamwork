package org.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.vo.StateListVO;


public class HallCollectionBills extends BillsPO{
	private myDate date;
	private String name;
	private String total;
	private ArrayList<StateListVO> list;
	public HallCollectionBills(myDate date, String name, String total, ArrayList<StateListVO> list){
		this.date=date;
		this.name=name;
		this.total=total;
		this.list=list;
	}
	public myDate getdate(){
		return date;
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
