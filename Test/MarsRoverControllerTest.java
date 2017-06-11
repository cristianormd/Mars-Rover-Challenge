import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests MarsRoverController's only method, which is the performBatchControl method,
 * the actual solution to Bearch's Code Challenge Mars Rover Problem
 *
 * Created by crmdias on 11/06/2017.
 */
class MarsRoverControllerTest {

    @Test
    void testControlMarsRovers() throws ParseException, IOException{
        //Arrange
        String input =
                "5 5" + System.getProperty("line.separator")+
                "1 2 N" + System.getProperty("line.separator")+
                "LMLMLMLMM" + System.getProperty("line.separator") +
                "3 3 E" + System.getProperty("line.separator") +
                "MMRMMRMRRM";

        String expectedOutput =
                "1 3 N" + System.getProperty("line.separator") +
                "5 1 E";

        InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(stream);

        //Act
        String out = MarsRoverController.performBatchControl(input);

        //Assert
        assertEquals(expectedOutput, out);
    }

}