package car;

/*
 * Author: Andre Tertzakian
 * July, 2013
 */

public class SUV extends Car {

	// Class Variables
	public static int STANDARD_CONSUMPTION_RATE = 3;
	public static int STANDARD_STARTING_FUEL = 50;
	public static int STANDARD_DISTANCE = 2;
	public static int STANDARD_AWD_DISTANCE = 1;

	/*
	 * Constructor
	 */
	public SUV() {
		super();
		// Set the character to represent the car on the track
		setAppearance('V');
		// Set the fuel consumption rate of the car
		setConsumptionRate(STANDARD_CONSUMPTION_RATE);
		// Set the starting fuel of the SUB
		setStartingFuel(STANDARD_STARTING_FUEL);
	}

	/*
	 * Set SUV into AWD mode, this lowers the distance travelled per turn
	 */
	public void setAWD() {
		//Change the standard distance travelled to the AWD mode distance
		setStandardDistance(STANDARD_AWD_DISTANCE);
	}

	/*
	 * Set SUV into AWD mode, this set the distance travelled per turn to the 
	 * standard distance
	 */
	public void setNormal() {
		//Change the standard distance travelled to the Normal mode distance
		setStandardDistance(STANDARD_DISTANCE);
	}
}
