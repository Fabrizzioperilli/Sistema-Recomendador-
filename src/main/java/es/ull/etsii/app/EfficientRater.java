package es.ull.etsii.app;

/**
 * EfficientRater implements Rater interface to create an efficient rater structure using an ID and a HashMap of ratings.
 * 
 * @author Carlos González Mendoza, Fabrizzio Daniell Perilli Martín, Francisco Javier García González
 * @version 2.0 (08/01/2023)
 */

import java.util.*;

public class EfficientRater implements Rater {
	private String myID;
	private HashMap<String, Rating> myRatings;

	public EfficientRater(String id) {
		if (!id.getClass().equals(String.class)) {
			throw new IllegalArgumentException("Invalid EfficientRater argument");
		}
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
