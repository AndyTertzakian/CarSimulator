package main;

/*
 * Author: Andre Tertzakian
 * July, 2016
 */

import java.util.Scanner;

import car.SUV;
import car.Sports;

import track.ArcticTrack;
import track.DesertTrack;

public class GameController {

	//Class Variables
	private ArcticTrack arctic = new ArcticTrack();    
	private DesertTrack desert = new DesertTrack(); 
	private SUV suv = new SUV();                    
	private int suvLocation = 0;                    
	private Sports sports = new Sports();           
	private int sportsLocation = 0;                 
	private Scanner sc = new Scanner(System.in);
	private boolean isNextTurnABlizzard = false;
	private boolean isNextTurnAHeatWave = false;
	private boolean keepGoing = true;

	/*
	 * Execute method for the game. Continues
	 * to go through game until the user quits
	 * or the end of the game is reached
	 */
	public void execute() {
		while (keepGoing) {
			//Display the current status of both cars on their respective tracks
			displayTracks();
			//Get the SUV Movement type1
			suvMovement();
			articOptions();
			sportMovement();
			desertOptions();
			outcome();
		}
	}

	/*
	 * Decides if either of the participants won the race.
	 * Sets the game to stop.
	 */
	private void outcome() {
		//If the artic 
		if (arctic.isWon()) {
			System.out.print("SUV won the game!!!!");
			keepGoing = false;
		} else if (desert.isWon()) {
			System.out.print("Sports Car won the game!!!!");
			keepGoing = false;
		}
	}
	
	/*
	 * Set/Get the current desert options
	 */
	private void desertOptions() {
		isNextTurnAHeatWave = desert.generateHeatWave();
		desert.setLocation(sports, sportsLocation);
	}

	/*
	 * Execute the turn for the Sports car
	 */
	private void sportMovement() {
		String selection = getSelectionForSports();
		int distanceTravelled = 0;
		if (selection.equalsIgnoreCase("d")) {
			setHeatWaveOptions();
			distanceTravelled = sports.move();
		} else if (selection.equalsIgnoreCase("q")) {
			keepGoing = false;
			System.out.print("You have just exited the game");
		} else {
			System.out.println("Invalid selection");
		}
		sportsLocation = sportsLocation + distanceTravelled;
	}

	/*
	 * Adjust the desert conditions for the sports car according to whether or not
	 * there is a heat wave
	 */
	private void setHeatWaveOptions() {
		if (isNextTurnAHeatWave) {
			System.out.println("A HEATWAVE HAMMERS THE DESERT TRACK!");
			sports.setConsumptionRate(Sports.STANDARD_CONSUMPTION_RATE * 2);
		} else {
			sports.setConsumptionRate(Sports.STANDARD_CONSUMPTION_RATE);
		}
	}

	
	/*
	 * Set/Get the current arctic options
	 */
	private void articOptions() {
		isNextTurnABlizzard = arctic.generateBlizzard();
		arctic.setLocation(suv, suvLocation);
	}

	/*
	 * Execute the turn for the SUV
	 */
	private void suvMovement() {
		String selection = getSelectionForSUV();
		int distanceTravelled = 0;
		if (selection.equalsIgnoreCase("a")) {
			suv.setAWD();
			if (isNextTurnABlizzard) {
				System.out.println("BLIZZARD HITS BUT SUV MOVES SLOWLY IN AWD MODE!");
			}
			distanceTravelled = suv.move();
		} else if (selection.equalsIgnoreCase("d")) {
			suv.setNormal();
			if (isNextTurnABlizzard) {
				System.out.println("BLIZZARD HITS AND CAR SPINS ITS WHEELS!");
				suv.setStandardDistance(0);
			}
			distanceTravelled = suv.move();
		} else if (selection.equalsIgnoreCase("q")) {
			keepGoing = false;
			System.out.print("You have just exited the game");
		} else {
			System.out.println("Invalid selection");
		}
		suvLocation = suvLocation + distanceTravelled;
	}

	/*
	 * Retrieves user input for the current turn for 
	 * the SUV. Returns the players selection.
	 */
	private String getSelectionForSUV() {
		System.out.println("\nSUV options: ");
		System.out.println("(a)ll wheel drive mode");
		System.out.println("(d)rive normally");
		System.out.println("(q)uit simulation");
		System.out.println("Enter selection: ");
		String selection = sc.next();
		return selection;
	}

	/*
	 * Retrieves user input for the current turn for 
	 * the sports car. Returns the players selection.
	 */
	private String getSelectionForSports() {
		System.out.println("\nSports options: ");
		System.out.println("(d)rive normally");
		System.out.println("(q)uit simulation");
		System.out.println("Enter selection: ");
		String selection = sc.next();
		return selection;
	}

	/*
	 * Show both tracks to the console 
	 */
	private void displayTracks() {
		System.out.println("\nARTIC TRACK");
		arctic.display();

		System.out.println("\nDESERT TRACK");
		desert.display();
	}

}
