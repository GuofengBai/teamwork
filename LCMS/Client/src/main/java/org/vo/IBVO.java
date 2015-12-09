package org.vo;

import java.util.ArrayList;

import javax.swing.JPanel;

import org.po.ComPO;
import org.po.InstorageBills;
import org.po.myDate;
import org.presentation.billsui.NewInstorageBillsUI;

public class IBVO implements PanelCreaterService{
	public myDate date;
	public String idNum;
	public String centerNum;
	public ArrayList<ComPO> list;
	public IBVO(myDate date,String idNum, String centerNum, ArrayList<ComPO> list){
		this.date=date;
		this.idNum=idNum;
		this.centerNum=centerNum;
		this.list=list;
	}
	public IBVO(InstorageBills po){
		this.date=po.getdate();
		this.idNum=po.getidNum();
		this.centerNum=po.getcenterNum();
		this.list=po.getlist();
	}
	public JPanel careatePanel(JPanel su) {
		JPanel panel=new NewInstorageBillsUI(su,this);
		return panel;
	}

}
