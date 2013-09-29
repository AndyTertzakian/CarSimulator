package car;

public class SUV extends Car {

	public static int STANDARD_CONSUMPTION_RATE = 3;
	public static int STANDARD_STARTING_FUEL = 50;
	public static int STANDARD_DISTANCE = 2;
	public static int STANDARD_AWD_DISTANCE = 1;

	public SUV() {
		super();
		setAppearance('V');
		setConsumptionRate(STANDARD_CONSUMPTION_RATE);
		setStartingFuel(STANDARD_STARTING_FUEL);
	}

	public void setAWD() {
		setStandardDistance(STANDARD_AWD_DISTANCE);
	}
	
	public void setNormal() {
		setStandardDistance(STANDARD_DISTANCE);
	}
	
	
}
