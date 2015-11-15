package org.po;

import java.io.Serializable;

public class UserPO  implements Serializable{
	
	public String account;
	private String password;
	public StaffPO staff;                     //与此账号对应的员工
	public POSITION staffRole;               //职务
	
	public UserPO(){
		super();
	}
	
	public UserPO(String account,String password,StaffPO staff){
		this.account=account;
		this.password=password;
		this.staff=staff;
		this.staffRole=staff.staffRole;
	}
	
	public String getAccount(){
		return account;
	}
	
	public String getPassword(){
		return password;
	}
	
	public boolean setPassword(String newpw){
		password=newpw;
		return true;
	}
	
	public StaffPO getStaff(){
		return staff;
	}
	
	public POSITION getStaffRole(){
		return staffRole;
	}
	
	public boolean setStaffRole(POSITION sr){
		staffRole=sr;
		return true;
	}
	
	

}
