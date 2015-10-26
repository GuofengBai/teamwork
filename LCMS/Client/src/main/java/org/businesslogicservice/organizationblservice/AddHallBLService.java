package org.businesslogicservice.organizationblservice;

public interface AddHallBLService {
	/**
	 * 启动新增营业厅
	 * @param city中转中心编号
	 * @param CenterNum 营业厅编号
	 * @param name 营业厅名称
	 * @return 返回启动是否成功
	 */
	public boolean AddHallbl(int city, int CenterNum, String name);
}
