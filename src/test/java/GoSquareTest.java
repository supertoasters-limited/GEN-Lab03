import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class GoSquareTest {

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

        this.player = new Player(this.board, this.gameDices, "Jean-Michel");
        this.allSquare = board.getAllSquares();
    }

    @Test
    public void initialSquareShouldBeGoSquare() {
        assertEquals(this.player.getPlayerPiece().getLocation(), this.allSquare[Board.GO_SQUARE]);
    }

    @Test
    public void playerShouldReceive200MoneyWhenLandedOnGoSquare() throws Exception {
        // player on Go square
        int amountBeforeGo = player.getNetWorth();

        // player on square 25
        Square newLoc = board.getSquare(player.getPlayerPiece().getLocation(), 25);
        newLoc.landedOn(player);

        // player on Go square (+ 1 round)
        newLoc = board.getSquare(player.getPlayerPiece().getLocation(), 15);
        newLoc.landedOn(player);


        assertTrue(200 == (player.getNetWorth() - amountBeforeGo));
    }
}