public class Player {

    private String name;
    private Piece playerPiece;
    private Die[] dice;
    private Board board;

    public Player(Board board, Die[] dice, String name) {
        this.board = board;
        this.dice = dice;
        this.name = name;

        this.playerPiece = new Piece(name, this.board.getAllSquares()[Board.GO_SQUARE]);
    }

    public void takeTurn() {
        int fvTot = 0;

        /* Roll the dice and save the result */
        for(int i = 0; i < dice.length; i++){
            dice[i].roll();
            fvTot += dice[i].getFaceValue();
        }

        /* Display player and roll value */
        System.out.println(this + " rolled " + fvTot);
        Square oldLoc = playerPiece.getLocation();

        /* Display player and new location */
        Square newLoc = null;
        try {
            newLoc = board.getSquare(oldLoc, fvTot);
        } catch (Exception e) {
            e.printStackTrace();
        }
        playerPiece.setLocation(newLoc);
        System.out.println(this + " moves to " + newLoc);

    }

    public String toString(){
        return name;
    }
}
