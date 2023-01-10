package es.ull.etsii.app;

/**
 * ThirdRatings has only one private variable named myRaters to store an ArrayList of Raters.
 * 
 * @author Carlos González Mendoza, Fabrizzio Daniell Perilli Martín, Francisco Javier García González
 * @version 2.0 (08/01/2023)
 */

import java.util.*;

public class ThirdRatings {
	private ArrayList<EfficientRater> myRaters;

	public ThirdRatings() {
		// default constructor
		this("ratings.csv");
	}

	public ThirdRatings(String ratingsfile) {
		FirstRatings fr = new FirstRatings();
		myRaters = fr.loadRaters(ratingsfile);
	}

	public int getRaterSize() {
		return myRaters.size();
	}

	private double getAverageByID(String id, int minimalRaters) {
		double totalRating = 0;
		int count = 0;

		for (Rater r : myRaters) {
			if (r.getRating(id) != -1) {
				totalRating += r.getRating(id);
				count += 1;
			}
		}

		if (count < minimalRaters) {
			return 0.0;
		} else {
			if (count == 0) {
				count = 1;
			}
			return totalRating / count;
		}
	}

	public ArrayList<Rating> getAverageRatings(int minimalRaters) {
		ArrayList<Rating> ret = new ArrayList<>();
		ArrayList<String> myMovies = MovieDatabase.filterBy(new TrueFilter());
		for (String movieID : myMovies) {
			double avgRating = getAverageByID(movieID, minimalRaters);
			if (avgRating != 0.0) {
				ret.add(new Rating(movieID, avgRating));
			}
		}
		return ret;
	}

	public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria) {
		ArrayList<Rating> ret = new ArrayList<>();
		ArrayList<String> myMovies = MovieDatabase.filterBy(filterCriteria);
		for (String movieID : myMovies) {
			double avgRating = getAverageByID(movieID, minimalRaters);
			if (avgRating != 0.0) {
				ret.add(new Rating(movieID, avgRating));
			}
		}
		return ret;
	}

}