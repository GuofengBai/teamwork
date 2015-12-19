package org.businesslogic.organizationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import org.Client.CurrentStaff;
import org.Client.RMIHelper;
import org.businesslogicservice.organizationblservice.HallCarBLService;
import org.dataservice.organizationdataservice.DriverAndCarDataService;
import org.po.CarPO;
import org.po.ResultMessage;
import org.vo.CarVO;

public class HallCarBL implements HallCarBLService{

	public ResultMessage addCar(CarPO po) {

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
			CarPO temp=data.findCar(po.getcarNum());
			if(temp!=null){
				String[] info={"已存在同编号车辆！"};
				return new ResultMessage(false,info);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			data.addCar(po);
		}catch (RemoteException e) {
			e.printStackTrace();
			String[] info={"数据端发生错误!"};
			return new ResultMessage(false,info);
		}
		return new ResultMessage(true,null);
		
	}

	public ResultMessage delCar(String CarNum) {
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
			CarPO temp=data.findCar(CarNum);
			if(temp==null){
				String[] info={"不存在该编号的车辆！"};
				return new ResultMessage(false,info);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		try{
			data.delCar(CarNum);
		}catch (RemoteException e) {
			e.printStackTrace();
			String[] info={"数据端发生错误!"};
			return new ResultMessage(false,info);
		}
		return new ResultMessage(true,null);
	}

	public Vector<CarVO> getList() {
		ArrayList<CarPO> gl = null;
		Vector<CarVO> list=new Vector<CarVO>();
		
		try {
			DriverAndCarDataService data=RMIHelper.getDataFactory().getOrganizationDataFactory().getDriverAndCarData();
			gl=data.findCarByHall(CurrentStaff.getStaff().workSpace.num);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		for(CarPO po:gl){
			list.add(new CarVO(po));
		}
		
		return list;
	}

}
