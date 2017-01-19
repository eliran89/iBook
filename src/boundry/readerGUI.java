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

import com.jgoodies.forms.factories.DefaultComponentFactory;

import controller.DBController;
import controller.loginController;
import controller.userController;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class readerGUI extends InterestedReaderGUI {
	
	
	private static String[] columnHeader = {"Title","Date"};
	public static String[][] data;
	private static int row = -1;
	public static int n = 0;
	
	public readerGUI( String name , String role) {
		super(name,role);
		img.setBounds(10, 521, 964, 357);
		
		
		JButton btnNewButton = new JButton("Write a new review");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = loginController.use.getUsername();
				makeReview(username);
			}
		});
		btnNewButton.setBounds(644, 320, 185, 47);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(readerGUI.class.getResource("/boundry/write-ballpoint-ballpen-icon.png")));
		lblNewLabel.setBounds(666, 184, 128, 100);
		add(lblNewLabel);
		
		JButton btnViewOrders = new JButton("View orders");
		btnViewOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = loginController.use.getUsername();
				readerGUI.showOrders(user);
			}
		});
		btnViewOrders.setBounds(417, 447, 120, 23);
		add(btnViewOrders);
		
	
	}
	
	
	/**
	 * showOrders - method. 
	 * The method will open a window showing the books ordered by the user.
	 * @param user - String. A username
	 */
	protected static void showOrders(String user) {
		// TODO Auto-generated method stub
		
		mainPanel showOrdersPanel = new mainPanel(user, role);
		
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
		showOrdersPanel.add(btnMainWindow);
		
		JLabel lblOrdersList = new JLabel("Orders List");
		lblOrdersList.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblOrdersList.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdersList.setBounds(390, 116, 184, 14);
		showOrdersPanel.add(lblOrdersList);
		
		JTable ordersTable = new JTable(data, columnHeader){

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
						c.setBackground(Color.CYAN);
						row = data;
					}
						
					
					return c;
				}
				
			};
			
			DefaultTableCellRenderer r = new DefaultTableCellRenderer();
			r.setHorizontalAlignment( SwingConstants.CENTER );
			
			for (int j = 0; j < columnHeader.length; j++)
				ordersTable.getColumnModel().getColumn(j).setCellRenderer(r);
			
			//table.setForeground(Color.BLUE);
			ordersTable.setBackground(Color.WHITE);
			ordersTable.setFont(new Font("Arial", Font.PLAIN, 12));
			ordersTable.setBounds(79, 230, 687, 325);
			ordersTable.setBorder(new LineBorder(Color.LIGHT_GRAY));
			ordersTable.setPreferredScrollableViewportSize(new Dimension(17,325));
			

			/*Scroll Pane*/
			JScrollPane pane = new JScrollPane(ordersTable);
			showOrdersPanel.add(ordersTable);
			
			JLabel lblBookName = DefaultComponentFactory.getInstance().createTitle("Book Name");
			lblBookName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			lblBookName.setForeground(Color.BLACK);
			lblBookName.setHorizontalAlignment(SwingConstants.CENTER);
			lblBookName.setBounds(79, 193, 216, 39);
			showOrdersPanel.add(lblBookName);
			
			/**/
			JLabel lblDate = DefaultComponentFactory.getInstance().createLabel("Date Ordered");
			lblDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			lblDate.setHorizontalAlignment(SwingConstants.CENTER);
			lblDate.setForeground(Color.BLACK);
			lblDate.setBounds(329, 196, 186, 32);
			showOrdersPanel.add(lblDate);
		
		
		loginController.mainG.setContentPane(showOrdersPanel);
		loginController.mainG.revalidate();

		
	}



	/**
	 * makeReview - method.
	 * This method will open a review writing screen for the reader
	 * @param username - String
	 */
	public static void makeReview(String username) {
		
		
		mainPanel ordersPanel = new mainPanel(username, role);
		
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
		ordersPanel.add(btnMainWindow);
		
		JLabel lblOrdersList = new JLabel("Orders List");
		lblOrdersList.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdersList.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblOrdersList.setBounds(413, 106, 138, 36);
		ordersPanel.add(lblOrdersList);
		
		JLabel lblHereWillBe = new JLabel("Here will be placed a table with the reader's orders from which he/she will be able to choose a book to review");
		lblHereWillBe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblHereWillBe.setHorizontalAlignment(SwingConstants.CENTER);
		lblHereWillBe.setBounds(47, 292, 928, 98);
		ordersPanel.add(lblHereWillBe);
		
		JButton btnReviewBook = new JButton("Review Book");
		btnReviewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//TODO - implement a review writing screen
			}
		});
		btnReviewBook.setBounds(415, 555, 111, 23);
		ordersPanel.add(btnReviewBook);
		
		
		
		
		loginController.mainG.setContentPane(ordersPanel);
		loginController.mainG.revalidate();
		
		
		
		
	}
	
	/**
	 * displayUserOrders - method.
	 * Sends a query to the database asking for all the orders of a reader
	 * @param username - String
	 */
	
	public static void displayUserOrders(String username){
		
		ArrayList<String> info;
		String q = "SELECT * "
				 + "FROM readerorder ro , SELECT A.userID FROM reader WHERE reader.username like %'"+username+"' "
				 + "WHERE a.userID = ro.userID";
		
		info = DBController.getFromDB(q);
	}

	public void bookSearch() {
		// TODO - implement readerGUI.bookSearch
		throw new UnsupportedOperationException();
	}

	public void displayResults() {
		// TODO - implement readerGUI.displayResults
		throw new UnsupportedOperationException();
	}

	public void chooseBook() {
		// TODO - implement readerGUI.chooseBook
		throw new UnsupportedOperationException();
	}
	
	
	
}