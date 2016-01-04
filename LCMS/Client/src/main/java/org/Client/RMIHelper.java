package org.Client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.dataservice.DataFactoryService.DataFactoryService;

public class RMIHelper {
    private static String IP = "localhost";//Can be read from config file
    private static DataFactoryService dataFactory;

    public static void init() {
    	
    	getIP();
    	
        try {
            dataFactory=(DataFactoryService)Naming.lookup("rmi://" + IP + "/data-factory");

            System.out.println("client创建!");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public static DataFactoryService getDataFactory() {
        return dataFactory;
    }
    
    public static void getIP(){
    	try {
			FileReader re=new FileReader("Config/IP.txt");
			BufferedReader br=new BufferedReader(re);
			IP=br.readLine();
			
			System.out.println(IP);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

}