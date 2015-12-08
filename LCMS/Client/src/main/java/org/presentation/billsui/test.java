package org.presentation.billsui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.po.BOXSTYPE;
import org.po.SENDSTYPE;
import org.po.SendingBills;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.SBVO;

public class test {
	public static void main(String[] args){
		JFrame frame = new JFrame();
		JPanel pl = new JPanel();
		myDate date = new myDate(2012,2,2);
		SendingBills bill = new SendingBills("SenderName", "ReceiverName", "SenderPhone", "ReceiverPhone", "SenderLocation",
				"ReceiverLocation",date, "GoodsNum", BOXSTYPE.Box, SENDSTYPE.FAST, "length", "width", "height", "weight");
		SBVO vo = new SBVO(bill);
		NewSendingBillsUI ui = new NewSendingBillsUI(pl, vo);
		frame.setContentPane(ui);
		ViewController.init(frame);
		frame.setVisible(true);
	}

}
