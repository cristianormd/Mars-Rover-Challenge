import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Controls test cases for class Command
 * <p>
 * Created by crmdias on 11/06/2017.
 */
class CommandTest {
    @Test
    void parseCommandSequence() {
        //Arrange
        String commandsString = "LRMLRM";
        Command[] expectedArray = {Command.Left, Command.Right, Command.Move, Command.Left, Command.Right, Command.Move};


        Command[] commandsArray = null;
        //Act
        try {
            commandsArray = Command.parseCommandSequence(commandsString);
        } catch (ParseException e) {
        }

        //Assert
        assertArrayEquals(commandsArray, expectedArray);
    }

}