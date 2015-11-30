package org.vo;

import org.po.STAFFROLE;



public class UserVO {
	
	public String account;
	private String password;
	public StaffVO staff;                     //与此账号对应的员工
	public STAFFROLE staffRole;               //职务
	
	public UserVO(){
		super();
	}
	
	public UserVO(String account,String password,StaffVO staff){
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
	
	public StaffVO getStaff(){
		return staff;
	}
	
	public STAFFROLE getStaffRole(){
		return staffRole;
	}
	
	public boolean setStaffRole(STAFFROLE sr){
		staffRole=sr;
		return true;
	}
	
	

}
