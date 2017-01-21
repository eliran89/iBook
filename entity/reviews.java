package entity;

import java.util.Collection;

public class reviews {

	Collection<reader> publish;
	private int reviewID;
	private String BookName;
	private String title;
	private String readerName;
	private int visible;
	private String text;
	
	
	
	/**Full Constractor*/
	public reviews(String BookName,int reviewID,String title,String readerName,int visible,String text)
	{
		this.reviewID = reviewID;
		this.BookName = BookName;
		this.title = title;
		this.readerName = readerName;
		this.visible = visible;
		this.text = text;
	}
	/** END Full Constractor*/
	
	
	
	/**Empty Constractor*/
	public reviews()
	{
		reviewID = 0;
		BookName = null;
		title = null;
		readerName = null;
		visible = 0;
		this.text = null;
	}
	/** END Empty Constractor*/

	
	
	/** getters*/
	public int getID(){return this.reviewID;}
	public String getBookName(){return this.BookName;}
	public String getTitle(){return this.title;}
	public String getReadName(){return this.readerName;}
	public String getText(){return this.text;}
	public int isVisible(){return this.visible;}
	/** END getters*/
	
	
	
	/**setters*/
	public void setID(int reviewID){this.reviewID = reviewID;}
	public void setBookName(String BookID){this.BookName = BookName;}
	public void setTitle(String title){this.title = title;}
	public void setReaderName(String readerName){this.readerName = readerName;}
	public void setText(String text){this.text = text;}
	public void setVisible(int visible){this.visible = visible;}
	/** END setters*/



}