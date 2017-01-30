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
/**
 * this class is the main frame that every panel goes into
 * @author GuyCohen, Nimrod mendel , Eliran Ifrach, Zachi Meyer
 */
public class MainWindowGUI extends JFrame{
	public static JLabel img;
	/**
	 * this is the constructor that gets the first panel(the rest of panels replaces them)
	 * @param panel the first panel that opens
	 */
	public MainWindowGUI(mainPanel panel) {
		super();
		
		setBackground(new Color(0, 0, 255));
		//setExtendedState( getExtendedState()|JFrame.MAXIMIZED_BOTH );
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginGUI.class.getResource("/boundry/ElecBook1.jpg")));
		setTitle("IBook Main Window");
		getContentPane().add(panel);
		//pack();
		
		
		/**Logout Listener*/
		
		/**END Logout Listener*/
		
		
		/**Reviews Listener*/
	
		//if(panel.btnCheckBookReviews != null)

		/**END Reviews Listener*/
		
		
	}
	
	
}
