package boundry;

import javax.swing.JPanel;
import javax.swing.JButton;

import controller.reviewController;
import controller.userController;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollBar;

import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextPane;

public class reviewGUI extends mainPanel {
	private JTextField textField;
	public static int n = 0;
	private String[] columnHeader = {"Book Name","Review Name","Reviewer"};
	public static String[][] data;
	private static int row = -1;
	
	public reviewGUI(String name,String role) {
		
			super(hello,role);
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
			
			JLabel lblSearchBy = new JLabel("Search By : ");
			lblSearchBy.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
			lblSearchBy.setHorizontalAlignment(SwingConstants.CENTER);
			lblSearchBy.setForeground(Color.WHITE);
			lblSearchBy.setBounds(52, 118, 131, 64);
			add(lblSearchBy);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
			comboBox.setBounds(173, 142, 143, 23);
			comboBox.addItem("Book Name");
			comboBox.addItem("Author");
			comboBox.addItem("Key Word");
			add(comboBox);
			
			textField = new JTextField();
			textField.setBounds(344, 142, 206, 23);
			add(textField);
			textField.setColumns(10);
			add(textField);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String type = comboBox.getSelectedItem().toString();
					String item = textField.getText();
					reviewController.searchReview(type,item);
				}
			});
			btnSearch.setBounds(590, 142, 89, 23);
			add(btnSearch);
			
	
			
			
		
			/*JTable table = new JTable();
			table.setForeground(Color.WHITE);
			table.setBackground(Color.WHITE);
			table.setFont(new Font("Tahoma", Font.BOLD, 14));
			table.setBounds(79, 230, 687, 325);
			table.setPreferredScrollableViewportSize(new Dimension(17,325));
			add(table);*/
			
			
			
			
		}
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
						c.setForeground(Color.BLUE);
						c.setBackground(Color.WHITE);
					}
					else
					{
						c.setForeground(Color.WHITE);
						c.setBackground(Color.BLUE);
					}
					if(isCellSelected(data,column))
					{
						c.setBackground(Color.RED);
						row = data;
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
	

	public void displayReview(String text) {
		JTextPane txtpnFds = new JTextPane();
		txtpnFds.setEditable(false);
		txtpnFds.setText(text);
		txtpnFds.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnFds.setBounds(206, 252, 439, 228);
		add(txtpnFds);
		
	}
}