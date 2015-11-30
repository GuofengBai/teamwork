package org.vo;

import org.po.HallDispatchBills;
import org.po.myDate;

public class HDBVO {
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

}
