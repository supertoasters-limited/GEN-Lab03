import java.util.Arrays;
import java.util.List;

public class Cup {

    private List<Die> dice;

    public Cup(Die[] dice) {
        this.dice = Arrays.asList(dice);
    }

    public void roll() {
        for (Die die : dice) {
            die.roll();
        }
    }

    public int getTotal() {
        int total = 0;

        for (Die die : dice) {
            total += die.getFaceValue();
        }

        return total;
    }
}
