package boundry;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import controller.DBController;
import controller.bookController;
import controller.loginController;
import controller.userController;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class readerGUI extends InterestedReaderGUI {
	
	/**
	 * readerGUI - GUI class.<br>
	 * The class creates the Graphical user interface for a reader.<br>
	 * Extends "InterestedReaderGUI".<br>
	 * Uses parameters:<br>
	 * @param name - String: username
	 * @param role - String: privilege level
	 * 
	 * @author Nimrod Mendel
	 */
	
	public readerGUI( String name , String role) {
		super(name,role);
		
		
		setForeground(Color.WHITE);
		img.setBounds(10, 521, 964, 357);
		
		
		
		/** write a review button **/
		JButton btnNewButton = new JButton("Write a new review");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = loginController.use.getUsername();
				bookController.displayMakeAReview(username);
			}
		});
		btnNewButton.setBounds(644, 320, 185, 47);
		add(btnNewButton);
		
		/**Write a review Icon**/
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(readerGUI.class.getResource("/boundry/write-ballpoint-ballpen-icon.png")));
		lblNewLabel.setBounds(666, 184, 128, 100);
		add(lblNewLabel);
		
		/**View orders icon**/
		JButton btnViewOrders = new JButton("View orders");
		btnViewOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = loginController.use.getUsername();
				bookController.displayUserOrders(user);
			}
		});
		btnViewOrders.setBounds(417, 447, 120, 23);
		add(btnViewOrders);
		
	
	}
	
	
	
	/**
	 * displayUserOrders - method.
	 * Sends a query to the database asking for all the orders of a reader
	 * @param username - String
	 */
	
	public static void displayUserOrders(int userId){
		
		ArrayList<String> info;
		info =  DBController.getFromDB("SELECT  b.Title   , ro.date	FROM readerorder ro , reader r , book b "
				+"WHERE ro.userID="+userId+" and ro.bookID=b.bookID and ro.userID=r.userID ");	
	}
	/** No orders results**/
	
	
	
	
}