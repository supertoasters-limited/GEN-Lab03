public class Piece {
    private String name;
    private Square location;

    public Piece(String name, Square location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Square getLocation() {
        return this.location;
    }

    public void setLocation(Square newLocation) {
        this.location = newLocation;
    }
}