package org.businesslogic.managebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import org.Client.RMIHelper;
import org.businesslogicservice.manageblservice.AccountManagementBLService;
import org.dataservice.managedataservice.AccountManagementDataService;
import org.po.BankAccountPO;
import org.po.ResultMessage;
import org.po.UserPO;
import org.test.dataservice.manageData.AccountManagementData;
import org.vo.BankAccountVO;

public class AccountManagementBL implements AccountManagementBLService{
	
	
	public Vector<BankAccountVO> getAccountList()  {
		// TODO Auto-generated method stub
		AccountManagementDataService amd;
		ArrayList<BankAccountPO> list=new ArrayList<BankAccountPO>();
		Vector<BankAccountVO> volist=new Vector<BankAccountVO>();
		
		try {
			amd = RMIHelper.getDataFactory().getManageDataFactory().getAccountManagementData();
			list=amd.getAccountList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(BankAccountPO account:list){
			BankAccountVO votemp=new BankAccountVO(account);
			volist.add(votemp);
		}
	
		return volist;
	}

	public ResultMessage addAccount(String name) {
		// TODO Auto-generated method stub
		String[] infotemp={"Failed","Exception"};
		ResultMessage message=new ResultMessage(false,infotemp);
		
		AccountManagementDataService amd;
		try {
			amd = RMIHelper.getDataFactory().getManageDataFactory().getAccountManagementData();
			BankAccountPO account=new BankAccountPO(name);
			message=amd.addAccount(account);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public long getBalance(String name) {
		// TODO Auto-generated method stub
		long result=0;
		
		AccountManagementDataService amd;
		try {
			amd = RMIHelper.getDataFactory().getManageDataFactory().getAccountManagementData();
			result=amd.getBalance(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public ResultMessage delAccount(String name) {
		// TODO Auto-generated method stub
		String[] infotemp={"Failed","Exception"};
		ResultMessage message=new ResultMessage(false,infotemp);
		
		AccountManagementDataService amd;
		try {
			amd = RMIHelper.getDataFactory().getManageDataFactory().getAccountManagementData();
			message=amd.delAccount(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public ResultMessage changeName(String name, String newname) {
		// TODO Auto-generated method stub
		String[] infotemp={"Failed","Exception"};
		ResultMessage message=new ResultMessage(false,infotemp);
		
		AccountManagementDataService amd;
		try {
			amd = RMIHelper.getDataFactory().getManageDataFactory().getAccountManagementData();
			message=amd.changeName(name, newname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public ResultMessage changeBalance(String name, long change) {
		// TODO Auto-generated method stub
		String[] infotemp={"Failed","Exception"};
		ResultMessage message=new ResultMessage(false,infotemp);
		
		AccountManagementDataService amd;
		try {
			amd = RMIHelper.getDataFactory().getManageDataFactory().getAccountManagementData();
			message=amd.changeBalance(name, change);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message;
		
	}

	public Vector<BankAccountVO> accountSearch(String namepart) {
		// TODO Auto-generated method stub
		ArrayList<BankAccountPO> list=new ArrayList<BankAccountPO>();
		
		AccountManagementDataService amd;
		try {
			amd = RMIHelper.getDataFactory().getManageDataFactory().getAccountManagementData();
			list=amd.search(namepart);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Vector<BankAccountVO> volist=new Vector<BankAccountVO>();
		for(BankAccountPO account:list){
			BankAccountVO votemp=new BankAccountVO(account);
			volist.add(votemp);
		}
		
		return volist;
	}

	public boolean check(UserPO user) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
