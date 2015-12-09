package org.po;

import java.util.ArrayList;



public class HallArrivingBills extends BillsPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String StartPlace;
	private String entruckNum;
	private ArrayList<StateListPO> list;
	public HallArrivingBills(myDate date,String idNum,String startPlace,String entruckNum ,ArrayList<StateListPO> list, String StartPlace){
		this.Date=date;
		this.idNum=idNum;
		this.StartPlace=StartPlace;
		this.entruckNum=entruckNum;
		this.list=list;
		this.type=BILLSTYPE.HAB;
		this.Examined=false;
	}
	
	public String getidNum(){
		return idNum;
	}
	
	public myDate getdate(){
		return Date;
	}
	
	public String getStartPlace(){
		return StartPlace;
	}
	
	public String getentruckNum(){
		return entruckNum;
	}
	
	public ArrayList<StateListPO> getlist(){
		return list;
	}

}
