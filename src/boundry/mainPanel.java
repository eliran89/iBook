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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import controller.loginController;
import controller.userController;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

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
		
		
		///////////////////to erase!!!//////
		
/*
		*//**Frame label *//*
		JLabel lblAddingANew = new JLabel("Edit User Details");
		lblAddingANew.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddingANew.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAddingANew.setBounds(274, 72, 331, 27);
		add(lblAddingANew);
		
		*//**ID label and textField *//*
		JLabel lblTitle = new JLabel("ID");
		lblTitle.setToolTipText("ID field cannot be edited");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setBounds(274, 152, 51, 20);
		add(lblTitle);
		
		JTextField textId = new JTextField();
		textId.setBounds(388, 154, 124, 20);
		textId.setColumns(10);
		textId.setEditable(false);
		add(textId);
		
		*//**first name label and textField *//*
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setToolTipText("Enter new account first name");
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setForeground(Color.BLACK);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(274, 202, 104, 20);
		add(lblFirstName);
		
		JTextField textFname = new JTextField();
		textFname.setColumns(10);
		textFname.setBounds(388, 204, 124, 20);
		textFname.setEditable(true);
		add(textFname);
		
		*//**last name label and textField *//*
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setToolTipText("Enter new account last name");
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setForeground(Color.BLACK);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(274, 250, 104, 20);
		add(lblLastName);
		
		JTextField textLname = new JTextField();
		textLname.setColumns(10);
		textLname.setBounds(388, 252, 124, 20);
		textLname.setEditable(true);
		add(textLname);
		
		*//**user name label and textField *//*
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setToolTipText("Username field cannot be edited");
		lblUserName.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserName.setForeground(Color.BLACK);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(274, 297, 104, 20);
		add(lblUserName);
		
		JTextField textUname = new JTextField();
		textUname.setColumns(10);
		textUname.setBounds(388, 299, 124, 20);
		textUname.setEditable(false);
		add(textUname);
		
		*//**password label and textField *//*
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setToolTipText("Enter 6 chars account password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(274, 344, 104, 20);
		add(lblPassword);
		
		JTextField textPassword = new JTextField("*****");
		textPassword.setColumns(10);
		textPassword.setBounds(388, 346, 124, 20);
		textPassword.setEditable(true);
		add(textPassword);

		
		*//**button Update *//*
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setToolTipText("Click here to update account");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					userController.setUserDetails(Integer.parseInt(textId.getText()),textFname.getText(),textLname.getText(),textUname.getText(),textPassword.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnUpdate.setBounds(516, 441, 89, 23);
		add(btnUpdate);
		
		*//**button Back *//*
		JButton btnBack = new JButton("Back");
		btnBack.setToolTipText("Click here to view all users details");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//userController.userSearch();
				userController.getUserDetails("Username","");
			}
		});
		btnBack.setBounds(274, 441, 89, 23);
		add(btnBack);*/
	}
}
