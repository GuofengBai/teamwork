package org.vo;

import java.util.ArrayList;

import javax.swing.JPanel;

import org.po.HallCollectionBills;
import org.po.StateListPO;
import org.po.myDate;
import org.presentation.billsui.NewHallCollectionBillsUI;

public class HCBVO implements PanelCreaterService{
	public myDate date;
	public String idNum;
	public String name;
	public String total;
	public ArrayList<StateListPO> list;
	public HCBVO(myDate date,String idNum, String name, String total, ArrayList<StateListPO> list){
		this.date=date;
		this.idNum=idNum;
		this.name=name;
		this.total=total;
		this.list=list;
	}
	public HCBVO(HallCollectionBills po){
		this.date=po.getdate();
		this.idNum=po.getidNum();
		this.name=po.getname();
		this.total=po.gettotal();
		this.list=po.getlist();
	}
	
	public JPanel careatePanel(JPanel su) {
		JPanel panel=new NewHallCollectionBillsUI(su,this);
		return panel;
	}

}
