// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package client;

import ocsf.client.*;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observer;

import com.mysql.jdbc.ResultSet;

import controller.DBController;
import entity.User;

/**
 * This class overrides some of the methods defined in the abstract
 * superclass in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */

public class IBookClient extends AbstractClient
{
  //Instance variables **********************************************

  /**
   * The interface type variable.  It allows the implementation of 
   * the display method in the client.
   */
 public static ChatIF clientUI; 
 
 //public 
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the chat client.
   *
   * @param host The server to connect to.
   * @param port The port number to connect on.
 * @param clientConsole 
   * @param clientUI The interface type variable.
   */
  
  public IBookClient(String host, int port, ClientConsole clientUI) 
    throws IOException 
  {
    super(host, port); //Call the superclass constructor
   // this.clientUI = clientUI;
    this.clientUI = clientUI;
    
    openConnection();
  }

  
  //Instance methods ************************************************
    
  /**
   * This method handles all data that comes in from the server.
   *
   * @param msg The message from the server.
   */
  public void handleMessageFromServer(Object msg) 
  {
	  if(msg instanceof ArrayList)
	  	DBController.rs = (ArrayList<String>)(msg);
	  
	  
	  else if(msg instanceof byte[][])
		  DBController.buffers = (byte[][]) msg;
		  
	  DBController.allowToProceed = true;
  }

  /**
   * This method handles all data coming from the UI            
   *
   * @param message The message from the UI.    
   */
  public void handleMessageFromClientUI(Object message)
  {
	 
    try
    {
  	 
    	sendToServer(message);
    	//sendToServer(message);
    
    } catch (Exception e) {
    	  System.out.println
          ("Could not send message to server.  Terminating client.");
        quit();
	}
  }
  
  /**
   * This method terminates the client.
   */
  public void quit()
  {
    try
    {
      closeConnection();
    }
    catch(IOException e) {}
    System.exit(0);
  }
}
//End of ChatClient class
