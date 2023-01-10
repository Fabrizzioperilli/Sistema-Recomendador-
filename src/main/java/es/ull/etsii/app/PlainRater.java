package es.ull.etsii.app;

/**
 * PlainRater implements Rater interface and keeps track of one rater and all their ratings.
 * 
 * @author Carlos González Mendoza, Fabrizzio Daniell Perilli Martín, Francisco Javier García González
 * @version 1.0
 */

import java.util.*;

public class PlainRater implements Rater {
	private String myID;
	private ArrayList<Rating> myRatings;

	public PlainRater(String id) {
		myID = id;
		myRatings = new ArrayList<>();
	}

	public void addRating(String item, double rating) {
		myRatings.add(new Rating(item, rating));
	}

	public boolean hasRating(String item) {
		for (int k = 0; k < myRatings.size(); k++) {
			if (myRatings.get(k).getItem().equals(item)) {
				return true;
			}
		}

		return false;
	}

	public String getID() {
		return myID;
	}

	public double getRating(String item) {
		for (int k = 0; k < myRatings.size(); k++) {
			if (myRatings.get(k).getItem().equals(item)) {
				return myRatings.get(k).getValue();
			}
		}

		return -1;
	}

	public int numRatings() {
		return myRatings.size();
	}

	public ArrayList<String> getItemsRated() {
		ArrayList<String> list = new ArrayList<>();
		for (int k = 0; k < myRatings.size(); k++) {
			list.add(myRatings.get(k).getItem());
		}

		return list;
	}
}
