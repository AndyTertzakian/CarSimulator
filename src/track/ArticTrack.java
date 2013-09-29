package track;

public class ArticTrack extends Track {

	public boolean generateBlizz() {
		boolean result = false;
		double r = Math.random();
		if(r <= 0.5) {
			result = true;
		}
		return result;
	}
}
