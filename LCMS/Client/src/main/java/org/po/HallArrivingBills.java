package org.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.vo.StateListVO;


public class HallArrivingBills extends BillsPO{
	private myDate date;
	private String StartPlace;
	private String entruckNum;
	private ArrayList<StateListVO> list;
	public HallArrivingBills(myDate date,String startPlace,String entruckNum ,ArrayList<StateListVO> list){
		this.date=date;
		this.StartPlace=StartPlace;
		this.entruckNum=entruckNum;
		this.list=list;
	}
	
	public myDate getdate(){
		return date;
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
