package org.po;

public class SendingBills extends BillsPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String SenderName;
	private String ReceiverName;
	private String SenderPhone;
	private String ReceiverPhone;
	private String SenderLocation;
	private String ReceiverLocation;
	private BOXSTYPE boxtype;
	private SENDSTYPE sendtype;
	private String length;
	private String width;
	private String height;
	private String weight;
	private EXPRESSSTATE expressState;
	private myDate arriveDate;
	private String ReceiverNameReal;

	public SendingBills() {
		super();
	}

	public SendingBills(String SenderName, String ReceiverName,
			String SenderPhone, String ReceiverPhone, String SenderLocation,
			String ReceiverLocation, myDate date, String GoodsNum,
			BOXSTYPE boxtype, SENDSTYPE sendtype, String length, String width,
			String height, String weight) {

		this.SenderName = SenderName;

		this.ReceiverName = ReceiverName;

		this.SenderPhone = SenderPhone;

		this.ReceiverPhone = ReceiverPhone;

		this.SenderLocation = SenderLocation;

		this.ReceiverLocation = ReceiverLocation;

		this.idNum = GoodsNum;

		this.Date = date;
		this.expressState = EXPRESSSTATE.LOCALHALL;

		this.type = BILLSTYPE.SB;

		this.boxtype = boxtype;

		this.sendtype = sendtype;
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
		this.Examined=false;
	}
	public void setdate(myDate t){
		this.Date=t;
	}
	public myDate getDate() {
		return Date;
	}

	public void setsendtype(SENDSTYPE t){
		this.sendtype=t;
	}
	public SENDSTYPE getsendstype(){
		return sendtype;
	}
	public void setboxstype(BOXSTYPE t){
		this.boxtype=t;
	}
	public BOXSTYPE getboxstype(){
		return boxtype;
	}

	public void setidNum(String l){
		this.idNum=l;
	}

	public String getidNum(){
		return idNum;
	}

	public void setSenderName(String s){
		this.SenderName=s;
	}

	public String getSenderName(){
		return SenderName;
	}

	public void setReceiverName(String s){
		this.ReceiverName=s;
	}

	public String getReceiverName(){
		return ReceiverName;
	}

	public void setSenderPhone(String s){
		this.SenderPhone=s;
	}
	public String getSenderPhone(){
		return SenderPhone;
	}
	public void setReceiverPhone(String s){
		this.ReceiverPhone=s;
	}
	public String getReceiverPhone(){
		return ReceiverPhone;
	}
	
	public void setSenderLocation(String s){
		this.SenderLocation=s;
	}

	public String getSenderLocation(){
		return SenderLocation;
	}

	public void setReceiverLocation(String s){
		this.ReceiverLocation=s;
	}
	public String getReceiverLocation(){
		return ReceiverLocation;
	}
	
	
	public void setlength(String s){
		this.length=s;
	}
	public String getlength(){
		return length;
	}
	
	public void setwidth(String s){
		this.width=s;
	}
	public String getwidth(){
		return width;
	}
	
	public void setheight(String s){
		this.height=s;
	}
	public String getheight(){
		return height;
	}
	
	public void setweight(String s){
		this.weight=s;
	}
	public String getweight(){
		return weight;
	}
	public void setExpressState(EXPRESSSTATE state){
		this.expressState=state;
		System.out.println("searvice");
	}
	
	public EXPRESSSTATE getState(){
		return expressState;
	}
	
	public void setArriveDate(myDate d){
		this.arriveDate=d;
	}
	
	public myDate getArriveDate(){
		return arriveDate;
	}
	
	public void setReceiverNameReal(String s){
		this.ReceiverNameReal=s;
	}
	
	public String getReceiverNameReal(){
		return ReceiverNameReal;
	}
}
