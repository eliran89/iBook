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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class OpenMailGUI extends mainPanel {
	private JTable table;
	private String[] columnHeader = {"Title","authorName"," Review Title","Review Username","Review Text"};
	public static String[][] data; // the data from the DB
	private static int row = -1;
	JButton btnApprove = new JButton("Approve");
	JButton btnReject = new JButton("Reject");
	JButton btnUpdate = new JButton("Update");
	
	
	public OpenMailGUI(String name , String role){
		super(name,role);
		
		
	
		setForeground(Color.WHITE);
		
		/* Button for main window */
		JButton btnMainWindow = new JButton("Main Window");
		btnMainWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reviewController.GoToMainWindow();
			}
		});
	
		btnMainWindow.setFont(new Font("AR CENA", Font.BOLD, 14));
		btnMainWindow.setBackground(Color.GREEN);
		btnMainWindow.setForeground(Color.WHITE);
		btnMainWindow.setBounds(26, 38, 138, 23);
		add(btnMainWindow);
		
		JLabel label = new JLabel("MailBox");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Sitka Subheading", Font.BOLD, 40));
		label.setBackground(Color.BLACK);
		label.setBounds(350, 94, 306, 56);
		add(label);
		
		
		
		
		
		
	}
	
	
	/** Displays the Reviews in table **/
	public void getReview()
	{
		
	 /**Create The Result Table*/
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
					c.setBackground(Color.CYAN);
					row = data;
				}
				
				
				return c;
			}
			
		};
		
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment( SwingConstants.CENTER );
		
		for (int j = 0; j < columnHeader.length; j++)
			table.getColumnModel().getColumn(j).setCellRenderer(r);
		
		
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setPreferredScrollableViewportSize(new Dimension(687,325));
		
		/**Scroll Pane*/
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(100, 230, 687, 325);
		add(pane);
		
		
		
		
	
		/** Buttons privileges**/
		if(loginController.use.getprivilege() == 3 || loginController.use.getprivilege() == 4 || loginController.use.getprivilege() == 5  ){					
		
			
		/** Button for Approve **/
		
		btnApprove.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnApprove.setBounds(845, 238, 131, 23);
		add(btnApprove);
		row=-1;
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (row!=-1){			
					String bTitle = new String( table.getValueAt(row, 0).toString());
					String uName= new String( table.getValueAt(row, 3).toString());
				//	try {
					reviewController.ApproveReview(bTitle,uName);
					//}catch (SQLException e1) {
					//	e1.printStackTrace();
					//}
					} // end if row
					else 
						errorBox("Please choose review first","Error");
				
			}
		});
				
		
		
		/** Button for Reject **/
	
		btnReject.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReject.setBounds(844, 296, 131, 23);
		add(btnReject);
		row=-1;
		btnReject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(row != -1){
					String bTitle = new String( table.getValueAt(row, 0).toString());
					String uName= new String( table.getValueAt(row, 3).toString());
					reviewController.removeReview(bTitle,uName);
				}
				else
					errorBox("Please choose review first","Error");
			}
		});
		add(btnReject);
		
		}// end of if privilege==3
		
		
		JButton btnDisplayReview = new JButton("Display Review");
		btnDisplayReview.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDisplayReview.setBounds(374, 596, 131, 23);
		add(btnDisplayReview);
		row=-1;
		btnDisplayReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (row != -1){
					String bTitle = new String( table.getValueAt(row, 0).toString());
					String uName = new String( table.getValueAt(row, 3).toString());
					row = -1;
					reviewController.displayMailReview(bTitle,uName);
				}
				else	
					errorBox("Please choose review first","Error");
				
			}
		});
			
		
		
		
  }// end of getReview()
	public void noResults()
	{
		JLabel label = new JLabel("<<No Results Found>>");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setBounds(292, 188, 177, 36);
		add(label);
	}
	
	/**displayReview display chosen review **/
	 
	public void displayReview(String text,String bTitle,String uName) {
			
			JTextPane txtpnFds = new JTextPane();
			
			/** editable text privileges **/
			if(loginController.use.getprivilege() == 3 || loginController.use.getprivilege() == 4 || loginController.use.getprivilege() == 5  ) txtpnFds.setEditable(true);
			else txtpnFds.setEditable(false);
			
			txtpnFds.setText(text);
			txtpnFds.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtpnFds.setBounds(206, 252, 439, 228);
			txtpnFds.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			add(txtpnFds);
			
			
			if(loginController.use.getprivilege() == 3) {
			
			/** button Approve **/
			
			btnApprove.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnApprove.setBounds(845, 238, 131, 23);
			add(btnApprove);
			btnApprove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						reviewController.ApproveReview(bTitle,uName);
					
				}
			});

			
			/**Button for Reject **/
			
			btnReject.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnReject.setBounds(844, 296, 131, 23);
			add(btnReject);
			btnReject.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(row != -1){
						
						reviewController.removeReview(bTitle,uName);
					}
					
				}
				
			});
			
			// Button for edit //
			JButton btnEdit = new JButton("Update");
			btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnEdit.setBounds(844, 354, 131, 23);
			add(btnEdit);
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
										
					
						reviewController.editReview(bTitle,uName,txtpnFds.getText());
					
					
				}
			});
		} // end of if privilege == 3
	
			
			/**  button Back  **/ 
			JButton btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					reviewController.openMailScreen();
				}
			});
			btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnBack.setBounds(374, 596, 131, 23);
			add(btnBack);
			
		}
}
