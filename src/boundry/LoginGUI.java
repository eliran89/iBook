package boundry;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.Window.Type;

//import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import controller.loginController;

public class LoginGUI extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel img;
	private JTextField textField_1;
	static public Boolean err=false;
	private JPasswordField passwordField_1;
	public LoginGUI() {
		super();
		setBackground(new Color(0, 0, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginGUI.class.getResource("/boundry/ElecBook1.jpg")));
		setTitle("IBook Login");
		getLPanel();
	}
	public void getLPanel()	
	{
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		getContentPane().add(panel);
		panel.setLayout(null);
		img = new JLabel(new ImageIcon(LoginGUI.class.getResource("/boundry/ElecBook1.jpg")));
		img.setBounds(0, 109, 531, 172);
		panel.add(img);
		
		Label label = new Label("Username :");
		label.setFont(new Font("Bodoni MT Black", Font.BOLD | Font.ITALIC, 14));
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(10, 20, 89, 19);
		panel.add(label);
		
		Label label_1 = new Label("Password :");
		label_1.setFont(new Font("Bodoni MT Black", Font.BOLD | Font.ITALIC, 14));
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setBounds(10, 58, 94, 19);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(105, 19, 112, 20);
		panel.add(textField_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(105, 58, 112, 19);
		panel.add(passwordField_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username;
				String password;
				username = textField_1.getText();
				password = passwordField_1.getText();
				dispose();
				try {
					loginController.login(username, password);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Cooper Black", Font.BOLD, 30));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(253, 20, 137, 46);
		panel.add(btnNewButton);
		
	
		if(err)
		{
			JLabel lblIncorrectDetailsPlease = new JLabel("incorrect details please try again");
			lblIncorrectDetailsPlease.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblIncorrectDetailsPlease.setForeground(new Color(255, 0, 0));
			lblIncorrectDetailsPlease.setBounds(37, 84, 211, 14);
			panel.add(lblIncorrectDetailsPlease);
		}
		
	}
		
	}

