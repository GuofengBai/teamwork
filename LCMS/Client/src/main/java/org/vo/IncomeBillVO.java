package org.vo;

import java.util.Vector;

import org.po.HallCollectionBills;
import org.po.myDate;

public class IncomeBillVO extends Vector<String>{
	public IncomeBillVO(myDate date ,String total,String name){
		this.add(date.toString());
		this.add(total);
		this.add(name);
	}
	
	public IncomeBillVO(HallCollectionBills bill){
		this.add(bill.getdate().toString());
		this.add(bill.gettotal());
		this.add(bill.getname());
	}
	
}
