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

public abstract class  mainPanel extends JPanel {
	
	public  JLabel img;
	public static String hello;
	public static String role;
	JButton btnCheckBookReviews;

	public JButton btnLogout = new JButton("Logout");
	
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
		
		
		///////////////////to erase!!!//////
		
/*		*//**Frame label *//*
		JLabel lblSetPayment = new JLabel("Set a New Payment Arrangement");
		lblSetPayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetPayment.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSetPayment.setBounds(274, 72, 331, 27);
		add(lblSetPayment);
		
		*//**ID label and textField *//*
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblID.setHorizontalAlignment(SwingConstants.LEFT);
		lblID.setForeground(Color.BLACK);
		lblID.setBounds(274, 152, 51, 20);
		add(lblID);
		
		JTextField textId = new JTextField("id");
		textId.setBounds(481, 152, 124, 20);
		textId.setColumns(10);
		textId.setEditable(false);
		add(textId);
		
		*//**user name label and textField *//*
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserName.setForeground(Color.BLACK);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(274, 201, 104, 20);
		add(lblUserName);
		
		JTextField textUname = new JTextField("uName");
		textUname.setColumns(10);
		textUname.setBounds(481, 201, 124, 20);
		textUname.setEditable(false);
		add(textUname);
		
		*//**credit card label and textField *//*
		JLabel lblCreditNum = new JLabel("Credit Card");
		lblCreditNum.setToolTipText("8-digits credit card number");
		lblCreditNum.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreditNum.setForeground(Color.BLACK);
		lblCreditNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCreditNum.setBounds(274, 250, 197, 20);
		add(lblCreditNum);
		
		JTextField textCreditNum = new JTextField("Credit_Card_Number");
		textCreditNum.setColumns(10);
		textCreditNum.setBounds(481, 250, 124, 20);
		textCreditNum.setEditable(true);
		add(textCreditNum);
		
		*//**Valid to label and textField *//*
		JLabel lblExpDate = new JLabel("Valid To");
		lblExpDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblExpDate.setForeground(Color.BLACK);
		lblExpDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExpDate.setBounds(274, 297, 197, 20);
		add(lblExpDate);
		
		JTextField textExpMonth = new JTextField("mm");
		textExpMonth.setHorizontalAlignment(SwingConstants.CENTER);
		textExpMonth.setColumns(10);
		textExpMonth.setBounds(481, 297, 27, 20);
		textExpMonth.setEditable(true);
		add(textExpMonth);
		
		JLabel slash = new JLabel("/");
		slash.setHorizontalAlignment(SwingConstants.LEFT);
		slash.setForeground(Color.BLACK);
		slash.setFont(new Font("Tahoma", Font.PLAIN, 14));
		slash.setBounds(509, 297, 11, 20);
		add(slash);
		
		JTextField textExpYear = new JTextField("yyyy");
		textExpYear.setHorizontalAlignment(SwingConstants.CENTER);
		textExpYear.setEditable(true);
		textExpYear.setColumns(10);
		textExpYear.setBounds(517, 297, 35, 20);
		add(textExpYear);
		
		*//**CVV label and textField *//*
		JLabel lblCVV = new JLabel("CVV");
		lblCVV.setToolTipText("3-digits number at the back of credit card");
		lblCVV.setHorizontalAlignment(SwingConstants.LEFT);
		lblCVV.setForeground(Color.BLACK);
		lblCVV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCVV.setBounds(274, 344, 104, 20);
		add(lblCVV);
		
		JTextField textCVV = new JTextField();
		textCVV.setHorizontalAlignment(SwingConstants.CENTER);
		textCVV.setColumns(10);
		textCVV.setBounds(481, 344, 27, 20);
		textCVV.setEditable(true);
		add(textCVV);
		
		*//**number of periods arrangement label and textField *//*
		JLabel lblNumberOfPeriod = new JLabel("Number of Years/Months");
		lblNumberOfPeriod.setToolTipText("up to 2 digits number is allowed");
		lblNumberOfPeriod.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumberOfPeriod.setForeground(Color.BLACK);
		lblNumberOfPeriod.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumberOfPeriod.setBounds(274, 390, 197, 20);
		add(lblNumberOfPeriod);
		
		JTextField txtNumOfPeriod;
		txtNumOfPeriod = new JTextField();
		txtNumOfPeriod.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumOfPeriod.setEditable(true);
		txtNumOfPeriod.setColumns(10);
		txtNumOfPeriod.setBounds(481, 390, 27, 20);
		add(txtNumOfPeriod);
		
		*//**Years/Months period comboBox *//*
		JComboBox comboBoxYearMonth = new JComboBox();
		comboBoxYearMonth.setBounds(516, 390, 89, 20);
		comboBoxYearMonth.addItem("Months");
		comboBoxYearMonth.addItem("Years");
		add(comboBoxYearMonth);

		
		*//**button Set *//*
		JButton btnSet = new JButton("Set");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String id = new String (textId.getText());
				//String uName = new String (textUname.getText());
				String creditNum = new String (textCreditNum.getText());
				String expMonth = new String (textExpMonth.getText());
				String expYear = new String (textExpYear.getText());
				String cvv = new String (textCVV.getText());
				
				int creditNumInt = Integer.parseInt(creditNum);
				int expMonthInt = Integer.parseInt(expMonth);
				int expYearInt = Integer.parseInt(expYear);
				int cvvInt = Integer.parseInt(cvv);
				
				boolean validate = userController.validateCreditCard(creditNumInt, expMonthInt, expYearInt, cvvInt);
				if (validate)
					userController.setNewPaymentArrangement(ID, uName, creditNum, expDate, cvv, perType, periodNum);
				else
					displaySetPayment(id, fName, lName, uName, priv);
				
				
			}
		});
		btnSet.setToolTipText("Click here to set a new payment arrangement");
		btnSet.setBounds(516, 441, 89, 23);
		add(btnSet);
		
		*//**button Back *//*
		JButton btnBack = new JButton("Back");
		btnBack.setToolTipText("Click here to view all users details");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//userController.userSearch();
				displaySetPayment(id, fName, lName, uName, priv);
			}
		});
		btnBack.setBounds(274, 441, 89, 23);
		add(btnBack);
		*/	

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
}
