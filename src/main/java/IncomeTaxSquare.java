import static java.lang.Math.min;

public class IncomeTaxSquare extends Square {

    public IncomeTaxSquare(String name){
        super(name);
    }

    public void landedOn(Player p){
        int w = p.getNetWorth();
        p.reduceCash(min(Math.floor(0.1 * w), 200));
    }
}
