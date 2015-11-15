package org.po;

public class theGoodState {
	private String GoodNum;
	private State state;
	public void setGoodNum(String s){
		this.GoodNum=s;
	}
	public String getGoodNum(){
		return GoodNum;
	}
	public void setState(State s){
		this.state=s;
	}
	public State getState(){
		return state;
	}

}
