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

    public Square getSquare(Square location, int offset) {
        Square result = new Square("Error");
        for(int i = 0; i < NB_SQUARE; i++){
            if(allSquares[i] == location){
                result = allSquares[(i+offset) % NB_SQUARE];
                break;
            }
        }
        return result;
    }

    public Square[] getAllSquares() {
        return allSquares.clone();
    }
}
