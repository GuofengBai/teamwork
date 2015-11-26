package org.po;

import java.io.Serializable;
import java.util.Vector;

import org.vo.StaffVO;

public class StaffPO implements Serializable{
	
	
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
	
	public StaffPO(){
		super();
	}
	
	public StaffPO(STAFFROLE role,String name,String num,GENDER gender,myDate birthday,String location,String phone,String user,String bankAccount,WorkSpace space,Payment payment){
		
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
	
	public StaffPO(StaffVO vo){
		super();
		this.name=vo.name;
		this.num=vo.num;
		this.gender=vo.gender;
		this.birthday=vo.birthday;
		this.location=vo.location;
		this.phone=vo.phone;
		this.bankAccount=vo.bankAccount;
		this.workSpace=vo.workSpace;
		this.payment=vo.payment;
		this.user=vo.user;
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
