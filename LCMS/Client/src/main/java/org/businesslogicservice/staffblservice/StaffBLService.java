package org.businesslogicservice.staffblservice;

import java.util.ArrayList;
import java.util.Vector;

import org.po.ResultMessage;
import org.vo.StaffVO;

public interface StaffBLService {
	
	public ResultMessage newStaff(StaffVO vo);
	
	public ResultMessage deleteStaff(String num);
	
	public ResultMessage updateStaff(StaffVO vo);
	
	public ArrayList<StaffVO> getAllStaff();
	
	public Vector<Vector<String>> getListData();
	
	public StaffVO findStaff(String num);

}
