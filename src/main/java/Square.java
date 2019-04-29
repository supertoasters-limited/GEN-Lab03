abstract class Square {

    private String name;

    public Square (String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.getName();
    }

    abstract void landedOn(Player p);
}