package entity;

public class interestedReader extends User {

	private int userID;
	private String firstName;
	private String lastName;
	
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
	public void setUserID(int userID){this.userID = userID;}
	public void setFirstName(String firstName){this.firstName = firstName;}
	public void setLastName(String lastName){this.lastName = lastName;}
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