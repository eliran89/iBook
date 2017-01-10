package boundry;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import controller.bookController;
import controller.userController;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class userBookGUI extends mainPanel {
	private JTextField textTitle;
	private JTextField textLangu;
	private JTextField textKeyWord;
	private JTextField textAuthor;
	private JTextField textAppendix;
	private JTextField textScope;
	private JTextField textBrief;
	
	private String[] columnHeader = {"Scope","Subject","Book Name","Book ID"};
	public static String[][] data;
	private static int row = -1;
	private JTable table_1;
	
	public userBookGUI(String name,String type){
		super(name,type);
		
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
		
		/*table_1 = new JTable();
		table_1.setBounds(181, 376, 583, 191);
		add(table_1);*/
		
		
		
		
		
		
		
	}
	
	public void displaySearch(){
		
		JLabel lblSearchBy = new JLabel("Search By : ");
		lblSearchBy.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblSearchBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchBy.setForeground(Color.WHITE);
		lblSearchBy.setBounds(10, 91, 131, 64);
		add(lblSearchBy);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBounds(189, 118, 51, 14);
		add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setForeground(Color.WHITE);
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAuthor.setBounds(178, 165, 62, 14);
		add(lblAuthor);
		
		JLabel lblLengu = new JLabel("Language");
		lblLengu.setHorizontalAlignment(SwingConstants.CENTER);
		lblLengu.setForeground(Color.WHITE);
		lblLengu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLengu.setBounds(434, 118, 73, 14);
		add(lblLengu);
		
		JLabel lblBrif = new JLabel("Brief");
		lblBrif.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrif.setForeground(Color.WHITE);
		lblBrif.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBrif.setBounds(189, 213, 38, 14);
		add(lblBrif);
		
		JLabel lblAppendix = new JLabel("Appendix");
		lblAppendix.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppendix.setForeground(Color.WHITE);
		lblAppendix.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAppendix.setBounds(434, 165, 73, 14);
		add(lblAppendix);
		
		JLabel lblScope = new JLabel("Scope");
		lblScope.setHorizontalAlignment(SwingConstants.CENTER);
		lblScope.setForeground(Color.WHITE);
		lblScope.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblScope.setBounds(694, 165, 51, 14);
		add(lblScope);
		
		JLabel lblKeyWord = new JLabel("Key Word");
		lblKeyWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblKeyWord.setForeground(Color.WHITE);
		lblKeyWord.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKeyWord.setBounds(694, 118, 73, 14);
		add(lblKeyWord);
		
		textTitle = new JTextField();
		textTitle.setBounds(248, 116, 124, 20);
		add(textTitle);
		textTitle.setColumns(10);
		
		textLangu = new JTextField();
		textLangu.setColumns(10);
		textLangu.setBounds(508, 116, 124, 20);
		add(textLangu);
		
		textKeyWord = new JTextField();
		textKeyWord.setColumns(10);
		textKeyWord.setBounds(769, 116, 124, 20);
		add(textKeyWord);
		
		textAuthor = new JTextField();
		textAuthor.setColumns(10);
		textAuthor.setBounds(250, 163, 124, 20);
		add(textAuthor);
		
		textAppendix = new JTextField();
		textAppendix.setColumns(10);
		textAppendix.setBounds(508, 163, 124, 20);
		add(textAppendix);
		
		textScope = new JTextField();
		textScope.setColumns(10);
		textScope.setBounds(769, 163, 124, 20);
		add(textScope);
		
		textBrief = new JTextField();
		textBrief.setColumns(10);
		textBrief.setBounds(248, 211, 124, 20);
		add(textBrief);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String brief = textBrief.getText();
				String title = textTitle.getText();
				String langu = textLangu.getText();
				String keyWord = textKeyWord.getText();
				String author = textAuthor.getText();
				String appendix = textAppendix.getText();
				String scope = textScope.getText();
				
				bookController.displayResults(brief,title,langu,keyWord,author,appendix,scope);
			}
		});
		btnSearch.setBounds(248, 287, 89, 23);
		add(btnSearch);
		
	}
	
	public void displayResults()
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
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment( SwingConstants.CENTER );
		
		for (int j = 0; j < columnHeader.length; j++)
			table.getColumnModel().getColumn(j).setCellRenderer(r);
		
		//table.setForeground(Color.BLUE);
		table.setBackground(Color.BLACK);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBounds(181, 376, 583, 191);
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setPreferredScrollableViewportSize(new Dimension(17,325));
		
		
		/**Scroll Pane*/
		JScrollPane pane = new JScrollPane(table);
		add(table);
		
		JLabel lblScope_1 = new JLabel("Scope");
		lblScope_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblScope_1.setForeground(Color.WHITE);
		lblScope_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblScope_1.setBounds(201, 345, 83, 23);
		add(lblScope_1);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject.setForeground(Color.WHITE);
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubject.setBounds(330, 345, 83, 23);
		add(lblSubject);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookName.setForeground(Color.WHITE);
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBookName.setBounds(459, 345, 111, 23);
		add(lblBookName);
		
		JLabel lblIndex = new JLabel("Index");
		lblIndex.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndex.setForeground(Color.WHITE);
		lblIndex.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIndex.setBounds(610, 342, 111, 23);
		add(lblIndex);
		
		JButton btnDisplayBook = new JButton("Display Book");
		btnDisplayBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String ID = (String) table.getValueAt(row, 3);
			}
		});
		btnDisplayBook.setBounds(394, 596, 129, 23);
		add(btnDisplayBook);
		
	}
	
	public void noResults(){
		
		JLabel label = new JLabel("<<No Results Found>>");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setBounds(360, 370, 239, 36);
		add(label);
		
	}
	
	public void orderBook() {
		// TODO - implement userBookGUI.orderBook
		throw new UnsupportedOperationException();
	}

	public void approvePayment() {
		// TODO - implement userBookGUI.approvePayment
		throw new UnsupportedOperationException();
	}

	public void displayWindow() {
		// TODO - implement userBookGUI.displayWindow
		throw new UnsupportedOperationException();
	}
}