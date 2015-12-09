package org.vo;

import java.util.Vector;

import javax.swing.JPanel;

import org.po.PayingBills;
import org.po.myDate;
import org.presentation.billsui.NewPayingBillsUI;

public class PayingBillVO extends Vector<String> implements PanelCreaterService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PayingBillVO(myDate date,long money,String name,String accountName,String item,String remark,boolean examined,String idNum){
		this.add(date.toString());
		this.add(String.valueOf(money));
		this.add(name);
		this.add(accountName);
		this.add(item);
		this.add(remark);
		
		if(examined){
			this.add("已审批");
		}else{
			this.add("未审批");
		}
		
		this.add(idNum);
	}
	
	public PayingBillVO(PayingBills bill){
		this.add(bill.getDate().toString());
		this.add(String.valueOf(bill.getMoney()));
		this.add(bill.getname());
		this.add(bill.getAccountName());
		this.add(bill.getItem());
		this.add(bill.getRemark());
		
		if(bill.Examined){
			this.add("已审批");
		}else{
			this.add("未审批");
		}
		this.add(bill.getIdNum());
	}

	public JPanel careatePanel(JPanel su) {
		JPanel panel=new NewPayingBillsUI(su);
		return panel;
	}
	
}
