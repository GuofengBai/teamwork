package org.vo;

import java.util.Vector;

import org.po.BeginAccountPO;

public class BeginAccountVO extends Vector<String>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BeginAccountVO(String organization,int people,int car,int storage,String accountName,long balance){
		this.add(organization);
		this.add(String.valueOf(people));
		this.add(String.valueOf(car));
		this.add(String.valueOf(storage));
		this.add(accountName);
		this.add(String.valueOf(balance));
	
	}
	
	public BeginAccountVO(BeginAccountPO account){
		this.add(account.getOrganization());
		this.add(String.valueOf(account.getPeople()));
		this.add(String.valueOf(account.getCar()));
		this.add(String.valueOf(account.getStorage()));
		this.add(account.getAccountName());
		this.add(String.valueOf(account.getBalance()));
	}
	
}
