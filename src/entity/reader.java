package entity;

import boundry.UserSearchGUI;

public class reader extends interestedReader {

	private String creditCard;
	private float debt;
	private readerType rType;


	/**
	 * reader - general constructor.
	 * creates a new instance of a reader
	 */
	public reader(){
		super();
		creditCard = null;
		debt = -1;
		rType = null;
	}
	
	
	/**
	 * reader - constructor.
	 * creates a new instance of a reader with following information:
	 * @param userID - int
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
	 *Sets credit card number for a reader. Any attempt to set an illegal credit card number,
	 *will trigger an error message
	 * @param credit - String
	 */
	public void setCreditCard(String credit){
		
		
		try{
			int x = Integer.parseInt(credit);
			this.creditCard = credit;
		}
		catch (Exception e){
			UserSearchGUI.errorBox("Illegal credit card number!", "Illegal Card Error!");
			return;
		}
		
		
		/*if(credit.equals(null) || credit.contains(".*\\d.*")|| credit.contains(" ")){
			UserSearchGUI.errorBox("Illegal credit card number!", "Illegal Card Error!");
			return;
		}
		
		this.creditCard = credit;*/
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
	 */
	public void addToDebt(float extraDebt) {
		debt += extraDebt;
	}

}