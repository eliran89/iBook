package controller;

import javax.swing.JOptionPane;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFrame;

import boundry.*;
import entity.*;



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
		else if(loginController.use.getprivilege() == 5)
			panel = new UserSearchGUI(loginController.use.getUsername(),"Librarian");
		else 
		{
			panel = new UserSearchGUI(loginController.use.getUsername(),"Manager");
			panel.searchForManager();
		}
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
		if(item.equals("Username") ){
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
	/**
	 * UserSearchForReports - get all the readers information and insert the information to the panel's array and display the panel
	 * @param item String - the kind of search the worker wants to make by
	 * @param search String - the name of the user the worker wants to search or hi's ID
	 */
	public static void UserSearchForReports(String item , String search){
		UserSearchGUI panel;
		ArrayList <String> info = null;
		panel = new UserSearchGUI(loginController.use.getUsername(),"Manager");
		if(item.equals("Username") ){
			info = DBController.getFromDB(" select r.userID, r.firstName, r.lastName, r.username, p.description"
										+" from reader r, user u, privilege p"
										+" where r.username like '%"+search+"%' and r.username = u.username and u.privilege = p.privilege");
		}
		if(item.equals("UserID"))
			info = DBController.getFromDB(	" select r.userID, r.firstName, r.lastName, r.username, p.description"
											+" from reader r, user u, privilege p"
											+" where r.userID = '"+search+"' and r.username = u.username and u.privilege = p.privilege");

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
			panel.searchForManager();
			panel.managerReportButtons();
		}

//		if there are no results at all we add a lable that says "no results"
		else
		{
			panel.searchForManager();
			panel.noResults();
		}
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
	
	/**addBookToOrderList method
	 * adds a book order for a reader to the database
	 * @param title
	 */
	public static void addBookToOrderList(String title) {
		// TODO - implement userController.addBookToOrderList
		
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
	 * Enables to set a new user's privilege
	 */
	public void setPrivilege() {
		// TODO - implement userController.setPrivilege
		throw new UnsupportedOperationException();
	}

	
	/**
	 * Open an Interested reader account
	 * @param ID, firstName, lastName, userName, Password
	 * @throws SQLException 
	 */
	public static void setUserDetails(int ID, String fname, String lname, String uname, String pass) throws SQLException {
		
		//System.out.println(loginController.use.getprivilege());
		
		interestedReader ir = new interestedReader();
		
		String idstr = Integer.toString(ID);

		ArrayList<String> idInDB = null;
		ArrayList<String> unameInDB = null;
		
		/**get ID if exists*/
			idInDB = DBController.getFromDB("select i.userID from interestedreader i where i.userID = '"+idstr+"'");
			if(idInDB != null){
				//System.out.println("ID " +idInDB.toString()+ " is already exists !");
				UserSearchGUI.errorBox("ID "+idInDB.toString()+" is already exists!\nPlease pick another one", "Add User");
			}
		/**get user name if exists*/
			else
			{
				unameInDB = DBController.getFromDB("select u.username from ibookdb.user u where u.username = '"+uname+"'");
				if(unameInDB != null)
					UserSearchGUI.errorBox("User "+unameInDB.toString()+" is already exists!\nPlease pick another one", "Add User");	
				/**getting here means user entered a unique user name and ID as needed*/
				else{
					ir.setUserID(ID);
					ir.setFirstName(fname);
					ir.setLastName(lname);
					ir.setUsername(uname);
					ir.setPassword(pass);
					
/*					System.out.println("ID: "+ir.getUserID());
					System.out.println("fName: "+ir.getFirstName());
					System.out.println("lName: "+ir.getLastName());
					System.out.println("UN: "+ir.getUsername()); 
					System.out.println("pass: "+ir.getpassword()); */

					if ((ir.getUserID() != -1) && (ir.getFirstName() != null) && (ir.getLastName() != null) && (ir.getUsername() != null) && (ir.getpassword()) != null ){
						DBController.insertToDB("INSERT INTO ibookdb.user (`username`, `password`, `privilege`, `status`) VALUES ('"+ir.getUsername()+"', '"+ir.getpassword()+"', '1', '1')");
						DBController.insertToDB("INSERT INTO ibookdb.interestedreader (`userID`, `firstName`, `lastName`, `username`) VALUES ('"+ir.getUserID()+"', '"+ir.getFirstName()+"', '"+ir.getLastName()+"', '"+ir.getUsername()+"')");
						UserSearchGUI.infoBox("User "+uname+" added successfully","Add User");
						}
				}
			}
	}


	public static void editUserDetails(String id, String fname, String lname, String uname, String pass) throws SQLException {

		ArrayList<String> iReaderUpdate = null;
		ArrayList<String> userUpdate = null;
		interestedReader ir = new interestedReader();
		
		ir.setUserID(Integer.parseInt(id));
		ir.setFirstName(fname);
		ir.setLastName(lname);
		ir.setUsername(uname);
		ir.setPassword(pass);
		
		/**Edit user by user name and id*/
		if ((ir.getUserID() != -1) && (ir.getFirstName() != null) && (ir.getLastName() != null) && (ir.getUsername() != null) && (ir.getpassword()) != null ){
			iReaderUpdate = DBController.getFromDB("UPDATE ibookdb.interestedreader i set i.firstName='"+fname+"', i.lastName='"+lname+"' where i.userID='"+id+"'");
			userUpdate = DBController.getFromDB("UPDATE ibookdb.user u set u.password='"+pass+"' where u.username='"+uname+"'");
			UserSearchGUI.infoBox("Edit user details succeeded!", "Edit User");
		}
	}
	
	
	public static void removeUser(String id, String uname) throws SQLException {

		ArrayList<String> priv = null;
		priv = DBController.getFromDB("select u.privilege from ibookdb.user u where u.username = '"+uname+"'");
		/**make sure privilege is less than 3 means remove only reader or interested reader*/
		if (Integer.parseInt(priv.get(0)) < 3){
			DBController.insertToDB("delete from ibookdb.interestedreader where userID='"+id+"'");
			DBController.insertToDB("delete from ibookdb.user where username='"+uname+"'");
			UserSearchGUI.infoBox("User removal succeeded", "User Removal");
		}
		else{
			UserSearchGUI.errorBox("User removal Failed,\nonly Reader or Interested reader removal allowed!","User Removal");
		}
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
	/**
	 * showReportsMain - open the main reports panel
	 */
	public static void showReportsMain(){
		ReportsGUI panel;
		panel = new ReportsGUI(loginController.use.getUsername(),"Manager");
		panel.displayReportsMain();
		loginController.mainG.setContentPane(panel);
		loginController.mainG.revalidate();
		
	}
	/**
	 * showAllUserReport - the method gets from the DB all the purchases that
	 * was been made and open a panel with the results table
	 */
	public static void showAllUserReport(){
		ArrayList<String> info;
		
		info = DBController.getFromDB("select   reader.username , book.Title ,readerorder.date"
									+" from readerorder , reader,book"
									+" where reader.userID = readerorder.userID and  readerorder.bookID = book.bookID"
									+" order by username");
		/*build the basic panel*/
		ReportsGUI panel;
	
		panel = new ReportsGUI(loginController.use.getUsername(),"Manager");
		
		
		/*if we get results we add the results table*/
		if(info != null)
		{
			ReportsGUI.data1 = new String[info.size()/3][3];
			
			int count =0;
			for(int i = 0 ; i < info.size()/3 ; i++)
				for(int j = 0 ; j < 3 ; j++){
					ReportsGUI.data1[i][j] = info.get(count);
					count++;
				}
			ReportsGUI.columnHeader1 = new String[3];
			ReportsGUI.columnHeader1[0] = "username";
			ReportsGUI.columnHeader1[1] = "bookName";
			ReportsGUI.columnHeader1[2] = "date";
			panel.allUsrers();
			panel.displayUsersReport();
			
		}
		
		/*if there are no results at all we add a lable that says "no results"*/
		else
			panel.noReaders();
		loginController.mainG.setContentPane(panel);
		loginController.mainG.revalidate();
	}
	/**
	 * showUserReport - gets a username and get from the DB information about his purchases 
	 * and open a panel with a results table
	 * @param username String - 
	 * the user we want the report to be about
	 */
	public static void showUserReport(String username){
		ArrayList<String> info;
		
		info = DBController.getFromDB("select  book.Title ,readerorder.date"
									+" from readerorder , reader,book"
									+" where reader.userID = readerorder.userID and  readerorder.bookID = book.bookID and reader.username = '"+username+"'"
									+" order by username");
		/*build the basic panel*/
		ReportsGUI panel;
	
		panel = new ReportsGUI(loginController.use.getUsername(),"Manager");
		
		
		/*if we get results we add the results table*/
		if(info != null)
		{
			ReportsGUI.data1 = new String[info.size()/2][2];
			
			int count =0;
			for(int i = 0 ; i < info.size()/2 ; i++)
				for(int j = 0 ; j < 2 ; j++){
					ReportsGUI.data1[i][j] = info.get(count);
					count++;
				}
			ReportsGUI.columnHeader1 = new String[2];
			ReportsGUI.columnHeader1[0] = "bookName";
			ReportsGUI.columnHeader1[1] = "date";
			panel.displayUsersReport();
			panel.singleUser(username);
			
		}
		
		/*if there are no results at all we add a lable that says "no results"*/
		else
			panel.noReaders();
		loginController.mainG.setContentPane(panel);
		loginController.mainG.revalidate();
		
		
	}
	public static void displayBookSearchForReports(){
		ReportsGUI panel = new ReportsGUI(loginController.use.getUsername(),"manager");
		panel.displayBookSearchForReports();
		loginController.mainG.setContentPane(panel);
		loginController.mainG.revalidate();
	}
	public static void displaySearchReport(){
		
	}
	public static void displayOrdersReportByScope(){
		
	}
	public static void displayOrdersReport(){
		
	}
	
}