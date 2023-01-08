package es.ull.etsii.app;

import es.ull.etsii.app.Week4;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class Week4Test {
	
	FourthRatings fourthRatings;
	Rater meRater;
	Rater otherRater;
		
	@BeforeEach
	void setUp() {
		// Set up preconditions
        fourthRatings = new FourthRatings();
        meRater = new EfficientRater("15");
        otherRater = new EfficientRater("20");
        
        meRater.addRating("2354", 10.0);
        meRater.addRating("3285", 6.0);
        meRater.addRating("1297", 2.0);
        meRater.addRating("5804", 8.0);
        
        otherRater.addRating("3285", 4.0);
        otherRater.addRating("1297", 7.0);
        otherRater.addRating("6574", 10.0);
        otherRater.addRating("2354", 9.0);
	}

	@Test
	@DisplayName("Test Rater with invalid format")
	void testRaterInvalidFormat() {
		assertThrows(NullPointerException.class, () -> new EfficientRater(null));
	}
	
	@Test
	@DisplayName("Test the results for the dotProduct method")
    void testDotProduct() {
        // Execute code under test
        double result = fourthRatings.dotProduct(meRater, otherRater);
        
        // Verify the result
        assertEquals(13.0, result);
        assertNotEquals(0, result);
	}
	
	@Test
	@DisplayName("Test illegal arguments for addRating method")
	void testFlightNumberInvalidFormat() {
		assertThrows(IllegalArgumentException.class, () -> {  // line 22-24 EfficientRater
			meRater.addRating("1234", -1.0);
			meRater.addRating(null, 5.0);
			otherRater.addRating("5678", -1.0);
			otherRater.addRating(null, 0);
		});
	}
}
