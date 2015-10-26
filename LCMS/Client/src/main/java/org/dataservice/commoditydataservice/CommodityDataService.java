package org.dataservice.commoditydataservice;

import java.rmi.Remote;

import org.po.ComPO;
<<<<<<< HEAD

public interface CommodityDataService extends Remote{
	/**
	 * 添加ComPO
=======
import org.po.ResultMessage;

public interface CommodityDataService extends Remote{
	/**
	 * 娣诲姞ComPO
>>>>>>> origin/master
	 * @return ResultMessage
	 */
	public ResultMessage addCom(ComPO po);
	/**
<<<<<<< HEAD
	 * 删除ComPO
=======
	 * 鍒犻櫎ComPO
>>>>>>> origin/master
	 * @return ResultMessage
	 */
	public ResultMessage delCom(ComPO po);
	/**
<<<<<<< HEAD
	 * 查找DriverPO
	 * @param GoodsNum 托运单号
=======
	 * 鏌ユ壘DriverPO
	 * @param GoodsNum 鎵樿繍鍗曞彿
>>>>>>> origin/master
	 * @return ResultMessage
	 */
	public ComPO findCom(long GoodsNum);
}
