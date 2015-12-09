package org.businesslogicservice.manageblservice;

import java.util.Vector;
import org.po.myDate;
import org.vo.IncomeBillVO;
import org.vo.PayingBillVO;

public interface StatusTableBLService {
	/**
	 * 获取该日期段所有收款单
	 * 
	 * @param myDate
	 * @return ResultMessage
	 */
	public Vector<IncomeBillVO> searchIncomeBill (myDate date1,myDate date2);
	
	/**
	 * 获取该日期段所有付款单
	 * 
	 * @param myDate
	 * @return ResultMessage
	 */
	public Vector<PayingBillVO> searchPayingBill (myDate date1,myDate date2);

}
