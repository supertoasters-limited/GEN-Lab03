public class Player {
    private String name;
    private Piece playerPiece;
    public void takeTurn(Die[] dice, Board board){
        int sum = 0;
        for(int i = 0; i < dice.length; i++){
            dice[i].roll();
            sum += dice[i].getFaceValue();
        }

        System.out.println("Player " + this + ": " + sum);
        Square oldLoc = playerPiece.getLocation();
        Square newLoc = board.getSquare(oldLoc, sum);
        playerPiece.setLocation(newLoc);
        System.out.println("Player " + this + ": " + newLoc);

    }

    public Player(Square pieceLocation, String name){
        this.name = name;
        this.playerPiece = new Piece(name, pieceLocation);
    }

    public String toString(){
        return name;
    }
}
