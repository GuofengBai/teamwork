package org.po;

public enum BILLSTYPE{
	CAB("中转中心到达单"),CFB("中转中心中专单"),CEB("中转中心装车单"),IB("入库单"),OB("出库单"),HAB("营业厅到达单"),HDB("派件单"),HCB("收款单"),HEB("营业厅装车单"),SB("寄件单"),PB("付款单");
	
	private String type;
	
	private BILLSTYPE(String s){
		this.type=s;
	}
	
	public String getType(){
		return type;
	}
}
