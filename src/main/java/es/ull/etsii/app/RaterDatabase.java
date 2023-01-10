package es.ull.etsii.app;

/**
 * RaterDatabase is an efficient way to get information about raters.
 * 
 * @author Carlos González Mendoza, Fabrizzio Daniell Perilli Martín, Francisco Javier García González
 * @version 1.0
 */

import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

public class RaterDatabase {
	private RaterDatabase() {
		throw new IllegalStateException("Utility class");
	}
	private static HashMap<String, Rater> ourRaters;

	private static void initialize() {
		// this method is only called from addRatings
		if (ourRaters == null) {
			ourRaters = new HashMap<>();
		}
	}

	public static void initialize(String filename) {
		if (ourRaters == null) {
			ourRaters = new HashMap<>();
			addRatings("src/main/resources/data/" + filename);
		}
	}

	public static void addRatings(String filename) {
		initialize();
		FileResource fr = new FileResource(filename);
		CSVParser csvp = fr.getCSVParser();
		for (CSVRecord rec : csvp) {
			String id = rec.get("rater_id");
			String item = rec.get("movie_id");
			String rating = rec.get("rating");
			addRaterRating(id, item, Double.parseDouble(rating));
		}
	}

	public static void addRaterRating(String raterID, String movieID, double rating) {
		initialize();
		Rater rater = null;
		if (ourRaters.containsKey(raterID)) {
			rater = ourRaters.get(raterID);
		} else {
			rater = new EfficientRater(raterID);
			ourRaters.put(raterID, rater);
		}
		rater.addRating(movieID, rating);
	}

	public static Rater getRater(String id) {
		initialize();

		return ourRaters.get(id);
	}

	public static ArrayList<Rater> getRaters() {
		initialize();
		return new ArrayList<>(ourRaters.values());
	}

	public static int size() {
		return ourRaters.size();
	}
}
