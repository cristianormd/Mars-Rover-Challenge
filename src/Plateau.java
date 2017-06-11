import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.NoSuchElementException;
import java.util.Scanner;

import java.security.InvalidParameterException;
import java.text.ParseException;

/**
 * This class represents a plateau on the surface of Mars, curiously rectangular and aligned with the poles.
 *
 *
 * Created by crmdias on 08/06/2017.
 */
class Plateau {

    private int x;
    private int y;

    Plateau(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Plateau cant have negative delimiters");
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Creates Plateau object given string representation
     *
     * @param str A string representation of a Plateau on form "(int: inclusiveXBound) (int: inclusiveYBound)"
     * @return A properly initialized Plateau
     * @throws ParseException if the string is not a valid representation of a Plateau
     */
    static Plateau fromString(String str) throws ParseException
    {
        Scanner input = new Scanner(str);
        int offset = 0;
        Plateau plateau;
        try {
            //parse plateau x
            int plateauX= input.nextInt();
            offset++;
            //parse ypos
            int plateauY = input.nextInt();
            offset++;

            plateau = new Plateau(plateauX, plateauY);
        }
        catch(NoSuchElementException nse) {
            throw new ParseException("Invalid string parsing Plateau", offset);
        }

        return plateau;
    }

    /**
     * Verifies if a coordinate is inside the Plateau
     *
     * @param coordinate the coordinate we are checking
     * @return true if its in the plateau, false otherwise
     */
    boolean contains(Coordinate coordinate) {
        return coordinate.getX() >=0 && coordinate.getX() <= this.x && coordinate.getY() >=0 && coordinate.getY() <= this.y;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Plateau.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Plateau other = (Plateau) obj;

        return this.x == other.x && this.y == other.y;
    }
}
