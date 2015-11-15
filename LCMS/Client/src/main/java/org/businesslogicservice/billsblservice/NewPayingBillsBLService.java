package org.businesslogicservice.billsblservice;

import java.util.ArrayList;

import org.po.ResultMessage;
import org.po.myDate;

public interface NewPayingBillsBLService {
	
	public ResultMessage addPayingBills(myDate date, String name, String PayNum);

	public ArrayList addItem(String Item, String cash);
	
	public ArrayList deleteItem(String Item);
}
