import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {

    @Test
    void testPieceNameAndLocation() {
        Square jail = new RegularSquare("Jail");
        Piece red = new Piece("Red", jail);

        assertEquals(red.getName(), "Red");
        assertEquals(red.getLocation().getName(), "Jail");

        Square bank = new RegularSquare("Bank");
        red.setName("Pink");
        red.setLocation(bank);

        assertEquals(red.getName(), "Pink");
        assertEquals(red.getLocation().getName(), "Bank");
    }
}