package entity;

import boundry.UserSearchGUI;
import controller.loginController;

public class interestedReader extends User {

	private int userID;
	private String firstName;
	private String lastName;
	
/*	public void backToUserSearch()
	{
		UserSearchGUI panelInException;
		if(loginController.use.getprivilege() == 4)
			panelInException = new UserSearchGUI(loginController.use.getUsername(),"Library Worker");
		else
			panelInException = new UserSearchGUI(loginController.use.getUsername(),"Librarian");
		loginController.mainG.setContentPane(panelInException);
		loginController.mainG.revalidate();
	}*/
	
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
	public void setUserID(int userID){
		if ((userID < 11111) || (userID > 99999)){
			UserSearchGUI.errorBox("Please enter a legal ID (greater than 11111 and lower than 99999)","Validate User ID");
		//	backToUserSearch();
			return;
		}
		this.userID = userID;
	}
	
	public void setFirstName(String firstName){
		if ((firstName.matches(".*\\d.*"))||firstName.contains(" ")){
			UserSearchGUI.errorBox("Please enter a legal first name\nNo digits or spaces allowed!","Validate First Name");
		//	backToUserSearch();
			return;
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName){
		if ((lastName.matches(".*\\d.*"))||lastName.contains(" ")){
			UserSearchGUI.errorBox("Please enter a legal last name\nNo digits or spaces allowed!","Validate Last Name");
		//	backToUserSearch();
			return;
		}	
		this.lastName = lastName;
	}
	/**setters END*/
	
	public void destroy() {
		// TODO - implement interestedReader.destroy
		throw new UnsupportedOperationException();
	}

	public void create() {
		// TODO - implement interestedReader.create
		throw new UnsupportedOperationException();
	}

}