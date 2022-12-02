package es.ull.etsii.app;

/**
 * Write a description of MovieRunnerAverage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MovieRunnerAverage {
	private String moviefile = "src/main/resources/data/ratedmoviesfull.csv";
	private String ratingsfile = "src/main/resources/data/ratings.csv";

	public void printAverageRatings() {
		SecondRatings sr = new SecondRatings(moviefile, ratingsfile);
		System.out.println("movie size is " + sr.getMovieSize());
		System.out.println("rater size is " + sr.getRaterSize());
		System.out.println(sr.getAverageRatings(2));
		System.out.println(sr.getTitle("2"));

		int minimalRaters = 12;
		ArrayList<Rating> avgRatingList = sr.getAverageRatings(minimalRaters);
		System.out.println(avgRatingList.size());

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
			System.out.println(id);
		} else {
			for (Rating r : avgRatingList) {
				if (r.getItem().equals(id)) {
					System.out.println("Average rating for " + title + " is: " + r.getValue());
				}
			}
		}
	}

}
