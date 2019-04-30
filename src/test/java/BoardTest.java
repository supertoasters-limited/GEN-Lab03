import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;
    private Square[] allSquare;



    @BeforeEach
    public void init(){
        this.board = new Board();
        this.allSquare = board.getAllSquares();
    }

    @Test
    public void aBoardShouldNotBeNull(){
        assertNotNull(this.board);
    }


    @Test
    public void aBoardShouldInitialiseAllItsSquare(){
        assertNotNull(this.allSquare);

        for (int i = 0; i < Board.NB_SQUARE  ; ++i){
            assertNotNull(this.allSquare[i]);
        }
    }


    @Test
    public void allSquareShouldHaveCorrectSize(){
        assertEquals(this.allSquare.length, Board.NB_SQUARE);
    }


    @Test
    public void GoSquareBoardShouldHaveCorrectName(){
        String goSquareName = "Go";
        assertEquals(this.allSquare[Board.GO_SQUARE].getName(), goSquareName);
    }

    @Test
    public void IncomeTaxSquareBoardShouldHaveCorrectName(){
        String goSquareName = "Income Tax";
        assertEquals(this.allSquare[Board.INCOME_TAX].getName(), goSquareName);
    }

    @Test
    public void JailSquareBoardShouldHaveCorrectName(){
        String goSquareName = "Jail";
        assertEquals(this.allSquare[Board.JAIL].getName(), goSquareName);
    }

    @Test
    public void GoToJailSquareBoardShouldHaveCorrectName(){
        String goSquareName = "Go To Jail";
        assertEquals(this.allSquare[Board.GO_TO_JAIL].getName(), goSquareName);
    }


    @Test
    public void OtherSquareBoardShouldHaveCorrectName(){
        String squareName = "Square ";
        for (int i = 1; i < Board.NB_SQUARE  ; ++i){
            if(i != 4 && i != 10 && i != 30){
                assertEquals(this.allSquare[i].getName(), squareName + i);
            }

        }
    }



    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10, 39})
    public void getSquareShouldGiveCorrespondingSquareWithPositiveValue(int value){

        Square square = this.allSquare[Board.GO_SQUARE];

        try {
            square = board.getSquare(square, value);
        } catch (Exception e) {
            e.printStackTrace();
        }


        assertEquals(square,this.allSquare[value % Board.NB_SQUARE]);

    }


    @ParameterizedTest
    @ValueSource(ints = {-3, -5, -10, -39})
    public void getSquareShouldGiveCorrespondingSquareWithNegativeValue(int value){

        Square square = this.allSquare[Board.GO_SQUARE];

        try {
            square = board.getSquare(square, value);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // stay in the group Z40
        value +=  Board.NB_SQUARE;

        assertEquals(square,this.allSquare[value]);

    }



    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -80, 78, Integer.MAX_VALUE})
    public void getSquareShouldGiveCorrespondingSquareWithExtremValue(int value){

        final Square square = this.allSquare[Board.GO_SQUARE];


        Exception thrown =
                assertThrows(Exception.class, ()->{
                    board.getSquare(square, value);
                });

        assertTrue(thrown.getMessage().contains("Offset must be between " + (-Board.NB_SQUARE) +
                "-"+Board.NB_SQUARE));
    }
}

