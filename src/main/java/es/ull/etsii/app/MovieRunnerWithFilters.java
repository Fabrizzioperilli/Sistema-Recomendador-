package es.ull.etsii.app;

/**
 * MovieRunnerWithFilters is used to find the average rating of movies using different filters.
 * 
 * @author Carlos González Mendoza, Fabrizzio Daniell Perilli Martín, Francisco Javier García González
 * @version 1.0
 */

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MovieRunnerWithFilters {
	private String ratingsfile = "src/main/resources/data/ratings.csv";
	private String moviefile = "ratedmoviesfull.csv";
	private Logger logger = Logger.getLogger(MovieRunnerWithFilters.class.getName());
	private static final String RATERS = "Number of raters: ";
	private static final String MOVIES = "Number of movies: ";
	private static final String LINES = "========================================================";

	public void printAverageRating() {
		ThirdRatings tr = new ThirdRatings(ratingsfile);
		MovieDatabase.initialize(moviefile);

		logger.log(Level.INFO,"{}", RATERS + tr.getRaterSize());
		logger.log(Level.INFO,"{}", MOVIES + MovieDatabase.size());

		int minimalRaters = 35;
		ArrayList<Rating> avgRatingList = tr.getAverageRatings(minimalRaters);
		logger.log(Level.INFO, "found {} movies" , avgRatingList.size());
		Collections.sort(avgRatingList);
		for (Rating r : avgRatingList) {
			logger.log(Level.INFO, "{} \t", r.getValue());
			logger.log(Level.INFO, "{}",MovieDatabase.getTitle(r.getItem()));
		}
		logger.log(Level.INFO, "{}", LINES);
	}

	public void printAverageRatingByYear() {
		ThirdRatings tr = new ThirdRatings(ratingsfile);
		MovieDatabase.initialize(moviefile);
		Filter yf = new YearAfterFilter(2000);

		logger.log(Level.INFO,"{}", RATERS + tr.getRaterSize());
		logger.log(Level.INFO,"{}", MOVIES + MovieDatabase.size());

		int minimalRaters = 20;
		ArrayList<Rating> avgRatingList = tr.getAverageRatingsByFilter(minimalRaters, yf);
		logger.log(Level.INFO, "found {} movies" , avgRatingList.size());
		Collections.sort(avgRatingList);
		for (Rating r : avgRatingList) {
			System.out.println(r.getValue() + "\tYear: " + MovieDatabase.getYear(r.getItem()) + "\t"
					+ MovieDatabase.getTitle(r.getItem()));
		}
		logger.log(Level.INFO, "{}", LINES);
	}

	public void printAverageRatingByGenre() {
		ThirdRatings tr = new ThirdRatings(ratingsfile);
		MovieDatabase.initialize(moviefile);
		Filter gf = new GenreFilter("Comedy");

		logger.log(Level.INFO,"{}", RATERS + tr.getRaterSize());
		logger.log(Level.INFO,"{}", MOVIES + MovieDatabase.size());

		int minimalRaters = 20;
		ArrayList<Rating> avgRatingList = tr.getAverageRatingsByFilter(minimalRaters, gf);
		logger.log(Level.INFO, "found {} movies" , avgRatingList.size());
		Collections.sort(avgRatingList);
		for (Rating r : avgRatingList) {
			System.out.println(r.getValue() + "\t" + MovieDatabase.getTitle(r.getItem()));
			System.out.println("\t" + MovieDatabase.getGenres(r.getItem()));
		}
		logger.log(Level.INFO, "{}", LINES);
	}

	public void printAverageRatingByMinutes() {
		ThirdRatings tr = new ThirdRatings(ratingsfile);
		MovieDatabase.initialize(moviefile);
		Filter mf = new MinutesFilter(105, 135);

		logger.log(Level.INFO,"{}", RATERS + tr.getRaterSize());
		logger.log(Level.INFO,"{}", MOVIES + MovieDatabase.size());

		int minimalRaters = 5;
		ArrayList<Rating> avgRatingList = tr.getAverageRatingsByFilter(minimalRaters, mf);
		logger.log(Level.INFO, "found {} movies" , avgRatingList.size());
		Collections.sort(avgRatingList);
		for (Rating r : avgRatingList) {
			System.out.println(r.getValue() + "\t" + "Time: " + MovieDatabase.getMinutes(r.getItem()) + " Mins" + "\t"
					+ MovieDatabase.getTitle(r.getItem()));
		}
		logger.log(Level.INFO, "{}", LINES);
	}

	public void printAverageRatingByDirector() {
		ThirdRatings tr = new ThirdRatings(ratingsfile);
		MovieDatabase.initialize(moviefile);
		Filter df = new DirectorsFilter(
				"Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack");

		logger.log(Level.INFO,"{}", RATERS + tr.getRaterSize());
		logger.log(Level.INFO,"{}", MOVIES + MovieDatabase.size());

		int minimalRaters = 4;
		ArrayList<Rating> avgRatingList = tr.getAverageRatingsByFilter(minimalRaters, df);
		logger.log(Level.INFO, "found {} movies" , avgRatingList.size());
		Collections.sort(avgRatingList);
		for (Rating r : avgRatingList) {
			System.out.println(r.getValue() + "\t" + MovieDatabase.getTitle(r.getItem()));
			System.out.println("\t" + MovieDatabase.getDirector(r.getItem()));
		}
		logger.log(Level.INFO, "{}", LINES);
	}

	public void printAverageRatingByYearAfterAndGenre() {
		ThirdRatings tr = new ThirdRatings(ratingsfile);
		MovieDatabase.initialize(moviefile);
		AllFilters f = new AllFilters();
		f.addFilter(new YearAfterFilter(1990));
		f.addFilter(new GenreFilter("Drama"));

		logger.log(Level.INFO,"{}", RATERS + tr.getRaterSize());
		logger.log(Level.INFO,"{}", MOVIES + MovieDatabase.size());

		int minimalRaters = 8;
		ArrayList<Rating> avgRatingList = tr.getAverageRatingsByFilter(minimalRaters, f);
		logger.log(Level.INFO, "found {} movies" , avgRatingList.size());
		Collections.sort(avgRatingList);
		for (Rating r : avgRatingList) {
			System.out.println(r.getValue() + "\tYear: " + MovieDatabase.getYear(r.getItem()) + "\t"
					+ MovieDatabase.getTitle(r.getItem()));
			System.out.println("\t" + MovieDatabase.getGenres(r.getItem()));
		}
		logger.log(Level.INFO, "{}", LINES);
	}

	public void printAverageRatingsByDirectorsAndMinutes() {
		ThirdRatings tr = new ThirdRatings(ratingsfile);
		MovieDatabase.initialize(moviefile);
		AllFilters f = new AllFilters();
		f.addFilter(new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack"));
		f.addFilter(new MinutesFilter(90, 180));

		logger.log(Level.INFO,"{}", RATERS + tr.getRaterSize());
		logger.log(Level.INFO,"{}", MOVIES + MovieDatabase.size());

		int minimalRaters = 3;
		ArrayList<Rating> avgRatingList = tr.getAverageRatingsByFilter(minimalRaters, f);
		logger.log(Level.INFO, "found {} movies" , avgRatingList.size());
		Collections.sort(avgRatingList);
		for (Rating r : avgRatingList) {
			System.out.println(r.getValue() + "\tTime: " + MovieDatabase.getMinutes(r.getItem()) + " Mins\t"
					+ MovieDatabase.getTitle(r.getItem()));
					logger.log(Level.INFO, "\t {}" , MovieDatabase.getDirector(r.getItem()));
		}
		logger.log(Level.INFO, "{}", LINES);
	}

}