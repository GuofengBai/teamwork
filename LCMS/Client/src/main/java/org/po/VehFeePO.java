package org.po;

public class VehFeePO {
	private int veh;
	private double fee;
	public VehFeePO(int veh,double fee){
		this.veh=veh;
		this.fee=fee;
	}
	public void setVeh(int s){
		this.veh=s;
	}
	public int getVeh(){
		return veh;
	}
	public void setFee(double s){
		this.fee=s;
	}
	public double getFee(){
		return fee;
	}

}
