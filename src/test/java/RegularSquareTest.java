import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RegularSquareTest {
    @Test
    public void aSquareShouldhaveAName(){
        String squareName = "ASuperSquare";
        Square square = new RegularSquare(squareName);
        assertNotNull(squareName);
        assertNotNull(square.getName());
    }

    @Test
    public void aSquareShouldHaveCorrectName(){
        String squareName = "JAIL";
        Square square = new RegularSquare(squareName);
        assertEquals(square.getName(), squareName);
    }
}