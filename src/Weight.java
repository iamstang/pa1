package w9;

/*
 * Weight unit
 * @author Khanutchon Ammawong
 */
public enum Weight implements Unit {
	
	/* define the members of the enumeration
	 * the attributes are:
	 * name = a string name for this unit
	 * value = multiplier to convert compare to kilogram
	 */
	KILOGRAM( "Kilogram" , 1000 ),
	GRAM( "Gram" , 1 ),
	GRAIN( "Grain", 0.00647 ),
	OUNCE( "Ounce" , 28.349 ),
	POUND( "Pound" , 453.592),
	TON( "Ton" , 1000000 );
	
	
	/** name of this unit */
	private String name;
	/** multiplier to convert this unit to std unit */
	private double value;
	
	/*
	 * constructer for enum members
	 * @param name initialze the name of the object
	 * @param value initialize the value of the object
	 */
	Weight ( String name , double value ){
		this.name = name;
		this.value = value;
	}
	
	
	/*
	 *  public properties of the enum members
	 * @return return multiplier value to convert this unit to std unit 
	 */
	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	
	/*
	 * @return return name of the unit
	 */
	public String toString(){
		return name;
	}

}
