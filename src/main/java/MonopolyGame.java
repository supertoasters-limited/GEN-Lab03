public class MonopolyGame {

    public final static int NB_ROUND = 20;
    public final static int NB_DICE = 2;
    public final static int NB_PLAYER_MIN = 2;
    public final static int NB_PLAYER_MAX = 8;

    private Board gameBoard;
    private Die[] gameDices;
    private Player[] gamePlayers;

    public void playGame() throws Exception {
        for (int i = 0; i < NB_ROUND; i++) {
            System.out.println("ROUND " + (i + 1));
            playRound();
            System.out.println();
        }
    }

    public MonopolyGame(int nbPlayer) throws Exception {
        if (nbPlayer < NB_PLAYER_MIN || nbPlayer > NB_PLAYER_MAX) {
            throw new Exception("Choose between " + NB_PLAYER_MIN + "-" + NB_PLAYER_MAX + " players");
        }

        this.gameBoard = new Board();
        this.gameDices = new Die[NB_DICE];


        for (int i = 0; i < NB_DICE; i++) {
            this.gameDices[i] = new Die();
        }

        this.gamePlayers = new Player[nbPlayer];
        for (int i = 0; i < this.gamePlayers.length; ++i) {
            this.gamePlayers[i] = new Player(this.gameBoard, this.gameDices, "Player" + i);
        }
    }

    private void playRound() throws Exception {
        for (Player p : this.gamePlayers) {
            p.takeTurn();
        }
    }
}
