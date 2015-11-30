package org.businesslogicservice.commodityblservice;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import org.po.ComPO;
import org.po.ResultMessage;
import org.vo.CommodityVO;

public interface DistrictChangeBLService {
	public ResultMessage change(String from,String to,int index,String location) throws RemoteException;
	public Vector<CommodityVO> getDistrictCommodity(String centerNum,String from) throws RemoteException;
	public ResultMessage changeDistrict(CommodityVO vo) throws RemoteException;
	public List<String> getArea(String centerNum) throws RemoteException;
	//public Vector<CommodityVO> getEmpty(String centerNum,String to) throws RemoteException;
}
