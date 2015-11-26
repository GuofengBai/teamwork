package org.businesslogic.staffbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import org.Client.RMIHelper;
import org.businesslogicservice.staffblservice.StaffBLService;
import org.dataservice.staffdataservice.StaffDataService;
import org.po.ResultMessage;
import org.po.StaffPO;
import org.vo.StaffVO;

public class StaffBL implements StaffBLService{

	public ResultMessage newStaff(StaffVO vo) {
		StaffPO po=new StaffPO(vo);
		StaffDataService staffData=null;
		try {
			staffData=RMIHelper.getDataFactory().getStaffData();
			if(staffData==null){
				String[] info={"连接错误","无法取得staffDataService"};
				return new ResultMessage(false,info);
			}
			return staffData.add(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage deleteStaff(String num) {
		StaffDataService staffData=null;
		try {
			staffData=RMIHelper.getDataFactory().getStaffData();
			if(staffData==null){
				String[] info={"连接错误","无法取得staffDataService"};
				return new ResultMessage(false,info);
			}
			return staffData.remove(num);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage updateStaff(StaffVO vo) {
		StaffPO po=new StaffPO(vo);
		StaffDataService staffData=null;
		try {
			staffData=RMIHelper.getDataFactory().getStaffData();
			if(staffData==null){
				String[] info={"连接错误","无法取得staffDataService"};
				return new ResultMessage(false,info);
			}
			return staffData.update(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<StaffVO> getAllStaff() {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector<Vector<String>> getListData() {
		StaffDataService staffData=null;
		try {
			staffData=RMIHelper.getDataFactory().getStaffData();
			return staffData.getAllStaffInfo();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public StaffVO findStaff(String num) {
		StaffDataService staffData=null;
		try {
			staffData=RMIHelper.getDataFactory().getStaffData();
			if(staffData==null){
				String[] info={"连接错误","无法取得staffDataService"};
				return null;
			}
			StaffVO vo=new StaffVO(staffData.find(num));
			return vo;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
