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
import org.po.ResultMessage;
import org.vo.CenterVO;

public class CenterBL implements CenterBLService{

	public ResultMessage addCenter(CenterVO vo) {
		
		try {
			CenterDataService centerData=RMIHelper.getDataFactory().getOrganizationDataFactory().getCenterData();
			if(centerData==null){
				String[] info={"网络错误，无法获得CenterData"};
				return new ResultMessage(false,info);
			}
			
			if(vo.get(1).length()!=7){
				String[] info={"中转中心编号必须是7位！"};
				return new ResultMessage(false,info);
			}
			
			if(vo.get(1).charAt(3)!='0'){
				String[] info={"中转中心编号第四位必须是‘0’！"};
				return new ResultMessage(false,info);
			}
			
			CenterPO temp=centerData.findCenter(vo.get(1));
			if(temp!=null){
				String[] info={"添加错误，已存在该编号的中转中心"};
				return new ResultMessage(false,info);
			}
			
			Vector<CenterVO> list=getList();
			for(CenterVO co:list){
				if(co.get(1).substring(0,3).equals(vo.get(1).substring(0,3))){
					String[] info={"区号（前三位）显示该城市已有中转中心！"};
					return new ResultMessage(false,info);
				}
				if(co.get(0).equals(vo.get(0))){
					String[] info={co.get(0)+"已有中转中心！"};
					return new ResultMessage(false,info);
				}
			}
			
			
			
			CenterPO po=new CenterPO(vo.get(0),vo.get(1),vo.get(2));
			centerData.addCenter(po);
			
			ManagerSettingBLService manager=BLFactory.getManagerSettingBL();
			manager.addCity(po.getname());
			
			CommodityBLService combl=BLFactory.getCommodityBL();
			combl.addCenter(po.getCenterNum());
			
		} catch (RemoteException e) {
			e.printStackTrace();
			String[] info={"添加错误，数据端发生错误"};
			return new ResultMessage(false,info);
		}
		return new ResultMessage(true,null);
	}

	public ResultMessage delCenter(String CenterNum) {
		try {
			
			CenterDataService centerData=RMIHelper.getDataFactory().getOrganizationDataFactory().getCenterData();
			if(centerData==null){
				String[] info={"网络错误，无法获得CenterData"};
				return new ResultMessage(false,info);
			}
		    
			CenterPO temp=centerData.findCenter(CenterNum);
			if(temp==null){
				String[] info={"删除错误，不存在该编号的中转中心"};
				return new ResultMessage(false,info);
			}
			
			centerData.delCenter(CenterNum);
			
			ManagerSettingBLService manager=BLFactory.getManagerSettingBL();
			manager.delCity(temp.getname());
			
			CommodityBLService combl=BLFactory.getCommodityBL();
			combl.delCenter(CenterNum);
			
		} catch (RemoteException e) {
			e.printStackTrace();
			String[] info={"添加错误，数据端发生错误"};
			return new ResultMessage(false,info);
		}
		return new ResultMessage(true,null);
	}

	public ResultMessage updateCenter(CenterVO vo) {
		
		try {
			CenterDataService centerData=RMIHelper.getDataFactory().getOrganizationDataFactory().getCenterData();
			if(centerData==null){
				String[] info={"网络错误，无法获得CenterData"};
				return new ResultMessage(false,info);
			}
		    
			CenterPO temp=centerData.findCenter(vo.get(1));
			if(temp==null){
				String[] info={"更新错误，不存在该编号的中转中心"};
				return new ResultMessage(false,info);
			}
			
			CenterPO po=new CenterPO(vo.get(0),vo.get(1),vo.get(2));
			centerData.updateCenter(po);
		    
		} catch (RemoteException e) {
			e.printStackTrace();
			String[] info={"添加错误，数据端发生错误"};
			return new ResultMessage(false,info);
		}
		return new ResultMessage(true,null);
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
