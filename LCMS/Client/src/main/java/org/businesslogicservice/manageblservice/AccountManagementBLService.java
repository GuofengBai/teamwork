package org.businesslogicservice.manageblservice;

import java.util.Vector;
import org.po.ResultMessage;
import org.po.UserPO;
import org.vo.BankAccountVO;

public interface AccountManagementBLService {
	/**
	 * 获取账户列表VO
	 * 
	 * @return Vector<BankAccountVO>
	 */
	public Vector<BankAccountVO> getAccountList ();
	
	/**
	 * 添加账户
	 * 
	 * @param String
	 * @return ResultMessage
	 */
	public ResultMessage addAccount(String name);
	
	/**
	 * 获取账户余额
	 * 
	 * @param String
	 * @return long
	 */
	public long getBalance(String name);
	
	/**
	 * 删除账号
	 * 
	 * @param String
	 * @return ResultMessage
	 */
	public ResultMessage delAccount(String name);
	
	/**
	 * 修改账户名
	 * 
	 * @param String
	 * @param String
	 * @return ResultMessage
	 */
	public ResultMessage changeName(String name,String newname);
	
	/**
	 * 修改余额
	 * 
	 * @param String
	 * @param long
	 * @return ResultMessage
	 */
	public ResultMessage changeBalance (String name,long change);
	
	/**
	 * 关键字查找
	 * 
	 * @param String
	 * @return Vector<BankAccountVO>
	 */
	public Vector<BankAccountVO> accountSearch(String namepart);
	
	/**
	 * 判断用户是否有财务人员最高权限
	 * 
	 * @param UserPO
	 * @return boolean
	 */
	public boolean check (UserPO user);
}
