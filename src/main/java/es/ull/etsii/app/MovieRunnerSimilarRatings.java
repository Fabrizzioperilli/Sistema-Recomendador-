package es.ull.etsii.app;

/**
 * MovieRunnerSimilarRatings uses methods from MovieRunnerWithFilters to work with a FourthRatings object instead of a ThirdRating object.
 * 
 * @author Carlos González Mendoza, Fabrizzio Daniell Perilli Martín, Francisco Javier García González
 * @version 1.0
 */
 
import java.util.*;

public class MovieRunnerSimilarRatings {
	private String ratingsfile = "ratings.csv";
	private String moviefile = "ratedmoviesfull.csv";

	public void printAverageRating() {
		FourthRatings fr = new FourthRatings();
		MovieDatabase.initialize(moviefile);
		RaterDatabase.initialize(ratingsfile);

		System.out.println("Number of raters: " + RaterDatabase.size());
		System.out.println("Number of movies: " + MovieDatabase.size());

		int minimalRaters = 1;
		ArrayList<Rating> avgRatingList = fr.getAverageRatings(minimalRaters);
		System.out.println("found " + avgRatingList.size() + " movies");
		Collections.sort(avgRatingList);
		for (Rating r : avgRatingList) {
			System.out.println(r.getValue() + "\t" + MovieDatabase.getTitle(r.getItem()));
		}
		System.out.println("========================================================");
	}

	public void printAverageRatingByYearAfterAndGenre() {
		FourthRatings fr = new FourthRatings();
		MovieDatabase.initialize(moviefile);
		RaterDatabase.initialize(ratingsfile);

		AllFilters f = new AllFilters();
		f.addFilter(new YearAfterFilter(1980));
		f.addFilter(new GenreFilter("Romance"));

		System.out.println("Number of raters: " + RaterDatabase.size());
		System.out.println("Number of movies: " + MovieDatabase.size());

		int minimalRaters = 1;
		ArrayList<Rating> avgRatingList = fr.getAverageRatingsByFilter(minimalRaters, f);
		System.out.println("found " + avgRatingList.size() + " movies");
		Collections.sort(avgRatingList);
		for (Rating r : avgRatingList) {
			System.out.println(r.getValue() + "\tYear: " + MovieDatabase.getYear(r.getItem()) + "\t"
					+ MovieDatabase.getTitle(r.getItem()));
			System.out.println("\t" + MovieDatabase.getGenres(r.getItem()));
		}
		System.out.println("========================================================");
	}

	public void printSimilarRatings() {
		FourthRatings fr = new FourthRatings();
		MovieDatabase.initialize(moviefile);
		RaterDatabase.initialize(ratingsfile);

		String id = "337";
		ArrayList<Rating> weightedRatings = fr.getSimilarRatings(id, 10, 3);
		Collections.sort(weightedRatings, Collections.reverseOrder());
		for (Rating r : weightedRatings) {
			System.out.println(r.getValue() + "\t" + MovieDatabase.getTitle(r.getItem()));
		}
		System.out.println("========================================================");
	}

	public void printSimilarRatingsByGenre() {
		FourthRatings fr = new FourthRatings();
		MovieDatabase.initialize(moviefile);
		RaterDatabase.initialize(ratingsfile);

		Filter f = new GenreFilter("Mystery");
		String id = "964";
		ArrayList<Rating> weightedRatings = fr.getSimilarRatingsByFilter(id, 20, 5, f);
		Collections.sort(weightedRatings, Collections.reverseOrder());
		for (Rating r : weightedRatings) {
			System.out.println(r.getValue() + "\t" + MovieDatabase.getTitle(r.getItem()));
			System.out.println("\t" + MovieDatabase.getGenres(r.getItem()));
		}
		System.out.println("========================================================");
	}

	public void printSimilarRatingsByDirector() {
		FourthRatings fr = new FourthRatings();
		MovieDatabase.initialize(moviefile);
		RaterDatabase.initialize(ratingsfile);

		Filter f = new DirectorsFilter(
				"Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh");
		String id = "120";
		ArrayList<Rating> weightedRatings = fr.getSimilarRatingsByFilter(id, 10, 2, f);
		Collections.sort(weightedRatings, Collections.reverseOrder());
		for (Rating r : weightedRatings) {
			System.out.println(r.getValue() + "\t" + MovieDatabase.getTitle(r.getItem()));
			System.out.println("\t" + MovieDatabase.getDirector(r.getItem()));
		}
		System.out.println("========================================================");
	}

	public void printSimilarRatingsByGenreAndMinutes() {
		FourthRatings fr = new FourthRatings();
		MovieDatabase.initialize(moviefile);
		RaterDatabase.initialize(ratingsfile);

		AllFilters f = new AllFilters();
		f.addFilter(new GenreFilter("Drama"));
		f.addFilter(new MinutesFilter(80, 160));
		String id = "168";
		ArrayList<Rating> weightedRatings = fr.getSimilarRatingsByFilter(id, 10, 3, f);
		Collections.sort(weightedRatings, Collections.reverseOrder());
		for (Rating r : weightedRatings) {
			System.out.println(r.getValue() + "\tTime " + MovieDatabase.getMinutes(r.getItem()) + " Mins\t"
					+ MovieDatabase.getTitle(r.getItem()));
			System.out.println("\t" + MovieDatabase.getGenres(r.getItem()));
		}
		System.out.println("========================================================");
	}

	public void printSimilarRatingsByYearAfterAndMinutes() {
		FourthRatings fr = new FourthRatings();
		MovieDatabase.initialize(moviefile);
		RaterDatabase.initialize(ratingsfile);

		AllFilters f = new AllFilters();
		f.addFilter(new YearAfterFilter(1975));
		f.addFilter(new MinutesFilter(70, 200));
		String id = "314";
		ArrayList<Rating> weightedRatings = fr.getSimilarRatingsByFilter(id, 10, 5, f);
		Collections.sort(weightedRatings, Collections.reverseOrder());
		for (Rating r : weightedRatings) {
			System.out.println(r.getValue() + "\tYear " + MovieDatabase.getYear(r.getItem()) + "\tTime "
					+ MovieDatabase.getMinutes(r.getItem()) + " Mins\t" + MovieDatabase.getTitle(r.getItem()));
		}
		System.out.println("========================================================");
	}
}
