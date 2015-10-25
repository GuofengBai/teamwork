package org.po;
import java.io.Serializable;

public class HallPO implements Serializable {
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;

	private int HallNum;// 营业厅编号，三位城市+1位+三位编号
	private String cityName;// 城市名称
	private double[] distanceToOtherCities;// 到其他城市的距离，数组长度为当前城市数

	public HallPO(int HallNum, String cityName, double[] distanceToOtherCities) {
		this.HallNum = HallNum;
		this.cityName = cityName;
		this.distanceToOtherCities = distanceToOtherCities;
	}

	public int getHallNum() {
		return HallNum;
	}

	public String getcityName() {
		return cityName;
	}

	public double[] getdistanceToOtherCities() {
		return distanceToOtherCities;
	}

	public void setHallNum(int HallNum) {
		this.HallNum = HallNum;
		// 不知道哪用
	}

	public void setdistanceToOtherCities(double[] distanceToOtherCities) {
		this.distanceToOtherCities = distanceToOtherCities;
		// 改变城市间距离时用
	}
	public void del(){
		
	}
}