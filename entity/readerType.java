package entity;

public enum readerType {
	
	
	ONEBYONE("onebyone"),
	PERIODIC("periodic");
	
	private String type;
	
	/**
	 * readerType constructor
	 * @param type - String. payment method for a reader (ONEBYONE, prediodic)
	 */
	private readerType(String type) {
		this.type = type; 
		
	}
	
	/**
	 * getType() - get method
	 * @return type - String, a payment method of a reader.
	 */
	public String getType(){return type;}
	
	public static readerType getTypeFromString(String type){
		
		if(!type.equals(null)){
			for(readerType rt : readerType.values())
				if(type.equalsIgnoreCase(rt.toString())) return rt;
		}
		return null;
	}
	
}