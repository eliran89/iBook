package entity;

import boundry.UserSearchGUI;
import controller.loginController;
/**
 * Contains all relevant getters and setters for an interested reader
 * @author Eliran
 */
public class interestedReader extends User {

	private int userID;
	private String firstName;
	private String lastName;
	/**
	 * interestedReader - constructor
	 * @param userID int
	 * @param firstName String
	 * @param lastName String
	 */
	public interestedReader(int userID, String firstName , String lastName)
	{
		this.setUserID(userID);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	public interestedReader(){
		this.userID = -1;
		this.firstName = null;
		this.lastName = null;
	}
	
	/** getters*/
	public int getUserID(){return userID;}
	public String getFirstName(){return firstName;}
	public String getLastName(){return lastName;}
	/**getters END*/
	
	/**setters*/
	public void setUserID(int iD){
		if ((iD <= 10000) || (iD > 99999)){
			UserSearchGUI.errorBox("Please enter a legal ID (greater than 11111 and lower than 99999)","Validate User ID");
			return;
		}
		this.userID = iD;
	}
	
	public void setFirstName(String firstName){
		if ((firstName.matches(".*\\d.*"))||firstName.contains(" ")){
			UserSearchGUI.errorBox("Please enter a legal first name\nNo digits or spaces allowed!","Validate First Name");
			return;
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName){
		if ((lastName.matches(".*\\d.*"))||lastName.contains(" ")){
			UserSearchGUI.errorBox("Please enter a legal last name\nNo digits or spaces allowed!","Validate Last Name");
			return;
		}	
		this.lastName = lastName;
	}
	/**setters END*/
}