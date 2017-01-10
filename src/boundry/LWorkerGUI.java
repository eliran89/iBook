package boundry;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import controller.loginController;
import controller.reviewController;
import controller.userController;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		btnUserManagement.setBounds(41, 272, 241, 86);
		add(btnUserManagement);
		
		JLabel imgU;
		imgU = new JLabel(new ImageIcon(InterestedReaderGUI.class.getResource("/boundry/UserIcons.jpg")));
		imgU.setBounds(31, 122, 246, 174);
		add(imgU);
		
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

	public void readerAcountOpening() {
		// TODO - implement LWorkerGUI.readerAcountOpening
		throw new UnsupportedOperationException();
	}

}