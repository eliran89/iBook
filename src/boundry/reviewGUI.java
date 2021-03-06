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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollBar;

import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class reviewGUI extends mainPanel {
	private JTextField textField;
	public static int n = 0;
	private String[] columnHeader = {"Book Name","Review Name","Reviewer"};
	public static String[][] data;
	private static int row = -1;
	
	public static JLabel lblSearchBy;
	/**
	 * reviewGUI constructor 
	 * @param name String
	 * @param role String
	 */
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
			btnMainWindow.setForeground(Color.BLACK);
			btnMainWindow.setBounds(26, 38, 138, 23);
			add(btnMainWindow);
			
			lblSearchBy = new JLabel("Search By : ");
			lblSearchBy.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
			lblSearchBy.setHorizontalAlignment(SwingConstants.CENTER);
			lblSearchBy.setForeground(Color.BLACK);
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
			
			//Search Review //
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
			
	
			
			
		
		
			
			
			
			
		}

	

	/**
	 * getReview display search result
	 */

		public void getReview()
		{
			
			/**Create The Result Table**/
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
			
			//table.setForeground(Color.BLUE);
			table.setBackground(Color.WHITE);
			table.setFont(new Font("Arial", Font.PLAIN, 12));
			table.setBorder(new LineBorder(Color.LIGHT_GRAY));
			table.setPreferredScrollableViewportSize(new Dimension(687,325));

			/*Scroll Pane*/
			JScrollPane pane = new JScrollPane(table);
			pane.setBounds(79, 230, 687, 325);
			add(pane);
		
			
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
		/**
		 * noResults display a labal "<No Results>"
		 */
	public void noResults()
	{
		JLabel label = new JLabel("<<No Results Found>>");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setBounds(292, 188, 177, 36);
		add(label);
	}
	
/**
 *  displayReview display chosen review
 * @param text String
 */
	public void displayReview(String text) {
		JTextPane txtpnFds = new JTextPane();
		txtpnFds.setEditable(false);
		txtpnFds.setText(text);
		txtpnFds.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnFds.setBounds(206, 252, 439, 228);
		add(txtpnFds);
		
	}
}