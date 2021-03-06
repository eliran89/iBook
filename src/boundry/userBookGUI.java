package boundry;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import controller.bookController;
import controller.loginController;
import controller.userController;
import entity.Book;


import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
/**
 * this method contains every screen and components the the user see in the book search 
 * or the book page and every interaction the a regular user has with the system's books
 * @author Guy Cohen, Nimrod Mendel
 *
 */
public class userBookGUI extends mainPanel {
	boolean bool =true;
	public JTextField textTitle;
	public JTextField textLangu;
	public JTextField textKeyWord;
	public JTextField textAuthor;
	public JTextField textAppendix;
	public JTextField textScope;
	public JTextField textBrief;
	public JButton btnSearch;
	public JButton btnRemoveBook;
	/**the headers for the book search table*/
	private String[] columnHeader = {"Scope","Subject","Book Name","Book ID"};
	/**the results of the book search table*/
	public static String[][] data = null;
	/**a number of row that had been pressed in a table(-1 none pressed)*/
	public static int row = -1;
	
	private JTextField TFLang;
	private JTable tableScopes;
	/**
	 * this is the constructor, it contains only the basic components that appears at every different window in this class
	 * with is every thing in mainPanel (witch this class extends) and a main window button
	 * @param name String the username for mainPanel use
	 * @param type String the type of the user(privilege level) for the mainPanel use
	 */
	public userBookGUI(String name,String type){
		super(name,type);
		
		JButton btnMainWindow = new JButton("Main Window");
		btnMainWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userController.GoToMainWindow();
			}
		});
		btnMainWindow.setFont(new Font("AR CENA", Font.BOLD, 14));
		btnMainWindow.setBackground(Color.GREEN);
		btnMainWindow.setForeground(Color.BLACK);
		btnMainWindow.setBounds(26, 38, 122, 23);
		add(btnMainWindow);
				
		
		
		
	}
	/**
	 * displaySearch display the search labals and textfields
	 */
	public void displaySearch(){
		
		JLabel lblSearchBy = new JLabel("Search By : ");
		lblSearchBy.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblSearchBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchBy.setForeground(Color.BLACK);
		lblSearchBy.setBounds(10, 91, 131, 64);
		add(lblSearchBy);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setBounds(189, 118, 51, 14);
		add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setForeground(Color.BLACK);
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAuthor.setBounds(178, 165, 62, 14);
		add(lblAuthor);
		
		JLabel lblLengu = new JLabel("Language");
		lblLengu.setHorizontalAlignment(SwingConstants.CENTER);
		lblLengu.setForeground(Color.BLACK);
		lblLengu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLengu.setBounds(434, 118, 73, 14);
		add(lblLengu);
		
		JLabel lblBrif = new JLabel("Brief");
		lblBrif.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrif.setForeground(Color.BLACK);
		lblBrif.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBrif.setBounds(189, 213, 38, 14);
		add(lblBrif);
		
		JLabel lblAppendix = new JLabel("Appendix");
		lblAppendix.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppendix.setForeground(Color.BLACK);
		lblAppendix.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAppendix.setBounds(434, 165, 73, 14);
		add(lblAppendix);
		
		JLabel lblScope = new JLabel("Scope");
		lblScope.setHorizontalAlignment(SwingConstants.CENTER);
		lblScope.setForeground(Color.BLACK);
		lblScope.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblScope.setBounds(694, 165, 51, 14);
		add(lblScope);
		
		JLabel lblKeyWord = new JLabel("Key Word");
		lblKeyWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblKeyWord.setForeground(Color.BLACK);
		lblKeyWord.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKeyWord.setBounds(694, 118, 73, 14);
		add(lblKeyWord);
		
		textTitle = new JTextField();
		textTitle.setBounds(248, 116, 124, 20);
		add(textTitle);
		textTitle.setColumns(10);
		
		textLangu = new JTextField();
		textLangu.setColumns(10);
		textLangu.setBounds(508, 116, 124, 20);
		add(textLangu);
		
		textKeyWord = new JTextField();
		textKeyWord.setColumns(10);
		textKeyWord.setBounds(769, 116, 124, 20);
		add(textKeyWord);
		
		textAuthor = new JTextField();
		textAuthor.setColumns(10);
		textAuthor.setBounds(250, 163, 124, 20);
		add(textAuthor);
		
		textAppendix = new JTextField();
		textAppendix.setColumns(10);
		textAppendix.setBounds(508, 163, 124, 20);
		add(textAppendix);
		
		textScope = new JTextField();
		textScope.setColumns(10);
		textScope.setBounds(769, 163, 124, 20);
		add(textScope);
		
		textBrief = new JTextField();
		textBrief.setColumns(10);
		textBrief.setBounds(248, 211, 124, 20);
		add(textBrief);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String brief = textBrief.getText();
				String title = textTitle.getText();
				String langu = textLangu.getText();
				String keyWord = textKeyWord.getText();
				String author = textAuthor.getText();
				String appendix = textAppendix.getText();
				String scope = textScope.getText();
				
				bookController.displayResults(brief,title,langu,keyWord,author,appendix,scope);
			}
		});
		btnSearch.setBounds(248, 287, 89, 23);
		add(btnSearch);
		
		JButton btnAddNewBook = new JButton("Add New Book");
		btnAddNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookController.addBook();
			}
		});
		btnAddNewBook.setBounds(414, 287, 129, 23);
		add(btnAddNewBook);
		if(loginController.use.getprivilege() < 3)
			btnAddNewBook.setVisible(false);
		
		JButton btnScopesEdit = new JButton("Scopes Edit");
		btnScopesEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookController.scopeEdit();
			}
		});
		btnScopesEdit.setBounds(580, 287, 129, 23);
		if(loginController.use.getprivilege() == 5)
			add(btnScopesEdit);
		
	}
	/**
	 * this method displays the book search results table that the information array(data)
	 * is being initialized in the boocController
	 * and an option to choose one of the results and a button to display this book's information
	 */
	public void displayResults()
	{
		JButton btnDisplayBook = new JButton("Display Book");
		/**Create The Result Table
		 * 
		 */
		btnRemoveBook = new JButton("Remove Book");
		/**the book search table*/
		JTable table = new JTable(data,columnHeader)
		{
			
			public boolean isCellEditable(int data,int columns){
				return false;
			}
			
			public Component prepareRenderer(TableCellRenderer r,int data ,int column){
				Component c = super.prepareRenderer(r,data,column);
				
				
				if(data % 2 == 0)
				{
					c.setForeground(Color.BLACK);
					c.setBackground(Color.WHITE);
				}
				else
				{
					c.setForeground(Color.BLACK);
					c.setBackground(Color.LIGHT_GRAY);
				}
				if(isCellSelected(data,column))
				{
					btnDisplayBook.setEnabled(true);
					btnRemoveBook.setEnabled(true);
					c.setBackground(Color.CYAN);
					row = data;
				}
				bool = true;
				return c;
			}
			
			
		};
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment( SwingConstants.CENTER );
		for (int j = 0; j < columnHeader.length; j++)
			table.getColumnModel().getColumn(j).setCellRenderer(r);
		
		//table.setForeground(Color.BLUE);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setPreferredScrollableViewportSize(new Dimension(583,191));
		table.setFillsViewportHeight(true);
		
		
		/*Scroll Pane*/
		JScrollPane pane = new JScrollPane(table);//add table to scroll bar
		pane.setBounds(181, 376, 583, 191);//set table dimention
		add(pane);
		
		
		
		
		btnDisplayBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String ID = (String) table.getValueAt(row, 3);
				//readerGUI.displayPurchase();
				bookController.chooseBook(ID);
			}
		});
		btnDisplayBook.setBounds(394, 596, 129, 23);
		btnDisplayBook.setEnabled(false);
		add(btnDisplayBook);
		
		btnRemoveBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String bid = (String) table.getValueAt(row, 3);
				try {
					infoBox("Book Removed","Successes");
					bookController.removeBook(bid);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnRemoveBook.setBounds(195, 596, 129, 23);
		add(btnRemoveBook);
		btnRemoveBook.setEnabled(false);
		if(loginController.use.getprivilege() < 4)
			btnRemoveBook.setVisible(false);
		
	}
	/**
	 * noResults display a label "<No Results>"
	 */
	public void noResults(){
		
		JLabel label = new JLabel("<<No Results Found>>");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setBounds(360, 370, 239, 36);
		add(label);
		
	}
	
	/**
	 * get an instance of Book class with the chosen book's information and display all 
	 * that information.
	 * @param book Book
	 */
	public void displayBook(Book book){
		
		String authors = new String(book.getAuthors().get(0));
		String scopes = new String(book.getScope().get(0));
		
		
		JLabel lblCost = new JLabel("Cost : $"+ book.getCost());
		lblCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblCost.setFont(new Font("Ariel", Font.BOLD, 16));
		lblCost.setBounds(631, 80, 251, 54);
		add(lblCost);
		
		JLabel lblBookTitle = new JLabel(book.getTitle());
		lblBookTitle.setFont(new Font("Poor Richard", Font.BOLD, 24));
		lblBookTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookTitle.setBounds(336, 80, 251, 54);
		add(lblBookTitle);
		
		/*JLabel lblAthors = new JLabel("Author(s) : ");
		lblAthors.setHorizontalAlignment(SwingConstants.CENTER);
		lblAthors.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAthors.setBounds(79, 251, 97, 14);
		add(lblAthors);*/
		/**the header of the authors table*/
		String[] headerAuthors = {"Authors"};
		/**the name of all the authors inside the authors table*/
		String[][] dataAuthors = new String[book.getAuthors().size()][1];
		for(int i = 0 ; i<book.getAuthors().size();i++)
			dataAuthors[i][0] = book.getAuthors().get(i);
		JTable tableAuthors = new JTable(dataAuthors,headerAuthors){
			public boolean isCellEditable(int data,int columns){
				return false;
			}
			
			public Component prepareRenderer(TableCellRenderer r,int data ,int column){
				Component c = super.prepareRenderer(r,data,column);
				
				return c;
			}
		};
		tableAuthors.setPreferredScrollableViewportSize(new Dimension(150,55));
		tableAuthors.setFillsViewportHeight(true);
		
		DefaultTableCellRenderer r1 = new DefaultTableCellRenderer();
		r1.setHorizontalAlignment( SwingConstants.CENTER );
		for (int j = 0; j < headerAuthors.length; j++)
			tableAuthors.getColumnModel().getColumn(j).setCellRenderer(r1);
		
		JScrollPane pane1 = new JScrollPane(tableAuthors);//add table to scroll bar
		pane1.setBounds(179, 253, 150, 55);//set table dimension
		add(pane1);
		
		/**Language labek**/
		JLabel lblLanguange = new JLabel("languange : ");
		lblLanguange.setHorizontalAlignment(SwingConstants.CENTER);
		lblLanguange.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLanguange.setBounds(72, 331, 97, 23);
		add(lblLanguange);
		
		TFLang = new JTextField();
		TFLang.setText(book.getLanguage());
		TFLang.setEditable(false);
		TFLang.setBounds(179, 334, 122, 20);
		add(TFLang);
		TFLang.setColumns(10);
		
		/**Brief labek**/
		JLabel lblBrief = new JLabel("Brief : ");
		lblBrief.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrief.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBrief.setBounds(568, 331, 72, 23);
		add(lblBrief);
		/**a text pane for the brief*/
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText(book.getBrief());
		textPane.setEditable(false);
		textPane.setBounds(664, 331, 243, 131);
		add(textPane);
		
		/**Appendix labek**/
		JLabel lblAppendix_1 = new JLabel("Appendix : ");
		lblAppendix_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppendix_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAppendix_1.setBounds(557, 188, 97, 23);
		add(lblAppendix_1);
		
		/**a text pane for the appendix*/
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText(book.getAppendix());
		textPane_1.setEditable(false);
		textPane_1.setBounds(664, 188, 243, 131);
		add(textPane_1);
		
		/**the header of the scopes table*/
		String[] headerScope = {"Scopes"};
		/**the name of all the scopes in the scopes table*/
		String[][] dataScopes = new String[book.getScope().size()][1];
		for(int i = 0 ; i<book.getScope().size();i++)
			dataScopes[i][0] = book.getScope().get(i);
		tableScopes = new JTable(dataScopes,headerScope){
			public boolean isCellEditable(int data,int columns){
				return false;
			}
			
			public Component prepareRenderer(TableCellRenderer r,int data ,int column){
				Component c = super.prepareRenderer(r,data,column);
				return c;
			}
		};
		tableScopes.setPreferredScrollableViewportSize(new Dimension(130,55));
		tableScopes.setFillsViewportHeight(true);
		
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment( SwingConstants.CENTER );
		for (int j = 0; j < headerScope.length; j++)
			tableScopes.getColumnModel().getColumn(j).setCellRenderer(r);
		
		JScrollPane pane = new JScrollPane(tableScopes);//add table to scroll bar
		pane.setBounds(179, 160, 150, 55);//set table dimention
		add(pane);
		
		
		JLabel lblChooseFormatTo = new JLabel("Choose format to Download:");
		lblChooseFormatTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseFormatTo.setFont(new Font("Tahoma", Font.BOLD , 14));
		lblChooseFormatTo.setBounds(269, 404, 228, 23);

		if(loginController.use.getprivilege()==2)
			add(lblChooseFormatTo);
		

		if(loginController.use.getprivilege() == 2)
			add(lblChooseFormatTo);
			

		JComboBox formatBox = new JComboBox();	//a combo box which will allow the reader to choose a format to download
		formatBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		formatBox.addItem("pdf");	//PDF format
		formatBox.addItem("fb2");	//fb2 format
		formatBox.addItem("docx");	//doc format
		formatBox.setBounds(589, 407, 89, 20);
		
		if(loginController.use.getprivilege() == 2)	//only a reader will be able to see it
			add(formatBox);
		
		
		
		JButton btnOrderTheBook = new JButton("Order The Book");
		btnOrderTheBook.setBackground(Color.GREEN);
		btnOrderTheBook.setBounds(679, 534, 150, 23);
		if(loginController.use.getprivilege() != 2)
			btnOrderTheBook.setVisible(false);
		btnOrderTheBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String format = formatBox.getSelectedItem().toString();	//save the requested format to download
				
				try {
					if(userController.addBookToOrderList(book.getTitle(), loginController.use.getUsername(), book.getCost()))
						bookController.downloadBook(book.getBookID(),format,book.getTitle());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				/*mainPanel orders = new mainPanel(username, role);
				
				JLabel lblBookName = new JLabel(title);
				lblBookName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
				lblBookName.setHorizontalAlignment(SwingConstants.CENTER);
				lblBookName.setBounds(421, 197, 144, 23);
				orders.add(lblBookName);
				
				loginController.mainG.setContentPane(orders);
				loginController.mainG.revalidate();*/
				
				
				//userController.addBookToOrderList(title);
			}
		});
		add(btnOrderTheBook);	
		
		/**Back to search button**/
		JButton btnBackToSearch = new JButton("Back To Search");
		btnBackToSearch.setBackground(Color.RED);
		btnBackToSearch.setBounds(145, 534, 150, 23);
		btnBackToSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookController.searchBook();
			}
		});
			
		add(btnBackToSearch);
		
		/**Edit book button**/
		JButton btnEditTheBook = new JButton("Edit Book Information");
		btnEditTheBook.setBackground(Color.GREEN);
		btnEditTheBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookController.editBookinfo(book);
			}
		});
		btnEditTheBook.setBounds(679, 534, 155, 23);
		add(btnEditTheBook);
		if(loginController.use.getprivilege() < 4)
			btnEditTheBook.setVisible(false);
		/**an image that indicates if the book is suspended*/
		JLabel imgS;
		imgS = new JLabel(new ImageIcon(InterestedReaderGUI.class.getResource("/boundry/suspended.jpg")));
		imgS.setBounds(361, 11, 211, 79);
		add(imgS);
		if(!book.isSuspended())
			imgS.setVisible(false);
	}
}