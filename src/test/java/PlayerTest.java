import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void thePlayerShouldHaveTheCorrectName() {
        String joker = "Joker";
        Player jokerPlayer = new Player(new Board(), new Die[2], joker);

        assertEquals(jokerPlayer.getName(), joker);
    }

    @Test
    public void thePlayerShouldPlayOnTheCorrectBoard() {
        Board board = new Board();
        Player superman = new Player(board, new Die[2], "Superman");

        assertEquals(superman.getBoard(), board);
    }

    @Test
    public void thePlayerShouldHaveTwoDice() {
        Die[] dice = new Die[2];
        Player ironman = new Player(new Board(), dice, "Iron Man");

        assertArrayEquals(dice, ironman.getDice());
    }

    @Test
    public void thePlayerShouldHaveAStartingLocation() {
        Player antman = new Player(new Board(), new Die[2], "Ant Man");

        assertNotNull(antman.getPlayerPiece());
    }

    @Test
    public void thePlayerShouldPlayHisTurnCorrectly() {

        Die yin = new Die();
        Die yang = new Die();
        Die[] dice = {yin, yang};
        Board board = new Board();

        Player batman = new Player(board, dice, "Batman");

        Square oldLoc = batman.getPlayerPiece().getLocation();
        batman.takeTurn();

        /* Retrieve dice values and new location */
        int fv = 0;
        for (int i = 0; i < batman.getDice().length; ++i) {
            fv += batman.getDice()[i].getFaceValue();
        }
        Square newLoc = batman.getPlayerPiece().getLocation();

        assertEquals(newLoc, board.getSquare(oldLoc, fv));
    }



}
