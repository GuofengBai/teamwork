package org.vo;

import java.util.ArrayList;

import javax.swing.JPanel;

import org.po.HallEntruckBills;
import org.po.StateListPO;
import org.po.myDate;
import org.presentation.billsui.NewCenterEntruckBillsUI;
import org.presentation.billsui.NewHallEntruckBillsUI;

public class HEBVO implements PanelCreaterService{
	public myDate date;
	public String entruckNum;
	public String hallNum;
	public String aimNum;
	public String carNum;
	public String driverName;
	public ArrayList<StateListPO> list;
	public HEBVO(myDate date, String entruckNum,
			String hallNum, String aimNum, String carNum, String driverName, ArrayList<StateListPO> list){
		this.date=date;
		this.entruckNum=entruckNum;
		this.hallNum=hallNum;
		this.aimNum=aimNum;
		this.carNum=carNum;
		this.driverName=driverName;
		this.list=list;
	}
	public HEBVO(HallEntruckBills po){
		this.date=po.getdate();
		this.entruckNum=po.getidNum();
		this.hallNum=po.gethallNum();
		this.aimNum=po.getaimNum();
		this.carNum=po.getcarNum();
		this.driverName=po.getdriverName();
		this.list=po.getlist();
	}
	public JPanel careatePanel(JPanel su) {
		JPanel panel=new NewHallEntruckBillsUI(su,this);
		return panel;
	}

}
