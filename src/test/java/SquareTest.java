import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class SquareTest {
    @Test
    public void aSquareShouldhaveAName(){
        Square square = new Square("ASuperSquare");
        assertNotNull(square);
        assertNotNull(square.getName());
    }

    @Test
    public void aSquareShouldHaveCorrectName(){
        final String SQUARE_NAME = "JAIL";
        Square square = new Square(SQUARE_NAME);
        assertEquals(square.getName(), SQUARE_NAME);
    }
}
