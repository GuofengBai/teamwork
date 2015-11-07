package org.businesslogicservice.organizationblservice;

import org.po.HallPO;

public interface HallBLService {
	/**
	 * 启动新增营业厅
	 * @param city中转中心编号
	 * @param CenterNum 营业厅编号
	 * @param name 营业厅名称
	 * @return 返回启动是否成功
	 */
	public HallPO AddHallbl(int city, int CenterNum, String name);
	/**
	 * 启动删除营业厅
	 * @param HallNum 营业厅编号
	 * @return 返回启动是否成功
	 */
	public boolean DelHallbl(int HallNum);
}
