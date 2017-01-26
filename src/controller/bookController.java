package controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import boundry.OpenMailGUI;
import boundry.ReportsGUI;
import boundry.mainPanel;
import boundry.orderListGUI;
import boundry.readerGUI;
import boundry.reviewGUI;
import boundry.userBookGUI;
import boundry.workerBookGUI;
import entity.Book;

public class bookController {
	public void newOrder() {
		// TODO - implement bookController.newOrder
		throw new UnsupportedOperationException();
	}
	
	/**
	 * addBook - display adding a book window
	 */
	public static void addBook() {
			workerBookGUI panel;
			if(loginController.use.getprivilege() == 4)
				panel = new workerBookGUI(loginController.use.getUsername(),"libraryWorker");
			else if(loginController.use.getprivilege() == 5)
				panel = new workerBookGUI(loginController.use.getUsername(),"Librarian");
			else
				panel = new workerBookGUI(loginController.use.getUsername(),"Manager");
			
			panel.addBook();
			loginController.mainG.setContentPane(panel);
			loginController.mainG.revalidate();
			
	}
	/**
	 * addBook get book information and add it to DB
	 * @param Book book 
	 * @throws SQLException 
	 */
	public static void addBook(Book book,File pdf,File docx,File fb2) throws SQLException {
		ArrayList<String> info =null;
		ArrayList<String> temp;
		info = DBController.getFromDB("select max(author.authorID) from author");
		int aNewID = Integer.parseInt(info.get(0)) + 1;
		int bNewID;
		temp = book.getAuthors();
		for(int i =0 ; i < temp.size() ; i++)
			if(!verifyAuthor(temp.get(i)))
			{
				DBController.insertToDB("INSERT INTO `ibookdb`.`author` (`authorID`, `authorName`) VALUES ('"+aNewID+"', '"+temp.get(i)+"');");
				aNewID++;
			}
		temp = book.getKey();
		if(temp != null)
			for( int i =0;i<temp.size();i++)
				if(!verifyKeyword(temp.get(i)))
					DBController.insertToDB("INSERT INTO `ibookdb`.`keyword` (`word`) VALUES ('"+temp.get(i)+"');");
		
		info =DBController.getFromDB("select max(book.bookID) from book");
		bNewID = Integer.parseInt(info.get(0))+1;
		if(book.isSuspended())
			DBController.insertToDB("INSERT INTO `ibookdb`.`book` (`bookID`, `Title`, `language`, `brief`, `appendix`, `numOfOrders`,  `cost`, `suspended`) VALUES ('"+bNewID+"', '"+book.getTitle()+"', '"+book.getLanguage()+"', '"+book.getBrief()+"', '"+book.getAppendix()+"', '0',  '"+book.getCost()+"', 1);");
		else
			DBController.insertToDB("INSERT INTO `ibookdb`.`book` (`bookID`, `Title`, `language`, `brief`, `appendix`,  `numOfOrders`,  `cost`, `suspended`) VALUES ('"+bNewID+"', '"+book.getTitle()+"', '"+book.getLanguage()+"', '"+book.getBrief()+"', '"+book.getAppendix()+"',  '0',  '"+book.getCost()+"', 0);");
		temp = book.getAuthors();
		for(int i = 0;i < temp.size();i++){
			
			int aID;
			int laID=0;
			info = DBController.getFromDB("select author.authorID from author where author.authorName = '"+temp.get(i)+"'");
			aID = Integer.parseInt(info.get(0));
			if(aID == laID){
				info = DBController.getFromDB("select author.authorID from author where author.authorName = '"+temp.get(i)+"'");
				aID = Integer.parseInt(info.get(i));
			}
			DBController.insertToDB("INSERT INTO `ibookdb`.`bauthor` (`authorID`, `bookID`) VALUES ('"+aID+"', '"+bNewID+"');");
			laID = aID;
		}
		temp = book.getKey();
		for(int i =0 ; i<temp.size() ; i++)
			DBController.insertToDB("INSERT INTO `ibookdb`.`bkey` (`bookID`, `Word`) VALUES ('"+bNewID+"', '"+temp.get(i)+"');");
		
		temp = book.getScope();
		ArrayList<String> temp2 = book.getSubject();
		for(int i =0 ; i < temp.size() ; i++)
			if(!verifyScope(temp.get(i)))
			{
				DBController.insertToDB("INSERT INTO `ibookdb`.`scope` (`scopeName`) VALUES ('"+temp.get(i)+"');");
				aNewID++;
			}
		for(int i =0 ; i<temp.size() ; i++)
			DBController.insertToDB("INSERT INTO `ibookdb`.`bscope` (`bookID`, `scopeName`, `rank`, `subject`) VALUES ('"+bNewID+"', '"+temp.get(i)+"', '0', '"+temp2.get(i)+"');");
		try {
			DBController.sendFile(pdf, docx, fb2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	/**
	 * removeBook - get a book id and remove it from DB
	 * the method gets an instance of String(witch is the book ID and erase the book from the database
	 * @param bid String
	 * @throws SQLException
	 * if the book ID is not a number or not exists in the data base it gets an exception
	 */
	public static void removeBook(String bid) throws SQLException {
		DBController.insertToDB("DELETE FROM `ibookdb`.`book` WHERE `bookID`='"+bid+"';");
		searchBook();
	}

	public void removeBookFromCatalog() {
		// TODO - implement bookController.removeBookFromCatalog
		throw new UnsupportedOperationException();
	}

	public void lockBook() {
		// TODO - implement bookController.lockBook
		throw new UnsupportedOperationException();
	}

	/**Book Search*/
	/**
	 * searchBook - display the search book screen
	 */
	public static void searchBook() {
		
		userBookGUI panel;
		if(loginController.use.getprivilege() == 1)
			panel = new userBookGUI(loginController.use.getUsername(),"Interested Reader");
		
		else if(loginController.use.getprivilege() == 2)
			panel = new userBookGUI(loginController.use.getUsername(),"Reader");
		
		else if(loginController.use.getprivilege() == 3)
			panel = new workerBookGUI(loginController.use.getUsername(),"editor");
		
		else if(loginController.use.getprivilege() == 4)
			panel = new workerBookGUI(loginController.use.getUsername(),"Library Worker");
		
		else if(loginController.use.getprivilege() == 5)
			panel = new workerBookGUI(loginController.use.getUsername(),"Librarian");
		
		else 
			panel = new workerBookGUI(loginController.use.getUsername(),"Manager");
		
		
		
		panel.displaySearch();
		loginController.mainG.setContentPane(panel);
		loginController.mainG.revalidate();
	}
	/**Book Search END*/
	
	/**
	 * displayResults - get a book information and searching books
	 * in the database that matches the search
	 *  
	 * @param brief String
	 * @param title String
	 * @param langu String 
	 * @param keyWord String 
	 * @param author String 
	 * @param appendix String 
	 * @param scope String 
	 */
	public static void displayResults(String brief,String title,String langu,String keyWord,String author,String appendix,String scope ){
		ArrayList<String> info;
		
			if(loginController.use.getprivilege() == 6)
				info = DBController.getFromDB("select distinct sc.scopeName,bsc.subject,b.Title,b.bookID " 
						+" from book b,author a,bauthor ba,keyword k,bkey bk,scope sc,bscope bsc"
						+" where b.bookID=ba.bookID and ba.authorID = a.authorID and b.bookID= bk.bookID and bk.Word=k.word "
						+" and b.bookID=bsc.bookID and bsc.scopeName=sc.scopeName and b.Title like '%"+title+"%' and b.appendix like '%"+appendix+"%'"
						+" and b.brief like '%"+brief+"%' and b.language like '%"+langu+"%' and a.authorName like '%"+author+"%' and k.word like '%"+keyWord+"%'"
						+" and sc.scopeName like '%"+scope+"%'"
						+" order by sc.scopeName");
			
			else
				info = DBController.getFromDB("select distinct sc.scopeName,bsc.subject,b.Title,b.bookID " 
						+" from book b,author a,bauthor ba,keyword k,bkey bk,scope sc,bscope bsc"
						+" where b.bookID=ba.bookID and ba.authorID = a.authorID and b.bookID= bk.bookID and bk.Word=k.word "
						+" and b.bookID=bsc.bookID and bsc.scopeName=sc.scopeName and b.Title like '%"+title+"%' and b.appendix like '%"+appendix+"%'"
						+" and b.brief like '%"+brief+"%' and b.language like '%"+langu+"%' and b.suspended = 0 and a.authorName like '%"+author+"%' and k.word like '%"+keyWord+"%'"
						+" and sc.scopeName like '%"+scope+"%'"
						+" order by sc.scopeName");
			
			userBookGUI panel;
			
			/*if his an interested reader add it to the title*/ 
			if(loginController.use.getprivilege() == 1)
				panel = new userBookGUI(loginController.use.getUsername(),"Interested Reader");
			
			/*if his a reader add it to the title*/
			else if(loginController.use.getprivilege() == 2)
				panel = new userBookGUI(loginController.use.getUsername(),"Reader");
			
			else if(loginController.use.getprivilege() == 3)
				panel = new workerBookGUI(loginController.use.getUsername(),"editor");
			
			else if(loginController.use.getprivilege() == 4)
				panel = new workerBookGUI(loginController.use.getUsername(),"Library Worker");
			
			else if(loginController.use.getprivilege() == 5)
				panel = new workerBookGUI(loginController.use.getUsername(),"Librarian");
			
			else 
				panel = new workerBookGUI(loginController.use.getUsername(),"Manager");
			
			/*if we get results we add the results table*/
			if(info != null)
			{
				userBookGUI.data = new String[info.size()/4][4];
				
				int count =0;
				for(int i = 0 ; i < info.size()/4 ; i++){
					for(int j = 0 ; j < 4 ; j++){
						
						if(j == 0 && i > 0 && count > 0 && info.get(count).equals(info.get(count-4)))
							userBookGUI.data[i][j] ="";
						else
							userBookGUI.data[i][j] = info.get(count);
						if(j==0 && i>0)
							System.out.println(userBookGUI.data[i][j]);
						count++;
					}}
				panel.displayResults();
				
			}
			else
				panel.noResults();
			panel.displaySearch();
			loginController.mainG.setContentPane(panel);
			loginController.mainG.revalidate();
			
			
	}
	/**
	 * chooseBook display the chosen book
	 * @param bid a String instance for the book id
	 */

	public synchronized static  void chooseBook(String bid) {
		
		Book book = new Book();
		
		userBookGUI panel;
		
		ArrayList<String> info=null;


		book.setBookId(bid);
		info = DBController.getFromDB("select b.Title,b.language,b.brief,b.appendix,b.cost,b.suspended"
									+" from book b"
									+" where b.bookID="+bid);
		
		book.setTitle(info.get(0));
		book.setLanguage(info.get(1));
		book.setBrief(info.get(2));
		book.setAppendix(info.get(3));
		float cost = Float.parseFloat(info.get(4));
		book.setCost(cost);
		System.out.println(info);
		int sus = Integer.parseInt(info.get(5));
		if(sus == 0)
			book.unlock();
		else
			book.lock();
		
		book.setSubject(DBController.getFromDB("select bscope.subject from bscope where bscope.bookID = '"+bid+"'"));
		
		if(book.getSubject().equals(info))
			book.setSubject(DBController.getFromDB("select bscope.subject from bscope where bscope.bookID = '"+bid+"'"));
		
		book.setScope( DBController.getFromDB("select s.scopeName"
				+" from scope s,bscope bs "
				+ "where s.scopeName = bs.scopeName and bs.bookID = " +bid));
		
		if(book.getScope().equals(book.getSubject()))
			book.setScope( DBController.getFromDB("select s.scopeName"
					+" from scope s,bscope bs "
					+ "where s.scopeName = bs.scopeName and bs.bookID = " +bid));
			
			
		book.setAuthors(DBController.getFromDB("select a.authorName"
									+" from author a, bauthor ba"
									+" where a.authorID = ba.authorID and ba.bookID = "+bid));
		
		if(book.getAuthors().equals(book.getScope()))
			book.setAuthors(DBController.getFromDB("select a.authorName"
					+" from author a, bauthor ba"
					+" where a.authorID = ba.authorID and ba.bookID = "+bid));
		
		/*if his an interested reader add it to the title*/ 
		if(loginController.use.getprivilege() == 1)
			panel = new userBookGUI(loginController.use.getUsername(),"Interested Reader");
		
		/*if his a reader add it to the title*/
		else if (loginController.use.getprivilege() == 2)
			panel = new userBookGUI(loginController.use.getUsername(),"Reader");
		
		else if(loginController.use.getprivilege() == 3)
			panel = new workerBookGUI(loginController.use.getUsername(),"editor");
		
		else if(loginController.use.getprivilege() == 4)
			panel = new workerBookGUI(loginController.use.getUsername(),"Library Worker");
		
		else if(loginController.use.getprivilege() == 5)
			panel = new workerBookGUI(loginController.use.getUsername(),"Librarian");
		
		else 
			panel = new workerBookGUI(loginController.use.getUsername(),"Manager");
		if(loginController.use.getprivilege() < 3)
			try {
				DBController.insertToDB("INSERT INTO `ibookdb`.`searches`(`bookID`,`date`)VALUES("+bid+",now());");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		panel.displayBook(book);
		loginController.mainG.setContentPane(panel);
		loginController.mainG.revalidate();
		
	}
	/**
	 * editBookinfo - gets a Book class and open the edit book page
	 * @param book Book
	 */
	public static void editBookinfo(Book book) {
		workerBookGUI panel;
		if (book.getKey() == null)
			book.setKey(DBController.getFromDB("select bkey.word from bkey where bkey.bookID='"+book.getBookID()+"'"));
		
		
		if(loginController.use.getprivilege() == 4)
			panel = new workerBookGUI(loginController.use.getUsername(),"Library Worker");
		
		else if(loginController.use.getprivilege() == 5)
			panel = new workerBookGUI(loginController.use.getUsername(),"Librarian");
		
		else 
			panel = new workerBookGUI(loginController.use.getUsername(),"Manager");
		panel.editBook(book);
		loginController.mainG.setContentPane(panel);
		loginController.mainG.revalidate();
	}

	public void setAbsRank() {
		// TODO - implement bookController.setAbsRank
		throw new UnsupportedOperationException();
	}
	/**
	 * display the scope edit panel
	 */
	public static void scopeEdit() {
		workerBookGUI panel = new workerBookGUI(loginController.use.getUsername(),"Librarian");
		ArrayList<String> info = DBController.getFromDB("select scope.scopeName from scope");
		if(info != null)
			panel.editScope(info);
		else
			panel.noScope();
		loginController.mainG.setContentPane(panel);
		loginController.mainG.revalidate();

	}
	/**
	 * updateScope get 2 strings and change a scope name in DB
	 * @param from - the name of the scope that is being changed
	 * @param to - the new name for the scope
	 */
	public static void updateScope(String from,String to){
		try {
			DBController.insertToDB("UPDATE `ibookdb`.`scope` SET `scopeName`='"+to+"' WHERE `scopeName`='"+from+"';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		scopeEdit();
		
	}
	/**
	 * verifyAuthor - Check the existence of an author
	 * @param author String
	 * @return boolean
	 * @throws SQLException 
	 */
	public synchronized static boolean verifyAuthor(String author) throws SQLException{
		return DBController.existsInDB("select author.authorName , author.authorID"
				+" from author"
				+" where author.authorName = '"+author+"'");
	}
	/**
	 * verifyScope - Check the existence of a scope
	 * @param scope String
	 * @return boolean
	 * @throws SQLException
	 */
	public synchronized static boolean verifyScope(String scope) throws SQLException{
		return DBController.existsInDB("select scope.scopeName"
									+" from scope"
									+" where scope.scopeName = '"+scope+"'");
	}
	/**
	 * verifyKeyword - Check the existence of a Keyword
	 * @param key String
	 * @return boolean
	 * @throws SQLException
	 */
	public synchronized static boolean verifyKeyword(String key) throws SQLException{
		return DBController.existsInDB("select keyword.word from keyword where keyword.word = '"+key+"'");
	}
	/**
	 * changeBookInfo - 
	 * The method gets a Book instance and compare every detail of the book in the database 
	 * (for example if a certain author exists and if he is already connected to the book
	 * if he's not the method connects him
	 * @param book Book
	 * @throws SQLException 
	 * 
	 */
	public static void changeBookInfo(Book book) throws SQLException{
		ArrayList<String> info =null;
		ArrayList<String> temp;
		info = DBController.getFromDB("select max(author.authorID) from author");
		int aNewID = Integer.parseInt(info.get(0)) + 1;
		int bNewID;
		temp = book.getAuthors();
		for(int i =0 ; i < temp.size() ; i++)
			try {
				if(!verifyAuthor(temp.get(i))) //check if all the authors in the list exists in the DB if not it adds a new one
				{
					DBController.insertToDB("INSERT INTO `ibookdb`.`author` (`authorID`, `authorName`) VALUES ('"+aNewID+"', '"+temp.get(i)+"');");
					aNewID++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		info = DBController.getFromDB("select bauthor.authorID from bauthor where bauthor.bookID = '"+book.getBookID()+"'");//get the book authors in order to erase them 
		for(int i = 0 ; i<info.size();i++)
			try {
				DBController.insertToDB("DELETE FROM `ibookdb`.`bauthor` WHERE `authorID`='"+info.get(i)+"' and`bookID`='"+book.getBookID() +"';");//delete the author
			} catch (SQLException e) {
				e.printStackTrace();
			}
		bNewID = Integer.parseInt(book.getBookID());
		temp = book.getAuthors(); // gets the new authors list
		for(int i = 0;i < temp.size();i++){
			
			int aID; //Variable that saves the author ID
			int laID=0;
			info = DBController.getFromDB("select author.authorID from author where author.authorName = '"+temp.get(i)+"'");
			aID = Integer.parseInt(info.get(0)); // gets the current authors ID
			if(aID == laID){
				info = DBController.getFromDB("select author.authorID from author where author.authorName = '"+temp.get(i)+"'");
				aID = Integer.parseInt(info.get(i));
			}
			try { //insert a new list of authors to the book
					DBController.insertToDB("INSERT INTO `ibookdb`.`bauthor` (`authorID`, `bookID`) VALUES ('"+aID+"', '"+bNewID+"');");
			} catch (SQLException e) {
			}
			laID = aID;
		}
		/*authors updated*/
		
		temp = book.getKey();
		for( int i =0;i<temp.size();i++)
				if(!verifyKeyword(temp.get(i)))  //check if the keyword exists in the DB if not it adds a new one
					DBController.insertToDB("INSERT INTO `ibookdb`.`keyword` (`word`) VALUES ('"+temp.get(i)+"');");

		
		info = DBController.getFromDB("select bkey.Word from bkey where bkey.bookID = '"+bNewID+"'"); //get the list of the book old keywords in order to erase them
		for(int i = 0; i< info.size();i++)
			DBController.insertToDB("DELETE FROM `ibookdb`.`bkey` WHERE `bookID`='"+bNewID+"' and`Word`='"+info.get(i)+"';");//delete every keyword in the list
		
		  //the new keywords list
		for(int i =0 ; i<temp.size() ; i++)//insert the new list of keywords to the DB
					DBController.insertToDB("INSERT INTO `ibookdb`.`bkey` (`bookID`, `Word`) VALUES ('"+bNewID+"', '"+temp.get(i)+"');");
		/*keyword updated*/
		
		temp = book.getScope(); //gets the new scope list
		ArrayList<String> temp2 = book.getSubject();
		for(int i =0 ; i < temp.size() ; i++) //if scope does not exists in the DB add a new one
				if(!verifyScope(temp.get(i)))
					DBController.insertToDB("INSERT INTO `ibookdb`.`scope` (`scopeName`) VALUES ('"+temp.get(i)+"');");
	//
		info = DBController.getFromDB("select bscope.scopeName from bscope where bscope.bookID = '"+bNewID+"'");//get the book's old scope list
		
		for(int i = 0;i<info.size();i++)//delete all the scopes from the old scope list
			DBController.insertToDB("DELETE FROM `ibookdb`.`bscope` WHERE `scopeName`='"+info.get(i)+"' and`bookID`='"+bNewID+"';");
		
		for(int i =0 ; i<temp.size() ; i++) //insert all the new scope list to the DB
					DBController.insertToDB("INSERT INTO `ibookdb`.`bscope` (`bookID`, `scopeName`, `rank`, `subject`) VALUES ('"+bNewID+"', '"+temp.get(i)+"', '0', '"+temp2.get(i)+"');");

		
		
		
		if(book.isSuspended())  // if the book is suspended put 1 in the suspended field in the DB
		{
			DBController.insertToDB("UPDATE `ibookdb`.`book` SET `Title`='', `language`='', `brief`='', `appendix`='', `cost`='-1', `suspended`='0' WHERE `bookID`='"+bNewID+"';");
			DBController.insertToDB("UPDATE `ibookdb`.`book` SET `Title`='"+book.getTitle()+"', `language`='"+book.getLanguage()+"', `brief`='"+book.getBrief()+"', `appendix`='"+book.getAppendix()+"', `cost`='"+book.getCost()+"', `suspended`='1'  WHERE `bookID`='"+bNewID+"';");
		}
		else{  // if the book is not suspended put 0 in the suspended field in the DB
			DBController.insertToDB("UPDATE `ibookdb`.`book` SET `Title`='', `language`='', `brief`='', `appendix`='', `cost`='-1', `suspended`='1' WHERE `bookID`='"+bNewID+"';");
			DBController.insertToDB("UPDATE `ibookdb`.`book` SET `Title`='"+book.getTitle()+"', `language`='"+book.getLanguage()+"', `brief`='"+book.getBrief()+"', `appendix`='"+book.getAppendix()+"', `cost`='"+book.getCost()+"', `suspended`='0'  WHERE `bookID`='"+bNewID+"';");
		}
		
		/*
		temp = book.getAuthors();
		for(int i = 0;i < temp.size();i++){
			
			int aID; //Variable that saves the author ID
			int laID=0;
			info = DBController.getFromDB("select author.authorID from author where author.authorName = '"+temp.get(i)+"'");
			aID = Integer.parseInt(info.get(0)); // gets the current authors ID
			if(aID == laID){
				info = DBController.getFromDB("select author.authorID from author where author.authorName = '"+temp.get(i)+"'");
				aID = Integer.parseInt(info.get(i));
			}
			try {
				if(!DBController.existsInDB("select bauthor.bookID from bauthor  where bauthor.bookID = '"+bNewID+"' and bauthor.authorID = '"+aID+"'"))
					DBController.insertToDB("INSERT INTO `ibookdb`.`bauthor` (`authorID`, `bookID`) VALUES ('"+aID+"', '"+bNewID+"');");
			} catch (SQLException e) {
			}
			laID = aID;
		}
		temp = book.getKey();
		for(int i =0 ; i<temp.size() ; i++)
			try {
				if(!DBController.existsInDB("select bkey. bookID from bkey where bkey.bookID = '"+bNewID+"' and bkey.Word ='"+temp.get(i)+"'"));
					DBController.insertToDB("INSERT INTO `ibookdb`.`bkey` (`bookID`, `Word`) VALUES ('"+bNewID+"', '"+temp.get(i)+"');");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		temp = book.getScope();
		ArrayList<String> temp2 = book.getSubject();
		for(int i =0 ; i < temp.size() ; i++)
			try {
				if(!verifyScope(temp.get(i)))
					DBController.insertToDB("INSERT INTO `ibookdb`.`scope` (`scopeName`) VALUES ('"+temp.get(i)+"');");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		for(int i =0 ; i<temp.size() ; i++)
			try {
				if(!DBController.existsInDB("select bscope.bookID from bscope where bscope.bookID = '"+bNewID+"' and bscope.scopeName = '"+temp.get(i)+"'"));
					DBController.insertToDB("INSERT INTO `ibookdb`.`bscope` (`bookID`, `scopeName`, `rank`, `subject`) VALUES ('"+bNewID+"', '"+temp.get(i)+"', '0', '"+temp2.get(i)+"');");
			} catch (SQLException e) {
				e.printStackTrace();

			}
	*/	
	}
	/**
	 * displayResultsForReports - get a book information and searching books
	 * in the database that matches the search
	 *  
	 * @param brief String
	 * @param title String
	 * @param langu String 
	 * @param keyWord String 
	 * @param author String 
	 * @param appendix String 
	 * @param scope String 
	 */
	public static void displayResultsForReports(String brief,String title,String langu,String keyWord,String author,String appendix,String scope){
		
		ArrayList<String> info;
		
		info = DBController.getFromDB("select distinct sc.scopeName,bsc.subject,b.Title,b.bookID " 
				+" from book b,author a,bauthor ba,keyword k,bkey bk,scope sc,bscope bsc"
				+" where b.bookID=ba.bookID and ba.authorID = a.authorID and b.bookID= bk.bookID and bk.Word=k.word "
				+" and b.bookID=bsc.bookID and bsc.scopeName=sc.scopeName and b.Title like '%"+title+"%' and b.appendix like '%"+appendix+"%'"
				+" and b.brief like '%"+brief+"%' and b.language like '%"+langu+"%' and a.authorName like '%"+author+"%' and k.word like '%"+keyWord+"%'"
				+" and sc.scopeName like '%"+scope+"%'"
				+" order by sc.scopeName");
		ReportsGUI panel;
		panel = new ReportsGUI(loginController.use.getUsername(),"Manager");
		
		if(info != null)
		{
			ReportsGUI.data2 = new String[info.size()/4][4];
			
			int count =0;
			for(int i = 0 ; i < info.size()/4 ; i++){
				for(int j = 0 ; j < 4 ; j++){
					
					if(j == 0 && i > 0 && count > 0 && info.get(count).equals(info.get(count-4)))
						ReportsGUI.data2[i][j] ="";
					else
						ReportsGUI.data2[i][j] = info.get(count);
					if(j==0 && i>0)
						System.out.println(ReportsGUI.data2[i][j]);
					count++;
				}}
			panel.displayBookSearchResults();
			
		}
		else
			panel.noBookResults();
		panel.displayBookSearchForReports();
		loginController.mainG.setContentPane(panel);
		loginController.mainG.revalidate();
		
	}
	/**
	 * cooseBookForReports - get book name and id and display the panel where the 
	 * manager choose what kind of report he wants
	 * @param bookName - a string contains the book name
	 * @param ID - a string contains the book ID
	 */
	public static void cooseBookForReports(String bookName,String ID){
		ReportsGUI panel = new ReportsGUI(loginController.use.getUsername(),"Manager");
		ArrayList<String> info =DBController.getFromDB("select scope.scopeName from scope,bscope where bscope.bookID = '"+ID+"' and scope.scopeName = bscope.scopeName");
		
		panel.chooseBy(bookName, ID,info);
		loginController.mainG.setContentPane(panel);
		loginController.mainG.revalidate();
	}

	
	
	/**
	 * findUsersOrders - method.
	 * The method finds all the books ordered by a reader.
	 * (NOT DONE YET)
	 * @param user - String, a username
	 */


/*	public static void findUsersOrders(String user) {
		
		ArrayList<String> orders = new ArrayList<String>();
		
		orders = DBController.getFromDB("select b.Title, ro.date "
						+"from book b, reader r, readerorder ro "
						+"where r.username like '%" +user+"' and " 
						+	   "r.userID = ro.userID and "
						+	   "b.bookID = ro.bookID ");
		
		if(!(orders.isEmpty())){
			
			readerGUI.data = new String[orders.size()/3][3];
			int count =0;
			for(int i = 0 ; i < orders.size()/3 ; i++)
				for(int j = 0 ; j < 3 ; j++){
					readerGUI.data[i][j] = orders.get(count);
					count++;
				}
		}
		
		
		System.out.println(orders.toString());

	}*/
	/**
	 * get a book information and pass it to DBController to download the wanted file
	 * @param bid
	 * @param format
	 * @param bookName
	 * @throws SQLException
	 */

	public static void downloadBook(String bid,String format,String bookName) throws SQLException{
		
		String path = null;
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("C:\\"));
		fileChooser.setDialogTitle("Select a diractory");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnValue = fileChooser.showOpenDialog(null);
		if(returnValue == JFileChooser.APPROVE_OPTION)
			path = fileChooser.getSelectedFile().getPath();
		DBController.getFile(bid,format,bookName,path);
		mainPanel.infoBox("The Book "+bookName+" has been sent to you!", "Book Ordered Message");	//show success message
	}

/**
 * displayUserOrders - get a username , get his orders from the datatbase 
 * and display a window with the results table or a lable "no results"
 * @param uName - the username
 */
public static void displayUserOrders(String uName) {
	
	orderListGUI reader= new orderListGUI(loginController.use.getUsername(),"Reader");
	ArrayList<String> orders = new ArrayList<String>();
	
	orders = DBController.getFromDB("SELECT  b.bookID ,b.Title , ro.date FROM readerorder ro , reader re , book b "+
			"WHERE re.username='"+uName+"' and ro.bookID=b.bookID and ro.userID=re.userID"); 

	
	if(orders != null){
		
		orderListGUI.data = new String[orders.size()/3][3];
		int count =0;
		for(int i = 0 ; i < orders.size()/3 ; i++)
			for(int j = 0 ; j < 3 ; j++){
				orderListGUI.data[i][j] = orders.get(count);
				count++;
			}
		reader.showOrders();
	}
	
	
	/**if there are no results at all we add a lable that says "no results"*/
	
	else
		reader.noResults();
	
	loginController.mainG.setContentPane(reader);
	loginController.mainG.revalidate();
	System.out.println(orders.toString());
	}
	public static void displayMakeAReview(String uName){
		
		orderListGUI order= new orderListGUI(loginController.use.getUsername(),"Reader");
		ArrayList<String> orders = new ArrayList<String>();
		
		orders = DBController.getFromDB("SELECT b.bookID, b.Title , ro.date FROM readerorder ro , reader re , book b "+
				"WHERE re.username='"+uName+"' and ro.bookID=b.bookID and ro.userID=re.userID"); 

		
		if(orders != null){
			
			orderListGUI.data = new String[orders.size()/3][3];
			int count =0;
			for(int i = 0 ; i < orders.size()/3 ; i++)
				for(int j = 0 ; j < 3 ; j++){
					orderListGUI.data[i][j] = orders.get(count);
					count++;
				}
			order.showOrders();
			order.makeReview();
			loginController.mainG.setContentPane(order);
			loginController.mainG.revalidate();
		}
		/**if there are no results at all we add a lable that says "no results"*/
		
		else{
			mainPanel.errorBox("No books in order list ", "No books");
			readerGUI raeder = new readerGUI(loginController.use.getUsername(),"Reader");
			loginController.mainG.setContentPane(raeder);
			loginController.mainG.revalidate();
		}
		
		
		//System.out.println(orders.toString());
	}
	/**
	 * displayWriteReview - get a book id and a book name and display a window
	 * for writing a review about that book
	 * @param bid - book ID
	 * @param bName - book name
	 * @throws SQLException
	 */
	public static void displayWriteReview(String bid , String bName) throws SQLException{
		orderListGUI order = new orderListGUI(loginController.use.getUsername(),"Reader");
		
		boolean bool = DBController.existsInDB("select r.username , r.BookID"
												+" from reviews r where r.username = '"+loginController.use.getUsername()+"' and r.BookID = '"+bid+"'");
		if(bool)
		{
			mainPanel.errorBox("A review about this book has already been made by you","Error");
			order.showOrders();
			order.makeReview();
		}
		else
			order.writeReview(bName, bid);
		loginController.mainG.setContentPane(order);
		loginController.mainG.revalidate();
		
	}
	/**
	 * get a book id a review title and the review itself and adding it to the reviews table 
	 * in the database
	 * @param bid - book ID
	 * @param text - the review text
	 * @param title - the review title
	 * @throws SQLException
	 */
	public static void sendTheReview(String bid , String text,String title) throws SQLException{
		// info= max review id+1 for new review
		ArrayList<String> info = DBController.getFromDB("select max(reviews.reviewid)+1 from reviews");
		DBController.insertToDB("INSERT INTO `ibookdb`.`reviews` (`reviewid`, `BookID`, `title`, `username`, `visible`, `text`) "
													+ " VALUES ('"+info.get(0)+"', '"+bid+"', '"+title+"', '"+loginController.use.getUsername()+"', '0', '"+text+"');");
		
		orderListGUI order = new orderListGUI(loginController.use.getUsername(),"Reader");
		order.showOrders();
		order.makeReview();
		loginController.mainG.setContentPane(order);
		loginController.mainG.revalidate();
		
	}
}