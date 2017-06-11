/**
 * Represents a Rover Controller, an entity that sends commands to rovers.
 *
 * Created by crmdias on 10/06/2017.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.text.ParseException;

public class MarsRoverController {

    /**
     * Parses input string and performs commands on rovers accordingly, printing their final position and orientation
     *
     * @param str input string on the form
     *            "(int: plateauX) (int: plateauY)[\n(int: xpos) (int: ypos) (char: orientation)\n(str: commands)]"
     * @throws ParseException In case the input string is invalid
     * @return returns string containing in each line the final position and orientation of each rover
     */
    static String performBatchControll(String str) throws ParseException {

        //Scanner is slightly slower than bufferedReader but generates more readable code
        Scanner input = new Scanner(str);

        //We initialize the Plateau
        Plateau plateau = Plateau.fromString(input.nextLine());

        String outputString = "";

        //Then while there are rovers (lineIndex is only used for exceptions)
        for(int lineIndex=1; input.hasNextLine(); lineIndex++) {

            //Parse rover
            MarsRover rover = MarsRover.fromString(input.nextLine(),plateau);
            lineIndex++;

            Command[] commands;

            //Parse the commands
            if(input.hasNextLine()) {
               commands = Command.parseCommandSequence(input.nextLine());
            }
            else
                throw new ParseException("A rover does not have commands (expected at line " + Integer.toString(lineIndex) +")", lineIndex);

            //Run commands
            rover.runCommandBacth(commands);
            outputString += rover.toString() + '\n';
        }
        if(outputString.length() > 0)
            outputString = outputString.substring(0,outputString.length()-1);
        return outputString;
    }

    public static void main(String[] args)
    {

    }
}
