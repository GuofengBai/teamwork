package org.businesslogicservice.manageblservice;

import java.util.Vector;

import org.po.HallCollectionBills;
import org.po.myDate;
import org.vo.IncomeBillVO;

public interface IncomeManagementBLService {
	public Vector<IncomeBillVO> incomeSearch (myDate date,String hallNumber);
}
