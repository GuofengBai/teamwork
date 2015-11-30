package org.businesslogicservice.billsblservice;

import java.util.Vector;

import org.po.ResultMessage;

public interface ExamineBillsBLService {

	public ResultMessage examineBills(String type,String idNum);
	
	public Vector<Vector<String>> getAllUnExaminedBills();
}
