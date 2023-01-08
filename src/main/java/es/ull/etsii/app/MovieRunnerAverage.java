package es.ull.etsii.app;

/**
 * Write a description of MovieRunnerAverage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MovieRunnerAverage {
	private String moviefile = "src/main/resources/data/ratedmoviesfull.csv";
	private String ratingsfile = "src/main/resources/data/ratings.csv";
	private Logger logger = Logger.getLogger(MovieRunnerAverage.class.getName());


	public void printAverageRatings() {
		SecondRatings sr = new SecondRatings(moviefile, ratingsfile);
		logger.log(Level.INFO, "movie size is {}", sr.getMovieSize());
		logger.log(Level.INFO, "rater size is {}", sr.getRaterSize());
		logger.log(Level.INFO, "{}", sr.getAverageRatings(2));
		logger.log(Level.INFO, "{}", sr.getTitle("2"));

		int minimalRaters = 12;
		ArrayList<Rating> avgRatingList = sr.getAverageRatings(minimalRaters);
		logger.log(Level.INFO, "{}", avgRatingList.size());

		Collections.sort(avgRatingList);
		for (Rating r : avgRatingList) {
			System.out.println(r.getValue() + "\t" + sr.getTitle(r.getItem()));
		}
	}

	public void getAverageRatingOneMovie() {
		SecondRatings sr = new SecondRatings(moviefile, ratingsfile);
		String title = "Vacation";
		int minimalRaters = 1;
		String id = sr.getID(title);
		ArrayList<Rating> avgRatingList = sr.getAverageRatings(minimalRaters);
		if (id.equals(new String("NO SUCH TITLE"))) {
			logger.log(Level.INFO, "{}", id);
		} else {
			for (Rating r : avgRatingList) {
				if (r.getItem().equals(id)) {
					System.out.println("Average rating for " + title + " is: " + r.getValue());
				}
			}
		}
	}

}
