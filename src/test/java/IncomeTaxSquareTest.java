import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IncomeTaxSquareTest {

    private Board board;
    private Player player;

    @BeforeEach
    public void init() {
        this.board = new Board();

        Die[] gameDices = new Die[MonopolyGame.NB_DICE];

        for (int i = 0; i < MonopolyGame.NB_DICE; i++) {
            gameDices[i] = new Die();
        }

        this.player = new Player(this.board, gameDices, "Pierre-Philipe");
    }

    @Test
    public void playerShouldBeIncomeTaxedWhenLandedOnIncomeTaxSquare() throws Exception {
        // player on Go square
        int amountBeforeGo = player.getNetWorth();
        int amountIncomeTaxed = amountBeforeGo - (int) Math.floor(amountBeforeGo * 0.1);

        // player on square 4
        Square newLoc = board.getSquare(player.getPlayerPiece().getLocation(), Board.INCOME_TAX);
        newLoc.landedOn(player);


        assertEquals(amountIncomeTaxed, player.getNetWorth());
    }
}