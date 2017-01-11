package boundry;

import controller.loginController;
import controller.reviewController;
import controller.userController;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class UserSearchGUI extends mainPanel{
	private JTextField textField;
	private String[] columnHeader1 = {"ID","First Name","Last Name","User Name", "Privilege Level"};
	public static String[][] data1;
	private static int row1 = -1;
	
	public UserSearchGUI(String name , String role)
	{
		super(name,role);
		btnLogout.setBounds(26, 11, 77, 16);
		setForeground(Color.WHITE);
		
		/* Button for main window */
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

		
		JLabel lblSearchBy = new JLabel("Search By :");
		lblSearchBy.setFont(new Font("AR CENA", Font.BOLD, 18));
		lblSearchBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchBy.setForeground(Color.BLACK);
		lblSearchBy.setBackground(Color.BLACK);
		lblSearchBy.setBounds(131, 115, 107, 66);
		add(lblSearchBy);
		
		/* Definition of comboBox used for search by ID or user name */
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.addItem("Username");
		comboBox.addItem("UserID");
		comboBox.setBounds(274, 137, 93, 22);
		add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(398, 139, 116, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = (String) comboBox.getSelectedItem();
				String search = (String) textField.getText();
				userController.getUserDetails(item, search);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.setBounds(553, 137, 107, 23);
		add(btnSearch);
		
		/*JTable table = new JTable();
		table.setForeground(Color.WHITE);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setBounds(79, 230, 687, 325);
		table.setPreferredScrollableViewportSize(new Dimension(17,325));
		add(table);*/
			
	}
	
	
	
	//////////////////////////////////////
	public void getUserDetails()
	{
		/**Create The Result Table*/
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
		table.setForeground(Color.BLUE);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBounds(79, 230, 687, 325);
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setPreferredScrollableViewportSize(new Dimension(17,325));
		
		/* Scroll Pane */
		JScrollPane pane = new JScrollPane(table);
		add(table);
		
		JLabel lblUserID = DefaultComponentFactory.getInstance().createTitle("User ID");
		lblUserID.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserID.setForeground(Color.WHITE);
		lblUserID.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserID.setBounds(67, 198, 107, 32);
		add(lblUserID);
		
		/***/
		JLabel lblFirstName = DefaultComponentFactory.getInstance().createLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setBounds(205, 198, 107, 32);
		add(lblFirstName);
		
		/***/
		JLabel lblLastName = DefaultComponentFactory.getInstance().createLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setBounds(342, 200, 107, 29);
		add(lblLastName);
		
		JLabel lblPrivilegeLevel = new JLabel("Privilege Level");
		lblPrivilegeLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrivilegeLevel.setForeground(Color.WHITE);
		lblPrivilegeLevel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrivilegeLevel.setBounds(633, 202, 87, 24);
		add(lblPrivilegeLevel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(480, 202, 87, 24);
		add(lblUsername);
		/***/
		
		
		
		/*JButton btnDisplayReview = new JButton("Display User");
		btnDisplayReview.setBounds(374, 596, 131, 23);
		add(btnDisplayReview);
		btnDisplayReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(row1 != -1){
					String bName = new String( table.getValueAt(row1, 0).toString());
					String uName = new String( table.getValueAt(row1, 2).toString());
					row1 = -1;
					userController.displayUser(bName,uName);
				}
				
			}
		});*/
		
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(374, 596, 131, 23);
		add(btnNewButton);
	//	79, 230, 687, 325
		JButton button = new JButton("Edit");
		button.setBounds(374, 900, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("Remove");
		button_1.setBounds(329, 900, 89, 23);
		add(button_1);
		
		JButton button_2 = new JButton("Set Payment Arrangement");
		button_2.setBounds(475, 900, 185, 23);
		add(button_2);
		
		//scrollBar.addAdjustmentListener(l);
	}
	
	
	public void noResults()
	{
		JLabel label = new JLabel("<<No Results Found>>");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setBounds(299, 242, 177, 36);
		add(label);
	}
	
	
	public void displayUser(String text) {
		JTextPane txtpnFds = new JTextPane();
		txtpnFds.setEditable(false);
		txtpnFds.setText(text);
		txtpnFds.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnFds.setBounds(206, 252, 439, 228);
		add(txtpnFds);
		
	}
	}