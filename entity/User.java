package entity;

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
	public void setUsername(String username){this.username=username;}
	public void setPassword(String password){this.password=password;}
	public void setprivilege(int privilege){this.privilege=privilege;}
}
