package org.businesslogicservice.organizationblservice;

import java.util.Vector;

import org.po.ResultMessage;
import org.vo.CenterVO;

public interface CenterBLService {
	/**
	 * 启动新增中转中心
	 * @param vo 中转中心
	 * @return 返回添加是否成功
	 */
	public ResultMessage addCenter(CenterVO vo);
	/**
	 * 启动删除中转中心
	 * @param CenterNum 中转中心编号
	 * @return 返回删除是否成功
	 */
	public ResultMessage delCenter(String CenterNum);
	/**
	 * 启动更新中转中心
	 * @param CenterNum 中转中心编号
	 * @return 返回更新是否成功
	 */
	public ResultMessage updateCenter(CenterVO vo);
	
	/**
	 * 
	 * @param CenterNum
	 * @return
	 */
	public CenterVO findCenter(String CenterNum);
	/**
	 * 获得中转中心列表
	 * @return 返回列表
	 */
	public Vector<CenterVO> getList();
}


