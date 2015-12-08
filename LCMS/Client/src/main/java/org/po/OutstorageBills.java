package org.po;

import java.io.Serializable;
import java.util.ArrayList;



public class OutstorageBills extends BillsPO{
	private String centerNum;
	private ArrayList<ComPO> list;
	public OutstorageBills(myDate date, String centerNum, String entruckNum, ArrayList<ComPO> list){
		this.Date=date;
		this.centerNum=centerNum;
		this.idNum=entruckNum;
		this.list=list;
		this.type=BILLSTYPE.OB;
		this.Examined=false;
	}
	public myDate getdate(){
		return Date;
	}
	
	public String getcenterNum(){
		return centerNum;
	}
	
	public String getidNum(){
		return idNum;
	}
	public ArrayList<ComPO> getlist(){
		return list;
	}

}
