package org.businesslogic.managebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import org.Client.RMIHelper;
import org.businesslogicservice.manageblservice.AccountManagementBLService;
import org.dataservice.managedataservice.AccountManagementDataService;
import org.po.BankAccountPO;
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

	public void addAccount(String name) {
		// TODO Auto-generated method stub
		AccountManagementDataService amd;
		try {
			amd = RMIHelper.getDataFactory().getManageDataFactory().getAccountManagementData();
			BankAccountPO account=new BankAccountPO(name);
			amd.addAccount(account);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public int getBalance(String name) {
		// TODO Auto-generated method stub
		
		AccountManagementData amd=new AccountManagementData();
		return amd.getBalance(name);
	}

	public void delAccount(String name) {
		// TODO Auto-generated method stub
		AccountManagementDataService amd;
		try {
			amd = RMIHelper.getDataFactory().getManageDataFactory().getAccountManagementData();
			amd.delAccount(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void changeName(String name, String newname) {
		// TODO Auto-generated method stub
		AccountManagementDataService amd;
		try {
			amd = RMIHelper.getDataFactory().getManageDataFactory().getAccountManagementData();
			amd.changeName(name, newname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void changeBalance(String name, int change) {
		// TODO Auto-generated method stub
		AccountManagementData amd=new AccountManagementData();
		amd.changeBalance(name, change);
		
		
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
