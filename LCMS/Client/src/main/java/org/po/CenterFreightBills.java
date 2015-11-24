package org.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.vo.StateListVO;


public class CenterFreightBills extends BillsPO{
	private myDate date;
	private String FreightNum;
	private String tramNum;
	private String caseNum;
	private String StartPlace;
	private String EndPlace;
	private String Scoutername;
	private long price;
	private SENDSTYPE send;
	private ArrayList<StateListVO> vo;
	public CenterFreightBills(myDate date, String FreightNum,
			String tramNum, String StartPlace, String EndPlace, String caseNum,
			String Scoutername, long price, SENDSTYPE send, ArrayList<StateListVO> vo){
		this.date=date;
		this.FreightNum=FreightNum;
		this.tramNum=tramNum;
		this.caseNum=caseNum;
		this.StartPlace=StartPlace;
		this.EndPlace=EndPlace;
		this.Scoutername=Scoutername;
		this.price=price;
		this.send=send;
		this.vo=vo;
	}
	public String getFreightNum(){
		return FreightNum;
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
		return date;
	}
	public long getprice(){
		return price;
	}
	public SENDSTYPE getsend(){
		return send;
	}
	public ArrayList<StateListVO> getvo(){
		return vo;
	}
}
