import java.util.Random;

public class Die {

    public static final int MIN = 1;
    public static final int MAX = 6;
    private int faceValue;

    public Die() {
        this.roll();
    }

    public void roll() {
        Random r = new Random();
        this.faceValue = r.nextInt(MAX) + MIN;
    }

    public int getFaceValue() {
        return this.faceValue;
    }
}
