package org.po;

import java.io.Serializable;
import java.util.ArrayList;



public class CenterArriveBills extends BillsPO{
	private String FreightNum;
	private ArrayList<StateListPO> po;
	public CenterArriveBills(myDate date, String FreightNum,
			String CenterNum, ArrayList<StateListPO> po){
		this.idNum=CenterNum;
		this.Date=date;
		this.FreightNum=FreightNum;
		this.po=po;
		this.type=BILLSTYPE.CAB;
		this.Examined=false;
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
	
	public ArrayList<StateListPO> getpo(){
		return po;
	}
}
