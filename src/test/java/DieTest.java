import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.*;

public class DieTest {

    @RepeatedTest(20)
    void testRollDie(){
        Die myDie = new Die();
        assertTrue(myDie.getFaceValue() <= Die.MAX);
        assertTrue(myDie.getFaceValue() >= Die.MIN);
    }
}
