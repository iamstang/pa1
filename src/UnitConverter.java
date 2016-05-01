package w9;

/*
 * Unit converter , convert value from unit to another unit
 * @author Khanutchon Ammawong
 */

public class UnitConverter {
	
	/*
	 * convert amount from unit to another
	 * @param amount the initial amount that user want to convert
	 * @param fromUnit initial unit of the amount
	 * @param toUnit unit user want to convert to
	 * @return return value of the new unit in double value
	 */
	public double convert( double amount , Unit fromUnit , Unit toUnit ){
		
		return ( amount * fromUnit.getValue() ) / toUnit.getValue();
	}
	
}
