package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import boundry.*;
import simpleChat.ClientConsole;
import controller.DBController;
import entity.User;



public class loginController {
	
	private static User use;
	private static ArrayList<String> usel;
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
			InterestedReaderGUI mainG;
			if(i == 6)
				mainG = new managerGUI("Manager",name);
			else if(i == 5)
				mainG = new librarianGUI("Librarian",name);
			else if(i == 4)
				mainG = new LWorkerGUI("Library worker",name);
			else if(i == 3)
				mainG = new editorGUI("Editor",name);
			else if(i == 2)
				mainG = new readerGUI("Reader",name);
			else
			{
				//DBController.getFromDB(String sql)
				mainG = new InterestedReaderGUI("Interested Reader",name);
			}
			mainG.setSize(1000,900);
			mainG.setVisible(true);
			mainG.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
		static public void logout(){
			
			LoginGUI log = new LoginGUI();
				log.setSize(550,320);
				log.setVisible(true);
			    log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			

	}
}
