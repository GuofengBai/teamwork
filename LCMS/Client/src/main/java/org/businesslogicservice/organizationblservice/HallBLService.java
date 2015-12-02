package org.businesslogicservice.organizationblservice;

import org.po.HallPO;
import org.vo.HallVO;

public interface HallBLService {
	/**
	 * @param vo 营业厅
	 * @return 返回添加是否成功
	 */
	public boolean AddHall(HallVO vo);
	/**
	 * 启动删除营业厅
	 * @param HallNum 营业厅编号
	 * @return 返回删除是否成功
	 */
	public boolean DelHall(String HallNum);
}
