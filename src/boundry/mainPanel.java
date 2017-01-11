package boundry;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.userController;

public class mainPanel extends JPanel {
	
	public  JLabel img;
	public static String hello;
	public static String role;
	JButton btnCheckBookReviews;

	public static JButton btnLogout = new JButton("Logout");
	
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


}
