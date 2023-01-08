package es.ull.etsii.app;

/**
 * Write a description of RecommendationRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.security.SecureRandom;

public class RecommendationRunner implements Recommender {
	public ArrayList<String> getItemsToRate() {
		ArrayList<String> ret = new ArrayList<String>();
		int candidateSize = 20;
		ArrayList<String> movieIDs = MovieDatabase.filterBy(new TrueFilter());

		SecureRandom random = new SecureRandom();
		for (int i = 0; i < candidateSize; i++) {
			String candidate = movieIDs.get(random.nextInt(movieIDs.size()));
			if (ret.contains(candidate)) {
				i--;
			} else {
				ret.add(candidate);
			}
		}
		return ret;
	}

	public void printRecommendationsFor(String webRaterID) {
		FourthRatings fr = new FourthRatings();
		int numSimilarRaters = 5;
		int minimalRaters = 3;

		ArrayList<Rating> recList = fr.getSimilarRatings(webRaterID, numSimilarRaters, minimalRaters);

		if (recList.size() == 0) {
			printError();
		} else {
			printUpperPart();
			int i = 0;
			for (Rating r : recList) {
				i++;
				if ((i + 1) % 2 == 0) {
					System.out.println("<tr class=\"even_rows\"><td>" + i + "</td>");
				} else {
					System.out.println("<tr class=\"odd_rows\"><td>" + i + "</td>");
				}

				String URL = MovieDatabase.getPoster(r.getItem());
				String title = MovieDatabase.getTitle(r.getItem());
				String country = MovieDatabase.getCountry(r.getItem());
				int year = MovieDatabase.getYear(r.getItem());
				String genre = MovieDatabase.getGenres(r.getItem());
				int minutes = MovieDatabase.getMinutes(r.getItem());

				System.out.println("<td><table><tr><td class = \"pic\">");

				if (URL.length() > 3) {
					System.out.println("<img src = \"" + URL + "\" target=_blank></td>");
				}

				System.out.println("<td><h3>" + title + "</h3>");
				System.out.println("<b>by " + genre + "</b><br>");
				System.out.println(year + "<br>");
				System.out.println(country + "<br>");
				System.out.println(minutes + " minutes</td></tr></table></td></tr>");
				if (i > 12)
					break;
			}
			printLowerPart();

		}
	}

	private void printError() {
		System.out.println("This is system error, please try again!");
	}

	private void printUpperPart() {
		System.out.println(
				"<link href=\"https://fonts.googleapis.com/css?family=Syncopate\" rel=\"stylesheet\"><link href=\"https://fonts.googleapis.com/css?family=Roboto|Syncopate\" rel=\"stylesheet\"><div id=\"header\"><h2>Recommended Movies:</h2></div><table class=\"outside_table\"><tr  class=\"table-header\"><th>&nbsp</th><th class=\"movie_title\">Title</th></tr>");
	}

	private void printLowerPart() {
		System.out.println("</table>");
	}

}
