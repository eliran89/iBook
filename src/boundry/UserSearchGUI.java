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
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class UserSearchGUI extends mainPanel{
	private static JTextField textField;
	private String[] columnHeader1 = {"ID","First Name","Last Name","User Name", "Privilege Level"};
	public static String[][] data1;
	private static int row1 = -1;
	
	private static JLabel lblSearchBy;
	private static JComboBox comboBox;
	private static JButton btnSearch;
	
	
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

		
		lblSearchBy = new JLabel("Search By :");
		lblSearchBy.setFont(new Font("AR CENA", Font.BOLD, 18));
		lblSearchBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchBy.setForeground(Color.BLACK);
		lblSearchBy.setBackground(Color.BLACK);
		lblSearchBy.setBounds(131, 115, 107, 66);
		add(lblSearchBy);
		
		/* Definition of comboBox used for search by ID or user name */
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.addItem("Username");
		comboBox.addItem("UserID");
		comboBox.setBounds(274, 137, 93, 22);
		add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(398, 139, 116, 20);
		add(textField);
		textField.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = (String) comboBox.getSelectedItem();
				String search = (String) textField.getText();
				controller.userController.getUserDetails(item, search);
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
	

	public void getUserDetails()
	{
		/**Create The Result Table after performing a user search*/
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
		
		/*Buttons for actions on users like: Add, Edit, Remove, Set Payment Arrangement*/
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAddUserDetails();
			}
		});
		btnAdd.setBounds(79, 596, 89, 23);
		add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = new String( table.getValueAt(row1,0).toString());
				String fName = new String( table.getValueAt(row1,1).toString());
				String lName = new String( table.getValueAt(row1,2).toString());
				String uName = new String( table.getValueAt(row1,3).toString());
				displayEditUserDetails(id,fName,lName,uName);
			}
		});
		btnEdit.setBounds(246, 596, 89, 23);
		add(btnEdit);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = new String( table.getValueAt(row1,0).toString());
				String uName = new String( table.getValueAt(row1,3).toString());
				try {
					controller.userController.removeUser(id,uName);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRemove.setBounds(410, 596, 89, 23);
		add(btnRemove);
		
		JButton btnPymnt = new JButton("Set Payment Arrangement");
		btnPymnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPymnt.setBounds(581, 596, 185, 23);
		add(btnPymnt);
		
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
	
	
	
	
	
	public static void displayAddUserDetails() {
		UserSearchGUI panelAdd;

		//System.out.println(loginController.use.getprivilege());
		if(loginController.use.getprivilege() == 4)
			panelAdd = new UserSearchGUI(loginController.use.getUsername(),"Library Worker");
		else
			panelAdd = new UserSearchGUI(loginController.use.getUsername(),"Librarian");
		
//		System.out.println("Im here!! and its great");
		
		/**Frame label */
		JLabel lblAddingANew = new JLabel("Adding a New Intereseted Reader");
		lblAddingANew.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddingANew.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAddingANew.setBounds(274, 72, 331, 27);
		panelAdd.add(lblAddingANew);
		
		/**ID label and textField */
		JLabel lblTitle = new JLabel("ID");
		lblTitle.setToolTipText("Enter 6-digit ID");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setBounds(274, 152, 51, 20);
		panelAdd.add(lblTitle);
		
		JTextField textId = new JTextField();
		textId.setBounds(388, 154, 124, 20);
		textId.setColumns(10);
		panelAdd.add(textId);
		
		/**first name label and textField */
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setToolTipText("No digits or spaces allowed");
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setForeground(Color.BLACK);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(274, 202, 104, 20);
		panelAdd.add(lblFirstName);
		
		JTextField textFname = new JTextField();
		textFname.setColumns(10);
		textFname.setBounds(388, 204, 124, 20);
		panelAdd.add(textFname);
		
		/**last name label and textField */
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setToolTipText("No digits or spaces allowed");
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setForeground(Color.BLACK);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(274, 250, 104, 20);
		panelAdd.add(lblLastName);
		
		JTextField textLname = new JTextField();
		textLname.setColumns(10);
		textLname.setBounds(388, 252, 124, 20);
		panelAdd.add(textLname);
		
		/**user name label and textField */
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setToolTipText("Enter unique username. No digits or spaces allowed");
		lblUserName.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserName.setForeground(Color.BLACK);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(274, 297, 104, 20);
		panelAdd.add(lblUserName);
		
		JTextField textUname = new JTextField();
		textUname.setColumns(10);
		textUname.setBounds(388, 299, 124, 20);
		panelAdd.add(textUname);
		
		/**password label and textField */
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setToolTipText("Enter 6-chars account password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(274, 344, 104, 20);
		panelAdd.add(lblPassword);
		
		JTextField textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(388, 346, 124, 20);
		panelAdd.add(textPassword);

		
		/**button Add */
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					userController.setUserDetails(Integer.parseInt(textId.getText()),textFname.getText(),textLname.getText(),textUname.getText(),textPassword.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAdd.setBounds(516, 441, 89, 23);
		panelAdd.add(btnAdd);
		
		/**button Back */
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//userController.userSearch();
				userController.getUserDetails("Username","");
			}
		});
		btnBack.setBounds(274, 441, 89, 23);
		panelAdd.add(btnBack);
		
		
		lblSearchBy.setVisible(false);
		comboBox.setVisible(false);
		textField.setVisible(false);
		btnSearch.setVisible(false);
		
		loginController.mainG.setContentPane(panelAdd);
		loginController.mainG.revalidate();
		//throw new UnsupportedOperationException();
	}	

	

	public static void displayEditUserDetails(String id, String fName, String lName, String uName) {
		UserSearchGUI panelEdit;
		//System.out.println("I'm on action!");
		//System.out.println(loginController.use.getprivilege());
		if(loginController.use.getprivilege() == 4)
			panelEdit = new UserSearchGUI(loginController.use.getUsername(),"Library Worker");
		else
			panelEdit = new UserSearchGUI(loginController.use.getUsername(),"Librarian");
		
	//	System.out.println("Im here!! and its great");
		
		/**Frame label */
		JLabel lblAddingANew = new JLabel("Edit User Details");
		lblAddingANew.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddingANew.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAddingANew.setBounds(274, 72, 331, 27);
		panelEdit.add(lblAddingANew);
		
		/**ID label and textField */
		JLabel lblTitle = new JLabel("ID");
		lblTitle.setToolTipText("ID field cannot be edited");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setBounds(274, 152, 51, 20);
		panelEdit.add(lblTitle);
		
		JTextField textId = new JTextField(id);
		textId.setBounds(388, 154, 124, 20);
		textId.setColumns(10);
		textId.setEditable(false);
		panelEdit.add(textId);
		
		/**first name label and textField */
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setToolTipText("Enter new account first name");
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setForeground(Color.BLACK);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(274, 202, 104, 20);
		panelEdit.add(lblFirstName);
		
		JTextField textFname = new JTextField(fName);
		textFname.setColumns(10);
		textFname.setBounds(388, 204, 124, 20);
		textFname.setEditable(true);
		panelEdit.add(textFname);
		
		/**last name label and textField */
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setToolTipText("Enter new account last name");
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setForeground(Color.BLACK);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(274, 250, 104, 20);
		panelEdit.add(lblLastName);
		
		JTextField textLname = new JTextField(lName);
		textLname.setColumns(10);
		textLname.setBounds(388, 252, 124, 20);
		textLname.setEditable(true);
		panelEdit.add(textLname);
		
		/**user name label and textField */
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setToolTipText("Username field cannot be edited");
		lblUserName.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserName.setForeground(Color.BLACK);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(274, 297, 104, 20);
		panelEdit.add(lblUserName);
		
		JTextField textUname = new JTextField(uName);
		textUname.setColumns(10);
		textUname.setBounds(388, 299, 124, 20);
		textUname.setEditable(false);
		panelEdit.add(textUname);
		
		/**password label and textField */
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setToolTipText("Enter 6 chars account password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(274, 344, 104, 20);
		panelEdit.add(lblPassword);
		
		JTextField textPassword = new JTextField("*****");
		textPassword.setColumns(10);
		textPassword.setBounds(388, 346, 124, 20);
		textPassword.setEditable(true);
		panelEdit.add(textPassword);

		
		/**button Update */
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setToolTipText("Click here to update account");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					userController.editUserDetails(textId.getText(),textFname.getText(),textLname.getText(),textUname.getText(),textPassword.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnUpdate.setBounds(516, 441, 89, 23);
		panelEdit.add(btnUpdate);
		
		/**button Back */
		JButton btnBack = new JButton("Back");
		btnBack.setToolTipText("Click here to view all users details");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//userController.userSearch();
				userController.getUserDetails("Username","");
			}
		});
		btnBack.setBounds(274, 441, 89, 23);
		panelEdit.add(btnBack);
		
		lblSearchBy.setVisible(false);
		comboBox.setVisible(false);
		textField.setVisible(false);
		btnSearch.setVisible(false);
		
		loginController.mainG.setContentPane(panelEdit);
		loginController.mainG.revalidate();
	}

}
	