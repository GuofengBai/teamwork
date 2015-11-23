package org.po;

import java.io.Serializable;
import java.util.Vector;

public class StaffPO implements Serializable{
	
	
	public UserPO user;
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
	
	public StaffPO(){
		super();
	}
	
	public StaffPO(String name,String num,GENDER gender,myDate birthday,String location,String phone,String bankAccount,
			WorkSpace workSpace,Payment payment,String ac,String password,STAFFROLE staffRole){
		
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
	
	public Vector<String> getInfo(){
		Vector<String> info=new Vector<String>();
		info.add(staffRole.toString());
		info.add(name);
		info.add(num);
		info.add(workSpace.toString());
		return info;
	}
	
	
	
	

}
