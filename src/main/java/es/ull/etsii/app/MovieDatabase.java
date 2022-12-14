package es.ull.etsii.app;

/**
 * MovieDatabase stores movie information in a HashMap for fast lookup of movie information given a movie ID. The class also allows filtering movies based on queries.
 * 
 * @author Carlos González Mendoza, Fabrizzio Daniell Perilli Martín, Francisco Javier García González
 * @version 1.0
 */

import java.util.*;


public class MovieDatabase {
	private MovieDatabase() {
		throw new IllegalStateException("Utility class");
	}
	private static HashMap<String, Movie> ourMovies;

	public static void initialize(String moviefile) {
		if (ourMovies == null) {
			ourMovies = new HashMap<>();
			loadMovies("src/main/resources/data/" + moviefile);
		}
	}

	private static void initialize() {
		if (ourMovies == null) {
			ourMovies = new HashMap<>();
			loadMovies("src/main/resources/data/ratedmoviesfull.csv");
		}
	}

	private static void loadMovies(String filename) {
		FirstRatings fr = new FirstRatings();
		ArrayList<Movie> list = fr.loadMovies(filename);
		for (Movie m : list) {
			ourMovies.put(m.getID(), m);
		}
	}

	public static boolean containsID(String id) {
		initialize();
		return ourMovies.containsKey(id);
	}

	public static int getYear(String id) {
		initialize();
		return ourMovies.get(id).getYear();
	}

	public static String getGenres(String id) {
		initialize();
		return ourMovies.get(id).getGenres();
	}

	public static String getTitle(String id) {
		initialize();
		return ourMovies.get(id).getTitle();
	}

	public static Movie getMovie(String id) {
		initialize();
		return ourMovies.get(id);
	}

	public static String getPoster(String id) {
		initialize();
		return ourMovies.get(id).getPoster();
	}

	public static int getMinutes(String id) {
		initialize();
		return ourMovies.get(id).getMinutes();
	}

	public static String getCountry(String id) {
		initialize();
		return ourMovies.get(id).getCountry();
	}

	public static String getDirector(String id) {
		initialize();
		return ourMovies.get(id).getDirector();
	}

	public static int size() {
		return ourMovies.size();
	}

	public static ArrayList<String> filterBy(Filter f) {
		initialize();
		ArrayList<String> list = new ArrayList<>();
		for (String id : ourMovies.keySet()) {
			if (f.satisfies(id)) {
				list.add(id);
			}
		}

		return list;
	}

}
