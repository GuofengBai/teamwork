package org.vo;

import java.util.ArrayList;

import org.po.HallArrivingBills;
import org.po.StateListPO;
import org.po.myDate;

public class HABVO {
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
}
