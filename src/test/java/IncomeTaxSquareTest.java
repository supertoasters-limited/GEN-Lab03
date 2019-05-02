import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IncomeTaxSquareTest {

    private Board board;
    private Player player;
    private Square[] allSquare;
    private Die[] gameDices;


    @BeforeEach
    public void init() {
        this.board = new Board();

        gameDices = new Die[MonopolyGame.NB_DICE];

        for (int i = 0; i < MonopolyGame.NB_DICE; i++) {
            gameDices[i] = new Die();
        }

        this.player = new Player(this.board, this.gameDices, "Pierre-Philipe");
        this.allSquare = board.getAllSquares();
    }

    @Test
    public void aBoardShouldNotBeNull() {
        assertNotNull(this.board);
    }


    @Test
    public void aBoardShouldInitialiseAllItsSquare() {
        assertNotNull(this.allSquare);

        for (int i = 0; i < Board.NB_SQUARE; ++i) {
            assertNotNull(this.allSquare[i]);
        }
    }

    @Test
    public void allSquareShouldHaveCorrectSize() {
        assertEquals(this.allSquare.length, Board.NB_SQUARE);
    }

    @Test
    public void initialSquareShouldBeGoSquare() {
        assertEquals(this.player.getPlayerPiece().getLocation(), this.allSquare[Board.GO_SQUARE]);
    }


    @Test
    public void playerShouldBeIncomeTaxedWhenLandedOnIncomeTaxSquare() throws Exception {
        // player on Go square
        int amountBeforeGo = player.getNetWorth();
        int amountIncomeTaxed = amountBeforeGo - (int) Math.floor(amountBeforeGo * 0.1);

        // player on square 4
        Square newLoc = board.getSquare(player.getPlayerPiece().getLocation(), Board.INCOME_TAX);
        newLoc.landedOn(player);


        assertTrue(amountIncomeTaxed == player.getNetWorth());
    }
}