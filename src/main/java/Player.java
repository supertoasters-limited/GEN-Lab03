public class Player {

    private Board board;
    private Die[] dice;
    private String name;
    private Piece playerPiece;

    private Double cash = 1500.0;

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
        Square newLoc = board.getSquare(oldLoc, fvTot);
        playerPiece.setLocation(newLoc);
        newLoc.landedOn(this);
        System.out.println(this + " moves to " + newLoc + " and has now : " + this.getNetWorth());

    }

    public String toString() {
        return name;
    }

    /* Needed for the tests */
    public Die[] getDice() {
        return dice;
    }

    /* Needed for the tests */
    public Board getBoard() {
        return board;
    }

    /* Needed for the tests */
    public Piece getPlayerPiece() {
        return playerPiece;
    }

    /* Needed for the tests */
    public String getName() {
        return name;
    }

    public Double getNetWorth() {
        return cash;
    }
    
    public void addCash(Double cash){
        this.cash += cash;
    }

    public void reduceCash(Double cash){
        this.cash -= cash;
    }
}
