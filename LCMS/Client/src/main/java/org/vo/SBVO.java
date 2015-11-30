package org.vo;

import org.po.BOXSTYPE;
import org.po.SENDSTYPE;
import org.po.SendingBills;
import org.po.myDate;

public class SBVO { 
	public String sendername;
	public String receivername;
	public String senderphone;
	public String receiverphone;
	public String senderlocation;
	public String receiverlocation;
	public myDate date;
	public String goodsnumber;
	public BOXSTYPE box;
	public SENDSTYPE send;
	public String length;
	public String width;
	public String height;
	public String weight;
	public SBVO(String SenderName, 
			String ReceiverName, String SenderPhone, String 
			ReceiverPhone, String SenderLocation, String 
			ReceiverLocation, myDate date, String GoodsNum, 
			BOXSTYPE boxtype, SENDSTYPE sendtype, String length, 
			String width, String height, String weight){
		this.sendername=SenderName;
		this.receivername=ReceiverName;
		this.senderphone=SenderPhone;
		this.receiverphone=ReceiverPhone;
		this.senderlocation=SenderLocation;
		this.receiverlocation=ReceiverLocation;
		this.date=date;
		this.goodsnumber=GoodsNum;
		this.box=boxtype;
		this.send=sendtype;
		this.length=length;
		this.width=width;
		this.height=height;
		this.weight=weight;
	}
	public SBVO(SendingBills po){
		this.sendername=po.getSenderName();
		this.receivername=po.getReceiverName();
		this.senderphone=po.getSenderPhone();
		this.receiverphone=po.getReceiverPhone();
		this.senderlocation=po.getSenderLocation();
		this.receiverlocation=po.getReceiverLocation();
		this.date=po.getDate();
		this.goodsnumber=po.getidNum();
		this.box=po.getboxstype();
		this.send=po.getsendstype();
		this.length=po.getlength();
		this.width=po.getwidth();
		this.height=po.getheight();
		this.weight=po.getweight();
	}
}
