import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {

    private Piece piece;
    private Square location;

    @BeforeEach
    void init() {
        this.location = new RegularSquare("Bank");
        this.piece = new Piece("Pion", this.location);
    }

    @Test
    void weShouldBeAbleToGetAPieceLocation() {
        assertEquals(this.piece.getLocation(), this.location);
    }

    @Test
    void weShouldBeAbleToSetAPieceLocation() {
        Square supermarket = new RegularSquare("Supermarket");
        this.piece.setLocation(supermarket);

        assertEquals(this.piece.getLocation(), supermarket);
    }

    @Test
    void aPlayerShouldHaveTheRightName() {
        assertEquals(this.piece.getName(), "Pion");
    }
}