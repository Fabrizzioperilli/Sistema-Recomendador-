package es.ull.etsii.app;

/**
 * Rater interface provides methods to the class that implements it.
 * 
 * @author Carlos González Mendoza, Fabrizzio Daniell Perilli Martín, Francisco Javier García González
 * @version 1.0
 */

import java.util.*;

public interface Rater {
	public void addRating(String item, double rating);

	public boolean hasRating(String item);

	public String getID();

	public double getRating(String item);

	public int numRatings();

	public ArrayList<String> getItemsRated();

}
