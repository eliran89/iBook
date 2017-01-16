package entity;

public class reader extends interestedReader {

	private String creditCard;
	private float debt;
	private readerType rType;


	/**
	 * reader - general constructor
	 */
	public reader(){
		super();
		creditCard = null;
		debt = -1;
		rType = null;
	}
	
	
	/**
	 * reader - constructor
	 * @param userID
	 * @param firstname
	 * @param lastname
	 * @param debt
	 * @param creditCard
	 * @param rType
	 * @param string6
	 */
	public reader(int userID, String firstname, String lastname, float debt ,String creditCard, readerType rType) {
		super(userID,firstname,lastname);
		this.creditCard = creditCard;
		this.debt = debt;
		this.rType = rType;
	}
	
	
	
	/**
	 * getReaderType - getter
	 * @return rType - readerType
	 */
	public readerType getReaderType() {
		return rType;
	}
	
	/**
	 * getcreditCard - getter
	 * @return creditCard - String
	 */
	public String getcreditCard() {
		return creditCard;
	}
	
	/**
	 * getDebt - getter
	 * @return debt - float
	 */
	public float getDebt() {
		return debt;
	}
	
	
	public void addToDebt() {
		// TODO - implement reader.addToDebt
		throw new UnsupportedOperationException();
	}

}