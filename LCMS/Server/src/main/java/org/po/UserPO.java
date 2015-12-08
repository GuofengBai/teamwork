package org.po;

import java.io.Serializable;

public class UserPO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String account;
	private String password;
	private String staffNumber;

	public UserPO() {
		super();
	}

	public UserPO(String account, String password, String number) {
		this.account = account;
		this.password = password;
		this.staffNumber = number;
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

	public String getNumber() {
		return staffNumber;
	}

	public void setNumber(String number) {
		this.staffNumber = number;
	}

}
