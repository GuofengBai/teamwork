package org.Client;


import org.vo.StaffVO;

public class CurrentStaff {
	private static StaffVO staff;

	public static void setStaff(StaffVO vo) {
		staff = vo;
	}

	public static StaffVO getStaff() {
		return staff;
	}

}
