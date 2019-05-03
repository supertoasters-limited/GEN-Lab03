import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private final static int STARTING_CASH = 1500;
    private final static int NB_OF_DICE = 2;
    private Player player;
    private Board board;
    private Die[] dice;
    private String name;

    @BeforeEach
    public void init() {
        this.board = new Board();
        this.dice = new Die[NB_OF_DICE];
        for (int i = 0; i < this.dice.length; ++i) {
            this.dice[i] = new Die();
        }
        this.name = "Joker";
        this.player = new Player(this.board, this.dice, this.name);

    }

    @Test
    public void thePlayerShouldHaveTheCorrectName() {
        assertEquals(this.player.getName(), this.name);
    }

    @Test
    public void thePlayerShouldPlayOnTheCorrectBoard() {
        assertEquals(this.player.getBoard(), this.board);
    }

    @Test
    public void thePlayerShouldHaveTheCorrectNumberOfDice() {
        assertArrayEquals(this.dice, this.player.getDice());
    }

    @Test
    public void thePlayerShouldHaveAStartingLocation() {
        assertNotNull(this.player.getPlayerPiece());
    }

    @Test
    public void thePlayerShouldPlayHisTurnCorrectly() throws Exception {
        Square oldLoc = this.player.getPlayerPiece().getLocation();
        this.player.takeTurn();

        /* Retrieve dice values and new location */
        int fv = 0;
        for (int i = 0; i < this.player.getDice().length; ++i) {
            fv += this.player.getDice()[i].getFaceValue();
        }
        Square newLoc = this.player.getPlayerPiece().getLocation();

        assertEquals(newLoc, this.board.getSquare(oldLoc, fv));
    }

    @Test
    public void weShouldBeAbleToGetAPlayerNetWorth() {
        assertEquals(this.player.getNetWorth(), STARTING_CASH);
    }

    @Test
    public void weShouldBeAbleToAddCashToAPlayer() {
        int money = 42;
        this.player.addCash(money);

        assertEquals(this.player.getNetWorth(), STARTING_CASH + money);
    }

    @Test
    public void weShouldBeAbleToReduceCashFromAPlayer() {
        int startingAmount = 100;
        int amountToRemove = 60;
        this.player.setCash(startingAmount);
        this.player.reduceCash(amountToRemove);

        /* Positive result */
        assertEquals(this.player.getNetWorth(), startingAmount - amountToRemove);

        this.player.reduceCash(amountToRemove);

        /* Negative result should not be possible */
        assertTrue(this.player.getNetWorth() >= 0);
    }

    @Test
    public void weShouldBeAbleToSetPlayerLocation() {
        Square heig = new RegularSquare("HEIG-VD");
        this.player.setLocation(heig);

        assertEquals(this.player.getPlayerPiece().getLocation(), heig);
    }
}
