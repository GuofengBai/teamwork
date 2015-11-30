package org.businesslogicservice.manageblservice;

import java.util.Vector;

import org.po.HallCollectionBills;
import org.po.PayingBills;
import org.po.myDate;
import org.vo.IncomeBillVO;
import org.vo.PayingBillVO;

public interface StatusTableBLService {
	public Vector<IncomeBillVO> searchIncomeBill (myDate date1,myDate date2);
	
	public Vector<PayingBillVO> searchPayingBill (myDate date1,myDate date2);

}
