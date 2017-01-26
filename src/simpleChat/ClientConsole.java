package simpleChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 


import javax.swing.JFrame;

import boundry.LoginGUI;

import client.IBookClient;
import simpleChatCommon.ChatIF;
import controller.DBController;
/**
 * This class constructs the UI for a chat client.  It implements the
 * chat interface in order to activate the display() method.
 * Warning: Some of the code here is cloned in ServerConsole 
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge  
 * @author Dr Robert Lagani&egrave;re
 * @version July 2000
 */
public class ClientConsole implements ChatIF 
{
  //Class variables *************************************************
  
  /**
   * The default port to connect on.
   */
  final public static int DEFAULT_PORT = 5555;
  
  //Instance variables **********************************************
  
  /**
   * The instance of the client that created this ConsoleChat.
   */
  public static  IBookClient client;
  static public DBController dbhandler;
  static public Boolean loginCProceed;
  //Constructors ****************************************************

  /**
   * Constructs an instance of the ClientConsole UI.
   *
   * @param host The host to connect to.
   * @param port The port to connect on.
   */
  public ClientConsole(String host, int port) 
  {
    try 
    {
      client= new IBookClient(host, port, this);
      client.openConnection();
    } 
    catch(IOException exception) 
    {
      System.out.println("Error: Can't setup connection!"
                + " Terminating client.");
      System.exit(1);
    }
  }
  
  //Instance methods ************************************************
  
  /**
   * This method waits for input from the console.  Once it is 
   * received, it sends it to the client's message handler.
   */
  public static void accept(Object message) 
  {
    try
    {
     /* BufferedReader fromConsole = 
        new BufferedReader(new InputStreamReader(System.in));*/

        client.handleMessageFromClientUI(message);
       
      
    } 
    catch (Exception ex) 
    {
      System.out.println
        ("Unexpected error while reading from console!");
    }
  }

  /**
   * This method overrides the method in the ChatIF interface.  It
   * displays a message onto the screen.
   *
   * @param message The string to be displayed.
   */
  public void display(Object message) 
  {
  /*  ResultSet rs = (ResultSet) message;
    String result1 = null;
	try{
		
		rs.next();
		result1 = rs.getString(1)+" \t " +rs.getString(2)+"\t"+rs.getString(3);
	 	System.out.println("client result:" + result1);
		 }catch (SQLException e) {e.printStackTrace();}*/
    	//dbhandler.setRs(rs);
	  /*dbhandler.setRs(message.toString());
	  dbhandler.setAllow(true);
	  System.out.println(dbhandler.rs);*/
	  
  }

  
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of the Client UI.
   *
   * @param args[0] The host to connect to.
   */
  public static void main(String[] args) 
  {
    String host = "";
    int port = 0;  //The port number
    try
    {
    	/*BufferedReader fromConsole = 
    	        new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("Enter ip addess");
    	try {
			host = fromConsole.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
      host = args[0];
    }
    catch(ArrayIndexOutOfBoundsException e)
    {
      host = "localhost";
     // System.out.println("exception");
    }
    

    dbhandler = new DBController(host,DEFAULT_PORT);
    LoginGUI log = new LoginGUI();
	log.setSize(550,320);
	log.setVisible(true);
    log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //chat.accept();  //Wait for console data
    
    
  }
}
//End of ConsoleChat class
