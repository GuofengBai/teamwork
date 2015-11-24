package org.vo;

import org.po.myDate;

public class CommodityVO {
	private String GoodsNum;// ���˵���
	private String date;// �������
	private String place;// Ŀ�ĵ�
	private String LocationNum;// �����źżܺ�λ��
	private String area;

	public CommodityVO(String GoodsNum, myDate inDate, String place, String LocationNum,String area) {
		this.GoodsNum = GoodsNum;
		this.date = String.valueOf(inDate.year)+String.valueOf(inDate.month)+String.valueOf(inDate.day);
		this.place = place;
		this.LocationNum = LocationNum;
		this.area=area;
	}
}
