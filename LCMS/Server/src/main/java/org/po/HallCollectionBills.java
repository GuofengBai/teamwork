package org.po;

import java.io.Serializable;
import java.util.ArrayList;



public class HallCollectionBills extends BillsPO{
	private String name;
	private String total;
	private ArrayList<StateListPO> list;
	public HallCollectionBills(myDate date,String idNum, String name, String total, ArrayList<StateListPO> list){
		this.Date=date;
		this.idNum=idNum;
		this.name=name;
		this.total=total;
		this.list=list;
		this.type=BILLSTYPE.HCB;
		this.Examined=false;
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
	public ArrayList<StateListPO> getlist(){
		return list;
	}

}
