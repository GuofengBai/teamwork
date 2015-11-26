package org.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.vo.StateListVO;


public class CenterEntruckBills extends BillsPO{
	private String HallNum;
	private String Vehicle;
	private String DriverName;
	private String ScouterName;
	private ArrayList<StateListVO> vo;
	public CenterEntruckBills(myDate date, String TrafficNum,
			String HallNum, String Vehicle, String DriverName,
			String ScouterName, ArrayList<StateListVO> vo){
		this.Date=date;
		this.idNum=TrafficNum;
		this.HallNum=HallNum;
		this.Vehicle=Vehicle;
		this.DriverName=DriverName;
		this.ScouterName=ScouterName;
		this.vo=vo;
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
	public ArrayList<StateListVO> getvo(){
		return vo;
	}
}
