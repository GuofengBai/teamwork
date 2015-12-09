package org.businesslogicservice.manageblservice;

import java.util.Vector;

import org.po.myDate;
import org.vo.IncomeBillVO;

public interface IncomeManagementBLService {
	/**
	 * 查找收款单
	 * 
	 * @param myDate,String
	 * @return Vector<IncomeBillVO>
	 */
	public Vector<IncomeBillVO> incomeSearch (myDate date,String hallNumber);
}
