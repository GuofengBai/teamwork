package org.po;

import java.util.ArrayList;



public class InstorageBills extends BillsPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String centerNum;
	private ArrayList<ComPO> list;
	public InstorageBills(myDate date,String idNum,String centerNum,ArrayList<ComPO> list){
		this.Date=date;
		this.idNum=idNum;
		this.centerNum=centerNum;
		this.list=list;
		this.type=BILLSTYPE.IB;
		this.Examined=false;
	}
	
	public String getidNum(){
		return idNum;
	}
	public myDate getdate(){
		return Date;
	}
	public String getcenterNum(){
		return centerNum;
	}
	public ArrayList<ComPO> getlist(){
		return list;
	}
	
	
}
