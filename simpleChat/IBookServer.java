package simpleChat;

//lalala

// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;

import dbSql.mysqlConnection;
import ocsf.server.*;

/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public  class IBookServer extends AbstractServer 
{
  //Class variables *************************************************
  
  /**
   * The default port to listen on.
   */
  final public static int DEFAULT_PORT = 5555;
  
  mysqlConnection dbConn;
  
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port int The port number to connect on.
   */
  public IBookServer(int port) 
  {
    super(port);
   
  }

  
  //Instance methods ************************************************
  
  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   */
  public synchronized void handleMessageFromClient
  (Object msg, ConnectionToClient client)
  {
	   String   query = msg.toString();
	   if(query.contains("select") || query.contains("SELECT"))
	    {
	    	ResultSet queryAns = ((ResultSet) dbConn.QueryHandler(msg));
		    ArrayList<String> result1 = null;
		    //result1.add(null);
	
		    try{

		    	ResultSetMetaData rsmd = (ResultSetMetaData) queryAns.getMetaData();
		    	int columnsNumber = rsmd.getColumnCount();
		    	
		    	while(queryAns.next())
		    	{
		    		if (result1 == null)
		    			result1 = new ArrayList<String>();
		    		for(int i = 1;i <= columnsNumber ; i++)
		    		{
		    			String res = queryAns.getString(i);
		    			result1.add(res);
		    		}
		    		
		    	}
		    	//System.out.println("server result:" + result1.toString() +"number of collumns = "+columnsNumber);
		    	queryAns.close();
		     	client.sendToClient(result1);
		    	}
		    catch(Exception e){
		    	
		    	e.getStackTrace();}
		    try {
				client.sendToClient(result1);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }  
	    else if(query.contains("insert") || query.contains("delete") || query.contains("update") || query.contains("INSERT") || query.contains("DELETE") || query.contains("UPDATE"))
	    {
	    	ArrayList<String> result1 = null;
	    	ResultSet queryAns = ((ResultSet) dbConn.QueryHandler(msg));
	    	try {
				client.sendToClient(result1);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	    }
	   /* else
	    {
	    	File file = new File("M:\\test.xml");
	        // Get the size of the file
	    	 InputStream in;
			try {
				in = new FileInputStream(file);

	    	 OutputStream out = null;
	    	try {
	    		
	            out = new FileOutputStream("M:\\test2.xml");
	        } catch (FileNotFoundException ex) {
	            System.out.println("File not found. ");
	        }

	        byte[] bytes = new byte[16*1024];

	        int count;
				while ((count = in.read(bytes)) > 0) {
				    out.write(bytes, 0, count);
				}


			in.close();
	        out.close();
	    }	catch (IOException e) {

			e.printStackTrace();
		}
	    }*/
	  }
  
  

    
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()
  {
	  dbConn.Set();	//set connection
    System.out.println
      ("Server listening for connections on port " + getPort());
  }
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }
  
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of 
   * the server instance (there is no UI in this phase).
   *
   * @param args[0] The port number to listen on.  Defaults to 5555 
   *          if no argument is entered.
 * @throws SQLException 
   */
  public static void main(String[] args)
  {
    int port = 0; //Port to listen on
    
    
    /*try{
    	mysqlConnection.addToDB(name, department);
    }catch (SQLException ex){ex.getStackTrace();}
    */
    try
    {
      port = Integer.parseInt(args[0]); //Get port from command line
    }
    catch(Throwable t)
    {
      port = DEFAULT_PORT; //Set port to 5555
    }
	
    IBookServer sv = new IBookServer(port);
    
    try 
    {
      sv.listen(); //Start listening for connections
    } 
    catch (Exception ex) 
    {
      System.out.println("ERROR - Could not listen for clients!");
    }
  }
}
//End of EchoServer class