package org.po;

import java.io.Serializable;

public class BankAccountPO implements Serializable{
	private String name="";
	private int balance=0;
	
	public BankAccountPO(String name){
		this.name=name;
		this.balance=0;
	}
	
	public BankAccountPO(String name,int balance){
		this.name=name;
		this.balance=balance;
	}
	
	public void setBalance(int balance){
		this.balance=balance;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public int getBalance(){
		return balance;
	}
	
}
