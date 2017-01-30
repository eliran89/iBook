package controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import boundry.mainPanel;
import client.ChatIF;
import client.ClientConsole;
import client.IBookClient;
import entity.*;
/**
 * DBController -  input and output from the DB
 * the DBController gets a query from the user and send it to the server
 * it also get a file and upload it to the server or download a file from the server
 * and gets an answer and send the results to the user.
 * @author Guy Cohen 

 */
public class DBController {
	static public ArrayList<String> rs = null;
	static public volatile boolean allowToProceed = false;
	static private String host;
	static private int port;
	ClientConsole chat;
	static public byte[][] buffers;
	
	/**
	 * Constructor get the connection details from the user 
	 * and put them in static variables
	 * @param host a String for the host(for the iBookClient use)
	 * @param portan int for the port (for the iBookClient use)
	 */
	public DBController(String host , int port)
	{
		this.host = host;
		this.port = port;
	}
	
	
	
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
			//System.out.println("the user we got is: "+rs.toString());
			
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
			//System.out.println("rs is: "+rs.toString());
		}
			
		
		return bool;
	}
	
	
	
	
	/**
	 * exitsInDB General
	 * this method sends a query to the server and if it gets a result it returns true else false
	 * @param query the query that been sent to the server
	 * @return Boolean if the method gets a result from the server then its true else false
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
			//System.out.println("rs is: null");
			bool = false;
		}
		else
		{
			bool = true;
			//System.out.println("rs is: "+rs.toString());
		}
			
		
		return bool;
	}
	/**
	 * this method is responsible for sending values to the database
	 * it gets an update or insert or delete query and send it to the server
	 * @param query the query that is been sent to the server
	 * @throws SQLException
	 */
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
	/**
	 * this method gets a book id,book name,file format name,and a path.
	 * it gets the chosen book file from the server(witch is the book id . the wanted format in the server's computer)
	 * and opens a new file that its name is the book name and it saves it in the wanted path
	 * @param bid the book id witch is the wanted book's name
	 * @param format the wanted format for the file
	 * @param bookName the name of the file in the client's computer
	 * @param path where the file is being saved
	 * @throws SQLException
	 */
	static synchronized public void getFile(String bid,String format,String bookName,String path) throws SQLException{
		
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
		//boolean success = (new File("C:/iBook Files")).mkdir();
		File f = new File(path+"/"+bookName+"."+format);
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
	/**
	 * this metod gets 3 instances of files and write every one of them to an instace of byte[][]
	 * every byte[][] contains buffers for a whole file.
	 * every file(byte[][]) puts into an arraylist and sent to the server
	 * @param pdf an instance of File that contains a pdf file
	 * @param docx an instance of File that contains a docx file
	 * @param fb2 an instance of File that contains a fb2 file
	 * @throws FileNotFoundException 
	 */
	static synchronized public void sendFile(File pdf,File docx,File fb2) throws FileNotFoundException{
		
		ArrayList<byte[][]> buffersT = new ArrayList<byte[][]>();

		InputStream inputStream = new FileInputStream(pdf);
		byte[][] buff = null;
		byte[] buffer = new byte[1024];
		
		/*build pdf*/
		try {
			ArrayList<byte[]> buffe = new ArrayList<byte[]>();
			while(inputStream.read(buffer)>0)
				buffe.add(buffer.clone());
			buff = new byte[buffe.size()][1024];
			for(int i = 0 ;i<buffe.size();i++)
				buff[i]=buffe.get(i);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		buffersT.add(buff.clone());
		
		/*build docx*/
		inputStream = new FileInputStream(docx);
		buffer = new byte[1024];
		try {
			ArrayList<byte[]> buffe = new ArrayList<byte[]>();
			while(inputStream.read(buffer)>0)
				buffe.add(buffer.clone());
			buff = new byte[buffe.size()][1024];
			for(int i = 0 ;i<buffe.size();i++)
				buff[i]=buffe.get(i);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		buffersT.add(buff.clone());
		
		/*build fb2*/
		inputStream = new FileInputStream(fb2);
		buffer = new byte[1024];
		try {
			ArrayList<byte[]> buffe = new ArrayList<byte[]>();
			while(inputStream.read(buffer)>0)
				buffe.add(buffer.clone());
			buff = new byte[buffe.size()][1024];
			for(int i = 0 ;i<buffe.size();i++)
				buff[i]=buffe.get(i);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		buffersT.add(buff.clone());
		
		ClientConsole chat= new ClientConsole(host, port);
		rs = null;
		allowToProceed = false;
		ClientConsole.accept(buffersT);	
			
		while(allowToProceed == false);	
		
	}
}
