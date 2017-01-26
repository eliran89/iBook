package boundry;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.bookController;
import controller.userController;

public class managerGUI extends GWorkerGUI {
	public managerGUI( String name , String role) {
		
		super(name,role);
		
		
		/** button for user details **/
		JButton btnUserManagement = new JButton("User details management");
		btnUserManagement.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUserManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				userController.userSuspendSearch();
					
			}
		});
		
		/** adding a user icon**/
		JLabel userPic = new JLabel("");
		userPic.setIcon(new ImageIcon(LWorkerGUI.class.getResource("/boundry/User-Group-icon.png")));
		userPic.setHorizontalAlignment(SwingConstants.CENTER);
		userPic.setBounds(171, 165, 163, 153);
		add(userPic);
		
		
		btnUserManagement.setBounds(138, 329, 228, 27);
		add(btnUserManagement);
		
		/** button for reports **/
		JButton btnRaports = new JButton("Reports");
		btnRaports.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRaports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userController.showReportsMain();
			}
		});

		
		
		btnRaports.setBounds(396, 551,155, 27);
		add(btnRaports);
		
		JLabel imgReports;
		imgReports = new JLabel(new ImageIcon(InterestedReaderGUI.class.getResource("/boundry/reports.png")));
		imgReports.setBounds(407, 412, 128, 128);
		add(imgReports);
		
		JLabel imgWorker;
		imgWorker = new JLabel(new ImageIcon(InterestedReaderGUI.class.getResource("/boundry/worker.jpg")));
		imgWorker.setBounds(359, 168, 211, 105);
		add(imgWorker);
		
		JButton btnWorkerManagement = new JButton("Workers");
		btnWorkerManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userController.displayWorkerSearch();
			}
		});
		btnWorkerManagement.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnWorkerManagement.setBounds(396, 329, 155, 27);
		add(btnWorkerManagement);

	}


	public void changePrivilages() {
		// TODO - implement managerGUI.changePrivilages
		throw new UnsupportedOperationException();
	}

	/**
	 * show all reader's books' orders
	 */
	public void getUserReport() {
		// TODO - implement managerGUI.getUserReport
		throw new UnsupportedOperationException();
	}

	/**
	 * show a histogram of number of searches and purchases per book
	 */
	public void getBookReport() {
		// TODO - implement managerGUI.getBookReport
		throw new UnsupportedOperationException();
	}

	/**
	 * show the absolute book's rank
	 */
	public int getAbsRankReport() {
		// TODO - implement managerGUI.getAbsRankReport
		throw new UnsupportedOperationException();
	}

	/**
	 * show the book's rank in scope
	 */
	public int getScopeRankReport() {
		// TODO - implement managerGUI.getScopeRankReport
		throw new UnsupportedOperationException();
	}

	public void displayWindow() {
		// TODO - implement managerGUI.displayWindow
		throw new UnsupportedOperationException();
	}

	public void suspendUser() {
		// TODO - implement managerGUI.suspendUser
		throw new UnsupportedOperationException();
	}

}