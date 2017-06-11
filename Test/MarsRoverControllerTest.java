import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests MarsRoverController's only method, which is the performBatchControll method,
 * the solution to Bearch's Code Challenge Mars Rover Problem
 *
 * Created by crmdias on 11/06/2017.
 */
class MarsRoverControllerTest {

    @Test
    void testMain() throws ParseException{
        //Arrange
        String input =
                "5 5\n" +
                "1 2 N\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MMRMMRMRRM";

        String expectedOutput =
                "1 3 N\n" +
                "5 1 E";

        InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(stream);

        //Act
        String out = MarsRoverController.performBatchControll(input);

        //Assert
        assertEquals(expectedOutput, out);
    }

}