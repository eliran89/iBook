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



import controller.bookController;
import controller.loginController;
import controller.reviewController;
import controller.userController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;

public class editorGUI extends mainPanel {
	
	
	public editorGUI( String name , String role) {
		super(name,role);
		
		/** main screen buttons and labels  **/
		
		
		//btnLogout.setBounds(10, 11, 89, 16);
		
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
		imgR.setBounds(560, 122, 247, 162);
		add(imgR);
		
		JButton btnMailBox = new JButton("Mail Box");
		btnMailBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMailBox.setBounds(585, 330, 211, 27);
		btnMailBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reviewController.openMailScreen();
				
			}
		});
		add(btnMailBox);
		
		
		JButton btnCheckBookReviews = new JButton("Check Book Reviews");
		btnCheckBookReviews.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCheckBookReviews.setBounds(585, 553, 211, 27);//138, 552
		add(btnCheckBookReviews);
		btnCheckBookReviews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				reviewController.checkReview();
			}	
		});	
		
		
		JLabel imgRe;
		imgRe = new JLabel(new ImageIcon(InterestedReaderGUI.class.getResource("/boundry/reviews.jpg")));
		imgRe.setBounds(585, 431, 211, 105);
		add(imgRe);
		
		JButton btnBookSearch = new JButton("Book Search");
		btnBookSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookController.searchBook();
			}
		});
		btnBookSearch.setBounds(120, 321,211, 23);
		btnBookSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		if(loginController.use.getprivilege() == 3)
			add(btnBookSearch);
		
		JLabel imgB;
		imgB = new JLabel(new ImageIcon(InterestedReaderGUI.class.getResource("/boundry/booksearch.jpg")));
		imgB.setBounds(120, 184, 211, 105);
		if(loginController.use.getprivilege() == 3)
			add(imgB);
		

	}

	
}