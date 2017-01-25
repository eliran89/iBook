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
		
		JLabel imgB;
		imgB = new JLabel(new ImageIcon(InterestedReaderGUI.class.getResource("/boundry/booksearch.jpg")));
		imgB.setBounds(171, 422, 211, 105);
		imgB.setBounds(137, 418, 211, 105);
		add(imgB);

	}

	public void addBook() {
		// TODO - implement GWorkerGUI.addBook
		throw new UnsupportedOperationException();
	}

	public void removeBook() {
		// TODO - implement GWorkerGUI.removeBook
		throw new UnsupportedOperationException();
	}

	public void bookSearch() {
		// TODO - implement GWorkerGUI.bookSearch
		throw new UnsupportedOperationException();
	}

	public void InventoryManagement() {
		// TODO - implement GWorkerGUI.InventoryManagement
		throw new UnsupportedOperationException();
	}

}