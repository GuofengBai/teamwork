package org.po;

public enum EXPRESSSTATE {
	
	LOCALHALL("到达当地营业厅"),LOCALCENTER("到达当地中转中心"),LOCALTOTARGET("从当地中转中心发往目的地中转中心"),TARGETCENTER("到达目的地中转中心"),TARGETHALL("到达目的地营业厅"),DISPATCH("派件中"),RECEIVED("已接收");
	
	private String state;
	
	private EXPRESSSTATE(String state){
		this.state=state;
	}
	
	public String getState(){
		return state;
	}

}
