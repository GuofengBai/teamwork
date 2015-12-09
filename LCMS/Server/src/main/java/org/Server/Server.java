package org.Server;

import javax.swing.JOptionPane;

public class Server 
{
    public static void main( String[] args )
    {
        RMIHelper.init();
        
        JOptionPane.showMessageDialog(null,"运行Server成功",null ,
				JOptionPane.WARNING_MESSAGE);
    }
}
