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
import javax.swing.JTable;

public class editorGUI extends mainPanel {
	private JTable table;
	public editorGUI( String name , String role) {
		super(name,role);
		btnLogout.setBounds(10, 11, 89, 16);
		
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
		imgR.setBounds(445, 141, 247, 137);
		add(imgR);
		
		JButton btnNewButton = new JButton("Mailbox");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reviewController.openMail();
			}
		});
		btnNewButton.setBounds(546, 336, 89, 23);
		add(btnNewButton);
		
		/*table = new JTable();
		table.setBounds(185, 392, 555, 227);
		add(table);*/
	
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
			
		table = new JTable();
		table.setBounds(185, 392, 555, 227);
		add(table);
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