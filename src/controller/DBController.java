package controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import simpleChat.ClientConsole;
import simpleChatCommon.ChatIF;
import client.IBookClient;
import entity.*;

public class DBController {
	static public ArrayList<String> rs = null;
	static public volatile Boolean allowToProceed = false;
	static private String host;
	static private int port;
	ClientConsole chat;
	
	
	 /** Constractor*/
	/**
	 * 
	 * @param host
	 * @param port
	 */
	public DBController(String host , int port)
	{
		this.host = host;
		this.port = port;
	}
	/**END Constractor*/
	
	
	/**getFromDB General*/
	/**
	 * 
	 * @param query
	 * @return
	 */
	static public ArrayList<String> getFromDB(String query){
		try {
			rs = null;
			allowToProceed = false;
			ClientConsole chat= new ClientConsole(host, port);

			ClientConsole.accept(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

		while(allowToProceed == false);	
		return rs;
		
	}
	/**END getFromDB General*/
	
	
	/**getFromDB for User*/
	/**
	 * 
	 * @param use
	 * @return
	 */
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
	/**END getFromDB for User*/
	
	
	
    /**existsInDB for User*/
	/**
	 * 
	 * @param use
	 * @return
	 * @throws SQLException
	 */
	static public Boolean existsInDB(User use) throws SQLException{
		Boolean bool;
		try {
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
	/**END existsInDB for User*/
	
	
	/**exitsInDB General*/
	/**
	 * 
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	static public Boolean existsInDB(String query) throws SQLException{
		Boolean bool;
		try {
			ClientConsole chat= new ClientConsole(host, port);
			rs = null;
			allowToProceed = false;
			ClientConsole.accept(query);	

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
	/**END exitsInDB General*/
	static public void insertToDB(String query) throws SQLException{
		Boolean bool;
		try {
			ClientConsole chat= new ClientConsole(host, port);
			rs = null;
			allowToProceed = false;
			ClientConsole.accept(query);	

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
			
	}
	

}
