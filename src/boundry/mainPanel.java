package boundry;

import java.awt.Color;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;
import java.util.Calendar;



import controller.loginController;
import controller.userController;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
/**
 * this class is an abstract class that Layout the basic design for every panel 
 * in the project , it contains the basic components for all the panel (a logout button ,image.....)
 * every other panel extends this panel
 * @author GuyCohen, Nimrod mendel , Eliran Ifrah, Zachi Mayer
 *
 */
public abstract class  mainPanel extends JPanel {
	
	public  JLabel img;
	public static String hello;
	public static String role;
	JButton btnCheckBookReviews;

	public JButton btnLogout = new JButton("Logout");
	/**
	 * this is a constructor that displays the basic components for all the project(a logout button ,image.....)
	 * it gets the username and the type of the user(privilege level) and displays them in labels on the window
	 * @param name the usename
	 * @param role type of user(privilege level)
	 */
	public mainPanel( String name , String role){
		super();
		this.hello = name;
		this.role = role;
		
		setBackground(Color.WHITE);
		setLayout(null);
		btnCheckBookReviews = null;
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("AR CENA", Font.BOLD, 13));
		btnLogout.setBackground(Color.RED);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userController.logout();
			}
		});
		btnLogout.setBounds(26, 11, 83, 16);
		add(btnLogout);
		
		img = new JLabel(new ImageIcon(LoginGUI.class.getResource("/boundry/ElecBook2.jpg")));
		img.setBounds(10, 630, 965, 248);
		add(img);
		
		JLabel hello = new JLabel("Hello "+ this.hello);
		hello.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		hello.setForeground(Color.BLACK);
		hello.setBounds(810, 9, 145, 17);
		add(hello);
		
		JLabel wname = new JLabel(role);
		wname.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		wname.setForeground(Color.BLACK);
		wname.setBounds(124, 9, 145, 17);
		add(wname);
		
		

	}
	
   	public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null,infoMessage,titleBar,JOptionPane.INFORMATION_MESSAGE);
    }
   	
	public static void warningBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null,infoMessage,titleBar,JOptionPane.WARNING_MESSAGE);
    }
	
	public static void errorBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null,infoMessage,titleBar,JOptionPane.ERROR_MESSAGE);
    }
	
	public static int confirmBox(String infoMessage){
		return JOptionPane.showConfirmDialog (null, infoMessage);
	}
	
	  //JDialog.setDefaultLookAndFeelDecorated(true);
	public static boolean yesNoBox(String msg, String lbl){
	int response = JOptionPane.showConfirmDialog(null, msg, lbl, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

	    if (response == JOptionPane.YES_OPTION){
	      //System.out.println(yesMessage);	   
	      return true;
	    }
	    return false;
	}
}
