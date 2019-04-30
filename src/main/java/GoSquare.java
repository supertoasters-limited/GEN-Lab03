public class GoSquare extends Square {

    public GoSquare(String name){
        super(name);
    }

    public void landedOn(Player p){
        p.addCash(200.0);
        p.setLocation(this);
    }
}
