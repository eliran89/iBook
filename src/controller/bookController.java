package controller;


import java.sql.SQLException;
import java.util.ArrayList;

import boundry.reviewGUI;
import boundry.userBookGUI;
import entity.Book;

public class bookController {

	public void newOrder() {
		// TODO - implement bookController.newOrder
		throw new UnsupportedOperationException();
	}

	public void addBook() {
		// TODO - implement bookController.addBook
		throw new UnsupportedOperationException();
	}

	public void removeBook() {
		// TODO - implement bookController.removeBook
		throw new UnsupportedOperationException();
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
	 * 
	 */
	public static void searchBook() {
		
		userBookGUI panel;
		if(loginController.use.getprivilege() == 1)
			panel = new userBookGUI(loginController.use.getUsername(),"Interested Reader");
		else
			panel = new userBookGUI(loginController.use.getUsername(),"Reader");
		
		panel.displaySearch();
		loginController.mainG.setContentPane(panel);
		loginController.mainG.revalidate();
	}
	/**Book Search END*/
	
	/**
	 * 
	 * @param brief
	 * @param title
	 * @param langu
	 * @param keyWord
	 * @param author
	 * @param appendix
	 * @param scope
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
			
			/**if his an interested reader add it to the title*/ 
			if(loginController.use.getprivilege() == 1)
				panel = new userBookGUI(loginController.use.getUsername(),"Interested Reader");
			
			/**if his a reader add it to the title*/
			else
				panel = new userBookGUI(loginController.use.getUsername(),"Reader");
			
			/**if we get results we add the results table*/
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
	 * 
	 * @param bid
	 */

	public  static  void chooseBook(String bid) {
		
		Book book = new Book();
		
		userBookGUI panel;
		
		ArrayList<String> info=null;


		
		info = DBController.getFromDB("select b.Title,b.language,b.brief,b.appendix,b.cost"
									+" from book b"
									+" where b.bookID="+bid);
		System.out.println(info);
		
		book.setTitle(info.get(0));
		book.setLanguage(info.get(1));
		book.setBrief(info.get(2));
		book.setAppendix(info.get(3));
		float cost = Float.parseFloat(info.get(4));
		book.setCost(cost);
		
		book.setScope( DBController.getFromDB("select s.scopeName"
				+" from scope s,bscope bs "
				+ "where s.scopeName = bs.scopeName and bs.bookID = " +bid));
		
		book.setAuthors(DBController.getFromDB("select a.authorName"
									+" from author a, bauthor ba"
									+" where a.authorID = ba.authorID and ba.bookID = "+bid));
		

		
		/**if his an interested reader add it to the title*/ 
		if(loginController.use.getprivilege() == 1)
			panel = new userBookGUI(loginController.use.getUsername(),"Interested Reader");
		
		/**if his a reader add it to the title*/
		else
			panel = new userBookGUI(loginController.use.getUsername(),"Reader");
		
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

	public void editBookinfo() {
		// TODO - implement bookController.editBookinfo
		throw new UnsupportedOperationException();
	}

	public void setAbsRank() {
		// TODO - implement bookController.setAbsRank
		throw new UnsupportedOperationException();
	}

	public void setScopeRank() {
		// TODO - implement bookController.setScopeRank
		throw new UnsupportedOperationException();
	}

}