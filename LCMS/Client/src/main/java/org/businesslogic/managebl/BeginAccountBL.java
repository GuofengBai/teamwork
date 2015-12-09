package org.businesslogic.managebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import org.Client.RMIHelper;
import org.businesslogicservice.manageblservice.BeginAccountBLService;
import org.dataservice.managedataservice.BeginAccountDataService;
import org.po.BeginAccountPO;
import org.po.ResultMessage;
import org.vo.BeginAccountVO;

public class BeginAccountBL implements BeginAccountBLService {

	public BeginAccountPO getBeginAccount() {
		// TODO Auto-generated method stub
		BeginAccountPO account=new BeginAccountPO(null, 0, 0, 0, null, 0);
		
		BeginAccountDataService bd;
		try {
			bd = RMIHelper.getDataFactory().getManageDataFactory().getBeginAccountData();
			account=bd.getBeginAccount();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return account;
	}
	
	public Vector<BeginAccountVO> getBeginAccountList(){
		
		ArrayList<BeginAccountPO> list=new ArrayList<BeginAccountPO>();
		Vector<BeginAccountVO> volist=new Vector<BeginAccountVO>();
		try {
			BeginAccountDataService bd=RMIHelper.getDataFactory().getManageDataFactory().getBeginAccountData();
			list=bd.getBeginAccountList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(BeginAccountPO account:list){
			BeginAccountVO votemp=new BeginAccountVO(account);
			volist.add(votemp);
		}
		
		return volist;
	}

	public ResultMessage deleteAccount(BeginAccountPO account) {
		// TODO Auto-generated method stub
		String[] infotemp={"Failed","Exception"};
		ResultMessage message=new ResultMessage(false,infotemp);
		
		try {
			BeginAccountDataService bd=RMIHelper.getDataFactory().getManageDataFactory().getBeginAccountData();
			message=bd.deleteAccount(account);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message;
	}

	
}
