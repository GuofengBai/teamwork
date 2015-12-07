package org.businesslogicservice.manageblservice;

import org.po.BeginAccountPO;
import org.po.ResultMessage;

public interface NewBeginAccountBLService {
	/**
	 * 新建期初账单
	 * 
	 * @param String,int,int,int,String,long
	 * @return ResultMessage
	 */
	public ResultMessage addBeginAccount(String organization,int people,int car,int storage,String accountname,long balance);
	
	/**
	 * 初始化
	 * 
	 * @param BeginAccountPO
	 * @return 
	 */
	public void accountInitilize(BeginAccountPO account);
}
