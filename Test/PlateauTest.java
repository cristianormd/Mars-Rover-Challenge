import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Contains tests testing the methods from class Plateau, in special method contains
 * <p>
 * Created by crmdias on 10/06/2017.
 */
class PlateauTest {
    private Plateau plateau = new Plateau(10, 10);

    @Test
    void testContainsInnerLowerBound() {

        //Arrange
        Coordinate testCoordinate = new Coordinate(0, 0);

        //Act
        boolean contains = plateau.contains(testCoordinate);

        //Assert
        assertEquals(contains, true);
    }

    @Test
    void testContainsOuterHigherBound() {

        //Arrange
        Plateau plateau = new Plateau(10, 10);
        Coordinate outsideCorner = new Coordinate(11, 11);

        //Act
        boolean isOutsideCorner = plateau.contains(outsideCorner);

        //Assert
        assertEquals(isOutsideCorner, false);
    }


    @Test
    void testContainsInnerHigherBound() {
        //Arrange
        Plateau plateau = new Plateau(10, 10);
        Coordinate outsideCorner = new Coordinate(10, 10);

        //Act
        boolean isOutsideCorner = plateau.contains(outsideCorner);

        //Assert
        assertEquals(isOutsideCorner, true);
    }

    @Test
    void testPlateuFromString() throws ParseException {
        //Arrange
        Plateau plateau = new Plateau(10, 10);
        String str = "10 10";

        //Act
        Plateau parsedPlateau = Plateau.fromString(str);

        //Assert
        assertEquals(parsedPlateau, plateau);
    }
}
