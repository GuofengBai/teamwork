package org.businesslogicservice.organizationblservice;

import java.util.Vector;
import org.vo.HallVO;

public interface HallBLService {
	/**
	 * 启动新增营业厅
	 * @param vo 营业厅
	 * @return 返回添加是否成功
	 */
	public boolean addHall(HallVO vo);
	/**
	 * 启动删除营业厅
	 * @param HallNum 营业厅编号
	 * @return 返回删除是否成功
	 */
	public boolean delHall(String HallNum);
	/**
	 * 启动更新营业厅
	 * @param HallNum 营业厅编号
	 * @return 返回更新是否成功
	 */
	public boolean updateHall(HallVO vo);
	/**
	 * 获得营业厅列表
	 * @return 返回列表
	 */
	public Vector<HallVO> getList();
}
