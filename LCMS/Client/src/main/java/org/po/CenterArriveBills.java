package org.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.vo.StateListVO;


public class CenterArriveBills extends BillsPO{
	private String FreightNum;
	private ArrayList<StateListVO> vo;
	public CenterArriveBills(myDate date, String FreightNum,
			String CenterNum, ArrayList<StateListVO> vo){
		this.idNum=CenterNum;
		this.Date=date;
		this.FreightNum=FreightNum;
		this.vo=vo;
		this.type=BILLSTYPE.CAB;
	}
	public String getidNum(){
		return idNum;
	}
	
	public myDate getdate(){
		return Date;
	}
	
	public String getFreightNum(){
		return FreightNum;
	}
	
	public ArrayList<StateListVO> getvo(){
		return vo;
	}
}
