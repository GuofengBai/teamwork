package org.dataservice.commoditydataservice;

import java.rmi.Remote;

import org.po.ComPO;
import org.po.ResultMessage;


public interface CommodityDataService extends Remote{

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
	public ComPO findCom(String GoodsNum);
}
