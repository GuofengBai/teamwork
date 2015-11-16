package org.po;
import java.io.Serializable;

public class ComPO implements Serializable {
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;
	private String GoodsNum;// ���˵���
	private myDate inDate;// �������
	private String place;// Ŀ�ĵ�
	private String LocationNum;// �����źżܺ�λ��

	public ComPO(String GoodsNum, myDate inDate, String place, String LocationNum) {
		this.GoodsNum = GoodsNum;
		this.inDate = inDate;
		this.place = place;
		this.LocationNum = LocationNum;
	}

	public ComPO() {
		super();
	}

	public String getGoodsNum() {
		return GoodsNum;
	}

	public myDate getinDate() {
		return inDate;
	}

	public String getplace() {
		return place;
	}

	public String LocationNum() {
		return LocationNum;

	}

	public void setLocationNum(String LocationNum) {
		this.LocationNum = LocationNum;
		// 库区调整使用
	}

	public void setGoodsNum(String GoodsNum) {
		this.GoodsNum = GoodsNum;
		// 不知道哪用，有可能用吧
	}
	public void del(){
		
	}
}
