package entity;

import boundry.UserSearchGUI;

public class User {
	private String username;
	private String password;
	private int privilege;
	public User(String usernam,String password,int privilege)
	{
		super();
		this.username=username;
		this.password=password;
		this.privilege=privilege;
	}
	public User(String username,String password)
	{
		super();
		this.username= username;
		this.password= password;
		this.privilege=0;
	}
	public User()
	{
		super();
		this.username=null;
		this.password=null;
		this.privilege=0;
	}
	public String getUsername(){return this.username;}
	public String getpassword(){return this.password;}
	public int getprivilege(){return this.privilege;}
	
	public void setUsername(String username){
		if (username.contains(" ")){
			UserSearchGUI.errorBox("Please enter a legal user name\nNo spaces allowed!","Validate User Name");
			return;
		}
		
		this.username=username;
	}
	
	public void setPassword(String password){
		if (password.contains(" ")){
			UserSearchGUI.errorBox("Please enter a legal password\nNo spaces allowed!","Validate User Password");
			return;
		}
		this.password=password;
	}
	
	public void setprivilege(int privilege){this.privilege=privilege;}
}
