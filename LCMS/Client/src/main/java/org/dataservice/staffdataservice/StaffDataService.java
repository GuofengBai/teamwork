package org.dataservice.staffdataservice;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.Vector;

import org.po.ResultMessage;
import org.po.StaffPO;

public interface StaffDataService extends Remote{
	
public ResultMessage add(StaffPO po);
	
	public ResultMessage remove(String num);
	
	public ResultMessage update(StaffPO po);
	
	public StaffPO find(String num);
	
	public ArrayList<StaffPO> getAll();
	
	public Vector<Vector<String>> getAllStaffInfo();

}
