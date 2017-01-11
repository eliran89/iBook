package boundry;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import controller.reviewController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class editorGUI extends mainPanel {
	private JTable table;
	private String[] columnHeader = {"Book Name","Review Name","Reviewer"};
	public static String[][] data; // the data from the DB
	private static int row = -1;
	
	public editorGUI( String name , String role) {
		super(name,role);
		btnLogout.setBounds(10, 11, 89, 16);
		
		setForeground(Color.WHITE);
		JLabel lblWelcomToIbook = new JLabel("Welcome To IBook");
		lblWelcomToIbook.setFont(new Font("Sitka Subheading", Font.BOLD, 40));
		lblWelcomToIbook.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomToIbook.setForeground(Color.BLACK);
		lblWelcomToIbook.setBackground(Color.BLACK);
		lblWelcomToIbook.setBounds(201, 63, 491, 67);
		add(lblWelcomToIbook);
		
		
		JLabel imgR;
		imgR = new JLabel(new ImageIcon(editorGUI.class.getResource("/boundry/mailbox.jpg")));
		imgR.setBounds(569, 179, 247, 137);
		add(imgR);
		
		JButton btnNewButton = new JButton("Mailbox");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reviewController.openMail();
				
			}
		});
		btnNewButton.setBounds(656, 348, 119, 23);
		add(btnNewButton);
		
		/*table = new JTable();
		table.setBounds(185, 392, 555, 227);
		add(table);*/
	
	}

	public void checkReview() {
		// TODO - implement editorGUI.checkReview
		throw new UnsupportedOperationException();
	}

	public void publishReview() {
		// TODO - implement editorGUI.publishReview
		throw new UnsupportedOperationException();
	}

	public void openMail() {
			
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
					c.setForeground(Color.GRAY);
					c.setBackground(Color.BLACK);
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
		//table.setForeground(Color.BLUE);
		table.setBackground(Color.BLACK);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBounds(79, 230, 687, 325);
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setPreferredScrollableViewportSize(new Dimension(17,325));

		/**Scroll Pane*/
		JScrollPane pane = new JScrollPane(table);
		add(table);
		
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
		
		JButton btnDisplayReview = new JButton("Display Review");
		btnDisplayReview.setBounds(374, 596, 131, 23);
		add(btnDisplayReview);
		btnDisplayReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(row != -1){
					String bName = new String( table.getValueAt(row, 0).toString());
					String uName = new String( table.getValueAt(row, 2).toString());
					row = -1;
					reviewController.displayReview(bName,uName);
				}
				
			}
		});
	}

	public void ReviewRemoval() {
		// TODO - implement editorGUI.ReviewRemoval
		throw new UnsupportedOperationException();
	}

	public void ReviewEditing() {
		// TODO - implement editorGUI.ReviewEditing
		throw new UnsupportedOperationException();
	}

	public void chooseReview() {
		// TODO - implement editorGUI.chooseReview
		throw new UnsupportedOperationException();
	}
}