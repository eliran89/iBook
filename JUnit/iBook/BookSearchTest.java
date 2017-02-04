package iBook;

import java.util.ArrayList;

import javax.print.attribute.standard.NumberOfDocuments;

import com.sun.javafx.scene.control.skin.ComboBoxPopupControl;

import boundry.MainWindowGUI;
import boundry.userBookGUI;
import controller.DBController;
import controller.bookController;
import controller.loginController;
import entity.User;
import junit.framework.TestCase;
/**
 * this class is a TastCase for book search<br>
 * it contains methods for expected successful book search<br>
 * and expected not successful book search 
 * @author Guy Cohen
 *
 */
public class BookSearchTest extends TestCase {
	String text;
	userBookGUI panelTest;
	DBController dbhandler;
	ArrayList<String> allBooks;
	boolean exists[];
	ArrayList<String> info = null;
	
	
	
	/**
	 * this method prepare every thing that is crucial for the tests<br>
	 * which is making a connection to the server and set a user that can make a book search
	 */
	protected void setUp() {
		dbhandler = new DBController("localhost",5555);
		loginController.use = new User();
		loginController.use.setUsername("test");
		loginController.use.setprivilege(6);
		
	}
	
	/*through GUI*/
	/**
	 * this method leave all the search fields empty and press "search"<br>
	 * we expect that all the books in the system will appear so we get all the book IDs 
	 * in the system and check if the search results table contains all of the
	 */
	public void testEmptyFields(){
		//make a book search with all the fields empty and expecting to get all the books
		panelTest = new userBookGUI("test", "test");
		panelTest.displaySearch();
		loginController.mainG = new MainWindowGUI(panelTest);
		panelTest.btnSearch.doClick();
		allBooks = DBController.getFromDB("select book.bookID from book");//the list of all the books
		exists = new boolean[allBooks.size()];//creating an array of flags to indicate the a book from "allBoks" is included in the results table
		for(int i=0;i<exists.length;i++)
			exists[i] = false;//putting false in all the flags
		for(int i = 0 ;i<panelTest.data.length;i++)
			for(int j = 0 ; j<allBooks.size();j++)
				if(panelTest.data[i][3].equals(allBooks.get(j)))//if the book is in the result table than his flag will turn on
					exists[j] = true;
		
		for(int i = 0;i<exists.length;i++)
			assertTrue(exists[i]);//check if all the flag turned on
	}
	
