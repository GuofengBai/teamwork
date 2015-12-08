package org.po;

public enum BOXSTYPE {
	Paper("纸箱"),Box("木箱"),Bag("纸袋");
	private String state;
	
	private BOXSTYPE(String state){
		this.state=state;
	}
	
	public String getState(){
		return state;
	}

}
