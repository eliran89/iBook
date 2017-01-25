package controller;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;

import java.awt.Color;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;

import boundry.*;
import entity.*;




public class userController {

	static public void logout(){
		
		try {
			DBController.insertToDB("UPDATE `ibookdb`.`user` SET `logged`='0' "
					+ "WHERE `username`='"+loginController.use.getUsername()+"';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		loginController.mainG.dispose();
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
	
	/**
	 * GoToMainWindow - display the main window(according to the level)
	 */
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
	
	
	/**
	 * adds a book order for a reader to the database.
	 * The method checks whether a reader had already purchased a book using SQL queries that are being sent to the database
	 * and updates it in case a reader hadn't already purchased the book he is trying to purchase.
	 * In addition, the method checks what payment agreement a user has, and if it's a "pay per view" kind of payment agreement,
	 * the method adds the cost of the book to his debt
	 * @param title - String. The title of the book
	 * @param username  - String. Username
	 * @param bookCost - float. The cost of the desired book
	 * @throws SQLException 
	 */
	public static boolean addBookToOrderList(String title, String username, float bookCost) throws SQLException {

		ArrayList<String> readerDetails = new ArrayList<String>();
		ArrayList<String> bookID = new ArrayList<String>();
		
		bookID = DBController.getFromDB("select b.bookID "
				+ "from book b "
				+ "where b.Title = '"+title+"' ");	//get bookID
		
		
		readerDetails = DBController.getFromDB("select r.userID "
									+ "from reader r "
									+ "where r.username = '"+username+"' ");	//get userID
		
		if(bookID.get(0).equals(readerDetails.get(0))) 
			readerDetails = DBController.getFromDB("select r.userID "
					+ "from reader r "
					+ "where r.username = '"+username+"' ");
		
		String q = "select ro.userID, ro.bookID "
				+ "from readerorder ro "
				+ "where ro.userID = '"+readerDetails.get(0)+ "' and "
						+ "ro.bookID = '"+bookID.get(0)+"' ";	//check orders
		
		
		
		boolean rs = DBController.existsInDB(q);	//indicates whether a reader had already ordered the book he/she is trying to order
		
		//System.out.println(rs);
		
		//if book already been purchased show pop up message
		if(rs){
			mainPanel.errorBox("Book has already been purchased!", "Book Already Purchased Error");	//failure message
			return false;
		}

			ArrayList<String> now = DBController.getFromDB("SELECT NOW() ");	//get date
			
			String query = "INSERT INTO `ibookdb`.`readerorder` (`userID`, `bookID`, `date`) "
					+ "VALUES ('"+readerDetails.get(0)+"', '"+bookID.get(0)+"', '"+now.get(0)+"')";	//insert to orders
		
			ArrayList<String> info = DBController.getFromDB(query);	//execute update
		
			/*check payment*/
			String rt = loginController.RDetails.getReaderType().toString();	//get reader type
			
			if(rt.equalsIgnoreCase("onebyone")){	//if one by one
				
				ArrayList<String>debtCalc = DBController.getFromDB("update `ibookdb`.`reader` set `reader`.`debt` = "
						+ ""+(loginController.RDetails.getDebt() + bookCost)+
						" where `reader`.`userID` = '"+readerDetails.get(0)+ "' ");	//insert debt
				
				loginController.RDetails.setDebt(loginController.RDetails.addToDebt(bookCost));	//set new debt
				//System.out.println("debt is: "+loginController.RDetails.getDebt());
			}
			
			return true;
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
				/*	
					System.out.println("ID: "+ir.getUserID());
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
	
	public static int getUserPrivilege(String uname){
		ArrayList<String> priv;
		int privInt;
		
		priv = DBController.getFromDB("select u.privilege from ibookdb.user u where u.username = '"+uname+"'");
		privInt = Integer.parseInt(priv.get(0));
		
		return privInt;		
	}
	
	public static String getReaderArrangement(String ID, String uname){
		ArrayList<String> rType;
		
		if (getUserPrivilege(uname) == 2){
			rType = DBController.getFromDB("select r.rType from ibookdb.reader r where r.userID = '"+ID+"'");
			System.out.println(rType.get(0));
			if (rType.get(0).equals("periodic"))
				return "Periodic";
			if (rType.get(0).equals("onebyone"))
				return "One-by-One";
		}
		return "NONE";
	}
	
	/**
	 * 
	 * @param creditNum
	 * @param expMonth
	 * @param expYear
	 * @param cvv
	 * @param periodNum
	 * @return
	 */
	public static boolean validateCreditCard(String creditNum, String expMonth, String expYear, String cvv, String periodNum, boolean visFlag){
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH);
		month++;		//to get current month
		
		int creditNumInt;
		int expMonthInt;
		int expYearInt;
		int cvvInt;
		int periodNumInt = 0;
		
		try{
			creditNumInt = Integer.parseInt(creditNum);
			expMonthInt = Integer.parseInt(expMonth);
			expYearInt = Integer.parseInt(expYear);
			cvvInt = Integer.parseInt(cvv);
			if (visFlag)
				periodNumInt = Integer.parseInt(periodNum);
		}
		catch (NumberFormatException e){	//it's not a number!!
			mainPanel.errorBox("Please enter valid numbers\nChars and symbols are not allowed", "Credit Card Error");
			return false;
		}
		
		if (!((creditNumInt >= 10000000) && (creditNumInt <= 99999999))){
				mainPanel.errorBox("Please enter a valid credit card number\nValid number contains 8 digits", "Credit Card Error");
				return false;
		}
		if (!((expMonthInt <= 12) && (expMonthInt > 0))){
			mainPanel.errorBox("Please enter a valid month value", "Credit Card Error");
			return false;
		}
		if (!((expYearInt <= year+100) && (expYearInt >= 2017))){
			mainPanel.errorBox("Please enter a valid year value", "Credit Card Error");
			return false;
		}
		if (((expMonthInt < month) && (expYearInt == year))||(expYearInt < year)){
			mainPanel.errorBox("Your credit is out dated\nPlease enter a valid one", "Credit Card Error");
			return false;
		}
		if (!((cvvInt <= 999) && (cvvInt >= 100))){
			mainPanel.errorBox("CVV value invalid\nPlease enter a 3-digit number", "Credit Card Error");
			return false;
		}
		if (visFlag)		//only if the field was visible user could edit it
			if (!((periodNumInt > 0) && (periodNumInt < 100))){
				mainPanel.errorBox("Number of periods invalid\nPlease enter a value between 1 to 99", "Credit Card Error");
				return false;
			}
		mainPanel.infoBox("Your credit card checked and confirmed!", "Credit Card Validated");
		return true;
	}
	
	/**
	 * The method updates relevant records according to following logic: <br>
	 * If a user is already a periodic reader - extend his payment arrangement <br>
	 * If a user is an interested reader - update his privilege into a reader and set arrangement <br>
	 * @param id
	 * @param uName: user name
	 * @param creditNum
	 * @param expYear: credit card expired year
	 * @param expMonth: credit card expired month
	 * @param cvv: 3-security-digits on user's credit card
	 * @param perType: period type. If a new arrangement is periodic, set monthly or yearly values
	 * @param periodNum: number of periods to set
	 * @param newPayment: type of new payment arrangement defined
	 * @throws SQLException
	 */
	public static void setNewPaymentArrangement(String id, String uName, String creditNum, String expYear, String expMonth, String cvv,String perType, String periodNum, String newPayment) throws SQLException {

		ArrayList<String> idIsReader = null;	//if exist means user defined as a reader
		ArrayList<String> idIsPeriodic = null;	//if exist means user defined as a periodic reader
		ArrayList<String> firstLastName = null;
		
		/**get first and last name*/
		firstLastName = DBController.getFromDB("select ir.firstName, ir.lastName from interestedreader ir where ir.userID = '"+id+"'");
		String firstName = (String) firstLastName.get(0);
		String lastName = (String) firstLastName.get(1);
		String newPaymentToDBFormat = newPayment.equals("One-by-One")?"onebyone":"periodic";
		String perTypeToDBFormat = perType.equals("Years")?"yearly":"monthly";
		
		/**get ID if exists in reader table*/
		idIsReader = DBController.getFromDB("select r.userID from reader r where r.userID = '"+id+"'");
			if(idIsReader == null){
				UserSearchGUI.infoBox("ID is NOT a reader!", "My check");
				DBController.insertToDB("UPDATE ibookdb.user SET privilege='2' WHERE username='"+uName+"'");	//updating into privilege level to reader
				DBController.insertToDB("INSERT INTO ibookdb.reader (`userID`, `creditCard`, `rType`, `firstName`, `lastName`, `username`) VALUES ('"+id+"', '"+creditNum+"', '"+newPaymentToDBFormat+"', '"+firstName+"', '"+lastName+"', '"+uName+"')");
				if (newPayment.equals("Periodic")){
					if (perType.equals("Months"))
						DBController.insertToDB("INSERT INTO ibookdb.periodicreader (`userID`, `pType`, `dateOfEnd`) VALUES ('"+id+"', '"+perTypeToDBFormat+"', DATE_ADD(SYSDATE(),INTERVAL '"+periodNum+"' MONTH))");
					else
						DBController.insertToDB("INSERT INTO ibookdb.periodicreader (`userID`, `pType`, `dateOfEnd`) VALUES ('"+id+"', '"+perTypeToDBFormat+"', DATE_ADD(SYSDATE(),INTERVAL '"+periodNum+"' YEAR))");
					UserSearchGUI.infoBox("Periodic arrangement has set successfully!", "Periodic Arrangement Set");
					getUserDetails("Username","");
				} 	//end case user is going to be a periodic
				else{
					UserSearchGUI.infoBox("One-by-One arrangement has set successfully!", "One-by-One Arrangement Set");
					getUserDetails("Username","");
				}
			} 		//end case user is not a reader yet
			else{	//case user is already a reader
				idIsPeriodic = DBController.getFromDB("select pr.userID from periodicreader pr where pr.userID = '"+id+"'");
				if(idIsPeriodic == null){		//means reader is NOT defined as periodic reader in DB
					if (newPayment.equals("Periodic")){
						DBController.insertToDB("UPDATE ibookdb.reader SET creditCard='"+creditNum+"', rType='"+newPaymentToDBFormat+"' WHERE userID='"+id+"'");
						if (perType.equals("Months"))
							DBController.insertToDB("INSERT INTO ibookdb.periodicreader (`userID`, `pType`, `dateOfEnd`) VALUES ('"+id+"', '"+perTypeToDBFormat+"', DATE_ADD(SYSDATE(),INTERVAL '"+periodNum+"' MONTH))");
						else
							DBController.insertToDB("INSERT INTO ibookdb.periodicreader (`userID`, `pType`, `dateOfEnd`) VALUES ('"+id+"', '"+perTypeToDBFormat+"', DATE_ADD(SYSDATE(),INTERVAL '"+periodNum+"' YEAR))");
						UserSearchGUI.infoBox("Periodic arrangement has set successfully!", "Periodic Arrangement Set");
						getUserDetails("Username","");
					}
					else
						mainPanel.errorBox("User is already defined as One-by-One reader\nAction aborted", "Payment Arrangements Issue");
				}
				else{							//means reader is defined as periodic reader in DB
					if (newPayment.equals("Periodic")){
						DBController.insertToDB("UPDATE ibookdb.reader SET creditCard='"+creditNum+"' WHERE userID='"+id+"'");
						if (perType.equals("Months"))	//means we're about to extend in 'month' periods
							DBController.insertToDB("UPDATE ibookdb.periodicreader SET `dateOfEnd` = DATE_ADD(dateOfEnd,INTERVAL '"+periodNum+"' MONTH), pType='"+perTypeToDBFormat+"' WHERE `userID`='"+id+"'");
						else							//means we're about to extend in 'year' periods
							DBController.insertToDB("UPDATE ibookdb.periodicreader SET `dateOfEnd` = DATE_ADD(dateOfEnd,INTERVAL '"+periodNum+"' YEAR), pType='"+perTypeToDBFormat+"' WHERE `userID`='"+id+"'");
						UserSearchGUI.infoBox("Periodic arrangement extended successfully!", "Periodic Arrangement Extension");
						getUserDetails("Username","");
					}
					else{
						DBController.insertToDB("UPDATE ibookdb.reader SET creditCard='"+creditNum+"', rType='"+newPaymentToDBFormat+"' WHERE userID='"+id+"'");
						DBController.insertToDB("DELETE FROM ibookdb.periodicreader WHERE userID='"+id+"'");
						UserSearchGUI.infoBox("One-by-One arrangement has set successfully!", "One-by-One Arrangement Set");
						getUserDetails("Username","");
					}
				}
			}
	}
		
	/*		if (newPayment.equals("Periodic")){
				idIsPeriodic = DBController.getFromDB("select pr.userID from periodicreader pr where pr.userID = '"+id+"'");
				if(idIsPeriodic == null)		//means user is NOT defined as periodic reader in DB
					if (perType.equals("monthly"))
						DBController.insertToDB("INSERT INTO ibookdb.periodicreader (`userID`, `pType`, `dateOfEnd`) VALUES ('"+id+"', '"+perTypeToDBFormat+"', DATE_ADD(SYSDATE(),INTERVAL '"+periodNum+"' MONTH))");
					else
						DBController.insertToDB("INSERT INTO ibookdb.periodicreader (`userID`, `pType`, `dateOfEnd`) VALUES ('"+id+"', '"+perTypeToDBFormat+"', DATE_ADD(SYSDATE(),INTERVAL '"+periodNum+"' YEAR))");
				else								//means user defined as periodic and we're about to extend his arrangement
					if (perType.equals("yearly"))	//means we're about to extend in 'month' periods
						DBController.insertToDB("UPDATE ibookdb.periodicreader SET `dateOfEnd` = DATE_ADD(dateOfEnd,INTERVAL '"+periodNum+"' MONTH) WHERE `userID`='"+id+"'");
					else							//means we're about to extend in 'year' periods
						DBController.insertToDB("UPDATE ibookdb.periodicreader SET `dateOfEnd` = DATE_ADD(dateOfEnd,INTERVAL '"+periodNum+"' YEAR) WHERE `userID`='"+id+"'");
				UserSearchGUI.infoBox("Periodic arrangement has set successfully!", "Periodic Arrangement Set");
			}
			else
			{
				
			}
	*/
	
	
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
	/**
	 *  
	 * @param bid
	 */
	public static void displaySearchReport(String bid,String bName){
		ArrayList<String> info = DBController.getFromDB("select searches.date from searches where searches.bookID = "+bid);
		ArrayList<String> nows = DBController.getFromDB("select now()");
		if(info == null  || nows.equals(info))
			nows = DBController.getFromDB("select now()");
		 String now = nows.get(0).substring(0,7);
		 ArrayList<String> dataT = new  ArrayList<String>();
	      double[] data;
	      int size;
	      if(info != null) 
	    	  size = info.size();
	      else
	    	  size = 0;
	        for(int p = 0; p < size;p++){
	        	String date = info.get(p);//+"."+info.get(p).substring(5, 7);
	        	if (date.contains(now))
	        	{
	        		date = date.substring(8, 10);
	        		dataT.add(date);
	        	}
	             
	        }
	        if(info != null){
	        	data = new double[dataT.size()];
	        	for(int i = 0;i < dataT.size();i++)
	        		data[i] = Double.parseDouble(dataT.get(i));
	        	
	        	double[] appears = new double[31];
	        	for(int i = 0;i<31;i++)
	        		appears[i] = 0;
	        	for(int i = 0;i<data.length;i++)
	        		appears[(int) data[i]]++;
	        	

	            final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	            
	            for(int i = 0;i < 31 ; i++)
	            	dataset.addValue( appears[i] , "Number Of Searches" , Integer.toString(i+1) );

	            JFreeChart barChart = ChartFactory.createBarChart("Searches Report", "Day", "Number Of Searches",   dataset,
	            		PlotOrientation.VERTICAL, true, true, false);

	            ChartFrame frame = new ChartFrame("Search Chart",barChart,true);
		        frame.setVisible(true);
		        frame.setSize(700, 600);
	        }
	        else
	        	mainPanel.infoBox("No searches", "Report");
	     //   frame.setDefaultCloseOperation(ChartFrame.EXIT_ON_CLOSE);
		
	}
	public static void displayOrderRankByScope(String scope , String bid , String bookName,ArrayList<String> scopes){
		ArrayList<String> info = DBController.getFromDB("select count(readerorder.userID) cnt,book.bookID"
														+" from book,readerorder ,bscope where readerorder.bookID = book.bookID and book.bookID = bscope.bookID and bscope.scopeName = '"+scope+"' "
														+" group by book.bookID"
														+" order by cnt");
		int rank = 1;
		if(info != null){
			int i = info.size()-2;
			while(i>0 && !bid.equals(info.get(i+1)))
			{
				System.out.println("i is : "+i);
				if(i>0 && Integer.parseInt(info.get(i))>Integer.parseInt(info.get(i-2)))
				rank++;
				i-=2;
			}
			if(i == 0 && !bid.equals(info.get(1)))
				rank ++;
		}
		ReportsGUI panel = new ReportsGUI(loginController.use.getUsername(),"Manager");	
		panel.chooseBy(bookName, bid, scopes);
		panel.displayRank(Integer.toString(rank));
		loginController.mainG.setContentPane(panel);
		loginController.mainG.revalidate();
		
		
	}
	public static void displayOrderRank( String bid , ArrayList<String> scopes,String bookName){
		ArrayList<String> info = DBController.getFromDB("select count(readerorder.userID) cnt,book.bookID"
														+" from book,readerorder where readerorder.bookID = book.bookID"
														+" group by book.bookID"
														+" order by cnt");
		int rank = 1;
		if(info != null){
			int i = info.size()-2;
			while(i>0 && !bid.equals(info.get(i+1)))
			{
				if(i>0 && Integer.parseInt(info.get(i))>Integer.parseInt(info.get(i-2)))
					rank++;
				i-=2;
			}
		if(i == 0 && !info.get(i+1).equals(bid))
			rank ++;
		}
		ReportsGUI panel = new ReportsGUI(loginController.use.getUsername(),"Manager");	
		panel.chooseBy(bookName, bid, scopes);
		panel.displayRank(Integer.toString(rank));
		loginController.mainG.setContentPane(panel);
		loginController.mainG.revalidate();
	}
	public static void displayOrdersReport(String bid){
		
		ArrayList<String> info = DBController.getFromDB("select readerorder.date from readerorder where readerorder.bookID = "+bid+"");
		ArrayList<String> nows = DBController.getFromDB("select now()");
		if(info == null  || nows.equals(info))
			nows = DBController.getFromDB("select now()");
		 String now = nows.get(0).substring(0,7);
		 ArrayList<String> dataT = new  ArrayList<String>();
	      double[] data;
	      int size;
	      if(info != null) 
	    	  size = info.size();
	      else
	    	  size = 0;
	        for(int p = 0; p < size;p++){
	        	String date = info.get(p);//+"."+info.get(p).substring(5, 7);
	        	if (date.contains(now))
	        	{
	        		date = date.substring(8, 10);
	        		dataT.add(date);
	        	}
	             
	        }
	        if(info != null){
	        	data = new double[dataT.size()];
	        	for(int i = 0;i < dataT.size();i++)
	        		data[i] = Double.parseDouble(dataT.get(i));
	        
	        	int[] appears = new int[31];
	        	for(int i = 0;i<31;i++)
	        		appears[i] = 0;
	        	for(int i = 0;i<data.length;i++)
	        		appears[(int) data[i]]++;
	        	int appearsSize = 0;
	        	
	        	final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	            
	            for(int i = 0;i < 31 ; i++)
	            	dataset.addValue( appears[i] , "Number Of Orders" , Integer.toString(i+1) );

	            JFreeChart barChart = ChartFactory.createBarChart("Orders Report", "Day", "Number Of Orders",   dataset,
	            		PlotOrientation.VERTICAL, true, true, false);

	            ChartFrame frame = new ChartFrame("Orders Chart",barChart,true);
		        frame.setVisible(true);
		        frame.setSize(700, 600);
	        }
	        else
	        	mainPanel.infoBox("No Orders", "Report");
	     //   frame.setDefaultCloseOperation(ChartFrame.EXIT_ON_CLOSE);
		
	}
	public static void displayWorkerSearch(){
		WorkerManagementGUI workers = new WorkerManagementGUI(loginController.use.getUsername());
		
		ArrayList<String> info = DBController.getFromDB("select u.username , p.description from user u , privilege p "
														+" where u.privilege = p.privilege and u.privilege>2 and p.privilege<6");
		
		if (info != null){
			int count = 0;
			workers.data = new String[info.size()/2][2];
			for(int i = 0 ; i < info.size()/2;i++)
				for(int j = 0 ; j < 2 ; j++){
					workers.data[i][j] = info.get(count);
					count++;
				}
			workers.displayWorkers();
			loginController.mainG.setContentPane(workers);
			loginController.mainG.revalidate();
		}
		else
			mainPanel.warningBox("No workers in the system", "Worker Management");
		
		
	}
	public static void displayEditPrivilege(String username,String oldPriv){
		
		ArrayList<String> privileges = new ArrayList<String>();
		privileges.add("Editor");
		privileges.add("Library Worker");
		privileges.add("Librarian");
		
		if(oldPriv.equals("Editor"))
			privileges.remove(0);
		
		if(oldPriv.equals("Library Worker"))
			privileges.remove(1);
		
		if(oldPriv.equals("Librarian"))
			privileges.remove(2);
		
		WorkerManagementGUI worker = new WorkerManagementGUI(loginController.use.getUsername());
		worker.editWorker(username, oldPriv, privileges);
		loginController.mainG.setContentPane(worker);
		loginController.mainG.revalidate();
	}
	public static void  changePrivilege(String username,String newPriv) throws SQLException{
		//UPDATE `ibookdb`.`user` SET `privilege`='4' WHERE `username`='Avi';
		if(newPriv.equals("Editor"))
			DBController.insertToDB("UPDATE `ibookdb`.`user` SET `privilege`='3' WHERE `username`='"+username+"';");
		
		else if(newPriv.equals("Library Worker"))
			DBController.insertToDB("UPDATE `ibookdb`.`user` SET `privilege`='4' WHERE `username`='"+username+"';");
		else
			DBController.insertToDB("UPDATE `ibookdb`.`user` SET `privilege`='5' WHERE `username`='"+username+"';");
		
		mainPanel.infoBox(username+"'s privilege has been changed","Privilege");
		displayWorkerSearch();
		
	}
	
}
