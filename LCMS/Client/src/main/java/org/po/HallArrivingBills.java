package org.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.vo.StateListVO;


public class HallArrivingBills extends BillsPO{
	private String StartPlace;
	private String entruckNum;
	private ArrayList<StateListVO> list;
	public HallArrivingBills(myDate date,String idNum,String startPlace,String entruckNum ,ArrayList<StateListVO> list){
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
	
	public ArrayList<StateListVO> getlist(){
		return list;
	}

}
