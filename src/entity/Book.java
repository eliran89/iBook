package entity;


import java.util.ArrayList;
import java.util.Collection;

public class Book {

	private ArrayList<String> authors;
	private ArrayList<String> Scope;
	private ArrayList<String> Key;
	private ArrayList<String> Subject;
	private String BookId;
	private String Title;
	private String Language;
	private String Brief;
	private String Appendix;
	private int numberOfSearches;
	private int numOfOrders;
	private int absoluteRank;
	private float cost;
	private boolean suspended;
	
	
	public Book(){
		authors = null;
		Scope = null;
		Key = null;
		Subject = null;
		BookId = null;
		Title = null;
		Language = null;
		Brief = null;
		Appendix = null;
		numberOfSearches = 0;
		numOfOrders = 0;
		absoluteRank = 0;
		cost = 0;
		suspended = false;
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getAuthors(){return authors;}
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getScope(){return Scope;}
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getKey(){return Key;}
	
	public ArrayList<String> getSubject(){return Subject;}
	
	/**
	 * 
	 * @return
	 */
	public String getBookID(){return BookId;}
	/**
	 * 
	 * @return
	 */
	public String getTitle(){return Title;}
	/**
	 * 
	 * @return
	 */
	public String getLanguage(){return Language;}
	/**
	 * 
	 * @return
	 */
	public String getBrief(){return Brief;}
	/**
	 * 
	 * @return
	 */
	public String getAppendix(){return Appendix;}
	/**
	 * 
	 * @return
	 */
	public float getCost(){return cost;}
	/**
	 * 
	 * @param authors
	 */
	public void setAuthors(ArrayList<String> authors){
		this.authors = authors;
	}
	/**
	 * 
	 * @param Scope
	 */
	public void setScope(ArrayList<String> Scope){
		this.Scope = Scope;
	}
	
	public void setKey(ArrayList<String> Key){
		this.Key = Key;
	}
	/**
	 * 
	 * @param Subject
	 */
	public void setSubject(ArrayList<String> Subject){
		this.Subject = Subject;
	}
	/**
	 * 
	 * @param BookId
	 */
	public void setBookId(String BookId){
		this.BookId = BookId;
	}
	/**
	 * 
	 * @param Title
	 */
	public void setTitle(String Title){
		this.Title = Title;
	}
	/**
	 * 
	 * @param Language
	 */
	public void setLanguage(String Language){
		this.Language = Language;
	}
	/**
	 * 
	 * @param Brief
	 */
	public void setBrief(String Brief){
		this.Brief = Brief;
	}
	
	public void setAppendix(String Appendix){
		this.Appendix = Appendix;
	}
	
	
	
	
	public int getNumberOfSearches() {
		return this.numberOfSearches;
	}

	public int getNumberOfOrders() {
		// TODO - implement Book.getNumberOfOrders
		throw new UnsupportedOperationException();
	}

	public int getAbsRank() {
		// TODO - implement Book.getAbsRank
		throw new UnsupportedOperationException();
	}

	public void isSuspended() {
		// TODO - implement Book.isSuspended
		throw new UnsupportedOperationException();
	}

	public void destroy() {
		// TODO - implement Book.destroy
		throw new UnsupportedOperationException();
	}

	public void create() {
		// TODO - implement Book.create
		throw new UnsupportedOperationException();
	}

	public void addToOrders() {
		// TODO - implement Book.addToOrders
		throw new UnsupportedOperationException();
	}

	public void addTosearches() {
		// TODO - implement Book.addTosearches
		throw new UnsupportedOperationException();
	}

	public void lock() {
		// TODO - implement Book.lock
		throw new UnsupportedOperationException();
	}

}