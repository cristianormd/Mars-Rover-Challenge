/**
 * Represents a generic orientation
 *
 * Created by crmdias on 08/06/2017.
 */
public enum Orientation {

    N(0,1){

        Orientation rotateLeft(){
            return W;
        }
        Orientation rotateRight(){
            return E;
        }
    },

    E(1,0) {

        Orientation rotateLeft(){
            return N;
        }
        Orientation rotateRight(){
            return S;
        }
    },

    S(0,-1){

        Orientation rotateLeft(){
            return E;
        }
        Orientation rotateRight(){
            return W;
        }
    },
    W(-1,0){

        Orientation rotateLeft() {
            return S;
        }
        Orientation rotateRight(){
            return N;
        }
    };

    final Coordinate vector;

    Orientation(int x, int y) {

        this.vector = new Coordinate(x,y);
    }

    abstract Orientation rotateLeft();
    abstract Orientation rotateRight();
}
