public class GoToJailSquare extends Square {

    public GoToJailSquare(String name) {
        super(name);
    }

    public void landedOn(Player p) {
        p.setLocation(p.getBoard().getAllSquares()[Board.JAIL]);
    }
}

