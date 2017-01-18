package controller;

import java.util.ArrayList;

import javax.swing.JFrame;

import boundry.*;



public class reviewController {
/**
 * searchReview check if there are review according to type and item
 * @param type String
 * @param item String
 */
	public static void searchReview(String type,String item) {
		
		ArrayList <String> info = null;
		
		/*Search by Book Name*/
		if(type.equals("Book Name"))
			info = DBController.getFromDB("select `book`.`Title`,`reviews`.`title`,`reviews`.`username` "
					+ "from book ,reviews "
					+ "where book.Title like '%"+item+"%' and book.suspended=0 and book.bookID=reviews.bookID and reviews.visible = 1 order by book.Title ASC");
		
		
		/*Search by Author Name*/
		if(type.equals("Author"))
			info = DBController.getFromDB("select `book`.`Title`,`reviews`.`title`,`reviews`.`username`"
			+"from book , reviews, author , bauthor "
			+"where book.bookID = reviews.bookID and author.authorID = bauthor.authorID and book.bookID = bauthor.bookID and author.authorName like '%"
			+ item+"%' and book.suspended=0 and reviews.visible =1"
					+ " order by book.Title ASC");
		
		/*Search by Keywords*/
		if(type.equals("Key Word"))
			info = DBController.getFromDB("select distinct `book`.`Title`,`reviews`.`title`,`reviews`.`username` "
					+"from reviews , book ,bkey"
					+ " where reviews.BookID = book.bookID and book.bookID = bkey.bookID and bkey.Word like '%"+item+"%' and reviews.visible =1"
							+ " order by book.Title ASC");
		
		/*build the basic panel*/
		reviewGUI panel;
		
		/*if his an interested reader add it to the title*/ 
		if(loginController.use.getprivilege() == 1)
			panel = new reviewGUI(loginController.use.getUsername(),"Interested Reader");
		
		/*if his a reader add it to the title*/
		else
			panel = new reviewGUI(loginController.use.getUsername(),"Reader");
		
		/*if we get results we add the results table*/
		if(info != null)
		{
			reviewGUI.data = new String[info.size()/3][3];
			
			int count =0;
			for(int i = 0 ; i < info.size()/3 ; i++)
				for(int j = 0 ; j < 3 ; j++){
					reviewGUI.data[i][j] = info.get(count);
					count++;
				}
			panel.getReview();
			
		}
		
		/*if there are no results at all we add a lable that says "no results"*/
		else
			panel.noResults();
		loginController.mainG.setContentPane(panel);
		loginController.mainG.revalidate();
		
		
	}

/**
 * checkReview 
 */
	public static void checkReview() {
		
		reviewGUI review = null;
		if(loginController.use.getprivilege() == 1)
			review = new reviewGUI(loginController.use.getUsername(),"Interested Reader");
		else
			review = new reviewGUI(loginController.use.getUsername(),"Reader");
		loginController.mainG.setContentPane(review);
		loginController.mainG.revalidate();

	}
	
	/**
	 * GoToMainWindow display  the main window 
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
			mainP = new readerGUI(loginController.use.getUsername(),"Library Worker");
		else if(loginController.use.getprivilege() == 5)
			mainP = new readerGUI(loginController.use.getUsername(),"Librarian");
		else 
			mainP = new readerGUI(loginController.use.getUsername(),"Manager");
		loginController.mainG.setContentPane(mainP);
		loginController.mainG.revalidate();
	}
	

	/**
	 * displayReview display the chose review
	 * @param bName String
	 * @param uName String
	 */
	public static void displayReview(String bName, String uName) {
		ArrayList <String> info = null;
		info = DBController.getFromDB("select reviews.text from reviews , book"
				+ " where reviews.BookID = book.bookID and reviews.username = '"+uName+"' and book.Title = '"+bName+"'");

		reviewGUI review = null;
		if(loginController.use.getprivilege() == 1)
			review = new reviewGUI(loginController.use.getUsername(),"Interested Reader");
		
		if(loginController.use.getprivilege() == 3)
			review = new reviewGUI(loginController.use.getUsername(),"Editor");
		
		else
			review = new reviewGUI(loginController.use.getUsername(),"Reader");
		
		review.displayReview(info.get(0)); // returns the first cell in the arraylist which is the text of the review
		loginController.mainG.setContentPane(review);
		loginController.mainG.revalidate();
		
	}

	


