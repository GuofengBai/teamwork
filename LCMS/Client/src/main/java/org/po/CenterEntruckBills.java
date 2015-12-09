package org.po;

import java.util.ArrayList;



public class CenterEntruckBills extends BillsPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String HallNum;
	private String Vehicle;
	private String DriverName;
	private String ScouterName;
	private ArrayList<StateListPO> po;
	public CenterEntruckBills(myDate date, String TrafficNum,
			String HallNum, String Vehicle, String DriverName,
			String ScouterName, ArrayList<StateListPO> po){
		this.Date=date;
		this.idNum=TrafficNum;
		this.HallNum=HallNum;
		this.Vehicle=Vehicle;
		this.DriverName=DriverName;
		this.ScouterName=ScouterName;
		this.po=po;
		this.type=BILLSTYPE.CEB;
		this.Examined=false;
	}
	public myDate getDate(){
		return Date;
	}
	public String getidNum(){
		return idNum;
	}
	public String getHallNum(){
		return HallNum;
	}
	public String getVehicle(){
		return Vehicle;
	}
	public String getDriverName(){
		return DriverName;
	}
	public String getScouterName(){
		return ScouterName;
	}
	public ArrayList<StateListPO> getpo(){
		return po;
	}
}
