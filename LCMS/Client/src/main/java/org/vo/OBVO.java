package org.vo;

import java.util.ArrayList;

import javax.swing.JPanel;

import org.po.ComPO;
import org.po.OutstorageBills;
import org.po.myDate;
import org.presentation.billsui.NewOutstorageBillsUI;

public class OBVO implements PanelCreaterService{
	public myDate date;
	public String centerNum;
	public String entruckNum;
	public ArrayList<ComPO> list;
	public OBVO(myDate date, String centerNum, String entruckNum, ArrayList<ComPO> list){
		this.date=date;
		this.centerNum=centerNum;
		this.entruckNum=entruckNum;
		this.list=list;
	}
	public OBVO(OutstorageBills po){
		this.date=po.getdate();
		this.centerNum=po.getcenterNum();
		this.entruckNum=po.getidNum();
		this.list=po.getlist();
	}
	public JPanel careatePanel(JPanel su) {
		JPanel panel=new NewOutstorageBillsUI(su,this);
		return panel;
	}

}
