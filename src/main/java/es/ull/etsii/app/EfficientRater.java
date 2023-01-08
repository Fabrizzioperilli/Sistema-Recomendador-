package es.ull.etsii.app;

/**
 * Write a description of EfficientRater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class EfficientRater implements Rater {
	private String myID;
	private HashMap<String, Rating> myRatings;

	public EfficientRater(String id) {
		myID = id;
		myRatings = new HashMap<>();
	}

	public void addRating(String item, double rating) {
		if (rating < 0) {
			throw new IllegalArgumentException("Invalid rating value (less than 0)");
		}
		myRatings.put(item, new Rating(item, rating));
	}

	public boolean hasRating(String item) {
		return myRatings.containsKey(item);
	}

	public String getID() {
		return myID;
	}

	public double getRating(String item) {
		if (myRatings.containsKey(item)) {
			return myRatings.get(item).getValue();
		} else {
			return -1;
		}
	}

	public int numRatings() {
		return myRatings.size();
	}

	public ArrayList<String> getItemsRated() {
		ArrayList<String> list = new ArrayList<>();
		for (String movieID : myRatings.keySet()) {
			list.add(movieID);
		}

		return list;
	}
}
