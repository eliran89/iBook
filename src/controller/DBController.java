package controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import simpleChat.ClientConsole;
import simpleChatCommon.ChatIF;
import client.IBookClient;
import entity.*;
/**
 * DBController input and output from the DB
 * @author Admin
 *
 */
public class DBController {
	static public ArrayList<String> rs = null;
	static public volatile boolean allowToProceed = false;
	static private String host;
	static private int port;
	ClientConsole chat;
	static public byte[][] buffers;
	
	 /** Constractor*/
	/**
	 * Constructor 
	 * @param host
	 * @param port
	 */
	public DBController(String host , int port)
	{
		this.host = host;
		this.port = port;
	}
	/**END Constractor*/
	
	
	
	/**
	 * getFromDB General - get query and return a result 
	 * @param query String - the query that sent to the DB
	 * @return ArrayList<String> - contains the query result from the DB
	 */
	static synchronized public ArrayList<String> getFromDB(String query){
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
	
	
	

	/**
	 * getFromDB for User when login - get a User instance and pull his information from the DB
	 * @param use User - contains a user information
	 * @return ArrayList<String> - contains the query result from the DB
	 */
	static synchronized public ArrayList<String> getFromDB(User use){
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
	
	
	
	
    
	/**
	 * existsInDB for User get a User instance and check if they exists in the DB the DB
	 * check if user exists in DB
	 * @param use User - contains the user information
	 * @return boolean - if it exits true else false
	 * @throws SQLException
	 */
	static synchronized public boolean existsInDB(User use) throws SQLException{
		boolean bool;
		try {
			ClientConsole chat= new ClientConsole(host, port);
			rs = null;
			allowToProceed = false;

			ClientConsole.accept("select * from user where username = '"+ use.getUsername()+"' and"
					+ " password = '"+use.getpassword()+"' and user.status =1 ");
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		while(allowToProceed == false);	
		
		if( rs == null)
		{
		//	System.out.println("rs is: null");
			bool = false;
		}
		else
		{
			bool = true;
			System.out.println("rs is: "+rs.toString());
		}
			
		
		return bool;
	}
	
	
	
	/**exitsInDB General*/
	/**
	 * exitsInDB General
	 * check if query return answer
	 * @param query String
	 * @return Boolean
	 * @throws SQLException
	 */
	static synchronized public boolean existsInDB(String query) throws SQLException{
		boolean bool;
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
	
	static synchronized public void insertToDB(String query) throws SQLException{
		boolean bool;
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
			//System.out.println("rs is: null");
			bool = false;
		}
		else
		{
			bool = true;
			System.out.println("rs is: "+rs.toString());
		}
			
	}
	static synchronized public void getFile(String bid,String format,String bookName) throws SQLException{
		
		String file = bid+"."+format;
		try {
			ClientConsole chat= new ClientConsole(host, port);
			rs = null;
			allowToProceed = false;
			ClientConsole.accept(file);	

		} catch (Exception e) {
			e.printStackTrace();
		}

		while(allowToProceed == false);	
		File f = new File("C:/Users/Admin/Desktop/"+bookName+"."+format);
		  try {
			FileOutputStream output = new FileOutputStream(f);
			try {
				//while (input.read(buffer) > 0)
				for(int i = 0;i < buffers.length;i++)
					output.write(buffers[i]);
			output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	  }
	
}
