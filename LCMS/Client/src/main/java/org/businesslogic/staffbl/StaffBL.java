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
		
		StaffDataService staffData=null;
		try {
			staffData=RMIHelper.getDataFactory().getStaffData();
			if(staffData==null){
				String[] info={"连接错误,无法取得staffDataService"};
				return new ResultMessage(false,info);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		try{
			StaffPO temp=null;
			temp=staffData.find(vo.num);
			if(temp==null){
				String[] info={"添加错误，已存在同编号的员工"};
				return new ResultMessage(false,info);
			}
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		
		StaffPO po=new StaffPO(vo.staffRole,vo.name,vo.num,vo.gender,vo.birthday,
				vo.location,vo.phone,vo.user,vo.bankAccount,vo.workSpace,vo.payment);
		try {
			staffData.add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			String[] info={"添加失败，数据端发生错误"};
			return new ResultMessage(false,info);
		}
		
		return new ResultMessage(true,null);
	}

	public ResultMessage deleteStaff(String num) {
		StaffDataService staffData=null;
		try {
			staffData=RMIHelper.getDataFactory().getStaffData();
			if(staffData==null){
				String[] info={"连接错误,无法取得staffDataService"};
				return new ResultMessage(false,info);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		try{
			StaffPO temp=null;
			temp=staffData.find(num);
			if(temp==null){
				String[] info={"删除错误，不存在该编号的员工"};
				return new ResultMessage(false,info);
			}
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		
		try {
			staffData.remove(num);
		} catch (RemoteException e) {
			e.printStackTrace();
			String[] info={"删除失败，数据端发生错误"};
			return new ResultMessage(false,info);
		}
		
		return new ResultMessage(true,null);
	}

	public ResultMessage updateStaff(StaffVO vo) {
		
		StaffDataService staffData=null;
		try {
			staffData=RMIHelper.getDataFactory().getStaffData();
			if(staffData==null){
				String[] info={"连接错误,无法取得staffDataService"};
				return new ResultMessage(false,info);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		try{
			StaffPO temp=null;
			temp=staffData.find(vo.num);
			if(temp==null){
				String[] info={"更新错误，不存在该编号的员工"};
				return new ResultMessage(false,info);
			}
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		
		StaffPO po=new StaffPO(vo.staffRole,vo.name,vo.num,vo.gender,vo.birthday,
				vo.location,vo.phone,vo.user,vo.bankAccount,vo.workSpace,vo.payment);
		try {
			staffData.add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			String[] info={"更改失败，数据端发生错误"};
			return new ResultMessage(false,info);
		}
		
		return new ResultMessage(true,null);
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
				//String[] info={"连接错误","无法取得staffDataService"};
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
