package boundry;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import controller.bookController;
import controller.loginController;
import controller.userController;

public class ReportsGUI extends mainPanel {
	
	public static String[] columnHeader1;// = {"username","bookName","date"};// = {"bookName","date"};
	public static String[][] data1;
	private static int row1 = -1;
	
	public ReportsGUI(String name, String type){
		super(name,type);

		JLabel lblWelcomToIbook = new JLabel("Reports");
		lblWelcomToIbook.setFont(new Font("Sitka Subheading", Font.BOLD, 40));
		lblWelcomToIbook.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomToIbook.setForeground(Color.BLACK);
		lblWelcomToIbook.setBackground(Color.WHITE);
		lblWelcomToIbook.setBounds(180, 62, 491, 67);
		add(lblWelcomToIbook);
		
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
			
/*
		JTable table = new JTable();
		table.setForeground(Color.BLUE);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBounds(79, 230, 687, 325);
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		add(table);
		

		
		
		/*
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookName.setBounds(180, 196, 101, 23);
		add(lblBookName);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(534, 196, 101, 23);
		add(lblDate);
		
		JLabel lblsOrderList = new JLabel("<dynamic>s Order List");
		lblsOrderList.setHorizontalAlignment(SwingConstants.CENTER);
		lblsOrderList.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		lblsOrderList.setBounds(290, 141, 229, 23);
		add(lblsOrderList);
*/
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
		table.setBounds(79, 230, 687, 325);
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setPreferredScrollableViewportSize(new Dimension(17,325));
		
		/* Scroll Pane */
		JScrollPane pane = new JScrollPane(table);
		add(table);
		
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
	 * singleUser - if the manager wants to see a certain user's orders
	 * this method is opened with a certain labels
	 * @param username String
	 */
	public void singleUser(String username){
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookName.setBounds(185, 196, 101, 23);
		add(lblBookName);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(534, 196, 101, 23);
		add(lblDate);
		
		JLabel lblsOrderList = new JLabel(username+"'s Order List");
		lblsOrderList.setHorizontalAlignment(SwingConstants.CENTER);
		lblsOrderList.setForeground(Color.RED);
		lblsOrderList.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		lblsOrderList.setBounds(300, 160, 229, 23);
		add(lblsOrderList);
	}
	/**
	 * allUsrers - if the manager wants to see all the orders in the DB
	 * it opens this method that shows a special labels
	 */
	public void allUsrers(){
		
		JLabel lblBookName_1 = new JLabel("Book Name");
		lblBookName_1.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblBookName_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookName_1.setBounds(377, 196, 109, 23);
		add(lblBookName_1);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblUsername.setBounds(144, 196, 109, 23);
		add(lblUsername);
		
		JLabel lblDate_1 = new JLabel("Date");
		lblDate_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_1.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblDate_1.setBounds(580, 196, 109, 23);
		add(lblDate_1);
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
}