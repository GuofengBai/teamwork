package org.businesslogicservice.staffblservice;

import java.util.ArrayList;

import org.po.ResultMessage;
import org.vo.StaffVO;

public interface StaffBLService {
	
	public ResultMessage newStaff(StaffVO vo);
	
	public ResultMessage deleteStaff(StaffVO vo);
	
	public ResultMessage updateStaff(StaffVO vo);
	
	public ArrayList<StaffVO> getAllStaff();

}
