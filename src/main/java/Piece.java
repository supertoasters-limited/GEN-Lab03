public class Piece {

    private String name;
    private Square location;

    public Piece(String name, Square location) {
        this.name = name;
        this.location = location;
    }

    public Square getLocation() {
        return this.location;
    }

    public void setLocation(Square newLocation) {
        this.location = newLocation;
    }

    /* Needed for the tests */
    public String getName() {
        return this.name;
    }
}