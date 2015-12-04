package org.businesslogicservice.organizationblservice;

import java.util.Vector;

import org.po.CenterPO;
import org.vo.CenterVO;
import org.vo.HallVO;

public interface CenterBLService {
	/**
	 * 启动新增中转中心
	 * @param vo 中转中心
	 * @return 返回添加是否成功
	 */
	public boolean addCenter(CenterVO vo);
	/**
	 * 启动删除中转中心
	 * @param CenterNum 中转中心编号
	 * @return 返回删除是否成功
	 */
	public boolean delCenter(String CenterNum);
	/**
	 * 启动更新中转中心
	 * @param CenterNum 中转中心编号
	 * @return 返回更新是否成功
	 */
	public boolean updateCenter(CenterVO vo);
	/**
	 * 获得中转中心列表
	 * @return 返回列表
	 */
	public Vector<CenterVO> getList();
}


