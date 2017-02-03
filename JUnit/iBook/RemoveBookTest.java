package iBook;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.print.attribute.standard.NumberOfDocuments;

import com.sun.javafx.scene.control.skin.ComboBoxPopupControl;

import boundry.MainWindowGUI;
import boundry.librarianGUI;
import boundry.userBookGUI;
import controller.DBController;
import controller.bookController;
import controller.loginController;
import entity.Book;
import entity.User;
import junit.framework.TestCase;


public class RemoveBookTest extends TestCase {

	
	String text;
	librarianGUI panelTest;
	DBController dbhandler;
	ArrayList<String> allBooks;
	boolean exists[];
	ArrayList<String> info = null;
	
	Book b1;
	String title = "The Litigators";
	String cost = "10";
	String brief = "A book about lawyers";
	String appendix = "no";
	String 
	
	
	@Before
	public void setUp() throws Exception {
		
		dbhandler = new DBController("localhost",5555);	//set up a new connection to db
		loginController.use = new User();	//define new user
		loginController.use.setUsername("test");
		loginController.use.setprivilege(4);
		
		/*Insert a new book to ibookdb*/
		String q = "INSERT INTO `ibookdb`.`book` (`bookID`, `Title`, `language`, `brief`, `appendix`, `numOfOrders`, `cost`, `suspended`) "
				+ "VALUES ('62', 'The Litigators', 'Hebrew', 'A book about lawyers', 'no', '0', '12', '0')";

		DBController.insertToDB(q);
		
		
		
		test();	//run test
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws SQLException {
		//fail("Not yet implemented");
		
		/*first, we check if the book is in the db*/
		
		
		String query = "select * from books b where b.Title = 'The Litigators'";
		assertTrue(DBController.existsInDB(query));	//book is in the DB
		
		/*delete book*/
		
		
		/*now, we check whether the book was removed*/
		//TODO-tests
	}

}
