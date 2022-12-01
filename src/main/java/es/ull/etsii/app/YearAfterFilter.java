package es.ull.etsii.app;

public class YearAfterFilter implements Filter {
	private int myYear;

	public YearAfterFilter(int year) {
		myYear = year;
	}

	public boolean satisfies(String id) {
		return MovieDatabase.getYear(id) >= myYear;
	}

}
