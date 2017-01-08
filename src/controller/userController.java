package controller;



import java.util.ArrayList;

import javax.swing.JFrame;

import boundry.*;



public class userController {

	static public void logout(){
    	LoginGUI.err = false;
		LoginGUI log = new LoginGUI();
			log.setSize(550,320);
			log.setVisible(true);
		    log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

}

	public static void userSearch() {
		
		UserSearchGUI panel;
		//System.out.println(loginController.use.getprivilege());
		if(loginController.use.getprivilege() == 4)
			panel = new UserSearchGUI(loginController.use.getUsername(),"Library Worker");
		else
			panel = new UserSearchGUI(loginController.use.getUsername(),"Librarian");
		loginController.mainG.setContentPane(panel);
		loginController.mainG.revalidate();
		
			
	}
	
	/**goToMainWindow method*/
	public static void GoToMainWindow()
	{
		mainPanel mainP = null;
		if(loginController.use.getprivilege() == 1)
			mainP = new InterestedReaderGUI(loginController.use.getUsername(),"Interested Reader");
		
		else if(loginController.use.getprivilege() == 2)
			mainP = new readerGUI(loginController.use.getUsername(),"Reader");
		
		else if(loginController.use.getprivilege() == 3)
			mainP = new editorGUI(loginController.use.getUsername(),"Editor");
		
		else if(loginController.use.getprivilege() == 4)
			mainP = new LWorkerGUI(loginController.use.getUsername(),"Library Worker");
		
		else if(loginController.use.getprivilege() == 5)
			mainP = new librarianGUI(loginController.use.getUsername(),"Librarien");
		else
			mainP = new managerGUI(loginController.use.getUsername(),"Manager");
		loginController.mainG.setContentPane(mainP);
		loginController.mainG.revalidate();
	}/**goToMainWindow method END*/

	

	public static void getUserDetails(String item , String search)
	{
		UserSearchGUI panel;
		//System.out.println(loginController.use.getprivilege());
		//System.out.println("right here!!");
		if(loginController.use.getprivilege() == 4)
			panel = new UserSearchGUI(loginController.use.getUsername(),"Library Worker");
		else
			panel = new UserSearchGUI(loginController.use.getUsername(),"Librarian");
	
		
		ArrayList <String> info = null;
		
		/**Search by Username*/
		if(item.equals("Username")){
			info = DBController.getFromDB("SELECT i.*, p.description"
										+" FROM interestedreader i, user u, privilege p"
										+" WHERE i.username like '%"+search+"%' and i.username = u.username and u.privilege = p.privilege"
										+" UNION"
										+" select r.userID, r.firstName, r.lastName, r.username, p.description"
										+" from reader r, user u, privilege p"
										+" where r.username like '%"+search+"%' and r.username = u.username and u.privilege = p.privilege");
			if(info!=null)
				System.out.println(info.toString());

		}
		/**Search by UserID*/
		if(item.equals("UserID"))
			info = DBController.getFromDB("select * "
			+"from interestedreader i "
			+"where i.userID = '"+search+"' order by i.username ASC");
		
		
		//System.out.println(info.toString());
		
	////////////////////////////	
		/**build the basic panel*/
		
		/**if he is an interested reader add it to the title*/ 
		if(loginController.use.getprivilege() == 5)
			panel = new UserSearchGUI(loginController.use.getUsername(),"Interested Reader");
		
		/**if he is a reader add it to the title*/
		else
			panel = new UserSearchGUI(loginController.use.getUsername(),"Reader");
		
		/**if we get results we add the results table*/
		if(info != null)
		{
			UserSearchGUI.data1 = new String[info.size()/5][5];
			
			int count =0;
			for(int i = 0 ; i < info.size()/5 ; i++)
				for(int j = 0 ; j < 5 ; j++){
					UserSearchGUI.data1[i][j] = info.get(count);
					count++;
				}
			//System.out.println(UserSearchGUI.data1[0][0]);
			panel.getUserDetails();
		}

//		if there are no results at all we add a lable that says "no results"
		else
			panel.noResults();
		loginController.mainG.setContentPane(panel);
		loginController.mainG.revalidate();
		
		
	}
		
			
	
	
	public static void displayUser(String bName, String uName) {
		ArrayList <String> info = null;
		info = DBController.getFromDB("select reviews.text from reviews , book"
				+ " where reviews.BookID = book.bookID and reviews.username = '"+uName+"' and book.Title = '"+bName+"'");

		UserSearchGUI account = null;
		if(loginController.use.getprivilege() == 1)
			account = new UserSearchGUI(loginController.use.getUsername(),"Interested Reader");
		else
			account = new UserSearchGUI(loginController.use.getUsername(),"Reader");
		account.displayUser(info.get(0));
		loginController.mainG.setContentPane(account);
		loginController.mainG.revalidate();
		
	}/**displayRiview method END*/
	
	public void addBookToOrderList() {
		// TODO - implement userController.addBookToOrderList
		throw new UnsupportedOperationException();
	}

	public void setDetails() {
		// TODO - implement userController.setDetails
		throw new UnsupportedOperationException();
	}

	public void openReaderAccount() {
		// TODO - implement userController.openReaderAccount
		throw new UnsupportedOperationException();
	}

	public void checkPrivilege() {
		// TODO - implement userController.checkPrivilege
		throw new UnsupportedOperationException();
	}

	/**
	 * enables to set a new user's privilege
	 */
	public void setPrivilege() {
		// TODO - implement userController.setPrivilege
		throw new UnsupportedOperationException();
	}

	public void setUserDetails() {
		// TODO - implement userController.setUserDetails
		throw new UnsupportedOperationException();
	}


	public void checkOrderDetails() {
		// TODO - implement userController.checkOrderDetails
		throw new UnsupportedOperationException();
	}

	public void makeTheOrder() {
		// TODO - implement userController.makeTheOrder
		throw new UnsupportedOperationException();
	}

	public void extendSubscription() {
		// TODO - implement userController.extendSubscription
		throw new UnsupportedOperationException();
	}

	public void changePrivilege() {
		// TODO - implement userController.changePrivilege
		throw new UnsupportedOperationException();
	}

	public void insertToDB() {
		// TODO - implement userController.insertToDB
		throw new UnsupportedOperationException();
	}

	public void legalDate() {
		// TODO - implement userController.legalDate
		throw new UnsupportedOperationException();
	}

}