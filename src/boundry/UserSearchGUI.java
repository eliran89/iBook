package boundry;

import controller.loginController;
import controller.userController;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class UserSearchGUI extends mainPanel{
	private JTextField textField;
	
	public UserSearchGUI(String name , String role)
	{
		super(name,role);
		setForeground(Color.WHITE);
		

		JButton btnMainWindow = new JButton("Main Window");
		btnMainWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userController.GoToMainWindow();
			}
		});
		btnMainWindow.setFont(new Font("AR CENA", Font.BOLD, 14));
		btnMainWindow.setBackground(Color.GREEN);
		btnMainWindow.setForeground(Color.WHITE);
		btnMainWindow.setBounds(26, 38, 122, 23);
		add(btnMainWindow);
		
		
		JLabel lblSearchBy = new JLabel("Search By :");
		lblSearchBy.setFont(new Font("AR CENA", Font.BOLD, 18));
		lblSearchBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchBy.setForeground(Color.WHITE);
		lblSearchBy.setBackground(Color.BLACK);
		lblSearchBy.setBounds(142, 158, 107, 66);
		add(lblSearchBy);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.addItem("Username");
		comboBox.addItem("UserID");
		comboBox.setBounds(269, 182, 93, 22);
		add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(391, 182, 116, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = (String) comboBox.getSelectedItem();
				String search = (String) textField.getText();
				userController.getUserDetails(item, search);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.setBounds(540, 181, 107, 23);
		add(btnSearch);
		
			
	}
}
