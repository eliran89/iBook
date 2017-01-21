package boundry;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;

import controller.loginController;
import controller.reviewController;
import controller.userController;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class LWorkerGUI extends GWorkerGUI {
	public LWorkerGUI( String name , String role) {
		super(name,role);
		

		JButton btnUserManagement = new JButton("User details management");
		btnUserManagement.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUserManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				userController.userSearch();
					
			}
		});
		btnUserManagement.setBounds(138, 344, 228, 27);
		add(btnUserManagement);
		
		
		/** adding a user icon**/
		JLabel userPic = new JLabel("");
		userPic.setIcon(new ImageIcon(LWorkerGUI.class.getResource("/boundry/User-Group-icon.png")));
		userPic.setHorizontalAlignment(SwingConstants.CENTER);
		userPic.setBounds(171, 165, 163, 153);
		add(userPic);
		
		
	}

	public void editReaderDetails() {
		// TODO - implement LWorkerGUI.editReaderDetails
		throw new UnsupportedOperationException();
	}

	public boolean checkPaymentArrangement() {
		// TODO - implement LWorkerGUI.checkPaymentArrangement
		throw new UnsupportedOperationException();
	}

	public void setPaymentArrangements() {
		// TODO - implement LWorkerGUI.setPaymentArrangements
		throw new UnsupportedOperationException();
	}

	/**
	 * Open an Interested reader account
	 * @param ID, firstName, lastName, userName, Password
	 */
	public void interestedReaderAcountOpening() {
		
		// TODO - implement LWorkerGUI.readerAcountOpening
		throw new UnsupportedOperationException();
	}
}