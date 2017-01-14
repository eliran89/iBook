package controller;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
			info = DBController.getFromDB("SELECT i.*, p.description"
										+" FROM interestedreader i, user u, privilege p"
										+" WHERE i.userID = '"+search+"' and i.username = u.username and u.privilege = p.privilege"
										+" UNION"
										+" select r.userID, r.firstName, r.lastName, r.username, p.description"
										+" from reader r, user u, privilege p"
										+" where r.userID = '"+search+"' and r.username = u.username and u.privilege = p.privilege");
		
		
		//System.out.println(info.toString());

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
		
	}/**displayRiview method END
	 * @param title */
	
	
	/**addBookToOrderList method
	 * adds a book order for a reader to the database
	 * @param title
	 */
	public static void addBookToOrderList(String title) {
		// TODO - implement userController.addBookToOrderList
		
		ArrayList<String> orderInfo;	//contains info about the order (userid, book id, date)
		
		String username = loginController.use.getUsername();	//get username
		ArrayList<String> info = null;
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-2017");	//date format
		LocalDateTime now = LocalDateTime.now();	//get order date
		
		
		//System.out.println("starting query");
		
		orderInfo = DBController.getFromDB("select reader.userID, book.bookID "
									  + "from reader, book "
									  + "where reader.username like '%"+username+"%' "
									  		+ "AND book.Title like '%"+title+"%' ");
		
		System.out.println("order information:");
		System.out.println("userID = "+orderInfo.get(0)+"\nbookID = "+orderInfo.get(1));
		
		String query = "INSERT INTO `ibookdb`.`readerorder` (`userID`, `bookID`, `date`) "
				+ "VALUES ('"+orderInfo.get(0)+"', '"+orderInfo.get(1)+"', '"+now.toString() +"')";
		
		info = DBController.getFromDB(query);	//execute update
		//throw new UnsupportedOperationException();
	}/**addBookToOrderList method END
	 * @param title */
	
	

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