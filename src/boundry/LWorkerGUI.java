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
/**
 * this class is responsible for the main window of the library worker
 * it contains all the components related to the library worker's main window 
 * @author Guy Cohen
 *
 */
public class LWorkerGUI extends GWorkerGUI {
	/**
	 * this is the constructor.
	 * it puts the general worke's components and the components that related to library worker
	 * on the panel.
	 * @param name the user name for the mainPanel use
	 * @param role the privilege level for the mainPanel use
	 */
	public LWorkerGUI( String name , String role) {
		super(name,role);
		
		JButton btnUserManagement = new JButton("User details management");
		btnUserManagement.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUserManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				userController.userSearch();
					
			}
		});
		btnUserManagement.setBounds(138, 330, 228, 27);
		add(btnUserManagement);
		
		/** adding a user icon**/
		JLabel userPic = new JLabel("");
		userPic.setIcon(new ImageIcon(LWorkerGUI.class.getResource("/boundry/User-Group-icon.png")));
		userPic.setHorizontalAlignment(SwingConstants.CENTER);
		userPic.setBounds(137, 136, 211, 162);
		add(userPic);
	}
}