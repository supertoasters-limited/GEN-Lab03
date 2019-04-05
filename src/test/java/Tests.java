import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    @Test
    public void testPieceName() {
        Piece bruno = new Piece("Bruno");

        assertEquals(bruno.getName(), "Bruno");
    }

}
