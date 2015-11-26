package org.businesslogicservice.manageblservice;

import java.util.ArrayList;
import java.util.Vector;

import org.po.BeginAccountPO;
import org.po.ResultMessage;
import org.vo.BeginAccountVO;

public interface BeginAccountBLService {
	public BeginAccountPO getBeginAccount();
	
	public Vector<BeginAccountVO> getBeginAccountList();
	
	public ResultMessage deleteAccount(BeginAccountPO account);
}
