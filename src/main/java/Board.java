public class Board {

    final public static int nbSquare = 40;
    private Square[] allSquares = new Square[40];

    public Board(){
        for(int i = 0; i < nbSquare; i++){
            if(i == 0){
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

    public Square getSquare(Square location, int offset){
        Square result = new Square("Error");
        for(int i = 0; i < nbSquare; i++){
            if(allSquares[i] == location){
                result = allSquares[(i+offset) % nbSquare];
                break;
            }
        }
        return result;
    }
}
