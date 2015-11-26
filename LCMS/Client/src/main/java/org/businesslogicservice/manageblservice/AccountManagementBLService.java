package org.businesslogicservice.manageblservice;

import java.util.ArrayList;
import java.util.Vector;

import org.po.BankAccountPO;
import org.po.ResultMessage;
import org.po.UserPO;
import org.vo.BankAccountVO;

public interface AccountManagementBLService {
	public Vector<BankAccountVO> getAccountList ();
	
	public ResultMessage addAccount(String name);
	
	public int getBalance(String name);
	
	public ResultMessage delAccount(String name);
	
	public ResultMessage changeName(String name,String newname);
	
	public ResultMessage changeBalance (String name,int change);
	
	public Vector<BankAccountVO> accountSearch(String namepart);
	
	public boolean check (UserPO user);
}
