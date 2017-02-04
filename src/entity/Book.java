package entity;


import java.util.ArrayList;
import java.util.Collection;

public class Book {

	public ArrayList<String> authors;
	public ArrayList<String> Scope;
	public ArrayList<String> Key;
	public ArrayList<String> Subject;
	public String BookId;
	public String Title;
	public String Language;
	public String Brief;
	public String Appendix;
	private int numberOfSearches;
	public int numOfOrders;
	private int absoluteRank;
	public float cost;
	public boolean suspended;
	public String pdfLocation;
	public String docxLocation;
	public String fb2Location;
	
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
	 * getPdf
	 * @return pdf Location
	 */
	public String getPdf(){return pdfLocation;}
	/**
	 * getDocx
	 * @return docx Location
	 */
	public String getDocx(){return docxLocation;}
	/**
	 * getFb2
	 * @return fb2 Location
	 */
	public String getFb2(){return fb2Location;}
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
	 * @param s ArrayList<String>
	 */
	public void setSubject(ArrayList<String> subject){
		this.Subject = subject;
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
	

	/**
	 * setPdf
	 * @param pdfLocation
	 */
	public void setPdf(String pdfLocation){
		this.pdfLocation = pdfLocation;
	}
	/**
	 * setDocx
	 * @param docxLocation
	 */
	public void setDocx(String docxLocation){
		this.docxLocation = docxLocation;
	}
	/**
	 * setFb2
	 * @param fb2Location
	 */
	public void setFb2(String fb2Location){
		this.fb2Location = fb2Location;
	}
	/**
	 * isSuspended return true if the book is Suspended else false
	 * @return suspended - the book status
	 */
	public boolean isSuspended() {
	return suspended;
	}

	/**
	 * isBookComplete - return true if all the required fields are filled else false
	 * @return boolean
	 */
	public boolean isBookComplete() {
		boolean bool = true;
		if(this.Appendix == null ||this.Scope == null || this.Subject == null||this.authors == null||this.Brief == null || this.cost < 0
				|| this.Key == null ||this.Title == null||this.Language == null || this.Appendix.equals("") || this.Brief.equals("") || this.Title.equals("") ||this.Language.equals("")
				|| this.Scope.size() == 0 || this.Subject.size() == 0 || this.authors.size() == 0 || this.Key.size() == 0)
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
	/**
	 * lock - change suspend to true
	 */
	public void lock() {
		suspended =true;
	}
	/**
	 * unlock - change suspend to false
	 */
	public void unlock() {
		suspended = false;
	}

}