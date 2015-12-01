package org.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;



public class HallCollectionBills extends BillsPO{
	private String name;
	private String total;
	private String HallNum;
	private ArrayList<StateListPO> list;
	public HallCollectionBills(myDate date,String idNum, String name, String total, ArrayList<StateListPO> list){
		this.Date=date;
		this.idNum=idNum;
		this.HallNum=idNum.substring(0, 8);
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
	public Vector<String> getInfo(){
		Vector<String> v=new Vector<String>();
		v.add(type.getType());
		v.add(idNum);
		v.add(Date.toString());
		v.add(total);
		return v;
	}
	
	public String getHallNum(){
		return HallNum;
	}

}
