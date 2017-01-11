package controller;

import java.util.ArrayList;

import javax.swing.JFrame;

import boundry.*;



public class reviewController {
/**
 * 
 * @param type
 * @param item
 */
	public static void searchReview(String type,String item) {
		
		ArrayList <String> info = null;
		
		/**Search by Book Name*/
		if(type.equals("Book Name"))
			info = DBController.getFromDB("select `book`.`Title`,`reviews`.`title`,`reviews`.`username` "
					+ "from book ,reviews "
					+ "where book.Title like '%"+item+"%' and book.suspended=0 and book.bookID=reviews.bookID and reviews.visible = 1 order by book.Title ASC");
		
		
		/**Search by Author Name*/
		if(type.equals("Author"))
			info = DBController.getFromDB("select `book`.`Title`,`reviews`.`title`,`reviews`.`username`"
			+"from book , reviews, author , bauthor "
			+"where book.bookID = reviews.bookID and author.authorID = bauthor.authorID and book.bookID = bauthor.bookID and author.authorName like '%"
			+ item+"%' and book.suspended=0 and reviews.visible =1"
					+ " order by book.Title ASC");
		
		/**Search by Keywords*/
		if(type.equals("Key Word"))
			info = DBController.getFromDB("select distinct `book`.`Title`,`reviews`.`title`,`reviews`.`username` "
					+"from reviews , book ,bkey"
					+ " where reviews.BookID = book.bookID and book.bookID = bkey.bookID and bkey.Word like '%"+item+"%' and reviews.visible =1"
							+ " order by book.Title ASC");
		
		/**build the basic panel*/
		reviewGUI panel;
		
		/**if his an interested reader add it to the title*/ 
		if(loginController.use.getprivilege() == 1)
			panel = new reviewGUI(loginController.use.getUsername(),"Interested Reader");
		
		/**if his a reader add it to the title*/
		else
			panel = new reviewGUI(loginController.use.getUsername(),"Reader");
		
		/**if we get results we add the results table*/
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
		
		/**if there are no results at all we add a lable that says "no results"*/
		else
			panel.noResults();
		loginController.mainG.setContentPane(panel);
		loginController.mainG.revalidate();
		
		
	}

/**
 * 
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
	 * 
	 */
	public static void GoToMainWindow()
	{
		mainPanel mainP = null;
		if(loginController.use.getprivilege() == 1)
			mainP = new InterestedReaderGUI(loginController.use.getUsername(),"Interested Reader");
		else
			mainP = new readerGUI(loginController.use.getUsername(),"Reader");
		loginController.mainG.setContentPane(mainP);
		loginController.mainG.revalidate();
	}
	
	/**displayRiview method*/
	/**
	 * 
	 * @param bName
	 * @param uName
	 */
	public static void displayReview(String bName, String uName) {
		ArrayList <String> info = null;
		info = DBController.getFromDB("select reviews.text from reviews , book"
				+ " where reviews.BookID = book.bookID and reviews.username = '"+uName+"' and book.Title = '"+bName+"'");

		reviewGUI review = null;
		if(loginController.use.getprivilege() == 1)
			review = new reviewGUI(loginController.use.getUsername(),"Interested Reader");
		else
			review = new reviewGUI(loginController.use.getUsername(),"Reader");
		review.displayReview(info.get(0)); // returns the first cell in the arraylist which is the text of the review
		loginController.mainG.setContentPane(review);
		loginController.mainG.revalidate();
		
	}/**displayRiview method END*/

	public void removeReview() {
		// TODO - implement reviewController.removeReview
		throw new UnsupportedOperationException();
	}


	public static void  openMail(){ // opens the table that displays the reviews
		ArrayList <String> info = null;
		
		
			info = DBController.getFromDB("select 'book'.'Title','author.authorName','reviews'.'title','reviews'.'username' ,'reviews'.'text'"
					+ "from book ,reviews,author,bauthor "
				+"where book.bookID = reviews.bookID  and author.authorID=bauthor.authorID and reviews.visible=1 "
					+"order by book.Title ASC");
			
			
			/** Checking the privileges for the title of the user screen **/
			editorGUI review=null;
			
			if(loginController.use.getprivilege() == 1)
				review = new editorGUI(loginController.use.getUsername(),"Interested Reader");
			if(loginController.use.getprivilege() == 2)
				review = new editorGUI(loginController.use.getUsername(),"Reader");
			if(loginController.use.getprivilege() == 3)
				review = new editorGUI(loginController.use.getUsername(),"Editor");
			if(loginController.use.getprivilege() == 4)
				review = new editorGUI(loginController.use.getUsername(),"Library Worker");
			if(loginController.use.getprivilege() == 5)
				review = new editorGUI(loginController.use.getUsername(),"Librarian");
			if(loginController.use.getprivilege() == 6)
				review = new editorGUI(loginController.use.getUsername(),"Manager");
			
			
			/** Putting in table the data **/
			if(info != null)
			{
				editorGUI.data = new String[info.size()/3][3];
				
				int count =0;
				for(int i = 0 ; i < info.size()/3 ; i++)
					for(int j = 0 ; j < 3 ; j++){
						editorGUI.data[i][j] = info.get(count);
						count++;
					}
				review.openMail();
				
			}
			//loginController.mainG.setContentPane(review);
			//loginController.mainG.revalidate();
			
		
				
	}

	public boolean checkDetails() {
		// TODO - implement reviewController.checkDetails
		throw new UnsupportedOperationException();
	}

	public void sendToEditor() {
		// TODO - implement reviewController.sendToEditor
		throw new UnsupportedOperationException();
	}


	public void makeVisible() {
		// TODO - implement reviewController.makeVisible
		throw new UnsupportedOperationException();
	}

}