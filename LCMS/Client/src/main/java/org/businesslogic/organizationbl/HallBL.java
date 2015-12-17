package org.businesslogic.organizationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import org.Client.RMIHelper;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.organizationblservice.CenterBLService;
import org.businesslogicservice.organizationblservice.HallBLService;
import org.dataservice.organizationdataservice.HallDataService;
import org.po.HallPO;
import org.po.ResultMessage;
import org.vo.CenterVO;
import org.vo.HallVO;

public class HallBL implements HallBLService{

	public ResultMessage addHall(HallVO vo) {
		HallPO po=new HallPO(vo.get(0),vo.get(1),vo.get(2),vo.get(3));
		try {
			HallDataService hallData=RMIHelper.getDataFactory().getOrganizationDataFactory().getHallData();
		    if(hallData==null){
		    	String[] info={"网络错误，无法找到HallData"};
		    	return new ResultMessage(false,info);
		    }
		    
		    if(vo.get(1).charAt(3)=='0'){
		    	String[] info={"编号错误！营业厅编号第四位应该是1"};
		    	return new ResultMessage(false,info);
		    }
	
		    
		    CenterBLService centerBL=BLFactory.getCenterBL();
		    Vector<CenterVO> list=centerBL.getList();
		    boolean isOK=false;
		    String trueCityName=null;
		    for(CenterVO co:list){
		    	if((co.get(1).substring(0,3)).equals(vo.get(1).substring(0, 1))){
		    		isOK=true;
		    		trueCityName=co.get(2);
		    		break;
		    	}
		    }
		    if(!isOK){
		    	String[] info={"编号错误！营业厅编号前三位查找不到中转中心"};
		    	return new ResultMessage(false,info);
		    }
		    if(!(trueCityName.equals(vo.get(2)))){
		    	String[] info={"城市错误！营业厅编号前三位查找到的中转中心是"+trueCityName};
		    	return new ResultMessage(false,info);
		    }
			
		    
		    HallPO temp=hallData.findHall(vo.get(1));
		    if(temp!=null){
		    	String[] info={"添加错误，已存在同编号的营业厅"};
		    	return new ResultMessage(false,info);
		    }
		    
			hallData.addHall(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			String[] info={"添加错误，数据段发生错误"};
	    	return new ResultMessage(false,info);
		}
		return new ResultMessage(true,null);
	}

	public ResultMessage delHall(String HallNum) {
		try {
			
			HallDataService hallData=RMIHelper.getDataFactory().getOrganizationDataFactory().getHallData();
		    if(hallData==null){
		    	String[] info={"网络错误，无法找到HallData"};
		    	return new ResultMessage(false,info);
		    }
		   
		    HallPO temp=hallData.findHall(HallNum);
		    if(temp==null){
		    	String[] info={"删除错误，不存在该编号的营业厅"};
		    	return new ResultMessage(false,info);
		    }
		    
			hallData.delHall(HallNum);
		} catch (RemoteException e) {
			e.printStackTrace();
			String[] info={"删除错误，数据段发生错误"};
	    	return new ResultMessage(false,info);
		}
		return new ResultMessage(true,null);
	}

	public ResultMessage updateHall(HallVO vo) {
		HallPO po=new HallPO(vo.get(0),vo.get(1),vo.get(2),vo.get(3));
		try {
			HallDataService hallData=RMIHelper.getDataFactory().getOrganizationDataFactory().getHallData();
		    if(hallData==null){
		    	String[] info={"网络错误，无法找到HallData"};
		    	return new ResultMessage(false,info);
		    }
		   
		    HallPO temp=hallData.findHall(vo.get(1));
		    if(temp==null){
		    	String[] info={"更新错误，不存在该编号的营业厅"};
		    	return new ResultMessage(false,info);
		    }
		    
		    hallData.updateHall(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			String[] info={"更新错误，数据段发生错误"};
	    	return new ResultMessage(false,info);
		}
		return new ResultMessage(true,null);
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
