package org.businesslogicservice.commodityblservice;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import org.po.ComPO;
import org.po.ResultMessage;
import org.vo.CommodityVO;

public interface DistrictChangeBLService {
	/**
	 * 库区调整
	 * @param from原库区
	 * @param to新库区
	 * @param index table中的位置
	 * @param location 新区排架位
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage change(String from,String to,int index,String location) throws RemoteException;
	/**
	 * 返回table中可显示的货物信息
	 * @param centerNum 中转中心编号
	 * @param from 新库区
	 * @return
	 * @throws RemoteException
	 */
	public Vector<CommodityVO> getDistrictCommodity(String centerNum,String from) throws RemoteException;
	/**
	 * 库区调整
	 */
	public ResultMessage changeDistrict(CommodityVO vo) throws RemoteException;
	/**
	 * 获得当前仓库存在的区
	 * @param centerNum
	 * @return
	 * @throws RemoteException
	 */
	public List<String> getArea(String centerNum) throws RemoteException;
	//public Vector<CommodityVO> getEmpty(String centerNum,String to) throws RemoteException;
}
