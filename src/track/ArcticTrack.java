package track;

/*
 * Author: Andre Tertzakian
 * July, 2013
 */

public class ArcticTrack extends Track {
	/*
	 * Determines whether or not there is a blizzard
	 * using a random number generator. There is a 50%
	 * chance of there being a blizzard
	 */
	public boolean generateBlizzard() {
		boolean result = false;
		double r = Math.random();
		if(r <= 0.5) {
			result = true;
		}
		return result;
	}
}
