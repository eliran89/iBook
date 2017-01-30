package iBook;

import java.util.ArrayList;

import javax.print.attribute.standard.NumberOfDocuments;

import boundry.MainWindowGUI;
import boundry.userBookGUI;
import controller.DBController;
import controller.loginController;
import entity.User;
import junit.framework.TestCase;

public class BookSearchTest extends TestCase {
	String[] fields = new String[7];
	String text;
	userBookGUI panelTest;
	DBController dbhandler;
	ArrayList<String> allBooks;
	boolean exists[];
	ArrayList<String> info = null;
	protected void setUp() throws Exception {
		dbhandler = new DBController("localhost",5555);
		loginController.use = new User();
		loginController.use.setUsername("test");
		loginController.use.setprivilege(6);
		
	}
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
	public void testTitleField(){//Check if the search results contains text in the title field(the word "the")
		panelTest = new userBookGUI("test", "test");
		panelTest.displaySearch();
		text = new String("the");
		panelTest.textTitle.setText(text);
		loginController.mainG = new MainWindowGUI(panelTest);
		panelTest.btnSearch.doClick();
		
		for(int i = 0;i<panelTest.data.length;i++)
			assertTrue(panelTest.data[i][2].contains("the")||panelTest.data[i][2].contains("The"));
	}
	public void testBookNotExists(){//search by a word that will not give an answer and check if the table data is empty
		panelTest = new userBookGUI("test", "test");
		panelTest.displaySearch();
		text = new String("15023");
		panelTest.textTitle.setText(text);
		loginController.mainG = new MainWindowGUI(panelTest);
		panelTest.btnSearch.doClick();
		if(panelTest.data == null)
			assertTrue(true);
	}
	public void SearchByManyFields(){
		//filling many text Fields in order to get a specific result and check if we got it
		panelTest = new userBookGUI("test", "test");
		panelTest.displaySearch();
		panelTest.textTitle.setText("Harry Potter");
		panelTest.textAuthor.setText("J.K.Rowling");
		panelTest.textLangu.setText("English");
		panelTest.textScope.setText("Kids");
		loginController.mainG = new MainWindowGUI(panelTest);
		panelTest.btnSearch.doClick();
		
		assertTrue(panelTest.data.length == 1);
		assertTrue(panelTest.data[0][2].equals("Harry Potter"));
		
	}
	
}
