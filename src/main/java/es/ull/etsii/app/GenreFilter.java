package es.ull.etsii.app;

/**
 * GenreFilter implements Filter interface to return true if a movie satisfies this genre (movies may have several genres).
 * 
 * @author Carlos González Mendoza, Fabrizzio Daniell Perilli Martín, Francisco Javier García González
 * @version 1.0
 */

public class GenreFilter implements Filter {
	private String genre;

	public GenreFilter(String withGenre) {
		genre = withGenre;
	}

	public boolean satisfies(String id) {
		String thisGenres = MovieDatabase.getGenres(id).toLowerCase();
		if (thisGenres.indexOf(genre.toLowerCase()) != -1) {
			return true;
		} else {
			return false;
		}
	}

	public String getName() {
		return "GenreFilter[" + genre + "]";
	}

}
