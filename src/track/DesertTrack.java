package track;

public class DesertTrack extends Track {
	public boolean generateHWave() {
		boolean result = false;
		double r = Math.random();
		if(r <= 0.5) {
			result = true;
		}
		return result;
	}

}
