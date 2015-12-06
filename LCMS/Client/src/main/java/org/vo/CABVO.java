package org.vo;

import java.util.ArrayList;

import javax.swing.JPanel;

import org.po.CenterArriveBills;
import org.po.StateListPO;
import org.po.myDate;
import org.presentation.billsui.NewCenterArriveBillsUI;

public class CABVO implements PanelCreaterService{
	public myDate date;
	public String FreightNum;
	public String CenterNum;
	public ArrayList<StateListPO> po;
	public CABVO(myDate date, String FreightNum,
			String CenterNum, ArrayList<StateListPO> po){
		this.date=date;
		this.FreightNum=FreightNum;
		this.CenterNum=CenterNum;
		this.po=po;
	}
	public CABVO(CenterArriveBills po){
		this.date=po.getdate();
		this.FreightNum=po.getFreightNum();
		this.CenterNum=po.getidNum();
		this.po=po.getpo();
	}
	public JPanel careatePanel(JPanel su) {
		JPanel panel=new NewCenterArriveBillsUI(su,this);
		return panel;
	}

}
