public class Player {

    private Board board;
    private String name;
    private Piece playerPiece;
    private int cash = 1500;
    private Die[] dice;
    private Cup cup;

    public Player(Board board, Die[] dice, String name) {
        this.board = board;
        this.name = name;
        this.playerPiece = new Piece(name, this.board.getAllSquares()[Board.GO_SQUARE]);
        this.dice = dice;
        this.cup = new Cup(this.dice);
    }

    public void takeTurn() throws Exception {
        int fvTot = 0;

        /* Roll the dice and save the result */
        this.cup.roll();
        fvTot = this.cup.getTotal();

        /* Display player and roll value */
        System.out.println(this + " rolled " + fvTot);
        Square oldLoc = this.playerPiece.getLocation();

        /* Display player and new location */
        Square newLoc = this.board.getSquare(oldLoc, fvTot);
        newLoc.landedOn(this);
        System.out.println(this + " moves to " + newLoc + " and has now : " + this.getNetWorth());

    }

    public String toString() {
        return this.name;
    }

    public int getNetWorth() {
        return this.cash;
    }
    
    public void addCash(int cash){
        this.cash += cash;
    }

    public void reduceCash(int cash) {
        this.cash -= cash;

        if (this.cash < 0) {
            this.cash = 0;
        }
    }

    public void setLocation(Square location) {
        this.playerPiece.setLocation(location);
    }

    /* Needed for the tests */
    public Board getBoard() {
        return this.board;
    }

    /* Needed for the tests */
    public Piece getPlayerPiece() {
        return this.playerPiece;
    }

    /* Needed for the tests */
    public String getName() {
        return this.name;
    }

    /* Needed for the tests */
    public Die[] getDice() {
        return this.dice;
    }
}
