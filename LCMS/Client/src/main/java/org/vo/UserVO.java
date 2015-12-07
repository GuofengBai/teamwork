package org.vo;

import java.util.Vector;

import org.po.STAFFROLE;
import org.po.UserPO;



public class UserVO extends Vector<String>{
	
	public UserVO(String account,String staffNumber){
		super();
		this.add(account);
		this.add(staffNumber);
	}
	
	public UserVO(UserPO po){
		super();
		this.add(po.getAccount());
		this.add(po.getNumber());
	}
	

}
