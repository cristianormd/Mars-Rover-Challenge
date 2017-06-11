/**
 * Represents a two dimensional coordinate
 * <p>
 * Created by crmdias on 08/06/2017.
 */

public class Coordinate {
    private int x;
    private int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    /**
     * Adds the given coordinate to this coordinate
     *
     * @param c the coordinate to be added
     */
    void add(Coordinate c) {
        this.x += c.x;
        this.y += c.y;
    }

    @Override
    public String toString() {
        return Integer.toString(x) + "," + Integer.toString(y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Coordinate.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Coordinate other = (Coordinate) obj;

        return this.x == other.x && this.y == other.y;
    }
}
