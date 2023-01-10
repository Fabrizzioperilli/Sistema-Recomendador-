package es.ull.etsii.app;

/**
 * MinutesFilter implements filter interface to return true if a movie's running time is at least min minutes and no more than max minutes.
 * 
 * @author Carlos González Mendoza, Fabrizzio Daniell Perilli Martín, Francisco Javier García González
 * @version 1.0
 */

public class MinutesFilter implements Filter {
	private int min;
	private int max;

	public MinutesFilter(int minMinutes, int maxMinutes) {
		min = minMinutes;
		max = maxMinutes;
	}

	public boolean satisfies(String id) {
		return MovieDatabase.getMinutes(id) >= min && MovieDatabase.getMinutes(id) <= max;
	}

	public String getName() {
		return "MinutesFilter[" + min + ", " + "]";
	}

}
