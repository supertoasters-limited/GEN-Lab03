import static java.lang.Math.min;

public class IncomeTaxSquare extends Square {
    public IncomeTaxSquare(String name){
        super(name);
    }
    public void landedOn(Player p){
        Double w = p.getNetWorth();
        Double min = min(0.1 * w, 200);
        p.reduceCash(min);
    }
}
