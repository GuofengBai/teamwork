package org.businesslogicservice.manageblservice;

import java.util.Vector;

import org.po.ResultMessage;
import org.vo.PayingBillVO;

public interface CostManagementBLService {
	public Vector<PayingBillVO> getAllBill();
	
	public ResultMessage delPayingBill();
}
