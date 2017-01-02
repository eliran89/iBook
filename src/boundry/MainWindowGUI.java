package boundry;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.*;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindowGUI extends JFrame{
	public static JLabel img;
	
	public MainWindowGUI(mainPanel panel) {
		super();
		
		setBackground(new Color(0, 0, 255));
		//setExtendedState( getExtendedState()|JFrame.MAXIMIZED_BOTH );
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginGUI.class.getResource("/boundry/ElecBook1.jpg")));
		setTitle("IBook Main Window");
		getContentPane().add(panel);
		//pack();
		
		
		/**Logout Listener*/
		panel.btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LoginGUI.err = false;
				userController.logout();
			}
		});
		/**END Logout Listener*/
		
		
		/**Reviews Listener*/
	
		//if(panel.btnCheckBookReviews != null)

		/**END Reviews Listener*/
		
		
	}
	
	
}
