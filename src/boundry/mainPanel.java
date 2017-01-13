package boundry;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		
/*		
		///////////////////to erase!!!//////
		
		*//**Create The Result Table*//*
		JTable table = new JTable();	

		
		
	//Eliran's temp check//
		table.setForeground(Color.BLUE);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBounds(79, 230, 687, 325);
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setPreferredScrollableViewportSize(new Dimension(17,325));
		
		add(table);
		
		JLabel lblUserID = DefaultComponentFactory.getInstance().createTitle("User ID");
		lblUserID.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserID.setForeground(Color.WHITE);
		lblUserID.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserID.setBounds(67, 198, 107, 32);
		add(lblUserID);
		
		*//***//*
		JLabel lblFirstName = DefaultComponentFactory.getInstance().createLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setBounds(205, 198, 107, 32);
		add(lblFirstName);
		
		*//***//*
		JLabel lblLastName = DefaultComponentFactory.getInstance().createLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setBounds(342, 200, 107, 29);
		add(lblLastName);
		
		JLabel lblPrivilegeLevel = new JLabel("Privilege Level");
		lblPrivilegeLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrivilegeLevel.setForeground(Color.WHITE);
		lblPrivilegeLevel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrivilegeLevel.setBounds(633, 202, 87, 24);
		add(lblPrivilegeLevel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(480, 202, 87, 24);
		add(lblUsername);
		*//***//*
		
		
		
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(79, 596, 89, 23);
		add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEdit.setBounds(246, 596, 89, 23);
		add(btnEdit);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemove.setBounds(410, 596, 89, 23);
		add(btnRemove);
		
		JButton btnPymnt = new JButton("Set Payment Arrangement");
		btnPymnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPymnt.setBounds(581, 596, 185, 23);
		add(btnPymnt);
		
		*/
		
	//	if(loginController.use.getprivilege() == 4)
//			panelAdd = new UserSearchGUI(loginController.use.getUsername(),"Library Worker");
//		else
//			panelAdd = new UserSearchGUI(loginController.use.getUsername(),"Librarian");
		
/*		JLabel lblAddingANew = new JLabel("Adding a New Intereseted Reader");
		lblAddingANew.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddingANew.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAddingANew.setBounds(274, 72, 331, 27);
		add(lblAddingANew);
		
		JLabel lblTitle = new JLabel("ID");
		lblTitle.setToolTipText("Enter new account ID");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setBounds(274, 152, 51, 20);
		add(lblTitle);
		
		JTextField textTitle = new JTextField();
		textTitle.setBounds(388, 154, 124, 20);
		add(textTitle);
		textTitle.setColumns(10);
		
		JTextField textLangu = new JTextField();
		textLangu.setColumns(10);
		textLangu.setBounds(388, 299, 124, 20);
		add(textLangu);
		
		JTextField textAuthor = new JTextField();
		textAuthor.setColumns(10);
		textAuthor.setBounds(388, 204, 124, 20);
		add(textAuthor);
		
		JTextField textAppendix = new JTextField();
		textAppendix.setColumns(10);
		textAppendix.setBounds(388, 346, 124, 20);
		add(textAppendix);
		
		JTextField textBrief = new JTextField();
		textBrief.setColumns(10);
		textBrief.setBounds(388, 252, 124, 20);
		add(textBrief);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setToolTipText("Enter new account first name");
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setForeground(Color.BLACK);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(274, 202, 104, 20);
		add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setToolTipText("Enter new account last name");
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setForeground(Color.BLACK);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(274, 250, 104, 20);
		add(lblLastName);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setToolTipText("Enter unique account username");
		lblUserName.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserName.setForeground(Color.BLACK);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(274, 297, 104, 20);
		add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setToolTipText("Enter 6 chars account password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(274, 344, 104, 20);
		add(lblPassword);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnAdd.setBounds(516, 441, 89, 23);
		add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnBack.setBounds(274, 441, 89, 23);
		add(btnBack);*/
		
	
		//loginController.mainG.setContentPane(panelAdd);
		//loginController.mainG.revalidate();
		
		
		
		//till here//////////////////////
		

		
	}
}
