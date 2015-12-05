package org.businesslogic.organizationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import org.Client.RMIHelper;
import org.businesslogicservice.organizationblservice.CenterBLService;
import org.dataservice.organizationdataservice.CenterDataService;
import org.dataservice.organizationdataservice.HallDataService;
import org.po.CenterPO;
import org.po.HallPO;
import org.vo.CenterVO;
import org.vo.HallVO;

public class CenterBL implements CenterBLService{

	public boolean addCenter(CenterVO vo) {
		CenterPO po=new CenterPO(vo.get(0),vo.get(1),vo.get(2));
		try {
			CenterDataService centerData=RMIHelper.getDataFactory().getOrganizationDataFactory().getCenterData();
		    centerData.addCenter(po);
		    return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delCenter(String CenterNum) {
		try {
			CenterDataService centerData=RMIHelper.getDataFactory().getOrganizationDataFactory().getCenterData();
		    centerData.delCenter(CenterNum);
		    return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateCenter(CenterVO vo) {
		CenterPO po=new CenterPO(vo.get(0),vo.get(1),vo.get(2));
		try {
			CenterDataService centerData=RMIHelper.getDataFactory().getOrganizationDataFactory().getCenterData();
		    centerData.updateCenter(po);
		    return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Vector<CenterVO> getList() {
		Vector<CenterVO> vList=new Vector<CenterVO>();
		ArrayList<CenterPO> allList=null;
		try {
			CenterDataService centerData=RMIHelper.getDataFactory().getOrganizationDataFactory().getCenterData();
		    allList=centerData.getAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(CenterPO po:allList){
			vList.add(new CenterVO(po));
		}
		return vList;
	}


}
