package org.businesslogic.organizationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import org.Client.RMIHelper;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.commodityblservice.CommodityBLService;
import org.businesslogicservice.organizationblservice.CenterBLService;
import org.businesslogicservice.organizationblservice.ManagerSettingBLService;
import org.dataservice.organizationdataservice.CenterDataService;
import org.po.CenterPO;
import org.vo.CenterVO;

public class CenterBL implements CenterBLService{

	public boolean addCenter(CenterVO vo) {
		System.out.println(vo);
		CenterPO po=new CenterPO(vo.get(0),vo.get(1),vo.get(2));
		System.out.println("添加中转中心"+po.getname()+po.getCenterNum()+po.getLocation());
		try {
			CenterDataService centerData=RMIHelper.getDataFactory().getOrganizationDataFactory().getCenterData();
			centerData.addCenter(po);
			
//			ManagerSettingBLService manager=BLFactory.getManagerSettingBL();
//			manager.addCity(po.getname());
			
//			CommodityBLService combl=BLFactory.getCommodityBL();
//			combl.addCenter(po.getCenterNum());
			
			
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
		    CenterPO center=centerData.findCenter(CenterNum);
			centerData.delCenter(CenterNum);
			
			ManagerSettingBLService manager=BLFactory.getManagerSettingBL();
			manager.delCity(center.getname());
			
			CommodityBLService combl=BLFactory.getCommodityBL();
			combl.addCenter(CenterNum);
			
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
