import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

public class DieTest {

    Die die;

    @BeforeEach
    void init() {
        this.die = new Die();
    }

    @RepeatedTest(10)
    void testNewDie() {
        assertTrue(this.die.getFaceValue() <= Die.MAX);
        assertTrue(this.die.getFaceValue() >= Die.MIN);
    }

    @RepeatedTest(10)
    void testDieRoll() {
        this.die.roll();
        assertTrue(this.die.getFaceValue() <= Die.MAX);
        assertTrue(this.die.getFaceValue() >= Die.MIN);
    }
}
