import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;


public class MonopolyGameTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, Integer.MIN_VALUE, 1})
    void theGameShouldntBePlayableByLessThanTwoPlayers(int value) {
        assertThrows(Exception.class, () -> new MonopolyGame(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6, 7, 8})
    void theGameShoulBePlayableByTwoToEightPlayers(int value) {
        try {
            new MonopolyGame(value);
        } catch (Exception e) {
            fail();
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {99, 100, 9, Integer.MAX_VALUE})
    void theGameShouldntBePlayableByMoreThanTwoPlayers(int value) {
        assertThrows(Exception.class, () -> new MonopolyGame(value));
    }
}
