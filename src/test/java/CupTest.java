import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CupTest {

    @Test
    public void aCupShouldRollDiceInIt() {
        Die[] dice = new Die[2];
        Cup cup = new Cup(dice);
    }
}
