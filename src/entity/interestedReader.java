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
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
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
			//TODO add a pop up message
			System.out.println("Please enter a legal ID (greater than 11111 and lower than 99999)");
		//	backToUserSearch();
			return;
		}
		this.userID = userID;
	}
	
	public void setFirstName(String firstName){
		if (firstName.matches(".*\\d.*")){
			//TODO add a pop up message
			System.out.println("Please enter a legal first name");
		//	backToUserSearch();
			return;
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName){
		if (lastName.matches(".*\\d.*")){
			//TODO add a pop up message
			System.out.println("Please enter a legal last name");
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