package boundry;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;

import controller.userController;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
/**
 * this class contains every component that displayed to the manager for the 
 * workers management (every method make a new window on the panel)
 * @author Guy Cohen
 *
 */
public class WorkerManagementGUI extends mainPanel {
	/**the workers search results table*/
	private JTable table;
	/**the header fo the workers search results table*/
	public static String[] columnHeader = {"Username","Privilege"};
	/**the results that been display in the table*/
	public static String[][] data;
	/**indicates the row number that the user pressed in the table(-1 in none pressed)*/
	private static int row1 = -1;
	private JTextField textFieldOldPrivilege;
	/**
	 * this is a constructor that gets the username and use 
	 * the constructor of the mainPanel(which it extends)
	 * this method send the user name and a constant role to mainPanel(only manager can access this class)
	 * @param name a username for mainPanel use
	 */
	public WorkerManagementGUI(String name){
		super(name,"Manager");
		
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
		
	}
	/**
	 * this method display a table with the workers search results
	 * witch is being initialized by the userController
	 * and a button that redirect to the privilege change method(editWorker)
	 */
	public void displayWorkers(){
		
		row1 = -1;

		
		JButton btnChengePrivilege = new JButton("Chenge Privilege");
		btnChengePrivilege.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = (String)table.getValueAt(row1, 0);
				String privilege = (String)table.getValueAt(row1, 1);
				userController.displayEditPrivilege(username, privilege);
			}
		});
		btnChengePrivilege.setBounds(400, 530, 160, 23);
		btnChengePrivilege.setEnabled(false);
		add(btnChengePrivilege);

		
		table = new JTable(data,columnHeader)
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
					btnChengePrivilege.setEnabled(true);
					c.setBackground(Color.CYAN);
					row1 = data1;
				}
					
				return c;
			}
			
		};
		
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment( SwingConstants.CENTER );
		
		for (int j = 0; j < columnHeader.length; j++)
			table.getColumnModel().getColumn(j).setCellRenderer(r);
		
		table.setForeground(Color.BLUE);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setPreferredScrollableViewportSize(new Dimension(556,256));
		table.setFillsViewportHeight(true);
		
		/* Scroll Pane */
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(213, 212, 556, 256);
		add(pane);
		
		JLabel lblWorkers = new JLabel("Workers :");
		lblWorkers.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWorkers.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorkers.setBounds(425, 169, 110, 32);
		add(lblWorkers);
		
			
		
	}
	/**
	 * this method is a window that shows the username of the worker the manager
	 * chose to change his privilege,
	 * it also shows the worker's current privilege and a comboBox with all the other privileges.
	 * if the manager press the "change" button then the workers privilege is being changed.
	 * @param name the worker's username
	 * @param oldPriv the worker's current privileges
	 * @param newPrivs a list with the other privileges names
	 */
	public void editWorker(String name, String oldPriv,ArrayList<String> newPrivs){
		
		JLabel lblOldPrivilege = new JLabel("Old Privilege :");
		lblOldPrivilege.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOldPrivilege.setHorizontalAlignment(SwingConstants.CENTER);
		lblOldPrivilege.setBounds(248, 239, 87, 29);
		add(lblOldPrivilege);
		
		textFieldOldPrivilege = new JTextField();
		textFieldOldPrivilege.setEditable(false);
		textFieldOldPrivilege.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldOldPrivilege.setText(oldPriv);
		textFieldOldPrivilege.setBounds(331, 244, 180, 24);
		add(textFieldOldPrivilege);
		textFieldOldPrivilege.setColumns(10);
		
		JLabel lblChangeTo = new JLabel("Change To :");
		lblChangeTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangeTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblChangeTo.setBounds(248, 301, 87, 29);
		add(lblChangeTo);
		
		JComboBox comboBoxNewPrivs = new JComboBox();
		comboBoxNewPrivs.setBounds(331, 306, 180, 24);
		for(int i = 0;i<newPrivs.size();i++)
			comboBoxNewPrivs.addItem(newPrivs.get(i));
		add(comboBoxNewPrivs);
		
		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newPriv = (String) comboBoxNewPrivs.getSelectedItem();
				try {
					userController.changePrivilege(name, newPriv);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnChange.setBounds(560, 305, 89, 23);
		add(btnChange);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userController.displayWorkerSearch();
			}
		});
		btnGoBack.setBounds(379, 517, 89, 23);
		add(btnGoBack);
		
		JLabel labelUsername = new JLabel(name);
		labelUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelUsername.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsername.setBounds(331, 188, 152, 29);
		add(labelUsername);
		
		
	}

}
