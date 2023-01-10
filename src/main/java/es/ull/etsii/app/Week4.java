package es.ull.etsii.app;

/**
 * Week4 is the main class for the correct execution of the program.
 * 
 * @author Carlos González Mendoza, Fabrizzio Daniell Perilli Martín, Francisco Javier García González
 * @version 2.0 (08/01/2023)
 */

class Week4 {
	public static void main(String[] args) {
		FourthRatings fourthRatings = new FourthRatings();
		Rater meRater = new EfficientRater("15");
		Rater otherRater = new EfficientRater("20");
		
		meRater.addRating("2354", 10.0);
		meRater.addRating("3285", 6.0);
		meRater.addRating("1297", 2.0);
		meRater.addRating("5804", 8.0);
		
		otherRater.addRating("3285", 4.0);
		otherRater.addRating("1297", 7.0);
		otherRater.addRating("6574", 10.0);
		otherRater.addRating("2354", 9.0);
		
		System.out.print(
		    "Consider the method dotProduct in the FourthRatings class. What should the call "
		        + "dotProduct('15', '20')  return? ");
		System.out.println(fourthRatings.dotProduct(meRater, otherRater));
		
		MovieRunnerSimilarRatings quiz = new MovieRunnerSimilarRatings();
		System.out.println("\n- Similar Ratings:\n");
		quiz.printSimilarRatings();
		System.out.println("\n- Similar Ratings by Genre:\n");
		quiz.printSimilarRatingsByGenre();
		System.out.println("\n- Similar Ratings by Director:\n");
		quiz.printSimilarRatingsByDirector();
		System.out.println("\n- Similar Ratings by Genre and Minutes:\n");
		quiz.printSimilarRatingsByGenreAndMinutes();
		System.out.println("\n- Similar Ratings by Year After and Minutes:\n");
		quiz.printSimilarRatingsByYearAfterAndMinutes();
	}
}
