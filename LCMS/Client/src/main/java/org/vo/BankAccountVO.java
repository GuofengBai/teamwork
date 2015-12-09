package org.vo;

import java.util.Vector;

import org.po.BankAccountPO;

public class BankAccountVO extends Vector<String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BankAccountVO(String name,long balance){
		this.add(name);
		this.add(String.valueOf(balance));
	}
	
	public BankAccountVO(BankAccountPO account){
		this.add(account.getName());
		this.add(String.valueOf(account.getBalance()));
	}
	
	public String getName(){
		return this.get(0);
	}
	
	public long getBalance(){
		return Long.parseLong(this.get(1));
	}
	
}
