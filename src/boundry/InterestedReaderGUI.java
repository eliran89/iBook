package boundry;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import controller.bookController;
import controller.reviewController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterestedReaderGUI extends mainPanel{
	public InterestedReaderGUI( String name , String role) {
		super(name,role);
		setForeground(Color.WHITE);
		
		JButton btnCheckBookReviews = new JButton("Check Book Reviews");
		btnCheckBookReviews.setBounds(374, 321, 211, 47);
		add(btnCheckBookReviews);
		btnCheckBookReviews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				reviewController.checkReview();
			}	
		});	
		
		JLabel lblWelcomToIbook = new JLabel("Welcome To IBook");
		lblWelcomToIbook.setFont(new Font("Sitka Subheading", Font.BOLD, 40));
		lblWelcomToIbook.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomToIbook.setForeground(Color.WHITE);
		lblWelcomToIbook.setBackground(Color.BLACK);
		lblWelcomToIbook.setBounds(225, 61, 491, 67);
		add(lblWelcomToIbook);
		
		JLabel imgR;
		imgR = new JLabel(new ImageIcon(InterestedReaderGUI.class.getResource("/boundry/reviews.jpg")));
		imgR.setBounds(374, 184, 211, 105);
		add(imgR);
		
		JButton btnBookSearch = new JButton("Book Search");
		btnBookSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookController.searchBook();
			}
		});
		btnBookSearch.setBounds(120, 321,211, 47);
		add(btnBookSearch);
		
		JLabel imgB;
		imgB = new JLabel(new ImageIcon(InterestedReaderGUI.class.getResource("/boundry/booksearch.jpg")));
		imgB.setBounds(120, 184, 211, 105);
		add(imgB);
		

	}
}
