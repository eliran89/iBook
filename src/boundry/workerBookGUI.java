package boundry;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.bookController;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class workerBookGUI extends userBookGUI {
	private JTextField textFieldTitle;
	private JTextField textFieldAuthor;
	private JTextField textFieldLangu;
	private JTextField textFieldBrief;
	private JTextField textFieldScope;
	private JTextField textFieldKey;
	private JTextField textFieldAppen;
	
	/**
	 * workerBookGUI
	 * @param name String
	 * @param type String
	 */
	public workerBookGUI(String name , String type) {
		super(name,type);
		

	}
	
	/**
	 * addBook 
	 */
	public void addBook() {
		
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
		
		JButton btnAddScope = new JButton("Add Scope");
		btnAddScope.setBounds(809, 179, 120, 23);
		btnAddScope.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});

		add(btnAddScope);
		
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

	public void bookRemoval() {
		// TODO - implement workerBookGUI.bookRemoval
		throw new UnsupportedOperationException();
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