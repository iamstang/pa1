package w9;
/*
 * Area unit
 * @author Khanutchon Ammawong
 */
public enum Area implements Unit {
	
	/* define the members of the enumeration
	 * the attributes are:
	 * name = a string name for this unit
	 * value = multiplier to convert compare to square meter
	 */
	SQUARE_METER("Square Meter",1),
	SQUARE_KILOMETER("Square Kilometer", 1000000),
	SQUARE_MILE("Square Mile", 2589988.11),
	YARD("Yard",0.8361),
	ACRE("Acre",4046.85),
	BARN("Barn",1.0e-28),
	RAI("Rai",1600);
	
	/** name of this unit */
	private String name;
	/** multiplier to convert this unit to std unit */
	private double value;
	
	/*
	 * constructer for enum members
	 * @param name initialze the name of the object
	 * @param value initialize the value of the object
	 */
	Area(String name,double value){
		this.name = name;
		this.value = value;
	}
	
	/*
	 *  public properties of the enum members
	 * @return return multiplier value to convert this unit to std unit 
	 */
	public double getValue(){
		return value;
	}
	
	/*
	 * @return return name of the unit
	 */
	public String toString(){
		return name;
	}
}
