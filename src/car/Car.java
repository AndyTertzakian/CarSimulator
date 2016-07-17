package car;

/*
 Author:  James Tam
 Version: April 1, 2013

 Features:
 * Tracks and manages information for appearance and fuel capacity.
 */

public class Car {
	private int startingFuel;
	private int standardDistance;
	private int consumptionRate;
	private char appearance;
	private int fuel;

	public Car() {
		setAppearance('c');
		fuel = startingFuel;
	}

	// As the car moves, this class or child classes can specify for that type
	// of car
	// how much fuel to consume.
	protected void consumeFuel(int amount) {
		if (amount < 0)
			fuel = 0;
		else
			fuel = fuel - amount;
	}

	public int getFuel() {
		return fuel;
	}

	// Allows external queries of the fuel state of a particular car.
	public boolean isEmpty() {
		if (fuel <= 0)
			return true;
		else
			return false;
	}

	// Car internally knows how much fuel to use and how far to move. However
	// the
	// actual movement in the virtual track must be done by another class hence
	// this method must communicate to the caller how far it moves.

	// If this method is overriden then all child class methods must also
	// display
	// the same debugging messages shown below.
	public int move() {
		consumeFuel(consumptionRate);
		System.out.println("Current fuel: " + fuel);
		System.out.println("Fuel use: " + consumptionRate);
		System.out.println("Distance traveled: " + standardDistance);
		return standardDistance;
	}

	public int getStartingFuel() {
		return startingFuel;
	}

	public void setStartingFuel(int startingFuel) {
		this.startingFuel = startingFuel;
		this.fuel = this.startingFuel;
	}

	public int getStandardDistance() {
		return standardDistance;
	}

	public void setStandardDistance(int standardDistance) {
		this.standardDistance = standardDistance;
	}

	public int getConsumptionRate() {
		return consumptionRate;
	}

	public void setConsumptionRate(int consumptionRate) {
		this.consumptionRate = consumptionRate;
	}

	public char getAppearance() {
		return appearance;
	}

	public void setAppearance(char anAppearance) {
		appearance = anAppearance;
	}

	public void setFuel(int newFuel) {
		if (newFuel < 0)
			System.out.println("Fuel cannot be set to a negative value");
		else
			fuel = newFuel;
	}

	public String toString() {
		String s = "";
		s = s + appearance;
		return s;
	}
}