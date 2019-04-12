public class Simulation {

    public static void main(String[] args) {

        try {
            MonopolyGame currentGame = new MonopolyGame(2);
            currentGame.playGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
