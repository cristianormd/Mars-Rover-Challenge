import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Contains test cases for Coordinate class
 * <p>
 * Created by crmdias on 10/06/2017.
 */
class CoordinateTest {
    @Test
    void equals() {
        assertEquals(new Coordinate(0, 0), new Coordinate(0, 0));
    }

}