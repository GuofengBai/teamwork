package org.po;

public enum STAFFROLE {
	
	COURIER("快递员"),HALLSTAFF("营业厅业务员"),CENTERSTAFF("中转中心营业员"),STORAGESTAFF("中转中心仓库管理人员"),FINANCIALSTAFF("财务人员"),GENERALMANAGER("总经理"),ADMINISTRATOR("管理员");

	private String text;
	
	private STAFFROLE(String text){
		this.text=text;
	}
	
	public String getName(){
		return this.text;
	}
	
}
