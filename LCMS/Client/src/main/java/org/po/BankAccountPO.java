package org.po;

import java.io.Serializable;

public class BankAccountPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name="";
	private long balance=0;
	
	public BankAccountPO(String name){
		this.name=name;
		this.balance=0;
	}
	
	public BankAccountPO(String name,long balance){
		this.name=name;
		this.balance=balance;
	}
	
	public void setBalance(long balance){
		this.balance=balance;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public long getBalance(){
		return balance;
	}
	
}
