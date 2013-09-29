package car;

public class Sports extends Car {

	public static int STANDARD_FUEL_CONSUMPTION_RATE = 2;
	public static int STANDARD_DISTANCE = 3;
	public static int STANDARD_STARTING_FUEL = 30;
	
	public Sports() {
		super();
		setAppearance('P');
		setStandardDistance(STANDARD_DISTANCE);
		setStartingFuel(STANDARD_STARTING_FUEL);
		setConsumptionRate(STANDARD_FUEL_CONSUMPTION_RATE);
	}
	
}
