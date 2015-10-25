package org.dataservice.commoditydataservice;

import java.rmi.Remote;

import org.po.ComPO;

public interface CommodityDataService extends Remote{
	/**
	 * 添加ComPO
	 * @return ResultMessage
	 */
	public ResultMessage addCom(ComPO po);
	/**
	 * 删除ComPO
	 * @return ResultMessage
	 */
	public ResultMessage delCom(ComPO po);
	/**
	 * 查找DriverPO
	 * @param GoodsNum 托运单号
	 * @return ResultMessage
	 */
	public ComPO findCom(long GoodsNum);
}
