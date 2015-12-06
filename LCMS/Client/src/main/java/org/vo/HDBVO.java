package org.vo;

import javax.swing.JPanel;

import org.po.HallDispatchBills;
import org.po.myDate;
import org.presentation.billsui.NewCenterEntruckBillsUI;
import org.presentation.billsui.NewHallDispatchBillsUI;

public class HDBVO implements PanelCreaterService{
	public myDate date;
	public String idNum;
	public String name;
	public String GoodsNum;
	public HDBVO(myDate date,String idNum, String name,
			String GoodsNum){
		this.date=date;
		this.idNum=idNum;
		this.name=name;
		this.GoodsNum=GoodsNum;
	}
	public HDBVO(HallDispatchBills po){
		this.date=po.getDate();
		this.idNum=po.getidNum();
		this.name=po.getname();
		this.GoodsNum=po.getgoodNum();
	}
	public JPanel careatePanel(JPanel su) {
		JPanel panel=new NewHallDispatchBillsUI(su,this);
		return panel;
	}

}
