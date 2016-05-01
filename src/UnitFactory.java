package w9;

/*
 * @author Khanutchon Ammawong
 */
public class UnitFactory {

	static UnitFactory Instance;
	
	private UnitFactory() {
		
		UnitFactory.Instance = new UnitFactory();
	}

	public static UnitFactory getInstance() { 
		
		return UnitFactory.Instance;
	}

	public UnitType[] getUnitTypes() {
		
		return UnitType.values();
	}

	public Unit[] getUnits(UnitType ut) {
		
		return ut.getUnit();
	}


}
