package boundry;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import controller.bookController;
import controller.loginController;
import controller.userController;
/**
 * 
 * @author Guy Cohen
 *this class is an abstract class that responsible for the window that related to both manager and library worker
 *it contains the components that they both allowed to access 
 */
public abstract class GWorkerGUI extends editorGUI {
	public GWorkerGUI( String name , String role) {
		super(name,role);
		
		
		JButton btnUserManagement = new JButton("User details management");
		btnUserManagement.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUserManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				userController.userSearch();
					
			}
		});
		
		JButton btnBookSearch = new JButton("Book Management");
		btnBookSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBookSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookController.searchBook();
			}
		});

		btnBookSearch.setBounds(138, 552,228, 27);
		add(btnBookSearch);
		/**this label display an image of the book search*/
		JLabel imgB;
		imgB = new JLabel(new ImageIcon(InterestedReaderGUI.class.getResource("/boundry/booksearch.jpg")));
		imgB.setBounds(171, 422, 211, 105);
		imgB.setBounds(137, 418, 211, 105);
		add(imgB);

	}



}