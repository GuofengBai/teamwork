package org.po;
import java.io.Serializable;


public class BeginAccountPO implements Serializable{
	private String accountName;
	private int balance;
	private String organization;//机构
	private int people;//人员
	private int car;//车辆
	private int storage;//库存
	
	public BeginAccountPO(String organization,int people,int car,int storage,String accountName,int balance){
		this.organization=organization;
		this.people=people;
		this.car=car;
		this.storage=storage;
		this.accountName=accountName;
		this.balance=balance;
	}
	
	public void setOrganization(String organization){
		this.organization=organization;
	}
	
	public String getOrganization(){
		return organization;
	}
	
	public void setPeople(int people){
		this.people=people;
	}
	
	public int getPeople(){
		return people;
	}
	
	public void setCar(int car){
		this.car=car;
	}
	
	public int getCar(){
		return car;
	}
	
	public void setStorage(int storage){
		this.storage=storage;
	}
	
	public int getStorage(){
		return storage;
	}
	
	public void setAccountName(String accountName){
		this.accountName=accountName;
	}
	
	public String getAccountName(){
		return accountName;
	}
	
	public void setBalance(int balance){
		this.balance=balance;
	}
	
	public int getBalance(){
		return balance;
	}
}
