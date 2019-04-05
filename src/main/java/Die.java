import java.util.Random;

public class Die {
    static final int MIN = 1;
    static final int MAX = 6;

    Die(){
        this.roll();
    }
    private int faceValue;
    public void roll(){
        Random r = new Random();
        this.faceValue = r.nextInt(MAX) + MIN;
    }

    public int getFaceValue() {
        return faceValue;
    }
}
