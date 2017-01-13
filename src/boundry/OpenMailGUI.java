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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;

public class OpenMailGUI extends mainPanel {
	private JTable table;
	private String[] columnHeader = {"Title","authorName"," Review Title","Review Username","Review Text"};
	public static String[][] data; // the data from the DB
	private static int row = -1;
	
	
	public OpenMailGUI(String name , String role){
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
		/**goToMainWindow method*/
		
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
		table.setBounds(100, 230, 687, 325);
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setPreferredScrollableViewportSize(new Dimension(17,325));

		/**Scroll Pane*/
		JScrollPane pane = new JScrollPane(table);
		add(table);
		
		/***/
		JLabel lblTitle = DefaultComponentFactory.getInstance().createTitle("Title");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(59, 203, 196, 29);
		add(lblTitle);
	
		/***/
		JLabel lblAuthorName = DefaultComponentFactory.getInstance().createLabel("authorName");
		lblAuthorName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblAuthorName.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthorName.setForeground(Color.BLACK);
		lblAuthorName.setBounds(205, 203, 196, 29);
		add(lblAuthorName);
		
		/***/
		JLabel lblReviewTitle = DefaultComponentFactory.getInstance().createLabel("Review Title");
		lblReviewTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblReviewTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblReviewTitle.setForeground(Color.BLACK);
		lblReviewTitle.setBounds(340, 203, 196, 29);
		add(lblReviewTitle);
		
		/***/
		JLabel lblReviewUsername = DefaultComponentFactory.getInstance().createLabel("Reviewer");
		lblReviewUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblReviewUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblReviewUsername.setForeground(Color.BLACK);
		lblReviewUsername.setBounds(487, 203, 186, 29);
		add(lblReviewUsername);
		
		/***/
		JLabel ReviewText = DefaultComponentFactory.getInstance().createLabel("Description");
		ReviewText.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		ReviewText.setHorizontalAlignment(SwingConstants.CENTER);
		ReviewText.setForeground(Color.BLACK);
		ReviewText.setBounds(620, 203, 186, 29);
		add(ReviewText);
		
		
		JButton btnDisplayReview = new JButton("Display Review");
		btnDisplayReview.setBounds(374, 596, 131, 23);
		add(btnDisplayReview);
		btnDisplayReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(row != -1){
					String bName = new String( table.getValueAt(row, 0).toString());
					String uName = new String( table.getValueAt(row, 3).toString());
					row = -1;
					reviewController.displayReview(bName,uName);
				}
				
			}
		});
		
		
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
}
