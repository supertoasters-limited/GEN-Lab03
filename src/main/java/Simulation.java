/*
 * Starting point of the program
 */
public class Simulation {

    public static void main(String[] args) {
        final int NB_PLAYER = 2;

        try {
            MonopolyGame currentGame = new MonopolyGame(NB_PLAYER);
            currentGame.playGame();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
