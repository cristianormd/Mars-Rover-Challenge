import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Contains tests regarding methods of the MarsRover class, in special restrainedMove, runCommand and fromString
 *
 * Created by crmdias on 10/06/2017.
 */
class MarsRoverTest {
    @Test
    void testRestrainedMoveInsideBounds(){
        //Arrange
        Plateau plateau = new Plateau(1,1);
        Coordinate roverCoordinate = new Coordinate(0,0);

        MarsRover rover = new MarsRover(roverCoordinate, Orientation.N, plateau);

        //Act
        rover.restrainedMove();

        //Assert
        assertEquals(rover.getPosition(),new Coordinate(0,1));
    }

    @Test
    void testRestrainedMoveOutsideBounds(){
        //Arrange
        Plateau plateau = new Plateau(1,1);
        Coordinate roverCoordinate = new Coordinate(0,1);

        MarsRover rover = new MarsRover(roverCoordinate, Orientation.N, plateau);

        //Act
        rover.restrainedMove();

        //Assert
        assertEquals(rover.getPosition(),new Coordinate(0,1));
    }

    @Test
    void testRunCommandRotation(){
        //Arrange
        Plateau plateau = new Plateau(1,1);
        Coordinate roverCoordinate = new Coordinate(0,1);

        MarsRover rover = new MarsRover(roverCoordinate, Orientation.N, plateau);

        //Act
        rover.runCommand(Command.Left);

        //Assert
        assertEquals(rover.getPosition(),new Coordinate(0,1));
        assertEquals(rover.getOrientation(),Orientation.W);
    }

    @Test
    void testFromString() throws ParseException{
        //Arrange
        Plateau plateau= new Plateau(1,1);

        String roverString = "0 1 N";
        Coordinate roverCoordinate = new Coordinate(0,2);

        MarsRover rover = new MarsRover(roverCoordinate, Orientation.N, plateau);
        MarsRover parsedRover;

        //Act
        parsedRover = MarsRover.fromString(roverString, plateau);

        //Assert
        assertEquals(parsedRover.getPosition(),rover.getPosition());
        assertEquals(parsedRover.getOrientation(),rover.getOrientation());
    }
}