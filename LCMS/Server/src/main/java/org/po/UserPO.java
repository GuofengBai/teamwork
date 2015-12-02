package org.po;

import java.io.Serializable;

public class UserPO  implements Serializable{
	
	public String account;
	private String password;
	public StaffPO staff;
	// 与此账号对应的员工
	public String number;// 编号
	public STAFFROLE staffRole; // 职务

	public UserPO() {
		super();
	}

	public UserPO(String account, String password, String number) {
		this.account = account;
		this.password = password;
		this.number = number;
	}

	public String getAccount() {
		return account;
	}

	public String getPassword() {
		return password;
	}

	public boolean setPassword(String newpw) {
		password = newpw;
		return true;
	}

	public StaffPO getStaff() {
		return staff;
	}

	public STAFFROLE getStaffRole() {
		return staffRole;
	}

	public boolean setStaffRole(STAFFROLE sr) {
		staffRole = sr;
		return true;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
