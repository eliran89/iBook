package boundry;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.bookController;
import controller.loginController;
import entity.Book;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox.KeySelectionManager;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;

public class workerBookGUI extends userBookGUI {
	private JTextField textFieldTitle;
	private JTextField textFieldAuthor;
	private JTextField textFieldLangu;
	private JTextField textFieldBrief;
	private JTextField textFieldScope;
	private JTextField textFieldKey;
	private JTextField textFieldAppen;
	private JTextField textFieldCost;
	ArrayList<String> authors;
	ArrayList<String> keywords;
	ArrayList<String> scopes;
	ArrayList<String> subjects;
	Book book;
	private JTextField textFieldSubject;
	private JTextField textFieldAuthorEdit;
	private JTextField textFieldCostEdit;
	private JTextField textFieldLanguEdit;
	private JTextField textFieldScopeEdit;
	private JTextField textFieldSubjectEdit;
	private JTextField textFieldKeyEdit;
	private JComboBox comboBoxAuthor;
	/**
	 * workerBookGUI
	 * @param name String
	 * @param type String
	 */
	public workerBookGUI(String name , String type) {
		super(name,type);

		


		
	}
	/**
	 * addBook - display the window of the book add  
	 * display a screen with book information to fill
	 */
	public void addBook() {
		
		book =new Book();
		authors = new ArrayList<String>();
		keywords = new ArrayList<String>();
		scopes = new ArrayList<String>();
		subjects = new ArrayList<String>();
		
		JLabel lblTitle = new JLabel("Title :");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(141, 123, 69, 29);
		add(lblTitle);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setBounds(220, 128, 148, 20);
		add(textFieldTitle);
		textFieldTitle.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author :");
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAuthor.setBounds(141, 175, 62, 29);
		add(lblAuthor);
		
		textFieldAuthor = new JTextField();
		textFieldAuthor.setColumns(10);
		textFieldAuthor.setBounds(220, 180, 148, 20);
		add(textFieldAuthor);
		
		JLabel lblBrife = new JLabel("Brief :");
		lblBrife.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrife.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBrife.setBounds(148, 303, 62, 29);
		add(lblBrife);
		
		JButton btnAddAuthor = new JButton("Add Author");
		btnAddAuthor.setBounds(395, 179, 103, 23);
		btnAddAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String author =new String( textFieldAuthor.getText());
				if(author.equals(""))
					warningBox("Must fill an author name","textFieldAuthor");
				else{
							boolean bool = true;
							for(int i = 0;i<authors.size();i++)
								if(authors.get(i).equals(author))
									bool = false;
							if (bool)
								authors.add(author);
							textFieldAuthor.setText("");
							
							}
				}
				
			
		});

		add(btnAddAuthor);
		
		JLabel lblLanguange = new JLabel("Languange :");
		lblLanguange.setHorizontalAlignment(SwingConstants.CENTER);
		lblLanguange.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLanguange.setBounds(529, 119, 89, 29);
		add(lblLanguange);
		
		textFieldLangu = new JTextField();
		textFieldLangu.setColumns(10);
		textFieldLangu.setBounds(626, 123, 148, 20);
		add(textFieldLangu);
		
		textFieldBrief = new JTextField();
		textFieldBrief.setColumns(10);
		textFieldBrief.setScrollOffset(1);
		textFieldBrief.setBounds(220, 313, 264, 131);
		add(textFieldBrief);
		
		JLabel lblScope = new JLabel("Scope :");
		lblScope.setHorizontalAlignment(SwingConstants.CENTER);
		lblScope.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblScope.setBounds(556, 175, 62, 29);
		add(lblScope);
		
		textFieldScope = new JTextField();
		textFieldScope.setColumns(10);
		textFieldScope.setBounds(626, 180, 148, 20);
		add(textFieldScope);
		
		JLabel lblSubject = new JLabel("Subject :");
		lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSubject.setBounds(556, 210, 62, 29);
		add(lblSubject);
		
		textFieldSubject = new JTextField();
		textFieldSubject.setColumns(10);
		textFieldSubject.setBounds(626, 219, 148, 20);
		add(textFieldSubject);
		
		JButton btnAddScope = new JButton("Add Scope");
		btnAddScope.setBounds(809, 179, 120, 23);
		btnAddScope.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String scope = new String( textFieldScope.getText());
				String subject = new String( textFieldSubject.getText());
				if(scope.equals("") || subject.equals(""))
					warningBox("Must fill a scope and subject name","textFieldScope");
				else{
							boolean bool = true;
							for(int i = 0;i< scopes.size();i++)
								if(scopes.get(i).equals(scope))
								{
									scopes.add(i, scope);
									subjects.add(i, subject);
									bool = false;
									textFieldSubject.setText("");
									textFieldScope.setText("");
								}
							if(bool)
							{
								scopes.add(scope);
								subjects.add(subject);
								textFieldSubject.setText("");
								textFieldScope.setText("");
					
							}
							else
								warningBox("You already added this scope, the first one were erased","textFieldScope");
								
						
					
				}
				
				
			}
		});

		add(btnAddScope);
		
		JLabel lblCost = new JLabel("Cost :");
		lblCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblCost.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCost.setBounds(556, 245, 62, 29);
		add(lblCost);
		
		textFieldCost = new JTextField();
		textFieldCost.setColumns(10);
		textFieldCost.setBounds(626, 255, 148, 20);
		add(textFieldCost);
		
		JLabel lblKeyword = new JLabel("Keyword :");
		lblKeyword.setHorizontalAlignment(SwingConstants.CENTER);
		lblKeyword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKeyword.setBounds(141, 235, 62, 29);
		add(lblKeyword);
		
		textFieldKey = new JTextField();
		textFieldKey.setColumns(10);
		textFieldKey.setBounds(220, 240, 148, 20);
		add(textFieldKey);
		
		JButton btnAddKeyword = new JButton("Add Keyword");
		btnAddKeyword.setBounds(395, 239, 120, 23);
		btnAddKeyword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String keyword =new String( textFieldKey.getText());
				if(keyword.equals(""))
					warningBox("Must fill a keyword","textFieldKey");
				else{
					boolean bool = true;
					for(int i = 0;i<keywords.size();i++)
						if(keywords.get(i).equals(keyword))
							bool = false;
					if(bool)
						keywords.add(keyword);
					textFieldKey.setText("");
				}
				
				
			}
		});

		add(btnAddKeyword);
		
		JLabel lblAppendix = new JLabel("Appendix :");
		lblAppendix.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppendix.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAppendix.setBounds(556, 303, 62, 29);
		add(lblAppendix);
		
		textFieldAppen = new JTextField();
		textFieldAppen.setScrollOffset(1);
		textFieldAppen.setColumns(10);
		textFieldAppen.setBounds(634, 313, 264, 131);
		add(textFieldAppen);
		
		JButton btnNewButton = new JButton("Add Book");
		btnNewButton.setBounds(476, 535, 120, 42);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean toContinue = true;
				String title = textFieldTitle.getText();
				String langu = textFieldLangu.getText();
				String cost = textFieldCost.getText();
				String appen = textFieldAppen.getText();
				String brief = textFieldBrief.getText();
				String scope = textFieldScope.getText();
				String subject = textFieldSubject.getText();
				
				try {
					if( !scope.equals("") && !subject.equals("") && bookController.verifyScope(scope))
					{	
						boolean bool = true;
						for (int i =0;i<scopes.size();i++)
							if(scopes.get(i).equals(scope))
							{
								scopes.add(i, scope);
								subjects.add(i, subject);
								bool = false;
								textFieldSubject.setText("");
								textFieldScope.setText("");
							}
						if(bool)
							scopes.add(scope);
							subjects.add(subject);
							textFieldSubject.setText("");
							textFieldScope.setText("");
					}
					else if((scope.equals("") && !subject.equals("") )|| (!scope.equals("") && subject.equals("") ))
					{
						errorBox("Must fill a scope and subject name","textFieldScope");
						toContinue =false;
					}
					else if (!scope.equals("") && !subject.equals("") && !bookController.verifyScope(scope))
					{
						toContinue =false;
						errorBox("Scope does not exists","textFieldScope");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				String author = textFieldAuthor.getText();
				if(!author.equals("")){
					boolean bool = true;
					for(int i = 0;i<authors.size();i++)
						if(authors.get(i).equals(author))
						{
							bool =false;
							textFieldAuthor.setText("");
						}
					if(bool)
					{
						authors.add(author);
						textFieldAuthor.setText("");
					}
				}	

				String keyword = textFieldKey.getText();
				if(!keyword.equals("") ){
					boolean bool = true;
					for(int i = 0;i<keywords.size();i++)
						if(keywords.get(i).equals(keyword))
							bool = false;
					if(bool)
						keywords.add(keyword);
					textFieldKey.setText("");
				}
				int costi;
				try{
					costi = Integer.parseInt(cost);
				}catch(Exception e){
					costi = -1;
					errorBox("cost must be a number at least 0","cost");
				}
				
				if(title.equals("") || langu.equals("") || brief.equals("") ||appen.equals("") || cost.equals("") || authors.size() == 0 || scopes.size() == 0)
					toContinue = false;
				if(costi > 0)
				{
					errorBox("cost must be a number at least 0","cost");
					toContinue = false;
				}
				
				if(!toContinue)
					errorBox("All fields must be filled","Error");
				else{
					book.setTitle(title);
					book.setAppendix(appen);
					book.setLanguage(langu);
					book.setAuthors(authors);
					book.setScope(scopes);
					book.setSubject(subjects);
					book.setBrief(brief);
					book.setCost(Float.parseFloat(cost));
					if(keywords.size()>0)
						book.setKey(keywords);
					try {
						bookController.addBook(book);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					infoBox("Book added","Successes");
					bookController.searchBook();
				}
					
				
			}
		});
		add(btnNewButton);
		
		JButton btnBackToSearch = new JButton("Back To Search");
		btnBackToSearch.setBounds(230, 535, 133, 42);
		btnBackToSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookController.searchBook();
			}
		});
			
		add(btnBackToSearch);
		
	}
	/**
	 * editBook - display the book information 
	 * with option to change them
	 * @param book Book
	 */
	public void editBook(Book book) {
		
		
		JCheckBox chckbxSuspended = new JCheckBox("Suspended");
		chckbxSuspended.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxSuspended.setBackground(Color.WHITE);
		chckbxSuspended.setBounds(39, 86, 200, 50);
		if(book.isSuspended())
			chckbxSuspended.setSelected(true);
		if(loginController.use.getprivilege() == 6)
			add(chckbxSuspended);
		
		JTextPane textPane = new JTextPane();
		textPane.setText(book.getBrief());
		textPane.setBounds(664, 331, 243, 131);
		add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText(book.getAppendix());
		textPane_1.setBounds(664, 188, 243, 131);
		add(textPane_1);
		
		
		JTextField TFTitle = new JTextField();
		TFTitle.setText(book.getTitle());
		TFTitle.setFont(new Font("Poor Richard", Font.BOLD, 24));
		TFTitle.setHorizontalAlignment(SwingConstants.CENTER);
		TFTitle.setBounds(336, 80, 251, 54);
		add(TFTitle);
		
		JLabel lblCost = new JLabel("Cost : $");
		lblCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblCost.setFont(new Font("Ariel", Font.BOLD, 16));
		lblCost.setBounds(565, 534, 75, 32);
		add(lblCost);
		
		textFieldAuthorEdit = new JTextField();
		textFieldAuthorEdit.setBounds(176, 291, 150, 20);
		add(textFieldAuthorEdit);
		textFieldAuthorEdit.setColumns(10);
		
		JLabel lblAthors = new JLabel("Author(s) : ");
		lblAthors.setHorizontalAlignment(SwingConstants.CENTER);
		lblAthors.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAthors.setBounds(79, 251, 97, 14);
		add(lblAthors);
		
		comboBoxAuthor = new JComboBox();
		ArrayList<String> authors = book.getAuthors();
		for(int i = 0 ; i < authors.size() ; i++)
			comboBoxAuthor.addItem(authors.get(i));
		comboBoxAuthor.setBounds(176, 250, 150, 20);
		add(comboBoxAuthor);
		
		JButton btnRemoveAuthor = new JButton("Remove");
		btnRemoveAuthor.setBounds(364, 249, 89, 23);
		btnRemoveAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String author = (String) comboBoxAuthor.getSelectedItem();
				int i=0;
				while(i<authors.size() && !author.equalsIgnoreCase(authors.get(i)))
					i++;
				/**
				 * 
				 */
				authors.remove(i);
				infoBox("Author Removed Successfully","Author removal");
				book.setAuthors(authors);
				book.setTitle(TFTitle.getText());
				book.setCost(Float.parseFloat(textFieldCostEdit.getText()));
				book.setLanguage(textFieldLanguEdit.getText());
				book.setBrief(textPane.getText());
				book.setAppendix(textPane_1.getText());
				if(chckbxSuspended.isSelected())
					book.lock();
				else
					book.unlock();
				bookController.editBookinfo(book);
				
				
				
				System.out.println(authors);
			}
		});
		add(btnRemoveAuthor);
		
		JButton btnAddAuthor = new JButton("Add");
		btnAddAuthor.setBounds(364, 290, 89, 23);
		btnAddAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String author = textFieldAuthorEdit.getText();
				if(author.equals(""))
					errorBox("Must fill an author","Authors");				
				else
				{
					int i = 0;
					while(i<authors.size() && !author.equalsIgnoreCase(authors.get(i)))
						i++;
					if(i == authors.size())
						authors.add(author);
					else
						errorBox("Author already exists","Authors");
					textFieldAuthorEdit.setText("");	
				}
				book.setAuthors(authors);
				book.setTitle(TFTitle.getText());
				book.setCost(Float.parseFloat(textFieldCostEdit.getText()));
				book.setLanguage(textFieldLanguEdit.getText());
				book.setBrief(textPane.getText());
				book.setAppendix(textPane_1.getText());
				if(chckbxSuspended.isSelected())
					book.lock();
				else
					book.unlock();
				bookController.editBookinfo(book);
			}
		});
		add(btnAddAuthor);
		
		JLabel lblLanguange = new JLabel("languange : ");
		lblLanguange.setHorizontalAlignment(SwingConstants.CENTER);
		lblLanguange.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLanguange.setBounds(72, 331, 97, 23);
		add(lblLanguange);
		
		textFieldCostEdit = new JTextField();
		textFieldCostEdit.setColumns(10);
		textFieldCostEdit.setText(Float.toString(book.getCost()));
		textFieldCostEdit.setBounds(650, 542, 150, 20);
		add(textFieldCostEdit);
		
		textFieldLanguEdit = new JTextField();
		textFieldLanguEdit.setColumns(10);
		textFieldLanguEdit.setText(book.getLanguage());
		textFieldLanguEdit.setBounds(176, 331, 150, 20);
		add(textFieldLanguEdit);

		JLabel lblBrief = new JLabel("Brief : ");
		lblBrief.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrief.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBrief.setBounds(568, 331, 72, 23);
		add(lblBrief);
		
		
		JLabel lblAppendix_1 = new JLabel("Appendix : ");
		lblAppendix_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppendix_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAppendix_1.setBounds(557, 188, 97, 23);
		add(lblAppendix_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(57, 216, 417, 107);
		add(separator);
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(57, 365, 433, 156);
		add(separator_1);
		
		JLabel lblScope_1 = new JLabel("Scope : ");
		lblScope_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblScope_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblScope_1.setBounds(79, 428, 97, 14);
		add(lblScope_1);
		
		JButton btnAddScope = new JButton("Add");
		btnAddScope.setBounds(364, 418, 89, 23);
		btnAddScope.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> scopes = book.getScope();
				ArrayList<String> subjects = book.getSubject();
				String scope = textFieldScopeEdit.getText();
				String subject = textFieldSubjectEdit.getText();
				if(scope.equals("") || subject.equals(""))
					errorBox("Must fill a scope and a subject","Scope/subject");
				else
				{
					int i = 0;
					while(i < scopes.size() && !scope.equalsIgnoreCase(scopes.get(i)))
						i++;
					if(i == scopes.size()){
								scopes.add(scope);
								subjects.add(subject);
								book.setScope(scopes);
								book.setSubject(subjects);
								book.setTitle(TFTitle.getText());
								book.setCost(Float.parseFloat(textFieldCostEdit.getText()));
								book.setLanguage(textFieldLanguEdit.getText());
								book.setBrief(textPane.getText());
								book.setAppendix(textPane_1.getText());
								if(chckbxSuspended.isSelected())
									book.lock();
								else
									book.unlock();
								bookController.editBookinfo(book);
							
						
					}
					else
						errorBox("The book already belongs to this scope","scopes");
					
				}
				
			}
		});
		add(btnAddScope);
		
		JLabel lblScopes = new JLabel("Scope(s) : ");
		lblScopes.setHorizontalAlignment(SwingConstants.CENTER);
		lblScopes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblScopes.setBounds(79, 386, 97, 14);
		add(lblScopes);
		
		JComboBox comboBoxScope = new JComboBox();
		ArrayList<String> scopes = book.getScope();
		for(int i = 0 ;i < scopes.size() ; i++)
			comboBoxScope.addItem(scopes.get(i));
		comboBoxScope.setBounds(176, 385, 150, 20);
		add(comboBoxScope);
		
		JButton btnRemoveScope = new JButton("Remove");
		btnRemoveScope.setBounds(364, 384, 89, 23);
		btnRemoveScope.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> scopes = book.getScope();
				ArrayList<String> subjects = book.getSubject();
				String scope = (String) comboBoxScope.getSelectedItem();
				int i = 0;
				while(!scope.equals(scopes.get(i)))
					i++;
				scopes.remove(i);
				subjects.remove(i);
				book.setScope(scopes);
				book.setSubject(subjects);
				book.setTitle(TFTitle.getText());
				book.setCost(Float.parseFloat(textFieldCostEdit.getText()));
				book.setLanguage(textFieldLanguEdit.getText());
				book.setBrief(textPane.getText());
				book.setAppendix(textPane_1.getText());
				if(chckbxSuspended.isSelected())
					book.lock();
				else
					book.unlock();
				bookController.editBookinfo(book);
				
			}
		});
		add(btnRemoveScope);
		
		textFieldScopeEdit = new JTextField();
		textFieldScopeEdit.setColumns(10);
		textFieldScopeEdit.setBounds(176, 422, 150, 20);
		add(textFieldScopeEdit);
		
		JLabel lblSubject_1 = new JLabel("Subject : ");
		lblSubject_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubject_1.setBounds(79, 462, 97, 14);
		add(lblSubject_1);
		
		textFieldSubjectEdit = new JTextField();
		textFieldSubjectEdit.setColumns(10);
		textFieldSubjectEdit.setBounds(176, 462, 150, 20);
		add(textFieldSubjectEdit);
		
		JLabel lblKeywords = new JLabel("Keyword(s) : ");
		lblKeywords.setHorizontalAlignment(SwingConstants.CENTER);
		lblKeywords.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKeywords.setBounds(72, 513, 97, 14);
		add(lblKeywords);
		
		JComboBox comboBoxKey = new JComboBox();
		comboBoxKey.setBounds(176, 507, 150, 20);
		ArrayList<String> keys = book.getKey();
		for(int i =0 ; i < keys.size() ; i++)
			comboBoxKey.addItem(keys.get(i));
		add(comboBoxKey);
		
		JButton btnRemoveKey = new JButton("Remove");
		btnRemoveKey.setBounds(364, 502, 89, 23);
			
		btnRemoveKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> keys = book.getKey();
				String key = (String) comboBoxKey.getSelectedItem();
				int i=0;
				while(!key.equalsIgnoreCase(keys.get(i)))
					i++;
				keys.remove(i);
				book.setKey(keys);
				System.out.println("keys: "+keys+" book.keys: "+book.getKey());
				book.setTitle(TFTitle.getText());
				book.setCost(Float.parseFloat(textFieldCostEdit.getText()));
				book.setLanguage(textFieldLanguEdit.getText());
				book.setBrief(textPane.getText());
				book.setAppendix(textPane_1.getText());
				if(chckbxSuspended.isSelected())
					book.lock();
				else
					book.unlock();
				bookController.editBookinfo(book);
				
			}
		});
		add(btnRemoveKey);
		
		textFieldKeyEdit = new JTextField();
		textFieldKeyEdit.setColumns(10);
		textFieldKeyEdit.setBounds(176, 543, 150, 20);
		add(textFieldKeyEdit);
		
		JButton btnAddKey = new JButton("Add");
		btnAddKey.setBounds(364, 542, 89, 23);
		btnAddKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> keys = book.getKey();
				String key = textFieldKeyEdit.getText();
				if(key.equals(""))
					errorBox("Must enter a keyword","Keyword");
				int i = 0;
				while(i<keys.size() && !key.equalsIgnoreCase(keys.get(i)))
					i++;
				if(i == keys.size()){
					keys.add(key);
					book.setKey(keys);
					book.setTitle(TFTitle.getText());
					book.setCost(Float.parseFloat(textFieldCostEdit.getText()));
					book.setLanguage(textFieldLanguEdit.getText());
					book.setBrief(textPane.getText());
					book.setAppendix(textPane_1.getText());
					if(chckbxSuspended.isSelected())
						book.lock();
					else
						book.unlock();
					bookController.editBookinfo(book);
				}
					
				else{
					errorBox("Keyword already exists","Keyword");
					textFieldKeyEdit.setText("");
				}
			}
		});
		add(btnAddKey);

		JButton btnSaveBook = new JButton("Save Book");
		btnSaveBook.setBounds(827, 602, 98, 23);
		btnSaveBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				book.setTitle(TFTitle.getText());
				book.setLanguage(textFieldLanguEdit.getText());
				book.setBrief(textPane.getText());
				book.setAppendix(textPane_1.getText());
				if(chckbxSuspended.isSelected())
					book.lock();
				else
					book.unlock();
				try{
					book.setCost(Float.parseFloat(textFieldCostEdit.getText()));
				}catch(Exception e){;
					book.setCost(-1);
				}
				if(!book.isBookComplete()){
					if(book.getCost() < 0)
						errorBox("cost must be a number more then 0","Cost");
					else
						errorBox("Book is not complete and will not be saved until","Book");
				}
				else
				{
					try {
						bookController.changeBookInfo(book);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					infoBox("Book Updated","Succsses");
					bookController.searchBook();
				}
			}
		});
		add(btnSaveBook);
		
		JButton btnBackToSearch_1 = new JButton("Back To Search");
		btnBackToSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookController.searchBook();
			}
		});
		btnBackToSearch_1.setBounds(48, 596, 124, 23);
		add(btnBackToSearch_1);
		
	}
	public void displayWindow() {
		// TODO - implement workerBookGUI.displayWindow
		throw new UnsupportedOperationException();
	}

	public void searchBook() {
			
	}

	public void chooseBook() {
		// TODO - implement workerBookGUI.chooseBook
		throw new UnsupportedOperationException();
	}

	public void operation() {
		// TODO - implement workerBookGUI.operation
		throw new UnsupportedOperationException();
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}