package org.businesslogic.blFactory;

import org.businesslogic.billsbl.NewSendingBillsBL;
import org.businesslogic.commoditybl.CommodityBL;
import org.businesslogic.managebl.ManageBL;
import org.businesslogic.organizationbl.OrganizationBL;
import org.businesslogic.staffbl.StaffBL;
import org.businesslogic.userbl.UserBL;
import org.businesslogicservice.billsblservice.NewSendingBillsBLService;
import org.businesslogicservice.commodityblservice.CommodityBLService;
import org.businesslogicservice.manageblservice.ManageBLService;
import org.businesslogicservice.organizationblservice.OrganizationBLService;
import org.businesslogicservice.staffblservice.StaffBLService;
import org.businesslogicservice.userblservice.UserBLService;

public class BLFactory {
	
	public static CommodityBLService commodityBL;
	
	public static StaffBLService staffBL;
	
	public static OrganizationBLService organizationBL;
	
	public static ManageBLService manageBL;
	
	public static UserBLService userBL;
	
	public static NewSendingBillsBLService newSendingBillsBL;
	
	public static void init(){
		commodityBL=null;
		staffBL=null;
		organizationBL=null;
		manageBL=null;
		userBL=null;
		newSendingBillsBL=null;
	}
	
	public static CommodityBLService getCommodityBL(){
		
		if(commodityBL==null){
			commodityBL=new CommodityBL();
		}
		
		return commodityBL;
	}

    public static StaffBLService getStaffBL(){
		
		if(staffBL==null){
			staffBL=new StaffBL();
		}
		
		return staffBL;
	}
    
    public static UserBLService getUserBL(){
		
		if(userBL==null){
		    userBL=new UserBL();
		}
		
		return userBL;
	}
    
    public static ManageBLService getManageBL(){
		
		if(manageBL==null){
		    manageBL=new ManageBL();
		}
		
		return manageBL;
	}
    
    public static OrganizationBLService getOrganizationBL(){
		
		if(organizationBL==null){
		    organizationBL=new OrganizationBL();
		}
		
		return organizationBL;
	}
    
    public static NewSendingBillsBLService getNewSendingBillsBL(){
		
		if(newSendingBillsBL==null){
		    newSendingBillsBL=new NewSendingBillsBL();
		}
		
		return newSendingBillsBL;
	}
    
    
}
