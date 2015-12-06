package org.vo;

import java.util.ArrayList;

import javax.swing.JPanel;

import org.po.CenterFreightBills;
import org.po.SENDSTYPE;
import org.po.StateListPO;
import org.po.myDate;
import org.presentation.billsui.NewCenterEntruckBillsUI;
import org.presentation.billsui.NewCenterFreightBillsUI;

public class CFBVO implements PanelCreaterService{
	public myDate date; 
	public String FreightNum;
	public String tramNum;
	public String StartPlace;
	public String EndPlace;
	public String caseNum;
	public String Scoutername;
	public long price;
	public SENDSTYPE send;
	public ArrayList<StateListPO> po;
	public CFBVO(myDate date, String FreightNum,
			String tramNum, String StartPlace, String EndPlace, String caseNum,
			String Scoutername, long price, SENDSTYPE send, ArrayList<StateListPO> po){
		this.date=date;
		this.FreightNum=FreightNum;
		this.tramNum=tramNum;
		this.StartPlace=StartPlace;
		this.EndPlace=EndPlace;
		this.caseNum=caseNum;
		this.Scoutername=Scoutername;
		this.price=price;
		this.send=send;
		this.po=po;		
	}
	public CFBVO(CenterFreightBills po){
		this.date=po.getdate();
		this.FreightNum=po.getidNum();
		this.tramNum=po.gettramNum();
		this.StartPlace=po.getStartPlace();
		this.EndPlace=po.getEndPlace();
		this.caseNum=po.getcaseNum();
		this.Scoutername=po.getScoutername();
		this.send=po.getsend();
		this.po=po.getpo();	
	}
	public JPanel careatePanel(JPanel su) {
		JPanel panel=new NewCenterFreightBillsUI(su,this);
		return panel;
	}
	

}
