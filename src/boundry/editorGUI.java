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



import controller.reviewController;
import controller.userController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class editorGUI extends mainPanel {
	
	
	public editorGUI( String name , String role) {
		super(name,role);
		
		/** main screen buttons and labels  **/
		
		
		btnLogout.setBounds(10, 11, 89, 16);
		
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
		btnMailBox.setBounds(629, 330, 126, 23);
		btnMailBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reviewController.openMailScreen();
				
			}
		});
		add(btnMailBox);
		
		
/**
		JButton btnUserManagement = new JButton("User details management");
		btnUserManagement.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUserManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				userController.userSearch();
					
			}
		});
		btnUserManagement.setBounds(48, 344, 228, 27);
		add(btnUserManagement);
		
		/** adding a user icon**//**
		JLabel userPic = new JLabel("");
		userPic.setIcon(new ImageIcon(LWorkerGUI.class.getResource("/boundry/User-Group-icon.png")));
		userPic.setHorizontalAlignment(SwingConstants.CENTER);
		userPic.setBounds(77, 160, 163, 153);
		add(userPic);
		
				**/
		
		
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