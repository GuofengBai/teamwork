package org.businesslogicservice.manageblservice;

import java.util.ArrayList;
import java.util.Vector;

import org.po.BankAccountPO;
import org.po.UserPO;
import org.vo.BankAccountVO;

public interface AccountManagementBLService {
	public Vector<BankAccountVO> getAccountList ();
	
	public void addAccount(String name);
	
	public int getBalance(String name);
	
	public void delAccount(String name);
	
	public void changeName(String name,String newname);
	
	public void changeBalance (String name,int change);
	
	public Vector<BankAccountVO> accountSearch(String namepart);
	
	public boolean check (UserPO user);
}
