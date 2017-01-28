package entity;

/**
 * Class - reader<br>
 * The class represents a user with "Reader" privileges.<br>
 * Extends interestedReader class.<br>
 * Uses parameters: creditCard (String); debt (float); readerType (readerType) 
 * @author Nimrod Mendel
 */
import boundry.UserSearchGUI;

public class reader extends interestedReader {

	private String creditCard;
	private float debt;
	private readerType rType;


	/**
	 * reader - general constructor.
	 * Creates a new instance of a reader
	 */
	public reader(){
		super();
		creditCard = null;
		debt = -1;
		rType = null;
	}
	
	
	/**
	 * reader - constructor.
	 * Creates a new instance of a reader with following information:
	 * @param userID - integer
	 * @param firstname - String
	 * @param lastname - String
	 * @param debt - float
	 * @param creditCard - String
	 * @param rType - readerType (ENUM)
	 
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
	public readerType getReaderType() {return rType;}
	
	/**
	 * getcreditCard - getter
	 * @return creditCard - String
	 */
	public String getcreditCard() {return creditCard;}
	
	/**
	 * getDebt - getter
	 * @return debt - float
	 */
	public float getDebt() {return debt;}
	
	/**
	 *setCreditCard - setter.
	 *Sets credit card number for a reader. In case of an illegal input (credit card string with letters i.e)
	 *an exception will be triggered and an error message will pop
	 * @param credit - String
	 */
	public void setCreditCard(String credit){
		
		
		try{
			int x = Integer.parseInt(credit);	//try to parse to integer
			this.creditCard = credit;	//if parsed succeeded set credit
		}
		catch (Exception e){	//if failed, trigger an exception
			UserSearchGUI.errorBox("Illegal credit card number!", "Illegal Card Error!");
			return;
		}
	}

	/**
	 * setDebt() - setter.
	 * Sets a debt for a reader
	 * @param debt - float
	 */
	public void setDebt(float debt){
		
		if(debt < 0.0){
			UserSearchGUI.errorBox("Can't set negative debt!", "Negative Debt Error!");
			return;
		}
		this.debt = debt;	//set value	
	}
	
	/**
	 * setrType() - setter
	 * sets a reader type. Any attempt to set an illegal reader type (different than "onebyone" or "periodic"),
	 * will trigger an error message
	 * @param rType - ENUM
	 */
	public void setrType(readerType rType){	
	
	
		if(!rType.equals("ONEBYONE") || !rType.equals("PERIODIC")){
			UserSearchGUI.errorBox("Illegal payment method!", "Illegal Payment Method!");
			return;
		}
		
		this.rType = rType;
	}
	
	/**
	 * addToDebt - method
	 * Adds a certain amount of money (book cost) to the debt a reader already has 
	 * @param extraDebt - float
	 * @return updated debt
	 */
	public float addToDebt(float extraDebt) {
		debt += extraDebt;
		return debt;
	}

}