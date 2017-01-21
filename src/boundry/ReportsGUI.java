package boundry;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import controller.bookController;
import controller.loginController;
import controller.reviewController;
import controller.userController;
import javax.swing.JComboBox;

public class ReportsGUI extends mainPanel {
	
	public static String[] columnHeader1;// = {"username","bookName","date"};// = {"bookName","date"};
	public static String[][] data1;
	public static String[] columnHeader2 = {"Scope","Subject","Book Name","Book ID"};
	public static String[][] data2;
	private static int row1 = -1;
	private JTextField textFieldDay;
	private JTextField textFieldYear;
	private JTextField textField_2;
	
	public ReportsGUI(String name, String type){
		super(name,type);

		JLabel lblReports = new JLabel("Reports");
		lblReports.setFont(new Font("Sitka Subheading", Font.BOLD, 40));
		lblReports.setHorizontalAlignment(SwingConstants.CENTER);
		lblReports.setForeground(Color.BLACK);
		lblReports.setBackground(Color.WHITE);
		lblReports.setBounds(180, 62, 491, 67);
		add(lblReports);
		
		JButton btnMainWindow = new JButton("Main Window");
		btnMainWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userController.GoToMainWindow();
			}
		});
		btnMainWindow.setFont(new Font("AR CENA", Font.BOLD, 14));
		btnMainWindow.setBackground(Color.GREEN);
		btnMainWindow.setForeground(Color.WHITE);
		btnMainWindow.setBounds(26, 38, 138, 23);
		add(btnMainWindow);
		
		
		/*JButton btnChoose = new JButton("Choose");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnChoose.setBounds(527, 500, 89, 23);
		add(btnChoose);
		
		JLabel label = new JLabel("<dynamic>");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(656, 500, 138, 23);
		add(label);*/

		/*JTable table = new JTable();
		table.setForeground(Color.BLUE);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBounds(181, 376, 583, 191);
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		add(table);*/
		
		
		
		
		
	}
		


	
	/**
	 * displayReportsMain - display the main report panel
	 */
	public void displayReportsMain() {
		

		
		JButton btnRaports = new JButton("User Report");
		btnRaports.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRaports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userController.userSearch();
			}
		});

		btnRaports.setBounds(613, 426,174, 27);
		add(btnRaports);
		
		JLabel imgRe;
		imgRe = new JLabel(new ImageIcon(InterestedReaderGUI.class.getResource("/boundry/UserIcons.jpg")));
		imgRe.setBounds(590, 324, 211, 105);
		add(imgRe);
		
		JButton btnBookreport = new JButton("Book Report");
		btnBookreport.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBookreport.setBounds(205, 430, 174, 27);
		btnBookreport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userController.displayBookSearchForReports();
			}
		});
		add(btnBookreport);
		
		JLabel imgBook;
		imgBook = new JLabel(new ImageIcon(InterestedReaderGUI.class.getResource("/boundry/Book-icon.png")));
		imgBook.setBounds(188, 324, 211, 105);
		add(imgBook);
	}
