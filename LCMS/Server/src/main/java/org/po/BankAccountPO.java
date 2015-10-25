package org.po;

import java.io.Serializable;

public class BankAccountPO implements Serializable{
	private String name="";
	private int balance=0;
	
	public BankAccountPO(String name){
		this.name=name;
	}
	
	public void balanceCal(){
		
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public int getbalance(){
		return balance;
	}
	
}
