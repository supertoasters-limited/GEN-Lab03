public class MonopolyGame {
    public final static int NB_ROUND = 20;
    public final static int NB_DICE = 2;
    public final static int NB_PLAYER_MIN = 2;
    public final static int NB_PLAYER_MAX = 8;

    private Board gameBoard;
    private Die[] gameDices;
    private int roundCnt;
    private Player[] gamePlayers;



    public void playGame() {
        for (int i = 0; i < NB_ROUND; i++) {
            playRound();
        }
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public MonopolyGame(int nbPlayer) throws Exception {
        if (nbPlayer < NB_PLAYER_MIN || nbPlayer > NB_PLAYER_MAX) {
            throw new Exception("Choose between "+ NB_PLAYER_MIN+"-" + NB_PLAYER_MAX +" players");
        }

        gameBoard = new Board();
        gameDices = new Die[NB_DICE];


        for(int i = 0; i < NB_DICE; i++){
            gameDices[i] = new Die();
        }
        roundCnt = 0;

        gamePlayers = new Player[nbPlayer];
        for (int i = 0; i < gamePlayers.length; i++) {
            gamePlayers[i] = new Player(gameBoard, gameDices, "Player" + i);
        }
    }

    public void playRound() {
        roundCnt++;
        for (Player p : gamePlayers) {
            p.takeTurn();
        }
    }
}
