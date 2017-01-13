package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import boundry.*;
import simpleChat.ClientConsole;
import controller.DBController;
import entity.*;



public class loginController {
	/**
	 * 
	 */
	public static User use;
	private static ArrayList<String> usel;
	public static MainWindowGUI mainG = null;
	public static interestedReader IRDetails = null;
	public static reader RDetails = null;
	
	/**
	 * login 
	 * @param username String
	 * @param password String
	 * @throws SQLException
	 */
	static public void login(String username , String password) throws SQLException{
		Boolean bool;
		String name = null;
		usel = null;
		use = new User(username,password);
		bool = DBController.existsInDB(use);
		if(bool == false)
		{
			LoginGUI.err=true;
			LoginGUI log = new LoginGUI();
			log.setSize(550,320);
			log.setVisible(true);
		    log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		else
		{
			int i=0;
			
			usel = DBController.getFromDB(use);
			while(usel == null);
			name = use.getUsername();
			i=Integer.parseInt((usel.get(2)));
			use.setprivilege(i);
			System.out.println(name);
			
			if(i == 6)
			{
				mainPanel panel =new managerGUI(name,"Manager");
				mainG = new MainWindowGUI(panel);
			}
			else if(i == 5)
			{
				mainPanel panel =new librarianGUI(name,"Librarian");
				mainG = new MainWindowGUI(panel);
			}
			else if(i == 4)
			{
				mainPanel panel =new LWorkerGUI(name,"Library Worker");
				mainG = new MainWindowGUI(panel);
			}
			else if(i == 3)
			{
				mainPanel panel =new editorGUI(name,"Editor");
				mainG = new MainWindowGUI(panel);
				IRDetails = new interestedReader(Integer.parseInt((usel.get(2))) , usel.get(0) , usel.get(1));
			}
			else if(i == 2)
			{
				mainPanel panel =new readerGUI(name,"Reader");
				mainG = new MainWindowGUI(panel);
				ArrayList<String> usel = DBController.getFromDB("select interestedreader.firstName , interestedreader.lastName , interestedreader.userID "
												+ "	from interestedreader "
												+ "where interestedreader.username = '"+use.getUsername()+"'");


				
				//RDetails = new reader(Integer.parseInt((usel.get(2))) , usel.get(0) , usel.get(1));
			}
			else
			{
				mainPanel panel =new InterestedReaderGUI(name,"InterestedReader");
				mainG = new MainWindowGUI(panel);
				
			}
			mainG.setSize(1000,900);
			mainG.setVisible(true);
			mainG.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
		
}
