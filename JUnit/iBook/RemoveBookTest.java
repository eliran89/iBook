package iBook;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.SUCCESSFUL;

import javax.print.attribute.standard.NumberOfDocuments;

import com.sun.javafx.scene.control.skin.ComboBoxPopupControl;

import boundry.MainWindowGUI;
import boundry.librarianGUI;
import boundry.userBookGUI;
import boundry.workerBookGUI;
import controller.DBController;
import controller.bookController;
import controller.loginController;
import entity.Book;
import entity.User;
import junit.framework.TestCase;

/**
 * This class is responsible for checking the correctness of removing a book methodology.<br>
 * The class uses an instance of a book and  adds it to the database.
 * After adding, the class removes the book from the database and checks whether it was properly removed.<br>
 * @author Nimrod Mendel
 *
 */
public class RemoveBookTest{

	//String text;
	workerBookGUI panelTest;
	DBController dbhandler;
	ArrayList<String> allBooks;
	boolean exists[];
	ArrayList<String> info = null;
	
	/*Book properties*/
	Book b1;
	String title = "The Litigators";
	String bid;
	float cost = 10;
	String brief = "A book about lawyers";
	String appendix = "no";
	String language = "English";
	int numOfOrders = 0;
	boolean suspended = false;
	String pdfLoc = "C:/files/62.pdf";
	String fb2Loc = "C:/files/62.fb2";
	String docxLoc = "C:/files/62.docx";
	File pdf = new File("C:/files/62.pdf");
	File fb2 = new File("C:/files/62.fb2");
	File docx = new File("C:/files/62.docx");
	int maxBidBefore;
	
	/*Author properties*/
	ArrayList<String> authors = new ArrayList<String>();
	
	/*Scope properties*/
	ArrayList<String>scope = new ArrayList<String>();
	
	/*Subject properties*/
	ArrayList<String> subject = new ArrayList<String>();
	
	/*Keyword properties*/
	ArrayList<String> keyword = new ArrayList<String>();
	
	
	
	
	/**
	 * setUp() - method.<br>
	 * The method sets up all the infrastructure we need for adding a book, and removing it afterwards.<br>
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		
		dbhandler = new DBController("localhost",5555);	//set up a new connection to db
		maxBidBefore = Integer.parseInt(DBController.getFromDB("select max(book.bookID) from book").get(0));
		loginController.use = new User();	//define new user
		loginController.use.setUsername("test");
		loginController.use.setprivilege(6);
		panelTest = new workerBookGUI("test", "test");
		loginController.mainG = new MainWindowGUI(panelTest);
		
		/*initialize book*/
		b1 = new Book();	//create a new book
		b1.setAppendix(appendix);	//set appendix
		b1.setBrief(brief);	//set brief
		b1.setCost(cost);	//set cost
		b1.setLanguage(language);	//set language
		b1.setTitle(title);	//set title
		b1.setFb2(fb2Loc);	//set fb2 file location
		b1.setPdf(pdfLoc);	//set pdf file location
		b1.setDocx(docxLoc);	//set docx file location
		
		
		authors.add("John Grisham");	//set authors
		keyword.add("Lawyers");			//set keyword
		scope.add("Drama");				//set scope
		subject.add("Crime");			//set subject
		
		b1.setAuthors(authors);
		b1.setKey(keyword);
		b1.setScope(scope);
		b1.setSubject(subject);
		
		
		
		/*Add the book*/
		bookController.addBook(b1, pdf, docx, fb2);
		

		
	}
	/*@Test
	public void addBookTest() throws Exception{
		
		//TODO - use bookController.addBook() to add a book
		//TODO - assertTrue(DBController.existInDB(q));
		
		bookController.addBook(b1, pdf, docx, fb2);
		assertTrue(DBController.existsInDB("select * from book b where b.Title = '"+title+"';"));
		
	}*/
	
	/**
	 * removeBookTest() - method.<br>
	 * This method will be responsible for proving the correctness of the book removal procedure. <br>
	 * @throws SQLException 
	 */
	@Test
	public void removeBookTest() throws SQLException{
		
		/*first, we check if the book is in the db*/
		assertTrue(DBController.existsInDB("select * from book b where b.Title = '"+title+"';"));
		
		/*now, we will delete the book and check that it is not there*/
		bid = Integer.toString(++maxBidBefore);	//bid supposed to be the new book id
		System.out.println(bid+ "is the current book id which is going to be erased");
		//ArrayList<String> info1 = DBController.getFromDB("select b.bookId from book b where b.Title = '"+title+"';");
		//System.out.println(info1.get(0)+ "is the current book id which is going to be erased");
		
		//panelTest = new workerBookGUI("test", "test");	//define new GUI screen
		//String instr = (String) info1.get(0);
		//System.out.println(instr +"is the founded new book id");
		bookController.removeBook(bid);
		System.out.println(bid);
		assertFalse(DBController.existsInDB("select * from book b where b.bookId = '"+bid+"';"));
		
		
		
	
		//loginController.mainG.setContentPane(panelTest);
		//loginController.mainG.revalidate();
		//loginController.mainG = new MainWindowGUI(panelTest);	//reload screen
		
	}
	
	@After
	public void tearDown() throws Exception {
	}

	/*
	@Test
	public void test() throws SQLException {
		//fail("Not yet implemented");
		
		
		
		
		
		/*now, we check whether the book was removed
		//TODO-tests
	}*/

}
