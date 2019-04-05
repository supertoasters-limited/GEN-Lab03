import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {

    @Test
    void testPieceNameAndLocation() {
        Square jail = new Square("Jail");
        Piece red = new Piece("Red", jail);

        assertEquals(red.getName(), "Red");
        assertEquals(red.getLocation().getName(), "Jail");

        Square bank = new Square("Bank");
        red.setName("Pink");
        red.setLocation(bank);

        assertEquals(red.getName(), "Pink");
        assertEquals(red.getLocation().getName(), "Bank");
    }
}