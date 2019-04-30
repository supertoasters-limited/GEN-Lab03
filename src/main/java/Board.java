public class Board {

    final public static int NB_SQUARE = 40;
    final public static int GO_SQUARE = 0;
    final public static int INCOME_TAX = 4;
    final public static int JAIL = 10;
    final public static int GO_TO_JAIL = 30;

    private Square[] allSquares = new Square[40];

    public Board() {
        for (int i = 0; i < NB_SQUARE; i++) {
            switch (i) {
                case GO_SQUARE:
                    allSquares[i] = new GoSquare("Go");
                    break;
                case INCOME_TAX:
                    allSquares[i] = new IncomeTaxSquare("Income Tax");
                    break;
                case JAIL:
                    allSquares[i] = new RegularSquare("Jail");
                    break;
                case GO_TO_JAIL:
                    allSquares[i] = new GoToJailSquare("Go To Jail");
                    break;
                default:
                    allSquares[i] = new RegularSquare("Square " + i);
                    break;
            }
        }
    }

    public Square getSquare(Square location, int offset) throws Exception{
        if(offset <= -Board.NB_SQUARE || offset >= Board.NB_SQUARE){
            throw new Exception("Offset must be between " + (-Board.NB_SQUARE) +
                    "-"+Board.NB_SQUARE);
        }


        Square result = new RegularSquare("Error");
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
