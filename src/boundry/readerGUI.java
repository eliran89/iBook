package boundry;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.loginController;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class readerGUI extends InterestedReaderGUI {
	
	public readerGUI( String name , String role) {
		super(name,role);
		img.setBounds(10, 521, 964, 357);
		
		JButton btnNewButton = new JButton("Write a new review");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = loginController.use.getUsername();
				
				
			}
		});
		btnNewButton.setBounds(621, 322, 208, 47);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(readerGUI.class.getResource("/boundry/write-ballpoint-ballpen-icon.png")));
		lblNewLabel.setBounds(660, 201, 128, 100);
		add(lblNewLabel);
		
	
	}
	public void makeReview() {
		// TODO - implement readerGUI.makeReview
		throw new UnsupportedOperationException();
	}

	public void bookSearch() {
		// TODO - implement readerGUI.bookSearch
		throw new UnsupportedOperationException();
	}

	public void displayResults() {
		// TODO - implement readerGUI.displayResults
		throw new UnsupportedOperationException();
	}

	public void chooseBook() {
		// TODO - implement readerGUI.chooseBook
		throw new UnsupportedOperationException();
	}
	
	/**
	 *displayPurchase method 
	 * 
	 * the method creates a new window, 
	 * displaying the details of the purchase
	 */
	public static void displayPurchase() {
		JPanel purchasePanel;
		
		
		JFrame user = new JFrame();	
		
		
	}
	/**
	 * END displayPurchase method
	 *
	 */
	
}