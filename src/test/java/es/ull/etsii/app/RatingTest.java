package es.ull.etsii.app;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import es.ull.etsii.app.Rating;


class RatingTest {
  
  Rating rating1;
  Rating rating2;

  @BeforeEach
  void setUp() {
    rating1 = new Rating("item1", 5.0);
    rating2 = new Rating("item2", 8.0);
  }

  @Test
  @DisplayName("Test the results for the getItem method")
  void testGetItem() {
    // Execute code under test
    String result1 = rating1.getItem();
    String result2 = rating2.getItem();
    
    assertEquals("item1", result1);
    assertEquals("item2", result2);
  }

  @Test
  @DisplayName("Test the results for the getValue method")
  void testGetValue() {
    
    double result1 = rating1.getValue();
    double result2 = rating2.getValue();
    
    assertEquals(5.0, result1);
    assertEquals(8.0, result2);
  }

  @Test
  @DisplayName("Test the results for the toString method")
  void testToString() {
    // Execute code under test
    String result1 = rating1.toString();
    String result2 = rating2.toString();
    
    // Verify the result
    assertEquals("[item1, 5.0]", result1);
    assertEquals("[item2, 8.0]", result2);
  }

  @Test
  @DisplayName("Test the results for the compareTo method")
  void testCompareTo() {
    assertEquals(-1, rating1.compareTo(rating2));
    assertEquals(1, rating2.compareTo(rating1));
  }

}
