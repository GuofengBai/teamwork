package org.vo;

import java.util.ArrayList;

import org.po.CenterArriveBills;
import org.po.StateListPO;
import org.po.myDate;

public class CABVO {
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

}
