package main;

import java.util.Scanner;

import car.SUV;
import car.Sports;

import track.ArticTrack;
import track.DesertTrack;

public class GameController {

	private ArticTrack artic = new ArticTrack();
	private DesertTrack desert = new DesertTrack();
	private SUV suv = new SUV();
	private int suvLocation = 0;
	private Sports sports = new Sports();
	private int sportsLocation = 0;
	private Scanner sc = new Scanner(System.in);
	private boolean isNextTurnABlizzard = false;
	private boolean isNextTurnAHWave = false;

	private boolean keepGoing = true;

	public void execute() {
		while (keepGoing) {
			displayTracks();
			suvMovement();
			articOptions();
			sportMovement();
			desertOptions();
			outcome();
		}
	}

	private void outcome() {
		if (artic.isWon()) {
			System.out.print("SUV won the game!!!!");
			keepGoing = false;
		} else if (desert.isWon()) {
			System.out.print("Sports won the game!!!!");
			keepGoing = false;
		}
	}

	private void desertOptions() {
		isNextTurnAHWave = desert.generateHWave();
		desert.setLocation(sports, sportsLocation);
	}

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

	private void setHeatWaveOptions() {
		if (isNextTurnAHWave) {
			System.out.println("A HEATWAVE HAMMERS THE DESERT TRACK!");
			sports.setConsumptionRate(Sports.STANDARD_FUEL_CONSUMPTION_RATE * 2);
		} else {
			sports.setConsumptionRate(Sports.STANDARD_FUEL_CONSUMPTION_RATE);
		}
	}

	private void articOptions() {
		isNextTurnABlizzard = artic.generateBlizz();
		artic.setLocation(suv, suvLocation);
	}

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

	private String getSelectionForSUV() {
		System.out.println("\nSUV options: ");
		System.out.println("(a)ll wheel drive mode");
		System.out.println("(d)rive normally");
		System.out.println("(q)uit simulation");
		System.out.println("Enter selection: ");
		String selection = sc.next();
		return selection;
	}

	private String getSelectionForSports() {
		System.out.println("\nSports options: ");
		System.out.println("(d)rive normally");
		System.out.println("(q)uit simulation");
		System.out.println("Enter selection: ");
		String selection = sc.next();
		return selection;
	}

	private void displayTracks() {
		System.out.println("\nARTIC TRACK");
		artic.display();

		System.out.println("\nDESERT TRACK");
		desert.display();
	}

}
