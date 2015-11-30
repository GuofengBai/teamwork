package org.vo;

import java.util.Vector;

import org.po.PayingBills;
import org.po.myDate;

public class PayingBillVO extends Vector<String>{
	public PayingBillVO(myDate date,long cash,String name,String accountName){
		this.add(date.toString());
		this.add(String.valueOf(cash));
		this.add(name);
		this.add(accountName);
	}
	
	public PayingBillVO(PayingBills bill){
		this.add(bill.getDate().toString());
		this.add(String.valueOf(bill.getCash()));
		this.add(bill.getname());
		this.add(bill.getPayNum());
		
		
	}
	
}
