package org.businesslogicservice.manageblservice;

import java.util.Vector;

import org.po.BeginAccountPO;
import org.po.ResultMessage;
import org.vo.BeginAccountVO;

public interface BeginAccountBLService {
	
	/**
	 * 获取当前期初账单
	 * 
	 * @return BeginAccountPO
	 */
	public BeginAccountPO getBeginAccount();
	
	/**
	 * 获取期初账单列表
	 * 
	 * @return Vector<BeginAccountVO>
	 */
	public Vector<BeginAccountVO> getBeginAccountList();
	
	/**
	 * 删除期初账单
	 * 
	 * @param BeginAccountPO
	 * @return ResultMessage
	 */
	public ResultMessage deleteAccount(BeginAccountPO account);
}