	/**
	 * this method check if the book search by one field(title) gives us the results we expect<br>
	 * we set the title field to a random word and verify that all the titles in the search results 
	 * table contains that word
	 */
	public void testTitleField(){//Check if the search results contains text in the title field(the word "the")
		panelTest = new userBookGUI("test", "test");
		panelTest.displaySearch();
		text = new String("the");
		panelTest.textTitle.setText(text);
		loginController.mainG = new MainWindowGUI(panelTest);
		panelTest.data = null;
		panelTest.btnSearch.doClick();
		
		for(int i = 0;i<panelTest.data.length;i++)//for every title in the table we check if it contains the word from the search
			assertTrue(panelTest.data[i][2].contains("the")||panelTest.data[i][2].contains("The"));
	}
	/**
	 * this method verify that in case there are no matching results for the search
	 * we wont get any results at all
	 */
	public void testBookNotExists(){//search by a word that will not give an answer and check if the table data is empty
		panelTest = new userBookGUI("test", "test");
		panelTest.displaySearch();
		panelTest.data = null;
		text = new String("15023");
		panelTest.textTitle.setText(text);
		loginController.mainG = new MainWindowGUI(panelTest);
		panelTest.data = null;
		panelTest.btnSearch.doClick();
		assertEquals(panelTest.data,null);//check that the results table hasn't been verified at all
	}
	/**
	 * this method makes a search by more then one field<br>
	 * it makes a search that only one book will appear in the results table
	 */
	public void testSearchByManyFields(){
		//filling many text Fields in order to get a specific result and check if we got it
		panelTest = new userBookGUI("test", "test");
		panelTest.displaySearch();
		panelTest.textTitle.setText("Harry Potter");
		panelTest.textAuthor.setText("J.K.Rowling");
		panelTest.textLangu.setText("English");
		panelTest.textScope.setText("Kids");
		loginController.mainG = new MainWindowGUI(panelTest);
		panelTest.data = null;
		panelTest.btnSearch.doClick();
		
		assertTrue(panelTest.data.length == 1);//we check that only one book is in the results table
		assertTrue(panelTest.data[0][2].equals("Harry Potter"));//we check that this is the book we wanted
		
	}
	/**
	 * this method is another method that makes a search by one field<br>
	 * this method makes a search by a scope 
	 * and makes sure that all the presented books are related to that scope
	 */
	public void testSearchByScope(){
		//Check if the search results contains text in the scope field(the word "Kids")
		panelTest = new userBookGUI("test", "test");
		panelTest.displaySearch();
		text = new String("Kids");
		panelTest.textScope.setText(text);
		loginController.mainG = new MainWindowGUI(panelTest);
		panelTest.data = null;
		panelTest.btnSearch.doClick();
		
		for(int i = 0;i<panelTest.data.length;i++)
			assertTrue(panelTest.data[i][0].contains("Kids")||panelTest.data[i][0].contains("kids")||panelTest.data[i][0].equals(""));
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*this methods are doing the same as the methods above but does not concern to the GUI*/
	/*through controller*/
	
	public void testEmptyFieldsController(){
		panelTest = new userBookGUI("test", "test");
		loginController.mainG = new MainWindowGUI(panelTest);
		panelTest.data = null;
		bookController.displayResults("", "", "", "", "", "", "");//the method that make the book search
		allBooks = DBController.getFromDB("select book.bookID from book");//the list of all the books
		exists = new boolean[allBooks.size()];//creating an array of flags to indicate the a book from "allBoks" is included in the results table
		for(int i=0;i<exists.length;i++)
			exists[i] = false;//putting false in all the flags
		for(int i = 0 ;i<panelTest.data.length;i++)
			for(int j = 0 ; j<allBooks.size();j++)
				if(panelTest.data[i][3].equals(allBooks.get(j)))//if the book is in the result table than his flag will turn on
					exists[j] = true;
		
		for(int i = 0;i<exists.length;i++)
			assertTrue(exists[i]);//check if all the flag turned on
	}
	
	public void testTitleFieldController(){//Check if the search results contains text in the title field(the word "the")
		panelTest = new userBookGUI("test", "test");
		loginController.mainG = new MainWindowGUI(panelTest);
		text = new String("the");
		bookController.displayResults("", text, "", "", "", "", "");

		
		for(int i = 0;i<panelTest.data.length;i++)
			assertTrue(panelTest.data[i][2].contains("the")||panelTest.data[i][2].contains("The"));
	}
	
	public void testBookNotExistsController(){//search by a word that will not give an answer and check if the table data is empty
		panelTest = new userBookGUI("test", "test");
		loginController.mainG = new MainWindowGUI(panelTest);
		text = new String("15023");
		panelTest.data = null;
		bookController.displayResults("", text, "", "", "", "", "");
		if(panelTest.data == null)
			assertTrue(true);
		else
			assertFalse(true);
	}
	
	public void testSearchByManyFieldsController(){
		//filling many text Fields in order to get a specific result and check if we got it
		panelTest = new userBookGUI("test", "test");
		loginController.mainG = new MainWindowGUI(panelTest);
		bookController.displayResults("", "Harry Potter", "English", "", "J.K.Rowling", "", "Kids");
		
		assertTrue(panelTest.data.length == 1);
		assertTrue(panelTest.data[0][2].equals("Harry Potter"));
		
	}
	
	public void testScopeFieldController(){//Check if the search results contains text in the scope field(the word "Kids")
		panelTest = new userBookGUI("test", "test");
		loginController.mainG = new MainWindowGUI(panelTest);
		text = new String("Kids");
		bookController.displayResults("", "", "", "", "", "", text);

		
		for(int i = 0;i<panelTest.data.length;i++)
			assertTrue(panelTest.data[i][0].contains("kids")||panelTest.data[i][0].contains("Kids")||panelTest.data[i][0].equals(""));
	}
	
}
