package org.vo;

import java.util.ArrayList;

import org.po.ComPO;
import org.po.OutstorageBills;
import org.po.myDate;

public class OBVO {
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

}
