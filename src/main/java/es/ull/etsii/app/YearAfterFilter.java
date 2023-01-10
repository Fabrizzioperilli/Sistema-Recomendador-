package es.ull.etsii.app;

/**
 * YearAfterFilter implements Filter interface to calculate the number of movies in the database that have at least a minimal number of ratings and came out in a particular year or later.
 * 
 * @author Carlos González Mendoza, Fabrizzio Daniell Perilli Martín, Francisco Javier García González
 * @version 1.0
 */

public class YearAfterFilter implements Filter {
	private int myYear;

	public YearAfterFilter(int year) {
		myYear = year;
	}

	public boolean satisfies(String id) {
		return MovieDatabase.getYear(id) >= myYear;
	}

}