	public static void  openMailScreen(){ // opens the table that displays the reviews
		ArrayList <String> info = null;
		
		
			info = DBController.getFromDB("select distinct b.Title , a.authorName , r.title , r.username , r.text "
				+"from book b, reviews r, author a, bauthor ba "
				+"where b.bookID = r.bookID and a.authorID=ba.authorID and  ba.bookID = r.bookID and r.visible=0 "
					+"order by b.Title ASC");
				

			/** Checking the privileges for the title of the user screen **/
			OpenMailGUI review=null;

					
			if(loginController.use.getprivilege() == 1)
				review = new OpenMailGUI(loginController.use.getUsername(),"Interested Reader");
			if(loginController.use.getprivilege() == 2)
				review = new OpenMailGUI(loginController.use.getUsername(),"Reader");
			if(loginController.use.getprivilege() == 3)
				review = new OpenMailGUI(loginController.use.getUsername(),"Editor");
			if(loginController.use.getprivilege() == 4)
				review = new OpenMailGUI(loginController.use.getUsername(),"Library Worker");
			if(loginController.use.getprivilege() == 5)
				review = new OpenMailGUI(loginController.use.getUsername(),"Librarian");
			if(loginController.use.getprivilege() == 6)
				review = new OpenMailGUI(loginController.use.getUsername(),"Manager");
		
			/**if we get results we add the results table*/
			if(info != null)
			{
				OpenMailGUI.data = new String[info.size()/5][5];
				
				int count =0;
				for(int i = 0 ; i < info.size()/5 ; i++)
					for(int j = 0 ; j < 5 ; j++){
						OpenMailGUI.data[i][j] = info.get(count);
						count++;
			}
				review.getReview();
				
			}
			
			/**if there are no results at all we add a lable that says "no results"*/
			else
				review.noResults();
			
			loginController.mainG.setContentPane(review);
			loginController.mainG.revalidate();
	}
	
	/** Display Mail Reviews in Mailbox**/
	
	public static void displayMailReview(String bName, String uName) {
		ArrayList <String> info = null;
		info = DBController.getFromDB("select reviews.text from reviews , book"
				+ " where reviews.BookID = book.bookID and reviews.username = '"+uName+"' and book.Title = '"+bName+"'");

		OpenMailGUI review = null;
		if(loginController.use.getprivilege() == 1)
			review = new OpenMailGUI(loginController.use.getUsername(),"Interested Reader");
		if(loginController.use.getprivilege() == 2)
			review = new OpenMailGUI(loginController.use.getUsername(),"Reader");
		if(loginController.use.getprivilege() == 3)
			review = new OpenMailGUI(loginController.use.getUsername(),"Editor");
		if(loginController.use.getprivilege() == 4)
			review = new OpenMailGUI(loginController.use.getUsername(),"Library Worker");
		if(loginController.use.getprivilege() == 5)
			review = new OpenMailGUI(loginController.use.getUsername(),"Librarian");
		if(loginController.use.getprivilege() == 6)
			review = new OpenMailGUI(loginController.use.getUsername(),"Manager");
	
		
		review.displayReview(info.get(0)); // returns the first cell in the arraylist which is the text of the review
		
		
		//reviewGUI.lblSearchBy.setVisible(false);
		//reviewGUI.comboBox.setVisible(false);
		//reviewGUI.textField.setVisible(false);
	//	reviewGUI.btnSearch.setVisible(false);
		
		loginController.mainG.setContentPane(review);
		loginController.mainG.revalidate();
		
	}

	/**  Approved reviews to visible=1   **/
	public static void ApproveReview(String bTitle,String uName) {
		ArrayList <String> info = null;
		ArrayList <String> updateVis = null;
		int bookId=0;
		
		info = DBController.getFromDB("select  r.BookID "+
		"from book b, reviews r "+
		"where b.bookID = r.bookID and r.username='"+uName+"' and b.Title='"+bTitle+"' and r.visible = 0");
		System.out.println(info.get(0));
		bookId=Integer.parseInt(info.get(0)); // converting the string bookId to integer
		
		updateVis = DBController.getFromDB("UPDATE reviews r SET visible=1 "
				+ "WHERE r.BookID="+bookId+" and r.username='"+uName+"' and r.visible=0");
		
		OpenMailGUI.infoBox("Review was approved!", "book");
		

	
	}
	// removed review the 'rejected button' pressed

	public void removeReview() {
		
		
	}
	public boolean checkDetails() {
		// TODO - implement reviewController.checkDetails
		throw new UnsupportedOperationException();
	}

	public void sendToEditor() {
		// TODO - implement reviewController.sendToEditor
		throw new UnsupportedOperationException();
	}


	

}