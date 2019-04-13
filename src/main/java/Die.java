import java.util.Random;

public class Die {

    static final int MIN = 1;
    static final int MAX = 6;
    private int faceValue;

    Die() {
        this.roll();
    }

    public void roll() {
        Random r = new Random();
        this.faceValue = r.nextInt(MAX) + MIN;
    }

    public int getFaceValue() {
        return faceValue;
    }
}
