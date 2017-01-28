package boundry;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
import javax.swing.JTextField;
import javax.swing.JTextPane;


/**
 * this class is responsible for the orders list display(for users and manager)
 * @author Guy Cohen
 *
 */
public class orderListGUI extends mainPanel {
	/**a String[][] that contains the results table's data*/
	public static String[][] data;
	/**an integer that indicates the number of the selected row(-1 if not selected*/
	private static int row = -1;
	public static int n = 0;	
	/**the headers of the orders list table*/
	private static String[] columnHeader = {"Book ID","Book Name","Date"};
	private JTable ordersTable;
	private JTextField textFieldReview;
	private JTextField textFieldTitle;
	
	
	/**
	 * this is the constructor, it displays the main panel's components and the basic  components
	 * for every window in that class
	 * @param name the use name for mainPanel use
	 * @param role the privilege level for mainPanel use
	 */
	public orderListGUI(String name, String role){
		super(name,role);
		
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
		btnMainWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userController.GoToMainWindow();
			}
		});
		add(btnMainWindow);
		
	
		
		
	}
	
	
	/**
	 * this method display a table with the user's order list
	 */
	public  void showOrders() {
	
	
	

	JLabel orderLabel = new JLabel("Order List");
	orderLabel.setHorizontalAlignment(SwingConstants.CENTER);
	orderLabel.setForeground(Color.BLACK);
	orderLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 40));
	orderLabel.setBackground(Color.BLACK);
	orderLabel.setBounds(280, 94, 306, 56);
	add(orderLabel);
	
	 ordersTable = new JTable(data, columnHeader){

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
		ordersTable.setBorder(new LineBorder(Color.LIGHT_GRAY));
		ordersTable.setPreferredScrollableViewportSize(new Dimension(17,325));
		
		/*Scroll Pane*/
		JScrollPane pane = new JScrollPane(ordersTable);
		pane.setBounds(100, 230, 687, 325);
		add(pane);
		


	}
	/**
	 * (comes with the method showOrders) display a button for make a review about a 
	 * book from the order list
	 */
	public void makeReview() {
		row =-1;
		/** Button for writing review**/
		JButton btnReviewBook = new JButton("Review Book");
		btnReviewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(row != -1){
					String bid = (String) ordersTable.getValueAt(row, 0);
					String bName = (String) ordersTable.getValueAt(row, 1);
					try {
						bookController.displayWriteReview(bid, bName);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else
					errorBox("Please choose a book  first","Error");
			}
		});
		btnReviewBook.setBounds(400, 580, 111, 23);
		add(btnReviewBook);
	
		
	}
	/**
	 * display a label that says "No Results Found"
	 * (comes when the user has no orders at all)
	 */
	public void noResults()
	{
		JLabel label = new JLabel("<<No Results Found>>");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setBounds(270, 188, 177, 36);
		add(label);
	}
	/**
	 * this method gets a book name and a book id and 
	 * display a window for writing a review about that book
	 * @param bName the chosen book name
	 * @param bid the chosen book id
	 */
	public void writeReview(String bName,String bid){
		
		
		
		JLabel label = new JLabel(bName+" - "+bid);
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(360, 98, 200, 30);
		add(label);
		
		JTextPane textPaneReview = new JTextPane();
		textPaneReview.setBounds(290, 260, 372, 199);
		textPaneReview.setBackground(Color.LIGHT_GRAY);
		textPaneReview.setForeground(Color.BLACK);
		add(textPaneReview);
		
		JLabel lblPleaseEnterYour = new JLabel("Please Enter your review here :");
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPleaseEnterYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterYour.setBounds(321, 206, 300, 43);
		add(lblPleaseEnterYour);
		
		JLabel lblReviewTitle = new JLabel("Review Title :");
		lblReviewTitle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReviewTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblReviewTitle.setBounds(290, 173, 94, 23);
		add(lblReviewTitle);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setBounds(394, 175, 158, 20);
		add(textFieldTitle);
		textFieldTitle.setColumns(10);
	
		
		/**Need To Complete*/
		JButton btnSend = new JButton("Send The Review");
		btnSend.setBounds(575, 480, 200, 31);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textPaneReview.getText();
				String title = textFieldTitle.getText();
				if (text.equals("") || title.equals(""))
					errorBox("Must enter a review and a title","Error");
			
				if (title.contains("'") || title.contains(",") ||text.contains("'") || title.contains(","))
					errorBox("Must enter a review and a title without panctuation like , or '","Error");
				else{
						infoBox("Review sent to be checked","Review Sent");
						try {
							bookController.sendTheReview(bid, text,title);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
				}
			}
		});
		add(btnSend);
		
		JButton btnBackToOrder = new JButton("Back To Order List");
		btnBackToOrder.setBounds(211, 480, 200, 31);
		btnBackToOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookController.displayMakeAReview(loginController.use.getUsername());
			}
		});
		add(btnBackToOrder);
		

	}
}
