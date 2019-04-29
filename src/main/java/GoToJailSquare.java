public class GoToJailSquare extends Square {
    public GoToJailSquare(String name) {
        super(name);
    }

    public void landedOn(Player p) {
        Square[] boardSquares = p.getBoard().getAllSquares();
        Square jail = boardSquares[Board.JAIL];
        p.getPlayerPiece().setLocation(jail);
    }
}

