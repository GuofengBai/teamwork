package org.businesslogic.organizationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import org.Client.CurrentStaff;
import org.Client.RMIHelper;
import org.businesslogicservice.organizationblservice.HallDriverBLService;
import org.dataservice.organizationdataservice.DriverAndCarDataService;
import org.po.DriverPO;
import org.po.ResultMessage;
import org.vo.DriverVO;

public class HallDriverBL implements HallDriverBLService {

	public ResultMessage addDriver(DriverPO po) {
		
		DriverAndCarDataService data=null;
		try {
			data=RMIHelper.getDataFactory().getOrganizationDataFactory().getDriverAndCarData();
			if(data==null){
				String[] info={"网络连接错误！"};
				return new ResultMessage(false,info);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		try {
			DriverPO temp=data.findDriver(po.getdriverNum());
			if(temp!=null){
				String[] info={"已存在同编号司机！"};
				return new ResultMessage(false,info);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			data.addDriver(po);
		}catch (RemoteException e) {
			e.printStackTrace();
			String[] info={"数据端发生错误!"};
			return new ResultMessage(false,info);
		}
		return new ResultMessage(true,null);
	}

	public ResultMessage delDriver(String DriverNum) {
		DriverAndCarDataService data=null;
		try {
			data=RMIHelper.getDataFactory().getOrganizationDataFactory().getDriverAndCarData();
			if(data==null){
				String[] info={"网络连接错误！"};
				return new ResultMessage(false,info);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		try {
			DriverPO temp=data.findDriver(DriverNum);
			if(temp==null){
				String[] info={"不存在该编号的司机！"};
				return new ResultMessage(false,info);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		try{
			data.delCar(DriverNum);
		}catch (RemoteException e) {
			e.printStackTrace();
			String[] info={"数据端发生错误!"};
			return new ResultMessage(false,info);
		}
		return new ResultMessage(true,null);
	}

	public Vector<DriverVO> getList() {
		ArrayList<DriverPO> gl = null;
		Vector<DriverVO> list=new Vector<DriverVO>();
		
		try {
			DriverAndCarDataService data=RMIHelper.getDataFactory().getOrganizationDataFactory().getDriverAndCarData();
			gl=data.findDriverByHall(CurrentStaff.getStaff().workSpace.num);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		for(DriverPO po:gl){
			list.add(new DriverVO(po));
		}
		
		return list;
	}

}
