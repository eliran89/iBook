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
import controller.loginController;
import controller.userController;
import entity.Book;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

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
	private JTable athorsTable;
	private JTextField TFLang;
	private JTable scopeTable;
	private JTable table_2;
	/**
	 * 
	 * @param name
	 * @param type
	 */
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
		btnMainWindow.setForeground(Color.BLACK);
		btnMainWindow.setBounds(26, 38, 122, 23);
		add(btnMainWindow);
		
		
		/*table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table_2.setBounds(179, 253, 239, 56);;
		add(table_2);*/
		
		
		
		/*table_1 = new JTable();
		table_1.setBounds(181, 376, 583, 191);
		add(table_1);*/
		
		
		
		
		
		
		
	}
	/**
	 * 
	 */
	public void displaySearch(){
		
		JLabel lblSearchBy = new JLabel("Search By : ");
		lblSearchBy.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblSearchBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchBy.setForeground(Color.BLACK);
		lblSearchBy.setBounds(10, 91, 131, 64);
		add(lblSearchBy);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setBounds(189, 118, 51, 14);
		add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setForeground(Color.BLACK);
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAuthor.setBounds(178, 165, 62, 14);
		add(lblAuthor);
		
		JLabel lblLengu = new JLabel("Language");
		lblLengu.setHorizontalAlignment(SwingConstants.CENTER);
		lblLengu.setForeground(Color.BLACK);
		lblLengu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLengu.setBounds(434, 118, 73, 14);
		add(lblLengu);
		
		JLabel lblBrif = new JLabel("Brief");
		lblBrif.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrif.setForeground(Color.BLACK);
		lblBrif.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBrif.setBounds(189, 213, 38, 14);
		add(lblBrif);
		
		JLabel lblAppendix = new JLabel("Appendix");
		lblAppendix.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppendix.setForeground(Color.BLACK);
		lblAppendix.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAppendix.setBounds(434, 165, 73, 14);
		add(lblAppendix);
		
		JLabel lblScope = new JLabel("Scope");
		lblScope.setHorizontalAlignment(SwingConstants.CENTER);
		lblScope.setForeground(Color.BLACK);
		lblScope.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblScope.setBounds(694, 165, 51, 14);
		add(lblScope);
		
		JLabel lblKeyWord = new JLabel("Key Word");
		lblKeyWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblKeyWord.setForeground(Color.BLACK);
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
	/**
	 * 
	 */
	public void displayResults()
	{
		/**Create The Result Table
		 * 
		 */
		
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
			
				if(getValueAt(data, column)=="")
					if(data % 2 == 0)
						c.setBackground(Color.LIGHT_GRAY);
					else
						c.setBackground(Color.WHITE);
				
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
		table.setBounds(181, 376, 583, 191);
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setPreferredScrollableViewportSize(new Dimension(17,325));
		
		
		/**Scroll Pane*/
		JScrollPane pane = new JScrollPane(table);
		add(table);
		
		JLabel lblScope_1 = new JLabel("Scope");
		lblScope_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblScope_1.setForeground(Color.BLACK);
		lblScope_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblScope_1.setBounds(210, 345, 83, 23);
		add(lblScope_1);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject.setForeground(Color.BLACK);
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubject.setBounds(350, 345, 83, 23);
		add(lblSubject);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookName.setForeground(Color.BLACK);
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBookName.setBounds(470, 345, 111, 23);
		add(lblBookName);
		
		JLabel lblIndex = new JLabel("Index");
		lblIndex.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndex.setForeground(Color.BLACK);
		lblIndex.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIndex.setBounds(630, 342, 111, 23);
		add(lblIndex);
		
		JButton btnDisplayBook = new JButton("Display Book");
		btnDisplayBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String ID = (String) table.getValueAt(row, 3);
				bookController.chooseBook(ID);
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
	public void displayBook(Book book){
		
		String[] sHeader = {"sName"};
		String[] aHeader = {"aName"};
		String[][] tData = new String[1][book.getAuthors().size()];
		
		for(int i = 0 ; i<book.getAuthors().size();i++)
			tData[0][i] = book.getAuthors().get(i);
		
		JLabel lblCost = new JLabel("Cost : "+ book.getCost()+"$");
		lblCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblCost.setFont(new Font("Ariel", Font.BOLD, 16));
		lblCost.setBounds(631, 80, 251, 54);
		add(lblCost);
		
		JLabel lblBookTitle = new JLabel(book.getTitle());
		lblBookTitle.setFont(new Font("Poor Richard", Font.BOLD, 24));
		lblBookTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookTitle.setBounds(336, 80, 251, 54);
		add(lblBookTitle);
		
		JLabel lblAthors = new JLabel("Athor(s) : ");
		lblAthors.setHorizontalAlignment(SwingConstants.CENTER);
		lblAthors.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAthors.setBounds(79, 251, 97, 14);
		add(lblAthors);
		
		athorsTable = new JTable(tData,aHeader){
			public boolean isCellEditable(int data,int columns){
				return false;
			}
			public Component prepareRenderer(TableCellRenderer r,int data ,int column){
				Component c = super.prepareRenderer(r,data,column);
		
				if(isCellSelected(data,column))
				{
					c.setBackground(Color.WHITE);
					row = data;
				}
					
				
				return c;
			}
			
				
			
		};
		
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment( SwingConstants.CENTER );
		for (int j = 0; j < aHeader.length; j++)
			athorsTable.getColumnModel().getColumn(j).setCellRenderer(r);
		
		athorsTable.setBorder(new LineBorder(Color.WHITE));
		athorsTable.setBounds(179, 253, 122, 34);
		athorsTable.setPreferredScrollableViewportSize(new Dimension(17,34));

		/**Scroll Pane*/
		JScrollPane pane = new JScrollPane(athorsTable);
		add(athorsTable);
		
		JLabel lblLanguange = new JLabel("languange : ");
		lblLanguange.setHorizontalAlignment(SwingConstants.CENTER);
		lblLanguange.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLanguange.setBounds(72, 331, 97, 23);
		add(lblLanguange);
		
		TFLang = new JTextField();
		TFLang.setText(book.getLanguage());
		TFLang.setEditable(false);
		TFLang.setBounds(179, 334, 122, 20);
		add(TFLang);
		TFLang.setColumns(10);
		
		JLabel lblBrief = new JLabel("Brief : ");
		lblBrief.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrief.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBrief.setBounds(568, 331, 72, 23);
		add(lblBrief);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText(book.getBrief());
		textPane.setEditable(false);
		textPane.setBounds(664, 331, 243, 131);
		add(textPane);
		
		JLabel lblAppendix_1 = new JLabel("Appendix : ");
		lblAppendix_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppendix_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAppendix_1.setBounds(557, 188, 97, 23);
		add(lblAppendix_1);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText(book.getAppendix());
		textPane_1.setEditable(false);
		textPane_1.setBounds(664, 188, 243, 131);
		add(textPane_1);
		
		JLabel lblScopes = new JLabel("Scope(s): ");
		lblScopes.setHorizontalAlignment(SwingConstants.CENTER);
		lblScopes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblScopes.setBounds(79, 192, 97, 14);
		add(lblScopes);
		
		tData = new String[book.getScope().size()][1];
		
		for(int i = 0 ; i<book.getScope().size();i++)
			tData[i][0] = book.getScope().get(i);
	//	System.out.println(book.getScope().size() + tData[0][0] + tData[0][1] + book.getScope());
		scopeTable = new JTable(tData,sHeader){
			public boolean isCellEditable(int data,int columns){
				return false;
			}
			public Component prepareRenderer(TableCellRenderer r,int data ,int column){
				Component c = super.prepareRenderer(r,data,column);
		
				if(isCellSelected(data,column))
				{
					c.setBackground(Color.WHITE);
					row = data;
				}
					
				
				return c;
			}
		};
		for (int j = 0; j < sHeader.length; j++)
			scopeTable.getColumnModel().getColumn(j).setCellRenderer(r);
		
		scopeTable.setBorder(new LineBorder(Color.WHITE));
		scopeTable.setBounds(179, 194, 122, 34);
		scopeTable.setPreferredScrollableViewportSize(new Dimension(17,34));

		/**Scroll Pane*/
		JScrollPane pane2 = new JScrollPane(scopeTable);
		add(scopeTable);
		
		JButton btnOrderTheBook = new JButton("Order The Book");
		btnOrderTheBook.setBackground(Color.GREEN);
		btnOrderTheBook.setBounds(679, 534, 150, 23);
		if(loginController.use.getprivilege() == 1)
			btnOrderTheBook.setVisible(false);
		add(btnOrderTheBook);
		
		JButton btnBackToSearch = new JButton("Back To Search");
		btnBackToSearch.setBackground(Color.RED);
		btnBackToSearch.setBounds(145, 534, 150, 23);
		btnBackToSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookController.searchBook();
			}
		});
			
		add(btnBackToSearch);
	}
}