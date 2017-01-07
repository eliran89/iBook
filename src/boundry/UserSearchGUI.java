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
	private String[] columnHeader1 = {"ID","Username","Privilege"};
	public static String[][] data1;
	private static int row1 = -1;
	
	public UserSearchGUI(String name , String role)
	{
		super(name,role);
		setForeground(Color.WHITE);
		
		JButton btnMainWindow = new JButton("Main Window");
		btnMainWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userController.GoToMainWindow();
			}
		});
		btnMainWindow.setFont(new Font("AR CENA", Font.BOLD, 14));
		btnMainWindow.setBackground(Color.GREEN);
		btnMainWindow.setForeground(Color.WHITE);
		btnMainWindow.setBounds(26, 38, 122, 23);
		add(btnMainWindow);

		
		JLabel lblSearchBy = new JLabel("Search By :");
		lblSearchBy.setFont(new Font("AR CENA", Font.BOLD, 18));
		lblSearchBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchBy.setForeground(Color.WHITE);
		lblSearchBy.setBackground(Color.BLACK);
		lblSearchBy.setBounds(142, 158, 107, 66);
		add(lblSearchBy);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.addItem("Username");
		comboBox.addItem("UserID");
		comboBox.setBounds(269, 182, 93, 22);
		add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(391, 182, 116, 20);
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
		btnSearch.setBounds(540, 181, 107, 23);
		add(btnSearch);

		
			
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
					c.setForeground(Color.BLUE);
					c.setBackground(Color.WHITE);
				}
				else
				{
					c.setForeground(Color.WHITE);
					c.setBackground(Color.BLUE);
				}
				if(isCellSelected(data1,column))
				{
					c.setBackground(Color.RED);
				//	System.out.println("Im here!!!!");
					row1 = data1;
				}
					
				return c;
			}
			
		};
		table.setForeground(Color.BLUE);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setBounds(79, 230, 687, 325);
		table.setPreferredScrollableViewportSize(new Dimension(17,325));
		
		/**Scroll Pane*/
		JScrollPane pane = new JScrollPane(table);
		add(table);
		
	//////////////////////////////////////	

	///////////////////////////////////////////////	
		/***/
		JLabel lblBookName = DefaultComponentFactory.getInstance().createTitle("Book Name");
		lblBookName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblBookName.setForeground(Color.WHITE);
		lblBookName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookName.setBounds(79, 193, 216, 39);
		add(lblBookName);
		
		/***/
		JLabel lblReviewName = DefaultComponentFactory.getInstance().createLabel("Review Name");
		lblReviewName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblReviewName.setHorizontalAlignment(SwingConstants.CENTER);
		lblReviewName.setForeground(Color.WHITE);
		lblReviewName.setBounds(329, 196, 186, 32);
		add(lblReviewName);
		
		/***/
		JLabel lblReviewer = DefaultComponentFactory.getInstance().createLabel("Reviewer");
		lblReviewer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblReviewer.setHorizontalAlignment(SwingConstants.CENTER);
		lblReviewer.setForeground(Color.WHITE);
		lblReviewer.setBounds(577, 198, 179, 29);
		add(lblReviewer);
		
		JButton btnDisplayReview = new JButton("Display User");
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
		});
		
		//scrollBar.addAdjustmentListener(l);
	}
public void noResults()
{
	JLabel label = new JLabel("<<No Results Found>>");
	label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setForeground(Color.RED);
	label.setBounds(292, 188, 177, 36);
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