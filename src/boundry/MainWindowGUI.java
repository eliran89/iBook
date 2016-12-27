package boundry;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import controller.loginController;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class MainWindowGUI extends JFrame{
	private JLabel img;
	public String hello;
	public String uname;
	public MainWindowGUI(String role , String name) {
		super();
		this.hello = name;
		this.uname = role;
		setBackground(new Color(0, 0, 255));
		//setExtendedState( getExtendedState()|JFrame.MAXIMIZED_BOTH );
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginGUI.class.getResource("/boundry/ElecBook1.jpg")));
		setTitle("IBook Main Window");
		getLPanel();
	}
	public void getLPanel()	
	{
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("AR CENA", Font.BOLD, 13));
		btnLogout.setBackground(Color.RED);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LoginGUI.err = false;
				loginController.logout();
			}
		});
		btnLogout.setBounds(26, 11, 73, 16);
		panel.add(btnLogout);
		
		img = new JLabel(new ImageIcon(LoginGUI.class.getResource("/boundry/ElecBook2.jpg")));
		img.setBounds(10, 630, 965, 248);
		panel.add(img);
		
		JLabel hello = new JLabel("Hello "+ this.hello);
		hello.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		hello.setForeground(Color.GREEN);
		hello.setBounds(810, 9, 145, 17);
		panel.add(hello);
		
		JLabel name = new JLabel(uname);
		name.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		name.setForeground(Color.GREEN);
		name.setBounds(109, 9, 145, 17);
		panel.add(name);
	}
	
}
