package org.po;

public enum SENDSTYPE {
	SLOW("经济"),NORMAL("一般"),FAST("特快");
	
	private String state;
	
	private SENDSTYPE(String state){
		this.state=state;
	}
	
	public String getState(){
		return state;
	}

}
