package org.businesslogicservice.manageblservice;

import java.util.Vector;

import org.po.PayingBills;
import org.po.ResultMessage;
import org.vo.PayingBillVO;

public interface CostManagementBLService {
	/**
	 * 获取付款单列表
	 * 
	 * @return Vector<PayingBillVO>
	 */
	public Vector<PayingBillVO> getAllBill();
	
	/**
	 * 修改付款单
	 * 
	 * @param String
	 * @param PayingBills
	 * @return ResultMessage
	 */
	public ResultMessage changeBill(String index,PayingBills newBill);
	
	/**
	 * 删除付款单
	 * 
	 * @param String
	 * @return ResultMessage
	 */
	public ResultMessage delBill(String index);
}
