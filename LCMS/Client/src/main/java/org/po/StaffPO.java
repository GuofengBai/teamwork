package org.po;

import java.io.Serializable;

public class StaffPO implements Serializable{
	
	
	public UserPO user;
	public POSITION staffRole;
	public String name;
	public String num;
	public GENDER gender;
	public myDate birthday;
	public String location;
	public String phone;
	public String bankAccount;
	public WORKPLACE workSpace;
	public Payment payment;
	
	public StaffPO(){
		super();
	}
	
	public StaffPO(String name,String num,GENDER gender,myDate birthday,String location,String phone,String bankAccount,
			WORKPLACE workSpace,Payment payment,String ac,String password,POSITION staffRole){
		
		this.name=name;
		this.num=num;
		this.gender=gender;
		this.birthday=birthday;
		this.location=location;
		this.phone=phone;
		this.bankAccount=bankAccount;
		this.workSpace=workSpace;
		this.payment=payment;
		this.user=new UserPO(ac,password,this);
		
		
	}
	
	
	
	

}
