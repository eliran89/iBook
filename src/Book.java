
import java.util.Collection;

public class Book {

	Collection<bAuthor> bAuthor;
	Collection<bScope> bScope;
	Collection<bKey> bKey;
	Collection<bSubject> bSubject;
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

	public void setInfo() {
		// TODO - implement Book.setInfo
		throw new UnsupportedOperationException();
	}

	public void lock() {
		// TODO - implement Book.lock
		throw new UnsupportedOperationException();
	}

}