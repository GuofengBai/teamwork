package org.businesslogicservice.commodityblservice;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import org.po.ComPO;
import org.vo.CommodityVO;

public interface DistrictChangeBLService {
	public ComPO change(String from,String to) throws RemoteException;
	public Vector<CommodityVO> getDistrictCommodity(String from) throws RemoteException;
	public void changeDistrict(CommodityVO vo) throws RemoteException;
	public List<String> getArea() throws RemoteException;
}
