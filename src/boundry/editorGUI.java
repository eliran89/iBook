package boundry;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.reviewController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class editorGUI extends mainPanel {
	public editorGUI( String name , String role) {
		super(name,role);
		
		setForeground(Color.WHITE);
		JLabel lblWelcomToIbook = new JLabel("Welcome To IBook");
		lblWelcomToIbook.setFont(new Font("Sitka Subheading", Font.BOLD, 40));
		lblWelcomToIbook.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomToIbook.setForeground(Color.WHITE);
		lblWelcomToIbook.setBackground(Color.BLACK);
		lblWelcomToIbook.setBounds(201, 63, 491, 67);
		add(lblWelcomToIbook);
		
		
		JLabel imgR;
		imgR = new JLabel(new ImageIcon(editorGUI.class.getResource("/boundry/mailbox.jpg")));
		imgR.setBounds(329, 169, 247, 137);
		add(imgR);
		
		JButton btnNewButton = new JButton("Mailbox");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reviewController.checkReview();
			}
		});
		btnNewButton.setBounds(413, 371, 89, 23);
		add(btnNewButton);
	
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
		// TODO - implement editorGUI.openMail
		throw new UnsupportedOperationException();
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