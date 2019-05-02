import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cup {

    private List<Die> dice = new ArrayList<>();

    public Cup(Die[] dice) {
        this.dice = Arrays.asList(dice);
    }

    /* Needed for the tests */
    public Cup(Die die) {
        this.dice.add(die);
    }

    public void roll() {
        for (Die die : this.dice) {
            die.roll();
        }
    }

    public int getTotal() {
        int total = 0;

        for (Die die : this.dice) {
            total += die.getFaceValue();
        }

        return total;
    }
}
