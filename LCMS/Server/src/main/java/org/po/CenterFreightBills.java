package org.po;

import java.util.ArrayList;



public class CenterFreightBills extends BillsPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tramNum;
	private String caseNum;
	private String StartPlace;
	private String EndPlace;
	private String Scoutername;
	private long price;
	private SENDSTYPE send;
	private ArrayList<StateListPO> po;
	public CenterFreightBills(myDate date, String FreightNum,
			String tramNum, String StartPlace, String EndPlace, String caseNum,
			String Scoutername, long price, SENDSTYPE send, ArrayList<StateListPO> po){
		this.Date=date;
		this.idNum=FreightNum;
		this.tramNum=tramNum;
		this.caseNum=caseNum;
		this.StartPlace=StartPlace;
		this.EndPlace=EndPlace;
		this.Scoutername=Scoutername;
		this.price=price;
		this.send=send;
		this.po=po;
		this.type=BILLSTYPE.CFB;
		this.Examined=false;
	}
	public String getidNum(){
		return idNum;
	}
	public String gettramNum(){
		return tramNum;
	}
	public String getcaseNum(){
		return caseNum;
	}
	public String getStartPlace(){
		return StartPlace;
	}
	public String getEndPlace(){
		return EndPlace;
	}
	public String getScoutername(){
		return Scoutername;
	}
	public myDate getdate(){
		return Date;
	}
	public long getprice(){
		return price;
	}
	public SENDSTYPE getsend(){
		return send;
	}
	public ArrayList<StateListPO> getpo(){
		return po;
	}
}
