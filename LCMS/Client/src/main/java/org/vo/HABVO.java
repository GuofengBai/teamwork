package org.vo;

import java.util.ArrayList;

import javax.swing.JPanel;

import org.po.HallArrivingBills;
import org.po.StateListPO;
import org.po.myDate;
import org.presentation.billsui.NewCenterEntruckBillsUI;
import org.presentation.billsui.NewHallArriveBillsUI;

public class HABVO implements PanelCreaterService{
	public myDate date;
	public String idNum;
	public String startPlace;
	public String entruckNum;
	public ArrayList<StateListPO> list;
	public HABVO(myDate date,String idNum, String startPlace,String entruckNum ,ArrayList<StateListPO> list){
		this.date=date;
		this.idNum=idNum;
		this.startPlace=startPlace;
		this.entruckNum=entruckNum;
		this.list=list;
	}
	public HABVO(HallArrivingBills po){
		this.date=po.getdate();
		this.idNum=po.getidNum();
		this.startPlace=po.getStartPlace();
		this.entruckNum=po.getentruckNum();
		this.list=po.getlist();		
	}
	
	public JPanel careatePanel(JPanel su) {
		JPanel panel=new NewHallArriveBillsUI(su,this);
		return panel;
	}
}
