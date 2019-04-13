import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class SquareTest {
    @Test
    public void aSquareShouldhaveAName(){
        String squareName = "ASuperSquare";
        Square square = new Square(squareName);
        assertNotNull(squareName);
        assertNotNull(square.getName());
    }

    @Test
    public void aSquareShouldHaveCorrectName(){
        String squareName = "JAIL";
        Square square = new Square(squareName);
        assertEquals(square.getName(), squareName);
    }
}