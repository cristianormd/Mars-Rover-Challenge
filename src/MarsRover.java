import java.text.ParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by crmdias on 08/06/2017.
 */
public class MarsRover {

    private Orientation orientation;
    private Coordinate position;
    private Plateau plateau;

    MarsRover(Coordinate position, Orientation orientation, Plateau plateau)
    {
        this.position = position;
        this.orientation = orientation;
        this.plateau = plateau;
    }

    Coordinate getPosition() {
        return position;
    }

    Orientation getOrientation() {
        return orientation;
    }

    /**
     * Runs all given commands in series
     * @param commands The sequence of commands to be performed
     */
    void runCommandBacth(Command[] commands) {
        for( Command command : commands)
            runCommand(command);
    }

    /**
     * Runs a given received command
     * @param command The command to be executed
     */
    void runCommand(Command command) {
        switch(command)
        {
            case Left:
                this.orientation = orientation.rotateLeft();
                break;
            case Right:
                this.orientation = orientation.rotateRight();
                break;
            case Move:
                this.restrainedMove();
                break;
        }
    }

    /**
     * Moves the rover in its current orientation by 1 unit, respecting the limits of the Plateau it`s in
     */
    void restrainedMove() {
        Coordinate moved = new Coordinate(this.position.getX(),this.position.getY());

        moved.add(this.orientation.vector);

        //Only updates to moved position if inside plateau
        if(this.plateau.contains(moved))
            this.position = moved;
    }

    /**
     * Creates MarsRover object given string representation and a plateau
     *
     * @param str partial String representation of the rover on form "(int: xpos) (int: ypos) (char: orientation)"
     * @param plateau Plateau where the rover is located
     * @return A properly initialized Mars Rover
     * @throws ParseException if the string is not a valid representation of a mars rover
     */
    static MarsRover fromString(String str, Plateau plateau) throws ParseException
    {
        Scanner input = new Scanner(str);
        int offset = 0;
        MarsRover rover;
        try {
            //parse xpos
            int roverX = input.nextInt();
            offset++;
            //parse ypos
            int roverY = input.nextInt();
            offset++;

            Coordinate roverPosition = new Coordinate(roverX, roverY);

            //parse orientation
            String orientationString = input.next();
            offset++;
            rover = new MarsRover(roverPosition, Orientation.valueOf(orientationString), plateau);
        }
        catch(NoSuchElementException nse) {
            throw new ParseException("Invalid string parsing MarsRover", offset);
        }

        return rover;
    }

    @Override
    public String toString() {
        return this.position.getX() + " " + this.position.getY() + " " + this.orientation.toString();
    }
}
