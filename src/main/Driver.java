package main;

/*
 Author:  James Tam
 Version: April 1, 2013

 Starting execution point.

 */

public class Driver {
	public static void main(String[] args) {
		//Create a new GameController and use it to execute the game
		GameController gameController = new GameController();
		gameController.execute();
	}
}