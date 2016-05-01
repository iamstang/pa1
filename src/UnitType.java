package w9;

/*
 * @author Khanutchon Ammawong
 */

public enum UnitType {
	
	LENGTH("Length",Length.values()),
	WEIGHT("Weight",Weight.values()),
	AREA("Area",Area.values());
	
	private String name;
	private Unit[] unit;
	
	private UnitType(String name , Unit[] unit){
		
		this.name = name;
		this.unit = unit;
	}

	public Unit[] getUnit(){
		
		return unit;
	}
	
	public String toString(){
		
		return name;
	}
	
}