/**
 * displayUsersReport - the userController update the arrays and declare the method
 * and the method update a table with the information in the arrays and displays it 
 */
	public void displayUsersReport() {
		JTable table = new JTable(data1,columnHeader1)
		{
			
			public boolean isCellEditable(int data1,int columns){
				return false;
			}
			public Component prepareRenderer(TableCellRenderer r,int data1 ,int column){
				Component c = super.prepareRenderer(r,data1,column);
				
				if(data1 % 2 == 0)
				{
					c.setForeground(Color.BLACK);
					c.setBackground(Color.WHITE);
				}
				else
				{
					c.setForeground(Color.BLACK);
					c.setBackground(Color.LIGHT_GRAY);
				}
				if(isCellSelected(data1,column))
				{
					c.setBackground(Color.CYAN);
					row1 = data1;
				}
					
				return c;
			}
			
		};
		
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment( SwingConstants.CENTER );
		
		for (int j = 0; j < columnHeader1.length; j++)
			table.getColumnModel().getColumn(j).setCellRenderer(r);
		
		table.setForeground(Color.BLUE);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setPreferredScrollableViewportSize(new Dimension(687,325));
		
		/* Scroll Pane */
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(79, 230, 687, 325);
		add(pane);
		
		JButton btnBackToSearch = new JButton("Back To Search");
		btnBackToSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userController.userSearch();
			}
		});
		btnBackToSearch.setBounds(330, 583, 154, 23);
		add(btnBackToSearch);
	}

	/**
	 * noReadersif there are no orders in the DataBase
	 * display a lable with "no orders"
	 */
	public void noReaders(){
		
		JLabel label = new JLabel("<<No Orders To Show>>");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setBounds(393, 163, 177, 36);
		add(label);
	}
	/**
	 * displayBookSearchForReports - display the search panel for the manager
	 * for reports
	 */
	public void displayBookSearchForReports(){
		
		 JTextField textTitle;
		 JTextField textLangu;
		 JTextField textKeyWord;
		 JTextField textAuthor;
		 JTextField textAppendix;
		 JTextField textScope;
		 JTextField textBrief;
		
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
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String brief = textBrief.getText();
				String title = textTitle.getText();
				String langu = textLangu.getText();
				String keyWord = textKeyWord.getText();
				String author = textAuthor.getText();
				String appendix = textAppendix.getText();
				String scope = textScope.getText();
				
				bookController.displayResultsForReports(brief,title,langu,keyWord,author,appendix,scope);
			}
		});
		btnSearch.setBounds(248, 287, 89, 23);
		add(btnSearch);
		

		
	}
	public void displayBookSearchResults(){
		JTable table = new JTable(data2,columnHeader2)
		{
			
			public boolean isCellEditable(int data,int columns){
				return false;
			}
			public Component prepareRenderer(TableCellRenderer r,int data ,int column){
				Component c = super.prepareRenderer(r,data,column);
				boolean bool =true;
				
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
					c.setBackground(Color.CYAN);
					row1 = data;
				}
				/*if(getValueAt(data, column)=="")
					if(data % 2 == 0)
						c.setBackground(Color.LIGHT_GRAY);
					else
						c.setBackground(Color.WHITE);*/
				
				return c;
			}
			
			
		};
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment( SwingConstants.CENTER );
		for (int j = 0; j < columnHeader2.length; j++)
			table.getColumnModel().getColumn(j).setCellRenderer(r);
		
		//table.setForeground(Color.BLUE);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setPreferredScrollableViewportSize(new Dimension(583,191));
		
		
		/*Scroll Pane*/
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(181, 376, 583, 191);
		add(pane);
		
		/*JLabel lblScope_1 = new JLabel("Scope");
		lblScope_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblScope_1.setForeground(Color.BLACK);
		lblScope_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblScope_1.setBounds(210, 345, 83, 23);
		add(lblScope_1);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject.setForeground(Color.BLACK);
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubject.setBounds(350, 345, 83, 23);
		add(lblSubject);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookName.setForeground(Color.BLACK);
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBookName.setBounds(470, 345, 111, 23);
		add(lblBookName);
		
		JLabel lblIndex = new JLabel("Index");
		lblIndex.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndex.setForeground(Color.BLACK);
		lblIndex.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIndex.setBounds(630, 342, 111, 23);
		add(lblIndex);*/
		

		JButton btnDisplayBookStatistics = new JButton("Display Book Statistics");
		btnDisplayBookStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ID = (String) table.getValueAt(row1, 3);
				String bookName = (String) table.getValueAt(row1, 2);
				bookController.cooseBookForReports(bookName, ID);
				
			}
		});
		btnDisplayBookStatistics.setBounds(376, 596, 184, 23);
		add(btnDisplayBookStatistics);
	}
	/**
	 * noBookResults - if there are no results from the search display a lable "no results"
	 */
	public void noBookResults(){
			
			JLabel label = new JLabel("<<No Results Found>>");
			label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setForeground(Color.RED);
			label.setBounds(360, 370, 239, 36);
			add(label);
			
		
	}
	/**
	 * chooseBy - display a panel with options for book statistics
	 * either by number of searches or number of orders
	 */
	public void chooseBy(String bookName, String ID , ArrayList<String> scopes){
		
		
		JLabel imgOrders;
		imgOrders = new JLabel(new ImageIcon(editorGUI.class.getResource("/boundry/orders.png")));
		imgOrders.setBounds(530, 258, 247, 162);
		add(imgOrders);
		
		JButton btnBackToSearch_1 = new JButton("Back To Search");
		btnBackToSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userController.displayBookSearchForReports();
			}
		});
		btnBackToSearch_1.setBounds(210, 571, 146, 23);
		add(btnBackToSearch_1);
		
		JButton btnByOrders = new JButton("By Orders");
		btnByOrders.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnByOrders.setBounds(554, 417, 211, 27);
		btnByOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userController.displayOrdersReport(ID);
				
			}
		});
		add(btnByOrders);
		
		JLabel lblsBookNameAndID = new JLabel(bookName+" - "+ID);
		lblsBookNameAndID.setHorizontalAlignment(SwingConstants.CENTER);
		lblsBookNameAndID.setForeground(Color.RED);
		lblsBookNameAndID.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		lblsBookNameAndID.setBounds(330, 160, 250, 23);
		add(lblsBookNameAndID);
		
		JLabel imgSearches;
		imgSearches = new JLabel(new ImageIcon(editorGUI.class.getResource("/boundry/searches.png")));
		imgSearches.setBounds(169, 258, 247, 162);
		add(imgSearches);
		
		JComboBox comboBoxScope = new JComboBox();
		comboBoxScope.setBounds(297, 500, 204, 23);
		add(comboBoxScope);
		comboBoxScope.addItem("All Scopes");
		for(int i = 0 ; i < scopes.size() ; i++)
			comboBoxScope.addItem(scopes.get(i));
		
		JButton btnBySearches = new JButton("By Searches");
		btnBySearches.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBySearches.setBounds(180, 421, 211, 27);
		btnBySearches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					userController.displaySearchReport(ID,bookName);
				
			}
		});

		
		
		JLabel lblBy = new JLabel("Rank By :");
		lblBy.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBy.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBy.setBounds(193, 498, 83, 23);
		add(lblBy);
		
		JButton btnChoose = new JButton("Choose");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String scope = (String)comboBoxScope.getSelectedItem();
				if(scope.equals("All Scopes"))
					userController.displayOrderRank(ID ,scopes,bookName);
				else
					userController.displayOrderRankByScope(scope, ID, bookName, scopes);
					
			}
		});
		btnChoose.setBounds(527, 500, 89, 23);
		add(btnChoose);
		
		add(btnBySearches);
		
	}
	public void displayRank(String rank){
		
		JLabel label = new JLabel("Rank is: "+rank);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(656, 500, 138, 23);
		add(label);
	}
}