package car;

/*
 * Author: Andre Tertzakian
 * July, 2013
 */

public class Sports extends Car {

	// Class Variables
	public static int STANDARD_CONSUMPTION_RATE = 2;
	public static int STANDARD_DISTANCE = 3;
	public static int STANDARD_STARTING_FUEL = 30;

	/*
	 * Constructor
	 */
	public Sports() {
		super();
		// Set the character to represent the car on the track
		setAppearance('P');
		//Set the Standard distance for the sports car to travel per turn
		setStandardDistance(STANDARD_DISTANCE);
		// Set the fuel consumption rate of the car
		setConsumptionRate(STANDARD_CONSUMPTION_RATE);
		// Set the starting fuel of the SUB
		setStartingFuel(STANDARD_STARTING_FUEL);
	}

}
