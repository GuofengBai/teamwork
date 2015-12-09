package org.po;

import java.util.ArrayList;



public class HallEntruckBills extends BillsPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hallNum;
	private String aimNum;
	private String carNum;
	private String driverName;
	private ArrayList<StateListPO> list;
	public HallEntruckBills(myDate date, String entruckNum,
			String hallNum, String aimNum, String carNum, String driverName, ArrayList<StateListPO> list){
		this.Date=date;
		this.idNum=entruckNum;
		this.hallNum=hallNum;
		this.aimNum=aimNum;
		this.carNum=carNum;
		this.driverName=driverName;
		this.list=list;
		this.type=BILLSTYPE.HEB;
		this.Examined=false;
	}
	public myDate getdate(){
		return Date;
	}
	
	public String getidNum(){
		return idNum;
	}
	
	public String gethallNum(){
		return hallNum;
	}
	
	public String getaimNum(){
		return aimNum;
	}
	
	public String getcarNum(){
		return carNum;
	}
	
	public String getdriverName(){
		return driverName;
	}
	
	public ArrayList<StateListPO> getlist (){
		return list ;
	}
	

}
