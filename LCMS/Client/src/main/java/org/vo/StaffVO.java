package org.vo;

import org.po.GENDER;
import org.po.Payment;
import org.po.STAFFROLE;
import org.po.StaffPO;
import org.po.WorkSpace;
import org.po.myDate;


public class StaffVO {
	
	public String user;
	public STAFFROLE staffRole;
	public String name;
	public String num;
	public GENDER gender;
	public myDate birthday;
	public String location;
	public String phone;
	public String bankAccount;
	public WorkSpace workSpace;
	public Payment payment;
	
	public StaffVO(){
		super();
	}
	
	public StaffVO(STAFFROLE role,String name,String num,GENDER gender,myDate birthday,String location,String phone,String user,String bankAccount,WorkSpace space,Payment payment){
		super();
		this.name=name;
		this.num=num;
		this.gender=gender;
		this.birthday=birthday;
		this.location=location;
		this.phone=phone;
		this.bankAccount=bankAccount;
		this.workSpace=space;
		this.payment=payment;
		this.user=user;
		
	}
	
	public StaffVO(StaffPO po){
		super();
		this.name=po.name;
		this.num=po.num;
		this.gender=po.gender;
		this.birthday=po.birthday;
		this.location=po.location;
		this.phone=po.phone;
		this.bankAccount=po.bankAccount;
		this.workSpace=po.workSpace;
		this.payment=po.payment;
		this.user=po.user;
	}

}
