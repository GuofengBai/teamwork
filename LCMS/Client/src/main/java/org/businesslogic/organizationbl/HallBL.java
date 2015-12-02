package org.businesslogic.organizationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import org.Client.RMIHelper;
import org.businesslogicservice.organizationblservice.HallBLService;
import org.dataservice.organizationdataservice.HallDataService;
import org.po.HallPO;
import org.vo.HallVO;

public class HallBL implements HallBLService{

	public boolean addHall(HallVO vo) {
		HallPO po=new HallPO(vo.get(0),vo.get(1),vo.get(2),vo.get(3));
		try {
			HallDataService hallData=RMIHelper.getDataFactory().getOrganizationDataFactory().getHallData();
		    hallData.addHall(po);
		    return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delHall(String HallNum) {
		try {
			HallDataService hallData=RMIHelper.getDataFactory().getOrganizationDataFactory().getHallData();
		    hallData.delHall(HallNum);
		    return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateHall(HallVO vo) {
		HallPO po=new HallPO(vo.get(0),vo.get(1),vo.get(2),vo.get(3));
		try {
			HallDataService hallData=RMIHelper.getDataFactory().getOrganizationDataFactory().getHallData();
		    hallData.updateHall(po);
		    return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Vector<HallVO> getList() {
		Vector<HallVO> vList=new Vector<HallVO>();
		ArrayList<HallPO> allList=null;
		try {
			HallDataService hallData=RMIHelper.getDataFactory().getOrganizationDataFactory().getHallData();
		    allList=hallData.getAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(HallPO po:allList){
			vList.add(new HallVO(po));
		}
		return vList;
	}

}
