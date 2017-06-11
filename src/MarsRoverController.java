import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.text.ParseException;

/**
 * Represents a Rover Controller, an entity that sends commands to rovers.
 *
 * Created by crmdias on 10/06/2017.
 */
public class MarsRoverController {

    /**
     * Parses input string and performs commands on rovers accordingly, printing their final position and orientation
     *
     * @param inStream stream that will receive the input. Input must be on the form
     *            "(int: plateauX) (int: plateauY)[\n(int: xpos) (int: ypos) (char: orientation)\n(str: commands)]"
     * @throws ParseException In case the input string is invalid
     * @throws IOException In case there is an error with writing or reading to one of the streams
     * @param outStream Stream where output containing in each line the final position and orientation of each rover
     *                  will be written
     */
    static void performBatchControl(InputStream inStream, OutputStream outStream) throws ParseException, IOException
    {
        //Scanner is slightly slower than bufferedReader but generates more readable code
        Scanner input = new Scanner(inStream);

        //We initialize the Plateau
        Plateau plateau;
        try {
            plateau = Plateau.fromString(input.nextLine());
        }catch(ParseException pe){
            throw new ParseException("Error parsing Plateau at line 1", 1);
        }
        //Then while there are rovers (lineIndex is only used for exceptions)
        for(int lineIndex=2; input.hasNextLine(); lineIndex++) {

            //Parse rover
            MarsRover rover;
            String line = "";
            try {
                line = input.nextLine();
                rover = MarsRover.fromString(line, plateau);
            }catch(ParseException pe){
                //if this is an empty line, input has stopped
                if(line.length() == 0)
                    return;
                throw new ParseException("Error parsing rover at line " + Integer.toString(lineIndex), lineIndex);
            }
            lineIndex++;

            Command[] commands;

            //Parse the commands
            if(input.hasNextLine()) {
                commands = Command.parseCommandSequence(input.nextLine());
            }
            else
                throw new ParseException("Rover does not have commands (expected at line " + Integer.toString(lineIndex) +")", lineIndex);

            //Run commands
            rover.runCommandBacth(commands);

            //Write result (we write a newline after the first output (after 2 input lines processed)
            if(lineIndex > 3)
                outStream.write(System.getProperty("line.separator").getBytes());

            outStream.write((rover.toString()).getBytes());
        }
    }

    /**
     * Parses input string and performs commands on rovers accordingly, printing their final position and orientation
     *
     * @param str input string on the form
     *            "(int: plateauX) (int: plateauY)[\n(int: xpos) (int: ypos) (char: orientation)\n(str: commands)]"
     * @throws ParseException In case the input string is invalid
     * @throws IOException if there is an error writing input or output
     * @return returns string containing in each line the final position and orientation of each rover
     */
    static String performBatchControl(String str) throws ParseException , IOException{
        //redirect input string to stream
        InputStream inStream = new ByteArrayInputStream(str.getBytes(StandardCharsets.US_ASCII));

        //get output stream
        OutputStream outStream = new ByteArrayOutputStream();

        performBatchControl(inStream, outStream);

        //transform output stream into string
        return outStream.toString();
    }

    /**
     * Entry point for application, can be used for solving the Mars Rover Problem.
     * User should provide input on the form
     *   "(int: plateauX) (int: plateauY)[\n(int: xpos) (int: ypos) (char: orientation)\n(str: commands)]"
     * @param args no argument used
     */
    public static void main(String[] args)
    {
        System.out.println("Please provide info on the form  " +
                "\"(int: plateauX) (int: plateauY)[\\n" +
                "(int: xpos) (int: ypos) (char: orientation)\\n(str: commands)]\" \n");

        try {
            performBatchControl(System.in, System.out);
        }
        catch(ParseException pe){
            System.out.println("Error parsing input at line " + pe.getErrorOffset() + ". Is it valid?\n" + pe.toString());
        }
        catch(IOException ie)
        {
            System.out.println("Internal error setting streams, please try again.");
        }
    }
}
