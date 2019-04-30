import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CupTest {

    @Test
    public void aCupShouldRollTheDiceInIt() {
        Die die = new Die();
        Cup cup = new Cup(die);
        int value = die.getFaceValue();

        while(value == die.getFaceValue()) {
            cup.roll();
        }

        assertNotEquals(value, die.getFaceValue());
    }

    @Test
    public void weShouldGetTotalFacesValuesOfDiceInACup() {
        int total;

        Die[] dice = new Die[2];
        for (int i = 0; i < dice.length; ++i) {
            dice[i] = new Die();
        }
        Cup cup = new Cup(dice);

        total = cup.getTotal();

        assertNotNull(total);

    }
}
