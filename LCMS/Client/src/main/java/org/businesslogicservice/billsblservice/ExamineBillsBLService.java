package org.businesslogicservice.billsblservice;

import java.util.Vector;

import org.po.ResultMessage;
import org.vo.PanelCreaterService;

public interface ExamineBillsBLService {

	public ResultMessage examineBills(String type,String idNum);
	
	public Vector<Vector<String>> getAllUnExaminedBills();
	
	public PanelCreaterService getPanelCreater(String type,String idNum);
}
