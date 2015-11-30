package org.vo;

import java.util.ArrayList;

import org.po.ComPO;
import org.po.InstorageBills;
import org.po.myDate;

public class IBVO {
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

}
