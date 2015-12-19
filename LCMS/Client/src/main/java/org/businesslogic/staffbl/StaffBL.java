package org.businesslogic.staffbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import org.Client.RMIHelper;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.organizationblservice.CenterBLService;
import org.businesslogicservice.organizationblservice.HallBLService;
import org.businesslogicservice.staffblservice.StaffBLService;
import org.dataservice.staffdataservice.StaffDataService;
import org.po.ResultMessage;
import org.po.STAFFROLE;
import org.po.StaffPO;
import org.vo.CenterVO;
import org.vo.HallVO;
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
			if(temp!=null){
				String[] info={"添加错误，已存在同编号的员工"};
				return new ResultMessage(false,info);
			}
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(vo.staffRole==STAFFROLE.FINANCIALSTAFF||vo.staffRole==STAFFROLE.GENERALMANAGER
				||vo.staffRole==STAFFROLE.ADMINISTRATOR){
			if(!vo.workSpace.type.equals("总部")){
				String[] info={"财务人员、总经理、管理员的工作地点必须是总部（此时忽略地点编号）!"};
				return new ResultMessage(false,info);
			}
		}else if(vo.staffRole==STAFFROLE.COURIER||vo.staffRole==STAFFROLE.HALLSTAFF){
			if(!vo.workSpace.type.equals("营业厅")){
				String[] info={"快递员、营业厅业务员的工作地点必须是营业厅!"};
				return new ResultMessage(false,info);
			}
			
			HallBLService hall=BLFactory.getHallBL();
			HallVO hv=hall.findHall(vo.workSpace.num);
			if(hv==null){
				String[] info={"不存在编号为"+vo.workSpace.num+"的营业厅!"};
				return new ResultMessage(false,info);
			}
		}else{
			if(!vo.workSpace.type.equals("中转中心")){
				String[] info={"中转中心业务员、仓库管理员的工作地点必须是中转中心!"};
				return new ResultMessage(false,info);
			}
			
			CenterBLService center=BLFactory.getCenterBL();
			CenterVO cv=center.findCenter(vo.workSpace.num);
			if(cv==null){
				String[] info={"不存在编号为"+vo.workSpace.num+"的中转中心!"};
				return new ResultMessage(false,info);
			}
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
		
		if(vo.staffRole==STAFFROLE.FINANCIALSTAFF||vo.staffRole==STAFFROLE.GENERALMANAGER
				||vo.staffRole==STAFFROLE.ADMINISTRATOR){
			if(!vo.workSpace.type.equals("总部")){
				String[] info={"财务人员、总经理、管理员的工作地点必须是总部（此时忽略地点编号）!"};
				return new ResultMessage(false,info);
			}
		}else if(vo.staffRole==STAFFROLE.COURIER||vo.staffRole==STAFFROLE.HALLSTAFF){
			if(!vo.workSpace.type.equals("营业厅")){
				String[] info={"快递员、营业厅业务员的工作地点必须是营业厅!"};
				return new ResultMessage(false,info);
			}
			
			HallBLService hall=BLFactory.getHallBL();
			HallVO hv=hall.findHall(vo.workSpace.num);
			if(hv==null){
				String[] info={"不存在编号为"+vo.workSpace.num+"的营业厅!"};
				return new ResultMessage(false,info);
			}
		}else{
			if(!vo.workSpace.type.equals("中转中心")){
				String[] info={"中转中心业务员、仓库管理员的工作地点必须是中转中心!"};
				return new ResultMessage(false,info);
			}
			
			CenterBLService center=BLFactory.getCenterBL();
			CenterVO cv=center.findCenter(vo.workSpace.num);
			if(cv==null){
				String[] info={"不存在编号为"+vo.workSpace.num+"的中转中心!"};
				return new ResultMessage(false,info);
			}
		}
		
		StaffPO po=new StaffPO(vo.staffRole,vo.name,vo.num,vo.gender,vo.birthday,
				vo.location,vo.phone,vo.user,vo.bankAccount,vo.workSpace,vo.payment);
		try {
			staffData.update(po);
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
			StaffPO po=staffData.find(num);
			if(po!=null){
				return new StaffVO(po);
			}else{
				return null;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
