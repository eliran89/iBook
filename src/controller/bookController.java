package controller;


import java.sql.SQLException;
import java.util.ArrayList;

import boundry.mainPanel;
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
	public static void addBook(Book book) throws SQLException {
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
		for( int i =0;i<temp.size();i++)
			if(!verifyKeyword(temp.get(i)))
				DBController.insertToDB("INSERT INTO `ibookdb`.`keyword` (`word`) VALUES ('"+temp.get(i)+"');");
		
		info =DBController.getFromDB("select max(book.bookID) from book");
		bNewID = Integer.parseInt(info.get(0))+1;
		DBController.insertToDB("INSERT INTO `ibookdb`.`book` (`bookID`, `Title`, `language`, `brief`, `appendix`, `numOfSearches`, `numOfOrders`, `absoluteRank`, `cost`, `suspended`) VALUES ('"+bNewID+"', '"+book.getTitle()+"', '"+book.getLanguage()+"', '"+book.getBrief()+"', '"+book.getAppendix()+"', '0', '0', '0', '"+book.getCost()+"', 0);");
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
		for(int i =0 ; i<temp.size() ; i++)
			DBController.insertToDB("INSERT INTO `ibookdb`.`bscope` (`bookID`, `scopeName`, `rank`, `subject`) VALUES ('"+bNewID+"', '"+temp.get(i)+"', '0', '"+temp2.get(i)+"');");
			
	}
	/**
	 * removeBook - get a book id and remove it from DB
	 * @param bid String
	 * @throws SQLException
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
	 * displayResults - display a results table
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
						
						if(j == 0 && i > 0 && info.get(count).equals( userBookGUI.data[i-1][j]))
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
	 * @param bid String
	 */

	public synchronized static  void chooseBook(String bid) {
		
		Book book = new Book();
		
		userBookGUI panel;
		
		ArrayList<String> info=null;


		book.setBookId(bid);
		info = DBController.getFromDB("select b.Title,b.language,b.brief,b.appendix,b.cost"
									+" from book b"
									+" where b.bookID="+bid);
		
		book.setTitle(info.get(0));
		book.setLanguage(info.get(1));
		book.setBrief(info.get(2));
		book.setAppendix(info.get(3));
		float cost = Float.parseFloat(info.get(4));
		book.setCost(cost);
		
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
		
		try {
			DBController.insertToDB("UPDATE `ibookdb`.`book` SET `numOfSearches`=`numOfSearches`+1 WHERE `bookID`='"+bid+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	public void setScopeRank() {
		// TODO - implement bookController.setScopeRank
		throw new UnsupportedOperationException();
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
	
}