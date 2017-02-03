package Fixtures;

import fit.ActionFixture;

import java.io.File;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import boundry.MainWindowGUI;
import controller.DBController;
import controller.bookController;
import controller.reviewController;
import boundry.reviewGUI;
import boundry.workerBookGUI;
import boundry.orderListGUI;
import controller.loginController;
import entity.User;

/**
 * Class for write review tests 
 * @author Zachi
 */

public class writeReview extends ActionFixture {
	
	private DBController dbhandler;
	private orderListGUI panelTest ;
	private String title;
	private int maxReviewBefore;
	private int maxReviewAfter;
	

	/**
	 * method creates a new connection to DB, log in as a reader and visualize test environment for writing a review
	 */
	public void startwriteReview() {
		dbhandler = new DBController("localhost",5555);
		loginController.use = new User();
		loginController.use.setUsername("test");
		loginController.use.setprivilege(6);
		panelTest = new orderListGUI("test", "test");
		panelTest.makeReview();
		loginController.mainG = new MainWindowGUI(panelTest);
		maxReviewBefore= Integer.parseInt(DBController.getFromDB("select max(review.reviewid) from reviews").get(0));
		
	}
	
	/**
	 * method makes a click on write Review button in order to write review
	 */
	public void writeReviewClick (){
		
		panelTest.btnReviewBook.doClick();
	}
	
	/**
	 * method makes a click on send the Review button in order to send review for checking
	 */
	
	public void sendReviewClick (){
		
		panelTest.btnSend.doClick();
	}
	
	
	/** method for writing Review Title */
	public void setReviewTitleField(String setReviewTitle) {
		title= setReviewTitle;
		panelTest.textFieldTitle.setText(setReviewTitle);
	}
	
	/** method for writing Review Text */
	public void setReviewTextField(String setReviewText) {
		panelTest.textPaneReview.setText(setReviewText);
	}
	
	
	
	
	/**
	 * checks if book was chosen from order list
	 * @return true if book chosen in table
	 */
	public boolean checkOrderBook() {
		if (panelTest.row != -1) return true;
		else return false;
			
	}
	/** 
	 * checks if the review was sent
	 * @return true if review was sent successfully
	 * */
	public boolean checkSendReview() {
		maxReviewAfter = Integer.parseInt(DBController.getFromDB("select max(review.reviewid) from reviews where reviews.visible = 0 ").get(0));
		if(maxReviewBefore == maxReviewAfter)
			return false;
		else
		{
			String maxTitle = DBController.getFromDB("select review.title from review where review.reviewid = "+maxReviewAfter+"").get(0);
			if(maxTitle.equals(title))
				return true;
		}
		return false;
		
		
	}
	
	
	
	
	
}
