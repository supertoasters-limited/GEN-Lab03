public class Board {

    final public static int NB_SQUARE = 40;
    final public static int GO_SQUARE = 0;
    private Square[] allSquares = new Square[40];

    public Board(){
        for(int i = 0; i < NB_SQUARE; i++){
            if(i == GO_SQUARE){
                allSquares[i] = new Square("Go");
            }
            else {
                allSquares[i] = new Square("Square "+ i);
            }
        }
    }

    public Square[] getAllSquares() {
        return allSquares.clone();
    }

    public Square getSquare(Square location, int offset) throws Exception{
        if(offset <= -Board.NB_SQUARE || offset >= Board.NB_SQUARE){
            throw new Exception("Offset must be between " + (-Board.NB_SQUARE) +
                    "-"+Board.NB_SQUARE);
        }

        Square result = new Square("Error");
        for(int i = 0; i < NB_SQUARE; i++){
            if(allSquares[i] == location){

                int tmp = i+offset;

                if(tmp < 0){
                    tmp += Board.NB_SQUARE;
                }

                result = allSquares[tmp % NB_SQUARE];
                break;
            }
        }
        return result;
    }

    public Square[] getAllSquares() {
        return allSquares.clone();
    }
}
