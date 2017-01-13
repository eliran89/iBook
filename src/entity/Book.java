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
	
	/**
	 * 
	 */
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
	 * getAuthors
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getAuthors(){return authors;}
	/**
	 * getScope
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getScope(){return Scope;}
	/**
	 * getKey
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getKey(){return Key;}
	/**
	 * getSubject
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getSubject(){return Subject;}
	
	/**
	 * getBookID
	 * @return String
	 */
	public String getBookID(){return BookId;}
	/**
	 * getTitle
	 * @return String
	 */
	public String getTitle(){return Title;}
	/**
	 * getLanguage
	 * @return String
	 */
	public String getLanguage(){return Language;}
	/**
	 * getBrief
	 * @return String
	 */
	public String getBrief(){return Brief;}
	/**
	 * getAppendix
	 * @return String
	 */
	public String getAppendix(){return Appendix;}
	/**
	 * getCost
	 * @return float
	 */
	public float getCost(){return cost;}
	/**
	 * setAuthors
	 * @param authors ArrayList<String>
	 */
	public void setAuthors(ArrayList<String> authors){
		this.authors = authors;
	}
	/**
	 * setScope
	 * @param Scope ArrayList<String>
	 */
	public void setScope(ArrayList<String> Scope){
		this.Scope = Scope;
	}
	/**
	 * setKey
	 * @param Key ArrayList<String>
	 */
	public void setKey(ArrayList<String> Key){
		this.Key = Key;
	}
	/**
	 * setSubject
	 * @param Subject ArrayList<String>
	 */
	public void setSubject(ArrayList<String> Subject){
		this.Subject = Subject;
	}
	/**
	 * setBookId
	 * @param BookId String
	 */
	public void setBookId(String BookId){
		this.BookId = BookId;
	}
	/**
	 * setTitle
	 * @param Title String
	 */
	public void setTitle(String Title){
		this.Title = Title;
	}
	/**
	 *  setLanguage
	 * @param Language String
	 */
	public void setLanguage(String Language){
		this.Language = Language;
	}
	/**
	 * setBrief
	 * @param Brief String
	 */
	public void setBrief(String Brief){
		this.Brief = Brief;
	}
	/**
	 * setAppendix
	 * @param Appendix String
	 */
	public void setAppendix(String Appendix){
		this.Appendix = Appendix;
	}
	/**
	 * setCost
	 * @param cost float
	 */
	public void setCost(float cost){
		this.cost = cost;
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

	public boolean isBookComplete() {
		boolean bool = true;
		if(this.Appendix == null ||this.Scope == null || this.Subject == null||this.authors == null||this.Brief == null||this.cost == 0
				|| this.Key == null ||this.Title == null||this.Language == null)
			bool = false;
		return bool;
		
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