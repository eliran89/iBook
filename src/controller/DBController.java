package controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import simpleChat.ClientConsole;
import simpleChatCommon.ChatIF;
import client.IBookClient;
import entity.User;

public class DBController {
	static public ArrayList<String> rs = null;
	static public volatile Boolean allowToProceed = false;
	static private String host;
	static private int port;
	//static public  IBookClient client;
	ClientConsole chat;
	public DBController(String host , int port)
	{
		this.host = host;
		this.port = port;
	}
	
	static public ArrayList<String> getFromDB(User use){
		User res= new User();
		try {
			rs = null;
			allowToProceed = false;
			ClientConsole chat= new ClientConsole(host, port);
			ClientConsole.accept("select * from user where username = '"+ use.getUsername()+"' and"
					+ " password = '"+use.getpassword()+"'");

		} catch (Exception e) {
			e.printStackTrace();
		}

		while(allowToProceed == false);	
		if(rs != null)
		{
			int i = 0;
			res.setUsername(rs.get(0));
			res.setPassword(rs.get(1));
			i=Integer.parseInt((rs.get(2)));
			res.setprivilege(i);
			System.out.println("the user we got is: "+rs.toString());
			
			return rs;
		}
		System.out.println("did not get a user");
		return null;
	}
	
	static public Boolean existsInDB(User use) throws SQLException{
		//Boolean bool = false;
		Boolean bool;
		try {
			
			//ClientConsole.client.openConnection();
			ClientConsole chat= new ClientConsole(host, port);
			rs = null;
			allowToProceed = false;
			ClientConsole.accept("select * from user where username = '"+ use.getUsername()+"' and"
					+ " password = '"+use.getpassword()+"'");
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		while(allowToProceed == false);	
		
		if( rs == null)
		{
			System.out.println("rs is: null");
			bool = false;
		}
		else
		{
			bool = true;
			System.out.println("rs is: "+rs.toString());
		}
			
		
		return bool;
	}


}
