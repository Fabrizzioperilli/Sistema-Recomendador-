package es.ull.etsii.app;

import es.ull.etsii.app.PlainRater;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class PlainRaterTest {

  PlainRater plainRater;

  @BeforeEach
  void setUp() {
    plainRater = new PlainRater("15");
  }

  @Test
  @DisplayName("Test the results for the addRating method")
  void testAddRating() {
    plainRater.addRating("1234", 5.0);
    plainRater.addRating("5678", 8.0);
    assertEquals(2, plainRater.numRatings());
  }
}
